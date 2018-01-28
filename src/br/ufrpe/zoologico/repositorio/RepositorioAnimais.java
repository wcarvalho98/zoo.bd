/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorioAnimais;

public class RepositorioAnimais implements IRepositorioAnimais{

	private ArrayList<Animal> rep;
	private static IRepositorioAnimais instance;
	
	private  RepositorioAnimais(){
		rep = new ArrayList<>();
	}
	
	private static IRepositorioAnimais getInstance(){
		if(instance == null){
			instance = new RepositorioAnimais();
		}
		
		return instance;
	}
	@Override
	public void cadastrar(Animal obj) {
		rep.add(obj);
	}

	@Override
	public void atualizar(Animal newObj) {
		rep.set(newObj.getId(), newObj);
	}

	@Override
	public void remover(Animal obj) {
		rep.remove(obj);
	}

	@Override
	public Animal buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<Animal> listarTodos() {
		return rep;
	}

}
