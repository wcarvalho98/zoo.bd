/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 29.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Consulta;

public class DAOConsultas extends DAO<Consulta>{

	@Override
	public void inserir(Consulta o) throws Exception {
		String sql = "insert into Consulta values (" + o.getId_consulta() + ", " + o.getData()
	}

	@Override
	public void remover(Consulta o) throws Exception {
	}

	@Override
	public void alterar(Consulta o) throws Exception {
	}

	@Override
	public Consulta buscar(int id) throws Exception {
		return null;
	}

	@Override
	public ArrayList<Consulta> listarTodos() throws Exception {
		return null;
	}

}
