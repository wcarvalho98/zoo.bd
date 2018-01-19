/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Jaula;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorioJaula;

public class RepositorioJaula implements IRepositorioJaula{
	
	private ArrayList<Jaula> r;
	private static IRepositorioJaula i;
	
	private RepositorioJaula(){
		r = new ArrayList<Jaula>();
	}
	
	private static IRepositorioJaula getInstance(){
		if(i == null){
			i = new RepositorioJaula();
		}
		return i;
	}
	
	@Override
	public void cadastrar(Jaula obj) {
		r.add(obj);
	}

	@Override
	public void atualizar(Jaula newObj) {
		r.set(newObj.getId_jaula(), newObj);
	}

	@Override
	public void remover(Jaula obj) {
		r.remove(obj);
	}

	@Override
	public Jaula buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<Jaula> listarTodos() {
		return r;
	}

}
