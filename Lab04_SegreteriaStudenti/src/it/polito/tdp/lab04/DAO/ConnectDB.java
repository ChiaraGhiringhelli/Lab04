package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	static private final String jdbcUrl = "jdbc:mysql://localhost:8889/iscritticorsi?user=root&password=root";
	static private Connection connection = null;
	
	// Static = variabili collegate sempre alla stessa classe che la richiama e che l'ha all'interno
	
	public static Connection getConnection() {

		// Tento di connettermi al DB e può non riuscirci
		
		try {
			if (connection == null || connection.isClosed()) {
				// nel caso non sia ancora aperta 
				connection = DriverManager.getConnection(jdbcUrl);
			}
			return connection;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}

}
