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

import br.ufrpe.zoologico.negocio.beans.SubCategoria;

public class DAOSubCategoria extends DAO<SubCategoria>{

	@Override
	public void inserir(SubCategoria o) throws Exception {
	}

	@Override
	public void remover(SubCategoria o) throws Exception {
	}

	@Override
	public void alterar(SubCategoria o) throws Exception {
	}

	@Override
	public ArrayList<SubCategoria> listarTodos() throws Exception {
		String sql = "SELECT * FROM sub_categoria";
		preparar(sql);
		ArrayList<SubCategoria> list = new ArrayList<>();
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
			SubCategoria o = new SubCategoria(rs.getInt(1), rs.getString(2), rs.getInt(3));
			list.add(o);
		}
		rs.close();
		fecharStmt();
		return list;
	}

}
