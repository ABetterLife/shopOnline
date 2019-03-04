package dao;

import domain.User;

public interface UserDao {
	void addUser(User user);
	User findUser(String userName, String password);

}
