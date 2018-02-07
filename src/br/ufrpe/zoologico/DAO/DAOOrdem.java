/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 01.02.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Ordem;

public class DAOOrdem extends DAO<Ordem> {

	@Override
	public void inserir(Ordem o) throws Exception {
	}

	@Override
	public void remover(Ordem o) throws Exception {
	}

	@Override
	public void alterar(Ordem o) throws Exception {
	}

	public Ordem buscar(int id) throws Exception {
		String sql = "SELECT * FROM Ordem WHERE `id` = ?";
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
		Ordem o = new Ordem(rs.getInt(1), rs.getString(2));
		rs.close();
		fecharStmt();
		return o;
	}

	@Override
	public ArrayList<Ordem> listarTodos() throws Exception {
		ArrayList<Ordem> list = new ArrayList<>();
		String sql = "SELECT * from Ordem";
		preparar(sql);
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
			Ordem o = new Ordem(rs.getInt(1), rs.getString(2));
			list.add(o);
		}
		rs.close();
		fecharStmt();
		return list;
	}

}
