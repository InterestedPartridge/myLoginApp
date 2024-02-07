package myLoginApp.service;

import myLoginApp.model.User;

public interface UserService {
	void addUser(User user);
	User getUserById(Integer userId);
}
