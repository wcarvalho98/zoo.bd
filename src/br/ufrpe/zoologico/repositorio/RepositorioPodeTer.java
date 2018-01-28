/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 19.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.PodeTer;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorio;

public class RepositorioPodeTer implements IRepositorio<PodeTer> {

	private ArrayList<PodeTer> r;
	private static IRepositorio<PodeTer> i;
	
	private RepositorioPodeTer(){
		r = new ArrayList<PodeTer>();
	}
	
	private static IRepositorio<PodeTer> getInstance(){
		if(i == null){
			i = new RepositorioPodeTer();
		}
		return i;
	}
	@Override
	public void cadastrar(PodeTer obj) {
		r.add(obj);
	}

	@Override
	public void atualizar(PodeTer newObj) {
		r.set(newObj.getIncidente().getSeq(), newObj);
	}

	@Override
	public void remover(PodeTer obj) {
		r.remove(obj);
	}

	@Override
	public PodeTer buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<PodeTer> listarTodos() {
		return r;
	}

}
