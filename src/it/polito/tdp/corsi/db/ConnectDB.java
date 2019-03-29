package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	
	static private final String jdbcUrl = "jdbc:mysql://localhost/iscritticorsi?user=root&password=ulla97";
	static private Connection connection = null;

	public static Connection getConnection() {

		try {
				connection = DriverManager.getConnection(jdbcUrl);
		
		} catch (SQLException e) {
			
			System.out.println("Errore connessione al DB");
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		
		}
		
		return connection;
	}
	
	
}
