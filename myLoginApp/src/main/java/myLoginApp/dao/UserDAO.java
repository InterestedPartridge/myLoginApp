package myLoginApp.dao;

import java.util.List;

import myLoginApp.model.User;

public interface UserDAO {
	void addUser(User user);
	User getUserById(Integer userId);
	List<User> getAllUsers();
}
