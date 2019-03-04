package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import dao.GoodsDao;
import domain.Category;
import domain.Goods;
import exception.DaoException;
import util.DBCPUtil;

public class GoodsDaoImpl implements GoodsDao {
	private QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		try {
			qr.update("insert into goods(id,name,price,image,description,category_id) "
					+ "values(?,?,?,?,?,?)", 
					goods.getId(),goods.getName(),goods.getPrice(),goods.getImage(),goods.getDescription(),goods.getCategory_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException();
		}

	}

	@Override
	public int getTotalRecord() {
		// TODO Auto-generated method stub
		//query返回object，先转换为long，再转换为int
	try {
		Long num=(Long) qr.query("select count(*) from goods", new ScalarHandler(1));
		return num.intValue();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new DaoException();
	}
		
	}

	@Override
	public List<Goods> findPageGoods(int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		try {
			return qr.query("select * from goods limit ?,?",new BeanListHandler<Goods>(Goods.class), startIndex,pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException();
		}
		
	}
/*
	@Override
	public List findCategoryNameByGoods() {
		// TODO Auto-generated method stub
		Category category=new Category();
		//return qr.query("select * from category where id=?", );
		List<String> list=null;
		try {
			list = qr.query("select name from category ",new ColumnListHandler<String>());
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException();
		}
		
		
	}
	*/

	@Override
	public List findPageGoods(int startIndex, int pageSize, String category_id) {
		// TODO Auto-generated method stub
		try {
			return qr.query("select * from goods where category_id=? limit ?,?",new BeanListHandler<Goods>(Goods.class),category_id, startIndex,pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException();
		}
	}

	@Override
	public int getTotalRecord(String category_id) {
		try {
			Long num=(Long) qr.query("select count(*) from goods where category_id=?", new ScalarHandler(1),category_id);
			return num.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException();
		}
	}

	@Override
	public Goods findGoodsById(String goodsId) {
		// TODO Auto-generated method stub
		try {
			return qr.query("select * from goods where id=?",new BeanHandler<Goods>(Goods.class),goodsId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException();
		}
	}

	@Override
	public void updateGoods(String goodsId) {
		// TODO Auto-generated method stub
		try {
			qr.update("update goods set state=? where id=?", 1,goodsId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void deleteGoods(String goodsId) {
		// TODO Auto-generated method stub
		try {
			qr.update("delete from goods where id=?", goodsId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	

}
