/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 19.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Ordem;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorio;

public class RepositorioOrdem implements IRepositorio<Ordem> {

	private ArrayList<Ordem> r;
	private static IRepositorio<Ordem> i;
	
	/**
	 * 
	 */
	public RepositorioOrdem() {
		r = new ArrayList<Ordem>();
	}
	
	private static IRepositorio<Ordem> getInstance(){
		if(i == null){
			i = new RepositorioOrdem();
		}
		return i;
	}

	@Override
	public void cadastrar(Ordem obj) {
		r.add(obj);
	}
	

	@Override
	public void atualizar(Ordem newObj) {
		r.set(newObj.getId(), newObj);
	}

	@Override
	public void remover(Ordem obj) {
		r.remove(obj);
	}

	@Override
	public Ordem buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<Ordem> listarTodos() {
		return r;
	}

}
