package web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Cart;
import domain.CartItem;
import domain.Category;
import domain.Goods;
import domain.Orders;
import domain.OrdersItem;
import domain.User;
import sevice.BusinessService;
import sevice.impl.BusinessServiceImpl;
import util.Page;
import util.WebUtil;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessService bs=new BusinessServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String operation=request.getParameter("operation"); 
		if("showIndexCategory".equals(operation)) {
			showIndexCategory(request,response);
		}
		if("showCategoryGoods".equals(operation)) {
			showCategoryGoods(request,response);
		}
		if("register".equals(operation)) {
			register(request,response);
		}
		if("login".equals(operation)) {
			login(request,response);
		}
		if("addCart".equals(operation)) {
			addCart(request,response);
		}
		if("genOrders".equals(operation)) {
			genOrders(request,response);
		}
		if("showUsersOrders".equals(operation)) {
			showUsersOrders(request,response);
		}
		if("showOrdersDetail".equals(operation)) {
			showOrdersDetail(request,response);
		}
		
	}
	private void showOrdersDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ordersId = request.getParameter("ordersId");//取得订单的id
		Orders o = bs.findOrdersById(ordersId);//订单的明细还要查出来;明细中还要查询出商品的信息
		request.setAttribute("o", o);
		request.getRequestDispatcher("client/showOrdersDetail.jsp").forward(request, response);
	}

	private void showUsersOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//判断用户是否登录：1、没有登录，转向登录页面
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
		request.setAttribute("message", "请先登录！2秒后将自动转向登录页面。<meta http-equiv='Refresh' content='2;URL="+request.getContextPath()+"/client/login.jsp'>");
		request.getRequestDispatcher("/client/message.jsp").forward(request, response);
		return;
			}
		List<Orders> os = bs.findOrdersByUsersId(user.getId());//查询某个用户的所有订单
		System.out.println(os);
		request.setAttribute("os", os);
		request.getRequestDispatcher("/client/listOrders.jsp").forward(request, response);
	}

	//生成订单
	private void genOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//判断用户是否登录：1、没有登录，转向登录页面
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null) {
			request.setAttribute("message", "请先登录！2秒后将自动转向登录页面。<meta http-equiv='Refresh' content='2;URL="+request.getContextPath()+"/client/login.jsp'>");
			request.getRequestDispatcher("/client/message.jsp").forward(request, response);
			return;
		}
		//取出购物车：Cart  Map<String,CartItem>  填充模型
		Cart cart = (Cart) session.getAttribute("cart");
		Orders orders = new Orders();
		orders.setNum(cart.getNum());
		orders.setPrice(cart.getPrice());
		List<OrdersItem> ordersItems = new ArrayList<OrdersItem>();
		for(Map.Entry<String, CartItem> item:cart.getItems().entrySet()) {
			CartItem ci=item.getValue();
			OrdersItem ordersItem = new OrdersItem();
			ordersItem.setNum(ci.getNum());
			ordersItem.setPrice(ci.getPrice());
			ordersItem.setGoods(ci.getGoods());
			ordersItems.add(ordersItem);
		}
		orders.setItems(ordersItems);
		bs.addOrders(orders,user);
		request.setAttribute("message", "<script type='text/javascript'>alert('生成订单成功！')</script>");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	//加入购物车
	private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取bookId
		String  goodsId=request.getParameter("goodsId");
		//System.out.println(goodsId+"gggggg");
		//获取要购买的商品
		Goods goods=bs.findGoodsById(goodsId);
		//System.out.println("goods="+goods);
		//从HttpSession中取出购物车
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		//System.out.println("Cart=="+cart);
		//获取用户
		//User user=(User) session.getAttribute("user");
		if(cart==null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
			//System.out.println("cartttt="+cart);
		}
		//把商品添加到购物车中
		cart.addGoods(goods);
		//System.out.println("cart="+cart);
		//提示添加到购物车成功
		request.setAttribute("message", "<script type='text/javascript'>alert('添加到购物车成功！')</script>");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		User user=bs.login(userName,password);
		//System.out.println(user);
		if(user==null) {
			request.setAttribute("message", "<script type='text/javascript'>alert('用户名或密码错误')</script>");
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("user",user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = WebUtil.fillBean(request, User.class);
		bs.register(user);
		request.setAttribute("message", "<script type='text/javascript'>alert('注册成功')</script");
		request.getRequestDispatcher("/client/login.jsp").forward(request, response);
	}

	//主页：按照分类进行分页商品查询查询
    private void showCategoryGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String pageNum = request.getParameter("pageNum");
		String category_id = request.getParameter("category_id");
		//System.out.println(pageNum);
		//System.out.println(category_id);
		Page page = bs.findPageRecords(pageNum,category_id);
		page.setUrl("/ClientServlet?operation=showCategoryGoods&category_id="+category_id);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/client/welcome.jsp").forward(request, response);
	}

	//查询商品分类，封装，便于前端显示主页商品分类
	private void showIndexCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> list=bs.findAllCategory();
		//System.out.println(list);
		request.getSession().setAttribute("list", list);
		//分类查询所有商品，还要分页
		String pageNum=request.getParameter("pageNum");
		Page page=bs.findPageRecords(pageNum);
		page.setUrl("/ClientServer?operation=showIndexCategory");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/client/welcome.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
