/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 19.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Especie;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorio;

public class RepositorioEspecie implements IRepositorio<Especie> {

	private ArrayList<Especie> r;
	private static IRepositorio<Especie> i;

	public RepositorioEspecie() {
		r = new ArrayList<Especie>();
	}

	@SuppressWarnings("unused")
	private static IRepositorio<Especie> getInstance() {
		if (i == null) {
			i = new RepositorioEspecie();
		}
		return i;
	}

	@Override
	public void cadastrar(Especie obj) {
		r.add(obj);
	}

	@Override
	public void atualizar(Especie newObj) {
		r.set(newObj.getSeq(), newObj);
	}

	@Override
	public void remover(Especie obj) {
		r.remove(obj);
	}

	@Override
	public Especie buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<Especie> listarTodos() {
		return r;
	}
}
