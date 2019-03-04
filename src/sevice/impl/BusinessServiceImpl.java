package sevice.impl;

import java.util.List;

import dao.CategoryDao;
import dao.GoodsDao;
import dao.OrdersDao;
import dao.UserDao;
import dao.impl.CategoryDaoImpl;
import dao.impl.GoodsDaoImpl;
import dao.impl.OrdersDaoImpl;
import dao.impl.UserDaoImpl;
import domain.Cart;
import domain.Category;
import domain.Goods;
import domain.Orders;
import domain.OrdersItem;
import domain.User;
import sevice.BusinessService;
import util.IdGenerator;
import util.Page;

public class BusinessServiceImpl implements BusinessService {
	private CategoryDao cDao=new CategoryDaoImpl();
	private GoodsDao gDao=new GoodsDaoImpl();
	private UserDao uDao=new UserDaoImpl();
    private OrdersDao oDao=new OrdersDaoImpl();
	@Override
	public void addCategory(Category c) {
		// TODO Auto-generated method stub
    c.setId(IdGenerator.getPrimaryKey());
    cDao.addCategory(c);
	}

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return cDao.findAll();
	}

	@Override
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		goods.setId(IdGenerator.getPrimaryKey());
		gDao.addGoods(goods);
	}

	@Override
	public Page findPageRecords(String pageNum) {
		// TODO Auto-generated method stub
		int num=1;    //默认页码
	    if(pageNum!=null&&!"".equals(pageNum.trim())) {
	    	num=Integer.parseInt(pageNum);
	    }
		int totalRecords=gDao.getTotalRecord();
		Page page=new Page(num, totalRecords);
		List records=gDao.findPageGoods(page.getStartIndex(), page.getPageSize());
		page.setRecords(records);
		return page;
	}

	@Override
	public Category findCategoryById(String category_id) {
		// TODO Auto-generated method stub
		return cDao.findCategoryById(category_id);
	}

	@Override
	public Page findPageRecords(String pageNum, String category_id) {
		// TODO Auto-generated method stub
		int num=1;    //默认页码
	    if(pageNum!=null&&!"".equals(pageNum.trim())) {
	    	num=Integer.parseInt(pageNum);
	    }
		int totalRecords=gDao.getTotalRecord(category_id);
		Page page=new Page(num, totalRecords);
		List records = gDao.findPageGoods(page.getStartIndex(),page.getPageSize(),category_id);
		page.setRecords(records);
		return page;
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		user.setId(IdGenerator.getPrimaryKey());
		uDao.addUser(user);
	}

	@Override
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		return uDao.findUser(userName,password);
	}

	@Override
	public Goods findGoodsById(String goodsId) {
		// TODO Auto-generated method stub
		return gDao.findGoodsById(goodsId);
	}

	@Override
	public void addOrders(Orders orders, User user) {
		// TODO Auto-generated method stub
		orders.setId(IdGenerator.getPrimaryKey());
		orders.setOrderNum(IdGenerator.getOrdersNum());
		//给购物项添加id
				List<OrdersItem> items = orders.getItems();
				for(OrdersItem item:items)
					item.setId(IdGenerator.getPrimaryKey());
		oDao.addOrders(orders,user);
	}

	@Override
	public List<Orders> findOrdersByUsersId(String usersId) {
		// TODO Auto-generated method stub
		return oDao.findOrdersByUsersId(usersId);
	}

	@Override
	public Orders findOrdersById(String ordersId) {
		// TODO Auto-generated method stub
		return oDao.findOrdersById(ordersId);
	}

	@Override
	public List<Orders> findOrdersByState(int i) {
		// TODO Auto-generated method stub
		return oDao.findOrdersByState(i);
	}

	@Override
	public void sureOrders(String ordersId) {
		// TODO Auto-generated method stub
		oDao.update(ordersId);
	}

	@Override
	public void updateGoods(String goodsId) {
		// TODO Auto-generated method stub
		gDao.updateGoods(goodsId);
	}

	@Override
	public void deleteGoods(String goodsId) {
		// TODO Auto-generated method stub
		gDao.deleteGoods(goodsId);
	}

}
