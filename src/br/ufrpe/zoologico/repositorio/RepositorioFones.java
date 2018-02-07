/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 17.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOFone;
import br.ufrpe.zoologico.negocio.beans.Fones;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorio;

public class RepositorioFones implements IRepositorio<Fones> {

	private ArrayList<Fones> repositorio;
	private static IRepositorio<Fones> instance;
	private DAOFone dao;

	private RepositorioFones() {
		dao = new DAOFone();
		repositorio = new ArrayList<>();
	}

	@SuppressWarnings("unused")
	private static IRepositorio<Fones> getInstace() {
		if (instance == null) {
			instance = new RepositorioFones();
		}
		return instance;
	}

	@Override
	public void cadastrar(Fones obj) {
		try {
			dao.inserir(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		repositorio.add(obj);
	}

	@Override
	public void atualizar(Fones newObj) {
		// TODO cadastrar dois n�meros distintos
		repositorio.set(newObj.getIdZoo(), newObj);
	}

	@Override
	public void remover(Fones obj) {
		repositorio.remove(obj);
	}

	@Override
	public Fones buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<Fones> listarTodos() {
		return repositorio;
	}

}
