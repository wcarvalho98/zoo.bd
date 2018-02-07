/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 19.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Tratador;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorio;

public class RepositorioTratador implements IRepositorio<Tratador> {

	private ArrayList<Tratador> r;
	private static IRepositorio<Tratador> i;

	private RepositorioTratador() {
		r = new ArrayList<Tratador>();
	}

	@SuppressWarnings("unused")
	private static IRepositorio<Tratador> getInstance() {
		if (i == null) {
			i = new RepositorioTratador();
		}
		return i;
	}

	@Override
	public void cadastrar(Tratador obj) {
		r.add(obj);
	}

	@Override
	public void atualizar(Tratador newObj) {
		// TODO alterar Tratador no repositorio problema
		// r.set(newObj, newObj);
	}

	@Override
	public void remover(Tratador obj) {
		r.remove(obj);
	}

	@Override
	public Tratador buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<Tratador> listarTodos() {
		return r;
	}

}
