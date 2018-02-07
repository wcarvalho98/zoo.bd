/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 17.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Docs;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorio;

public class RepositorioDocs implements IRepositorio<Docs> {

	private ArrayList<Docs> rep;
	private static IRepositorio<Docs> instance;

	private RepositorioDocs() {
		rep = new ArrayList<Docs>();
	}

	@SuppressWarnings("unused")
	private static IRepositorio<Docs> getInstance() {
		if (instance == null) {
			instance = new RepositorioDocs();
		}

		return instance;
	}

	@Override
	public void cadastrar(Docs obj) {
		rep.add(obj);
	}

	@Override
	public void atualizar(Docs newObj) {
		rep.set(newObj.getIdDoc(), newObj);
	}

	@Override
	public void remover(Docs obj) {
		rep.remove(obj);
	}

	@Override
	public Docs buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<Docs> listarTodos() {
		return rep;
	}

}
