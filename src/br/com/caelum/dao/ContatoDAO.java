package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.modelo.Contato;

public class ContatoDAO {
	
	private Connection connection;
	
	public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?, ?, ?, ?)";
		try(PreparedStatement stmt = this.connection.prepareStatement(sql)) {
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getContatos() {
		String sql = "select id, nome, email, endereco, dataNascimento from contatos";
		List<Contato> contatos = new ArrayList<>();
		try(PreparedStatement stmt = this.connection.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					Contato contato = new Contato();
					contato.setId(rs.getLong("id"));
					contato.setNome(rs.getString("nome"));
					contato.setEmail(rs.getString("email"));
					contato.setEndereco(rs.getString("endereco"));
					Calendar dataNascimento = Calendar.getInstance();
					dataNascimento.setTime(rs.getDate("dataNascimento"));
					contato.setDataNascimento(dataNascimento);
					contatos.add(contato);
				}
			}			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return contatos;
	}
	
	public void update(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		try(PreparedStatement stmt = this.connection.prepareStatement(sql)) {
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Contato contato) {
		String sql = "delete from contatos where id=?";
		try(PreparedStatement stmt = this.connection.prepareStatement(sql)) {		
			stmt.setLong(1, contato.getId());
			stmt.execute();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Contato getContatoById(Long id) {
		String sql = "select id, nome, email, endereco, dataNascimento from contatos where id=?";
		Contato contato = null;
		try(PreparedStatement stmt = this.connection.prepareStatement(sql)) {
			stmt.setLong(1, id);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					contato = new Contato();
					contato.setId(rs.getLong("id"));
					contato.setNome(rs.getString("nome"));
					contato.setEmail(rs.getString("email"));
					contato.setEndereco(rs.getString("endereco"));
					Calendar dataNascimento = Calendar.getInstance();
					dataNascimento.setTime(rs.getDate("dataNascimento"));
					contato.setDataNascimento(dataNascimento);					
				}
			}			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return contato;
	}

}
