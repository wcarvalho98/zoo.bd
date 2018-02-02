/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Diagnostico;

public class DAODiagnostico extends DAO<Diagnostico> {

	@Override
	public void inserir(Diagnostico o) throws Exception {
		String sql = "INSERT INTO diagnostico VALUES (?,?,?)";
		preparar(sql);
		getStmt().setInt(1, o.getConsulta().getId_consulta());
		getStmt().setString(2, o.getDoenca().getId_doenca());
		getStmt().setString(3, o.getDescri());
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
	public void remover(Diagnostico o) throws Exception {
		String sql = "DELETE FROM diagnostico WHERE id_consulta = ?, id_doenca = ?";
		preparar(sql);
		getStmt().setInt(1, o.getConsulta().getId_consulta());
		getStmt().setString(2, o.getDoenca().getId_doenca());
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
	
	public void remover(int id_consulta) throws Exception {
		String sql = "DELETE FROM diagnostico WHERE id_consulta = ?";
		preparar(sql);
		getStmt().setInt(1, id_consulta);
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
	
	public void remover(String id_doenca) throws Exception {
		String sql = "DELETE FROM diagnostico WHERE id_doenca = ?";
		preparar(sql);
		getStmt().setString(1, id_doenca);
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
	public void alterar(Diagnostico o) throws Exception {
		String sql = "UPDATE diagnostico SET descri = ? WHERE id_consulta = ?, id_doenca = ?";
		preparar(sql);
		getStmt().setString(1, o.getDescri());
		getStmt().setInt(2, o.getConsulta().getId_consulta());
		getStmt().setString(3, o.getDoenca().getId_doenca());
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
	public ArrayList<Diagnostico> listarTodos() throws Exception {
		return null;
	}

}
