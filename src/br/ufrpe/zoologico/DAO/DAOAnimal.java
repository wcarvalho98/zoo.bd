/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 22.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Animal;

public class DAOAnimal extends DAO<Animal>{

	@Override
	public void inserir(Animal o) throws Exception {
		String sql = "INSERT INTO Animal () VALUES ()";
	}

	@Override
	public void remover(Animal o) throws Exception {
	}

	@Override
	public void alterar(Animal o) throws Exception {
	}

	public Animal buscar(int id) throws Exception {
		return null;
	}

	@Override
	public ArrayList<Animal> listarTodos() throws Exception {
		return null;
	}

}
