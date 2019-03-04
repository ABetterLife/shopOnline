package dao;

import java.util.List;

import domain.Orders;
import domain.User;

public interface OrdersDao {

	void addOrders(Orders orders, User user);

	List<Orders> findOrdersByUsersId(String ordersId);

	Orders findOrdersById(String ordersId);

	List<Orders> findOrdersByState(int i);

	void update(String ordersId);

	

}
