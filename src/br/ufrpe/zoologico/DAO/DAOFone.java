/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 22.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Fones;

public class DAOFone extends DAO<Fones>{

	@Override
	public void inserir(Fones o) throws Exception {
		String sql = "INSERT INTO Fones VALUES (" + o.getIdZoo() + ", '" + o.getFone() + "')";
		getComando().executeQuery(sql);
	}

	@Override
	public void remover(Fones o) throws Exception {
		String sql = "DELETE FROM Fones WHERE idZoo =" + o.getIdZoo() + "AND fones = '" + o.getFone() + "'";
		getComando().executeQuery(sql);
	}

	@Override
	public void alterar(Fones o) throws Exception {
	}

	@Override
	public Fones buscar(int id) throws Exception {
		return null;
	}

	@Override
	public ArrayList<Fones> listarTodos() throws Exception {
		return null;
	}

}