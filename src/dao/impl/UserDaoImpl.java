package dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.UserDao;
import domain.Category;
import domain.User;
import exception.DaoException;
import util.DBCPUtil;

public class UserDaoImpl implements UserDao{
	private QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		try {
			qr.update("insert into user (id,userName,email,phone_number,password) values(?,?,?,?,?)", user.getId(),user.getUserName(),user.getEmail(),user.getPhone_number(),user.getPassword());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public User findUser(String userName, String password) {
		// TODO Auto-generated method stub
		try {
			return qr.query("select * from user where userName=? and password=?",new BeanHandler<User>(User.class),userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException();
		}
	}

}
