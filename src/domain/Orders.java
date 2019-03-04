package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 *CREATE TABLE orders(
    id VARCHAR(100) PRIMARY KEY,
    orderNum VARCHAR(100) NOT NULL UNIQUE,
    num INT,
    price FLOAT(8,2),
    user_id VARCHAR(100),
    CONSTRAINT user_id_fk FOREIGN KEY(user_id) REFERENCES USER(id)
);
 */
public class Orders implements Serializable {
	private String id;
	private String orderNum;//订单编号(notnull  unique)
	private int num;//数量
	private float price;//付款金额
	private int state; // 0 表示未发货  1表示已发货
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	private List<OrdersItem> items = new ArrayList<OrdersItem>();//订单中的订单项
	
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<OrdersItem> getItems() {
		return items;
	}

	public void setItems(List<OrdersItem> items) {
		this.items = items;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
