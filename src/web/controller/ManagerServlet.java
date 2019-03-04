package web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import domain.Category;
import domain.Goods;
import domain.Orders;
import sevice.BusinessService;
import sevice.impl.BusinessServiceImpl;
import util.Page;
import util.WebUtil;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessService bs=new BusinessServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
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
		if("addCategory".equals(operation)) {
			addCategory(request,response);
		}
		if("showAllCategory".equals(operation)) {
			showAllCategory(request,response);
		}
		if("showAllCategoryUI".equals(operation)) {
			showAllCategoryUI(request,response);
		}
		if("addGoods".equals(operation)) {
			addGoods(request,response);
		}
		if("showAllGoods".equals(operation)) {
			showAllGoods(request,response);
		}
		if("showAllOrders0".equals(operation)){
			showAllOrders0(request,response);
		}
		if("showOrdersDetail".equals(operation)){
			showOrdersDetail(request,response);
		}
		if("sureOrders".equals(operation)){
			sureOrders(request,response);
		}
		if("showAllOrders1".equals(operation)){
			showAllOrders1(request,response);
		}
		if("updateGoods".equals(operation)) {
			updateGoods(request,response);
		}
		if("deleteGoods".equals(operation)) {
			deleteGoods(request,response);
		}
	}
	private void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String goodsId=request.getParameter("goodsId");
		bs.deleteGoods(goodsId);
		request.setAttribute("message", "<script type='text/javascript'>alert('删除商品成功')</script>");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	//修改商品
	private void updateGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String goodsId=request.getParameter("goodsId");
		bs.updateGoods(goodsId);
		request.setAttribute("message", "<script type='text/javascript'>alert('更新商品成功')</script>");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	//显示已处理订单
	private void showAllOrders1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Orders> os = bs.findOrdersByState(1);
		request.setAttribute("os", os);
		request.getRequestDispatcher("/manager/showOrders.jsp").forward(request, response);
	}

	//确认发货
	private void sureOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ordersId = request.getParameter("ordersId");//取得订单的id
		bs.sureOrders(ordersId);
		request.setAttribute("message", "<script type='text/javascript'>alert('发货成功')</script>");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void showOrdersDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ordersId = request.getParameter("ordersId");//取得订单的id
		Orders o = bs.findOrdersById(ordersId);//订单的明细还要查出来;明细中还要查询出书的信息;哪个用户的也要查询出来
		request.setAttribute("o", o);
		request.getRequestDispatcher("/manager/showOrdersDetail.jsp").forward(request, response);
	}

	private void showAllOrders0(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Orders> os = bs.findOrdersByState(0);
		request.setAttribute("oss", os);
		request.getRequestDispatcher("/manager/showOrders.jsp").forward(request, response);
	}

	//查询商品，分页显示所有商品
	private void showAllGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageNum=request.getParameter("pageNum");
		//System.out.println(pageNum);
		Page page=bs.findPageRecords(pageNum);
		page.setUrl("/ManagerServlet?operation=showAllGoods");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manager/listGoods.jsp").forward(request, response);
	}

	//添加商品到数据库中
	private void addGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String resultPath = "";
		//设置文件上传的目标路径
		String storePath=getServletContext().getRealPath("/files");
		try {
			Goods goods=new Goods();
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//upload
			ServletFileUpload upload=new ServletFileUpload(factory);
			//解析request
			List<FileItem> items=upload.parseRequest(request);
			for(FileItem file:items) {
				//判断一个参数域是普通的表单输入域，还是文件上传域，如果该方法返回真的话，则是前者
				if(file.isFormField()) {
					//封装数据到Javabeen
					String fieldName=file.getFieldName();//返回表单表现name属性的值    字段名，除了图片
					String fieldValue=file.getString(request.getCharacterEncoding());//将FileItem对象中保存的数据流内容以一个字符串返回
					BeanUtils.setProperty(goods, fieldName, fieldValue);
				}
				else {
					//处理文件上传
					InputStream in=file.getInputStream();
					String fieldName=file.getName();   //获得文件上传字段的文件名
					fieldName=UUID.randomUUID()+fieldName.substring(fieldName.lastIndexOf("\\")+1);
					//设置存储图片文件名
					goods.setImage(fieldName);
					OutputStream out=new FileOutputStream(storePath+"\\"+fieldName);
					byte[] b=new byte[1024];
					int len=-1;
					while((len=in.read(b))!=-1) {
						out.write(b);
					}
					out.close();
					in.close();
					file.delete();    //删除临时文件
				}
			}
			//System.out.println(goods);
			bs.addGoods(goods);
			resultPath="/manager/addGoods.jsp";
			//查询分类
			List<Category> list=bs.findAllCategory();
			request.setAttribute("list", list);
			request.setAttribute("message", "<script type='text/javascript'>alert('添加成功')</script>");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultPath="/message.jsp";
			request.setAttribute("message", "服务器忙");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher(resultPath).forward(request, response);
	}

	//添加商品时，显示所有商品分类
private void showAllCategoryUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> list=bs.findAllCategory();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/manager/addGoods.jsp").forward(request, response);
	}
     //查询所有分类时显示所有商品分类
private void showAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> list=bs.findAllCategory();
		request.setAttribute("list",list);
		request.getRequestDispatcher("/manager/listCategory.jsp").forward(request, response);
	}

//添加分类到数据库中
	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Category c=WebUtil.fillBean(request, Category.class);
		bs.addCategory(c);
		request.setAttribute("message", "<script type='text/javascript'>alert('添加成功')</script");
		//跳转
		request.getRequestDispatcher("/manager/addCategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
