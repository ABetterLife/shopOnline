package dao;

import java.util.List;

import domain.Category;
import domain.Goods;

public interface GoodsDao {
       void addGoods(Goods goods);
       int getTotalRecord();    //查询数据库中所有记录条数
       List<Goods> findPageGoods(int startIndex,int pageSize);
	   List findPageGoods(int startIndex, int pageSize, String category_id);
	   int getTotalRecord(String category_id);
	Goods findGoodsById(String goodsId);
	void updateGoods(String goodsId);
	void deleteGoods(String goodsId);
     
}
