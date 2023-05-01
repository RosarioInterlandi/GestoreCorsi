package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnect {

	public static Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mariadb://localhost/iscritticorsi?user=root&password=rosy2001";
		Connection conn = DriverManager.getConnection(dbUrl);
		return conn;
	}

}
