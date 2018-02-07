/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 17.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Zoo;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorioZoo;

public class RepositorioZoo implements IRepositorioZoo {

	private ArrayList<Zoo> repositorio;
	private static IRepositorioZoo instance;

	private RepositorioZoo() {
		repositorio = new ArrayList<Zoo>();
	}

	public static IRepositorioZoo getInstance() {
		if (instance == null) {
			instance = new RepositorioZoo();
		}
		return instance;
	}

	@Override
	public void cadastrar(Zoo obj) {
		repositorio.add(obj);
	}

	@Override
	public void atualizar(Zoo newObj) {
		repositorio.set(newObj.getIdZoo(), newObj);
	}

	@Override
	public void remover(Zoo obj) {
		repositorio.remove(obj);
	}

	@Override
	public Zoo buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<Zoo> listarTodos() {
		return repositorio;
	}

}
