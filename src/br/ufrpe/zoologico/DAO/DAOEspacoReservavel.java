/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 07.02.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.zoologico.gui.grafica.controller.ScreenManager;
import br.ufrpe.zoologico.negocio.beans.EspacoReservavel;

public class DAOEspacoReservavel extends DAO<EspacoReservavel> {

	@Override
	public void inserir(EspacoReservavel o) throws Exception {
		String sql = "INSERT INTO espacos_reservavel (dimensao_area, capacidade, tipo, nome, idZoo) "
				+ "VALUES (?, ?, ?, ?, ?)";
		preparar(sql);
		getStmt().setDouble(1, o.getDimensao_area());
		getStmt().setInt(2, o.getCapacidade());
		getStmt().setString(3, o.getTipo());
		getStmt().setString(4, o.getNome());
		getStmt().setInt(5, o.getIdZoo());
		try {
			getStmt().execute();
			getCon().commit();
			ScreenManager.alertaInformativo("Inserção realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			ScreenManager.alertaErro("Não foi possível inserir!");
		} finally {
			fecharStmt();
		}
	}

	@Override
	public void remover(EspacoReservavel o) throws Exception {
		String sql = "DELETE FROM espacos_reservavel WHERE id_espaco = ?";
		preparar(sql);
		getStmt().setInt(1, o.getId());
		try {
			getStmt().execute();
			getCon().commit();
			ScreenManager.alertaInformativo("Remoção realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			ScreenManager.alertaErro("Não foi possível remover!");
		} finally {
			fecharStmt();
		}
	}

	@Override
	public void alterar(EspacoReservavel o) throws Exception {
		String sql =  "UPDATE espacos_reservavel SET dimensao_area = ?, capacidade = ?, tipo = ?, nome = ?, idZoo = ?";
		preparar(sql);
		getStmt().setDouble(1, o.getDimensao_area());
		getStmt().setInt(2, o.getCapacidade());
		getStmt().setString(3, o.getTipo());
		getStmt().setString(4, o.getNome());
		getStmt().setInt(5, o.getIdZoo());
		try {
			getStmt().execute();
			getCon().commit();
			ScreenManager.alertaInformativo("Alteração realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			ScreenManager.alertaErro("Não foi possível alterar!");
		} finally {
			fecharStmt();
		}
	}
	
	public EspacoReservavel buscar(int id_espaco) throws Exception {
		String sql = "SELECT * FROM espacos_reservavel WHERE id_espaco = ?";
		preparar(sql);
		getStmt().setInt(1, id_espaco);
		ResultSet rs = null;
		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			fecharStmt();
			ScreenManager.alertaErro("Espaço Reservavel não encontrado!");
		}
		rs.next();
		EspacoReservavel o = new EspacoReservavel(rs.getInt(1), rs.getDouble(2), rs.getInt(3), 
				rs.getString(4), rs.getString(5), rs.getInt(6));
		rs.close();
		fecharStmt();
		return o;
	}

	@Override
	public ArrayList<EspacoReservavel> listarTodos() throws Exception {
		ArrayList<EspacoReservavel> r = new ArrayList<EspacoReservavel>();
		String sql = "SELECT * FROM espacos_reservavel";
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
		while(rs.next()) {
			EspacoReservavel o = new EspacoReservavel(rs.getInt(1), rs.getDouble(2), rs.getInt(3), 
					rs.getString(4), rs.getString(5), rs.getInt(6));
			r.add(o);
		}
		rs.close();
		fecharStmt();
		return r;
	}

}
