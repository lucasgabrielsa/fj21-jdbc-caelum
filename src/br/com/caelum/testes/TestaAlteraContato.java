package br.com.caelum.testes;

import java.util.Calendar;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;

public class TestaAlteraContato {

	public static void main(String[] args) {

		Contato contato = new ContatoDAO().getContatoById(3l);
		contato.setNome("Thiago Henrique");
		contato.setEmail("thiagofox@gmail.com");
		contato.setEndereco("Rua Rad. Odorico Cintra, 67");
		contato.setDataNascimento(Calendar.getInstance());
		new ContatoDAO().update(contato);
		
		System.out.println("Contato alterado!");

	}

}
