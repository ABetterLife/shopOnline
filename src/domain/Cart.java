package domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {
	private Map<String, CartItem> items = new HashMap<String, CartItem>();//key:购物项对应的商品的id value：购物项
	public Map<String, CartItem> getItems() {
		return items;
	}
	private int num;
	private float price;//总价，付款时的金额
	public int getNum() {
		num = 0;
		for(Map.Entry<String, CartItem> me:items.entrySet()){
			num+=me.getValue().getNum();
		}
		return num;
	}
	/*public void setNum(int num) {
		this.num = num;
	}*/
	public float getPrice() {
		price=0;
		for(Map.Entry<String, CartItem> me:items.entrySet()){
			price+=me.getValue().getPrice();
		}
		return price;
	}
	/*public void setPrice(float price) {
		this.price = price;
	}*/
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		//System.out.println(items.containsKey(goods.getId()));
		//System.out.println("items="+items);
		if(items.containsKey(goods.getId())){
			//有
			CartItem item = items.get(goods.getId());
			item.setNum(item.getNum()+1);
			//System.out.println(item.getNum()+",,,,,,");
		}else{
			//没有
			CartItem item = new CartItem();
			item.setGoods(goods);
			item.setNum(1);
			items.put(goods.getId(), item);
			//System.out.println(item.getNum()+"..");
			//System.out.println("items==="+items);
		}
	}
	
}
