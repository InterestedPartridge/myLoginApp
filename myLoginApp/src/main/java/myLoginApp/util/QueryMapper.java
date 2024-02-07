package myLoginApp.util;

public interface QueryMapper {
	public static final String ADD_USER = "insert into UserTable values(?, ?, ?, ?);";
	public static final String GET_USER_BY_ID = "select * from UserTable where userId = ?";
	public static final String VERIFY = "select * from UserTable where userName = ? and password = ?";
	public static final String GET_ALL_USERS = "select * from userTable;";
}
