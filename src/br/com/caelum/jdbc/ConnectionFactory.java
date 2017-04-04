package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private final String STRING_CONEXAO = "jdbc:mysql://localhost/fj21";
	private final String USER = "root";
	private final String PASS = "123";

	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(STRING_CONEXAO, USER, PASS);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
