package domain;

import java.io.Serializable;

public class CartItem implements Serializable{
	private Goods goods;
	private int num;
	private float price;
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getPrice() {
		return num*goods.getPrice();
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
