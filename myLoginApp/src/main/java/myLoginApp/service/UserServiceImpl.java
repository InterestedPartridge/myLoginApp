package myLoginApp.service;

import myLoginApp.model.User;
import myLoginApp.util.DBConnectionUtil;
import myLoginApp.util.QueryMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import myLoginApp.dao.*;

public class UserServiceImpl implements UserService{
	
	UserDAO UserDAO = new UserDAOImpl();

	@Override
	public void addUser(User user) {
		UserDAO.addUser(user);
	}

	@Override
	public User getUserById(Integer userId) {
		return UserDAO.getUserById(userId);
	}
	
	public void isValid(String userName, String password) {
		DBConnectionUtil connection = new DBConnectionUtil();
		UserDAO userdao = new UserDAOImpl();
		User user = new User();
		try {
			Connection conn = connection.getDBConnection();
			PreparedStatement pstmt = conn.prepareStatement(QueryMapper.VERIFY);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
		        String userRole = rs.getString(4); // Access the fourth column
		        if (userRole == null) {
		            System.out.println("NoUserFound");
		        } else if (userRole.equals("user")) {
		            System.out.println("welcome back " + rs.getString(2));
		        } else {
		            System.out.println("welcome admin " + rs.getString(2));
		            List<User> list = userdao.getAllUsers();
		            Collections.sort(list, (user1, user2) -> user1.getUserName().compareTo(user2.getUserName()));
		            System.out.println(list);
		        }
		    } else {
		        System.out.println("NoUserFound");
		    }
		} catch (SQLException e) {
			e.printStackTrace();
            throw new RuntimeException(e);
		}
	}

}
