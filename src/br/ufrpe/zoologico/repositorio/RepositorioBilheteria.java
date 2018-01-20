/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 20.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Bilheteria;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorioBilheteria;

public class RepositorioBilheteria implements IRepositorioBilheteria{

	private ArrayList<Bilheteria> r;
	private static IRepositorioBilheteria i;
	
	private RepositorioBilheteria() {
		r = new ArrayList<Bilheteria>();
	}
	
	private static IRepositorioBilheteria getInstance(){
		if ( i == null ){
			i = new RepositorioBilheteria();
		}
		return i;
	}
	
	@Override
	public void cadastrar(Bilheteria obj) {
		r.add(obj);
	}

	@Override
	public void atualizar(Bilheteria newObj) {
		r.set(newObj.getId(), newObj);
	}

	@Override
	public void remover(Bilheteria obj) {
		r.remove(obj);
	}

	@Override
	public Bilheteria buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<Bilheteria> listarTodos() {
		return r;
	}
	
}
