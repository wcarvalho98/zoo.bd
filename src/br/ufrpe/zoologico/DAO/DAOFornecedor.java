/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 05.02.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Fornecedor;

public class DAOFornecedor extends DAO<Fornecedor>{

	@Override
	public void inserir(Fornecedor o) throws Exception {
	}

	@Override
	public void remover(Fornecedor o) throws Exception {
	}

	@Override
	public void alterar(Fornecedor o) throws Exception {
	}

	@Override
	public ArrayList<Fornecedor> listarTodos() throws Exception {
		String sql = "SELECT * FROM fornecedor";
		preparar(sql);
		ArrayList<Fornecedor> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			fecharStmt();
			e.printStackTrace();
		}
		while (rs.next()) {
			Fornecedor o = new Fornecedor(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
			list.add(o);
		}
		rs.close();
		fecharStmt();
		return list;
	}
}
