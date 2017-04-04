package br.com.caelum.testes;

import java.util.Calendar;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;

public class TestaInsereContatoDAO {

	
	public static void main(String[] args) {
		
		ContatoDAO dao = new ContatoDAO();
		
		Contato contato = new Contato();
		
		contato.setNome("Lucas Gabriel");
		contato.setEmail("lucasgabrielsa@hotmail.com");
		contato.setEndereco("Av. Jose Miguel Saramago 17");
		contato.setDataNascimento(Calendar.getInstance());
		
		dao.adiciona(contato);
		
		System.out.println(String.format("Contato %s adicionado com sucesso!", contato.getNome()));
		
		
	}

}
