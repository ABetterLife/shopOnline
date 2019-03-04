package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.OrdersDao;
import domain.Goods;
import domain.Orders;
import domain.OrdersItem;
import domain.User;
import exception.DaoException;
import util.DBCPUtil;

public class OrdersDaoImpl implements OrdersDao {
	private QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());
    /**
     * 保存订单信息
     */
	@Override
	public void addOrders(Orders orders, User user) {
		// TODO Auto-generated method stub
		try {
			qr.update("insert into orders(id,orderNum,num,price,user_id) values(?,?,?,?,?)",orders.getId(),orders.getOrderNum(),orders.getNum(),orders.getPrice(),user.getId());
			//订单中的订单项
			List<OrdersItem> items=orders.getItems();
			if(items!=null&items.size()>0) {
				String sql="insert into ordersitem(id,num,price,orders_id,goods_id) values(?,?,?,?,?)";
				Object pl[][] = new Object[items.size()][];
				for(int i=0;i<items.size();i++) {
					OrdersItem item=items.get(i);
					pl[i]=new Object[] {item.getId(),item.getNum(),item.getPrice(),orders.getId(),item.getGoods().getId()};
				}
				qr.batch(sql, pl);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException();
		}
	}
	@Override
	public List<Orders> findOrdersByUsersId(String usersId) {
		// TODO Auto-generated method stub
		try {
			return qr.query("select * from orders where user_id=? order by orderNum desc", new BeanListHandler<Orders>(Orders.class), usersId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	@Override
	public Orders findOrdersById(String ordersId) {
		// TODO Auto-generated method stub
		try {
			Orders o = qr.query("select * from orders where id=?", new BeanHandler<Orders>(Orders.class), ordersId);
			
			
			if(o!=null){
				//查询用户信息:少的一方，不管有没有需求，默认都是查出来的
				User user = qr.query("select * from user where id=(select user_id from orders where id=?)", new BeanHandler<User>(User.class), ordersId);
				o.setUser(user);
				//订单明细
				List<OrdersItem> items = qr.query("select * from ordersitem where orders_id=?", new BeanListHandler<OrdersItem>(OrdersItem.class), ordersId);
//				查询出书的信息
				if(items!=null&&items.size()>0){
					for(OrdersItem item:items){
						Goods goods = qr.query("select * from goods where id=(select goods_id from ordersitem where id=?)", new BeanHandler<Goods>(Goods.class),item.getId());
						item.setGoods(goods);
					}
				}
				o.setItems(items);
			}
			return o;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	@Override
	public List<Orders> findOrdersByState(int i) {
		// TODO Auto-generated method stub
		try {
			List<Orders> os = qr.query("select * from orders where state=? order by ordernum desc", new BeanListHandler<Orders>(Orders.class), i);
			if(os!=null&&os.size()>0){
				for(Orders o:os){
					User user = qr.query("select * from user where id=(select user_id from orders where id=?)", new BeanHandler<User>(User.class), o.getId());
					o.setUser(user);
				}
			}
			return os;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	@Override
	public void update(String ordersId) {
		// TODO Auto-generated method stub
		try {
			qr.update("update orders set state=? where id=?", 1,ordersId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	

}
