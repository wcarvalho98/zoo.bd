/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 22.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Fones;

public class DAOFone extends DAO<Fones> {

	@Override
	public void inserir(Fones o) throws Exception {
		String sql = "INSERT INTO Fones (idZoo, numero) VALUES (?,?)";
		preparar(sql);
		getStmt().setInt(1, o.getIdZoo());
		getStmt().setString(2, o.getFone());
		try {
			getStmt().execute();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			e.printStackTrace();
		} finally {
			fecharStmt();
		}
	}

	@Override
	public void remover(Fones o) throws Exception {
		String sql = "DELETE FROM Fones WHERE idZoo = ? , numero = ?";
		preparar(sql);
		getStmt().setInt(1, o.getIdZoo());
		getStmt().setString(2, o.getFone());
		try {
			getStmt().execute();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			e.printStackTrace();
		} finally {
			fecharStmt();
		}
	}

	@Override
	public void alterar(Fones o) throws Exception {
		String sql = "UPDATE Fones SET `idZoo` = ?, `numero` = ?";
		preparar(sql);
		getStmt().setInt(1, o.getIdZoo());
		getStmt().setString(2, o.getFone());
		try {
			getStmt().execute();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			e.printStackTrace();
		} finally {
			fecharStmt();
		}
	}

	@Override
	public ArrayList<Fones> listarTodos() throws Exception {
		String sql = "SELECT * from fones";
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
		ArrayList<Fones> list = new ArrayList<>();
		while (rs.next()) {
			Fones f = new Fones(rs.getString(2), rs.getInt(1));
			list.add(f);
		}
		rs.close();
		fecharStmt();
		return list;
	}

}
