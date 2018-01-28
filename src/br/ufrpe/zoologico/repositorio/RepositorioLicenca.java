/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Licenca;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorio;

public class RepositorioLicenca implements IRepositorio<Licenca>{
	
	private ArrayList<Licenca> rep;
	private static IRepositorio<Licenca> instance;
	
	private RepositorioLicenca(){
		rep = new ArrayList<Licenca>();
	}
	
	private static IRepositorio<Licenca> getInstance(){
		if(instance == null){
			instance = new RepositorioLicenca();
		}
		return instance;
	}
	
	@Override
	public void cadastrar(Licenca obj) {
		rep.add(obj);
	}

	@Override
	public void atualizar(Licenca newObj) {
		rep.set(newObj.getId_liceca(), newObj);
	}

	@Override
	public void remover(Licenca obj) {
		rep.remove(obj);
	}

	@Override
	public Licenca buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<Licenca> listarTodos() {
		return rep;
	}

}
