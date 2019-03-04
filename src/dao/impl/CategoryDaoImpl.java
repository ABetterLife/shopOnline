package dao.impl;

import java.sql.SQLException;
import java.util.List;
/*
create table category(
			id varchar(100) primary key,
			name varchar(100) not null unique,
			description varchar(255)
		);
 */

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.CategoryDao;
import domain.Category;
import exception.DaoException;
import util.DBCPUtil;

public class CategoryDaoImpl implements CategoryDao {
	private QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());

	public void addCategory(Category c) {
		// TODO Auto-generated method stub
		try {
			qr.update("insert into category (id,name,description) values(?,?,?)", c.getId(),c.getName(),c.getDescription());
		} catch (SQLException e) {
			throw new DaoException(e);
		}

	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		try {
			return qr.query("select * from category", new BeanListHandler<Category>(Category.class));
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e);
		}
		
	}

	@Override
	public Category findCategoryById(String category_id) {
		// TODO Auto-generated method stub
		try {
			return qr.query("select * from category where id=?",new BeanHandler<Category>(Category.class),category_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException();
		}
	}

}
