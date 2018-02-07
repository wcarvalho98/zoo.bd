/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.JornadaTrabalho;

public class DAOJornadaDeTrabalho extends DAO<JornadaTrabalho> {

	@Override
	public void inserir(JornadaTrabalho o) throws Exception {
		String sql = "INSERT INTO jornada_de_trabalho (`trabalha_sabado`, `descr`) VALUES (?,?)";
		preparar(sql);
		getStmt().setBoolean(1, o.isTrabalha_sabado());
		getStmt().setString(2, o.getDesc());
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
	public void remover(JornadaTrabalho o) throws Exception {
		String sql = "DELETE FROM jornada_de_trabalho WHERE id = ?";
		preparar(sql);
		getStmt().setInt(1, o.getId());
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
	public void alterar(JornadaTrabalho o) throws Exception {
		String sql = "UPDATE jornada_de_trabalho SET `trabalha_sabado` = ?, `descr` = ?" + "WHERE id = ?";
		preparar(sql);
		getStmt().setBoolean(1, o.isTrabalha_sabado());
		getStmt().setString(2, o.getDesc());
		getStmt().setInt(3, o.getId());
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

	public JornadaTrabalho buscar(int id) throws Exception {
		String sql = "SELECT * FROM jornada_de_trabalho WHERE id = ?";
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
		JornadaTrabalho o = new JornadaTrabalho(rs.getInt(1), rs.getBoolean(2), rs.getString(3));
		rs.close();
		fecharStmt();
		return o;
	}

	@Override
	public ArrayList<JornadaTrabalho> listarTodos() throws Exception {
		ArrayList<JornadaTrabalho> r = new ArrayList<JornadaTrabalho>();
		String sql = "SELECT * FROM jornada_de_trabalho";
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
			JornadaTrabalho o = new JornadaTrabalho(rs.getInt(1), rs.getBoolean(2), rs.getString(3));
			r.add(o);
		}
		rs.close();
		fecharStmt();
		return r;
	}

}
