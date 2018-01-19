/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Incidente;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorio;

public class RepositorioIncidente implements IRepositorio<Incidente>{
	
	private ArrayList<Incidente> r;
	private static IRepositorio<Incidente> i;
	
	private RepositorioIncidente(){
		r = new ArrayList<Incidente>();
	}
	
	private static IRepositorio<Incidente> getInstance(){
		if(i == null){
			i = new RepositorioIncidente();
		}
		return i;
	}
	@Override
	public void cadastrar(Incidente obj) {
		r.add(obj);
	}

	@Override
	public void atualizar(Incidente newObj) {
		r.set(newObj.getSeq(), newObj);
	}

	@Override
	public void remover(Incidente obj) {
		r.remove(obj);
	}

	@Override
	public Incidente buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<Incidente> listarTodos() {
		return r;
	}

}
