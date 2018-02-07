/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 19.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Genero;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorio;

public class RepositorioGenero implements IRepositorio<Genero> {
	private ArrayList<Genero> r;
	private static IRepositorio<Genero> i;

	/**
	 * 
	 */
	public RepositorioGenero() {
		r = new ArrayList<Genero>();
	}

	@SuppressWarnings("unused")
	private static IRepositorio<Genero> getInstance() {
		if (i == null) {
			i = new RepositorioGenero();
		}
		return i;
	}

	@Override
	public void cadastrar(Genero obj) {
		r.add(obj);
	}

	@Override
	public void atualizar(Genero newObj) {
		r.set(newObj.getId(), newObj);
	}

	@Override
	public void remover(Genero obj) {
		r.remove(obj);
	}

	@Override
	public Genero buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<Genero> listarTodos() {
		return r;
	}

}
