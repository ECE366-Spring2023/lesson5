package com.cooperps.rps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@SpringBootApplication
@RestController
public class RpsApplication {

	@PostMapping("/getUserById")
	public User create(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"rps", "postgres", "password");
		User user = new User();
		try {
			Connection connection = dcm.getConnection();
			UserDAO userDAO = new UserDAO(connection);

			user = userDAO.findById(Integer.parseInt(message));
			System.out.println(user);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@PostMapping("/setGamesAndWins")
	public void setGamesAndWins(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"rps", "postgres", "password");
		try {
			Connection connection = dcm.getConnection();
			UserDAO userDAO = new UserDAO(connection);

			userDAO.setGamesAndWins(2, 10000000);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Hello!");
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"rps", "postgres", "password");

		try {
			Connection connection = dcm.getConnection();
			UserDAO userDAO = new UserDAO(connection);
			//userDAO.setGamesAndWins(2, 10000000);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		SpringApplication.run(RpsApplication.class, args);
	}

}
