/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOAnimal;
import br.ufrpe.zoologico.negocio.beans.Animal;

public class GerenciamentoAnimal {
	private DAOAnimal animal;
	
	public GerenciamentoAnimal() {
		this.animal = new DAOAnimal();
	}
	
	public void cadastrarAnimal(Animal o) {
		try {
			if (o != null) {
				animal.inserir(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void removerAnimal(Animal o) {
		try {
			if (o != null) {
				animal.remover(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterarAnimal(Animal o) {
		try {
			animal.alterar(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Animal buscarAnimal(int id) {
		try {
			return animal.buscar(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Animal> listarAnimais(){
		try {
			return animal.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Animal>();
		}
	}
	
}
