/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOVeterinario;
import br.ufrpe.zoologico.negocio.beans.Veterinario;

public class GerenciamentoVeterinario {

	private DAOVeterinario veterinario;

	public GerenciamentoVeterinario() {
		this.veterinario = new DAOVeterinario();
	}

	public void cadastrarVeterinario(Veterinario o) {
		try {
			veterinario.inserir(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removerVeterinario(Veterinario o) {
		try {
			veterinario.remover(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterarVeterinario(Veterinario o) {
		try {
			veterinario.alterar(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Veterinario buscarVeterinario(String cpf) {
		try {
			return veterinario.buscar(cpf);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Veterinario> listarVeterinarios() {
		try {
			return veterinario.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Veterinario>();
		}
	}
}
