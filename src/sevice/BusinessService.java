package sevice;

import java.util.List;

import domain.Cart;
import domain.Category;
import domain.Goods;
import domain.Orders;
import domain.User;
import util.Page;

public interface BusinessService {
	void addCategory(Category c);
	List<Category> findAllCategory();
    void addGoods(Goods goods);
    Page findPageRecords(String pageNum);
	Category findCategoryById(String category_id);
	//根据分类查询商品
	Page findPageRecords(String pageNum, String categoryId);
	void register(User user);
	User login(String userName, String password);
	Goods findGoodsById(String goodsId);
	void addOrders(Orders orders, User user);
	List<Orders> findOrdersByUsersId(String id);
	Orders findOrdersById(String ordersId);
	List<Orders> findOrdersByState(int i);
	void sureOrders(String ordersId);
	void updateGoods(String goodsId);
	void deleteGoods(String goodsId);
}
