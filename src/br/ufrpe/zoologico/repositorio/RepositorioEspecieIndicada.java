/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 19.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.EspecieIndicada;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorio;

public class RepositorioEspecieIndicada implements IRepositorio<EspecieIndicada> {

	private ArrayList<EspecieIndicada> r;
	private static IRepositorio<EspecieIndicada> i;

	private RepositorioEspecieIndicada() {
		r = new ArrayList<EspecieIndicada>();
	}

	@SuppressWarnings("unused")
	private static IRepositorio<EspecieIndicada> getInstance() {
		if (i == null) {
			i = new RepositorioEspecieIndicada();
		}
		return i;
	}

	@Override
	public void cadastrar(EspecieIndicada obj) {
		r.add(obj);
	}

	@Override
	public void atualizar(EspecieIndicada newObj) {
		r.set(newObj.getSeq(), newObj);
	}

	@Override
	public void remover(EspecieIndicada obj) {
		r.remove(obj);
	}

	@Override
	public EspecieIndicada buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<EspecieIndicada> listarTodos() {
		return r;
	}

}
