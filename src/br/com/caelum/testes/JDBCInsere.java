package br.com.caelum.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.ConnectionFactory;

public class JDBCInsere {

	public static void main(String[] args) throws SQLException {

		try(Connection conexao = new ConnectionFactory().getConnection()) {
			
			String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?, ?, ?, ?)";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
				stmt.setString(1, "Caelum");
				stmt.setString(2, "contato@caelum.com.br");
				stmt.setString(3, "R. Vergueiro 3185 cj57");			
				stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
				
				stmt.execute();	
			}
			
			System.out.println("Contato gravado!");
			
		}

	}

}
