/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 20.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Fornecedor;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorio;

public class RepositorioFornecedor implements IRepositorio<Fornecedor> {

	private ArrayList<Fornecedor> r;
	private static IRepositorio<Fornecedor> i;

	private RepositorioFornecedor() {
		r = new ArrayList<Fornecedor>();
	}

	@SuppressWarnings("unused")
	private static IRepositorio<Fornecedor> getInstance() {
		if (i == null) {
			i = new RepositorioFornecedor();
		}
		return i;
	}

	@Override
	public void cadastrar(Fornecedor obj) {
		r.add(obj);
	}

	@Override
	public void atualizar(Fornecedor newObj) {
		// TODO fornecedor sem id
		// r.set(, newObj);
	}

	@Override
	public void remover(Fornecedor obj) {
		r.remove(obj);
	}

	@Override
	public Fornecedor buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<Fornecedor> listarTodos() {
		return r;
	}

}
