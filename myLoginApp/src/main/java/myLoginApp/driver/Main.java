package myLoginApp.driver;

import myLoginApp.service.*;

import java.util.Scanner;

import myLoginApp.model.User;

public class Main {
	public static void main(String[] args) {
		User user1 = new User(1, "aryan", "pass", "admin");
		User user2 = new User(2, "aman", "pass", "user");
		User user3 = new User(3, "yash", "pas", "user");
		UserServiceImpl usi = new UserServiceImpl();
//		usi.addUser(user1);
//		usi.addUser(user2);
//		usi.addUser(user3);
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter UserName: ");
		String userName = scn.nextLine();
		System.out.println("Enter Password: ");
		String password = scn.nextLine();
		usi.isValid(userName, password);
	}
}
