package myLoginApp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import myLoginApp.model.User;
import myLoginApp.util.DBConnectionUtil;
import myLoginApp.util.QueryMapper;

public class UserDAOImpl implements UserDAO{
	
	@Override
	public void addUser(User user) {
		DBConnectionUtil connection = new DBConnectionUtil();
		try {
			Connection conn = connection.getDBConnection();
			PreparedStatement pstmt = conn.prepareStatement(QueryMapper.ADD_USER);
			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getUserRole());
			pstmt.execute();
		} catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
	}

	@Override
	public User getUserById(Integer userId) {
		DBConnectionUtil connection = new DBConnectionUtil();
		User user = new User();
		try {
			Connection conn = connection.getDBConnection();
			PreparedStatement pstmt = conn.prepareStatement(QueryMapper.GET_USER_BY_ID);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setUserRole(rs.getString(4));
			}
		} catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return user;
	}


	@Override
	public List<User> getAllUsers() {
		DBConnectionUtil connection = new DBConnectionUtil();
		List<User> list = new ArrayList<>();
		try {
			Connection conn = connection.getDBConnection();
			PreparedStatement pstmt = conn.prepareStatement(QueryMapper.GET_ALL_USERS);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setUserRole(rs.getString(4));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
            throw new RuntimeException(e);
		}
		return list;
	}
}
