package br.com.caelum.testes;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;

public class TestaListaContatos {
	
	public static void main(String[] args) {
		List<Contato> contatos = new ContatoDAO().getContatos();
		
		for (Contato contato : contatos) {
			imprimeContato(contato);
		}
	}
	
	public static void imprimeContato(Contato contato) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataNascimento = sdf.format(contato.getDataNascimento().getTime());
		System.out.println(contato.getId() + " - " + contato.getNome() + " - "+ contato.getEndereco() + " - " + contato.getEmail() + " - " + dataNascimento);
	}

}
