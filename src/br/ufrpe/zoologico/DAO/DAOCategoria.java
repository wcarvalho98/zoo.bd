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

import br.ufrpe.zoologico.negocio.beans.Categoria;

public class DAOCategoria extends DAO<Categoria> {

	@Override
	public void inserir(Categoria o) throws Exception {
	}

	@Override
	public void remover(Categoria o) throws Exception {
	}

	@Override
	public void alterar(Categoria o) throws Exception {
	}

	@Override
	public ArrayList<Categoria> listarTodos() throws Exception {
		String sql = "SELECT * FROM categoria";
		preparar(sql);
		ArrayList<Categoria> list = new ArrayList<>();
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
			Categoria o = new Categoria(rs.getInt(1), rs.getString(2));
			list.add(o);
		}
		rs.close();
		fecharStmt();
		return list;
	}

	public Categoria buscar(int id) throws Exception {
		String sql = "SELECT * FROM categoria WHERE `cod` = ?";
		preparar(sql);
		getStmt().setInt(1, id);
		ResultSet rs = null;
		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			fecharStmt();
			e.printStackTrace();
		}
		rs.next();
		Categoria o = new Categoria(rs.getInt(1), rs.getString(2));
		rs.close();
		fecharStmt();
		return o;
	}

}
