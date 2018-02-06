/** 
 * @author WILDER.CARVALHO
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Fatura;
import br.ufrpe.zoologico.negocio.beans.Servico;
import javafx.fxml.FXML;

public class DAOFatura extends DAO<Fatura> {
	
	public void inserir(Fatura o, int idServico) throws Exception {
		String sql = "insert into pedido_servico (idZoo) values (?)";
		preparar(sql);
		getStmt().setInt(1, 1);
		try {
			getStmt().execute();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			e.printStackTrace();
		} finally {
			fecharStmt();
		}
		
		sql = "SELECT max(id) FROM zoologico.pedido_servico";
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
		rs.next();
		int idPed = rs.getInt(1);
		rs.close();
		fecharStmt();
		
		sql = "insert into fatura (valor, id_ped_serv, dataDaFatura, dt_paga, tp_fatura, vl_multa, stats) values(?, ?, ?, ?, ?, ?, ?)";
		preparar(sql);
		getStmt().setDouble(1, o.getValor());
		getStmt().setInt(2, idPed);
		getStmt().setDate(3, Date.valueOf(o.getDataDaFatura()));
		getStmt().setDate(4, Date.valueOf(o.getDt_paga()));
		getStmt().setString(5, o.getTp_fatura());
		getStmt().setDouble(6, o.getVl_multa());
		getStmt().setString(7, o.getStats());
		try {
			getStmt().execute();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			e.printStackTrace();
		} finally {
			fecharStmt();
		}
		
		sql = "insert into item_servico(idPed, idServ) values (?, ?)";
		preparar(sql);
		getStmt().setInt(1, idPed);
		getStmt().setInt(2, idServico);
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
	public void remover(Fatura o) throws Exception {
		String sql = "delete FROM fatura WHERE idFatura = ?";
		preparar(sql);
		getStmt().setInt(1, o.getIdFatura());
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
	public void alterar(Fatura o) throws Exception {
		String sql = "UPDATE fatura SET valor = ?, dataDaFatura = ?, dt_paga = ?, vl_multa = ?, stats = ?, tp_fatura = ?, id_ped_serv = ? WHERE idFatura = ?";
		preparar(sql);
		getStmt().setDouble(1, o.getValor());
		getStmt().setDate(2, Date.valueOf(o.getDataDaFatura()));
		getStmt().setDate(3, Date.valueOf(o.getDt_paga()));
		getStmt().setDouble(4, o.getVl_multa());
		getStmt().setString(5, o.getStats());
		getStmt().setString(6, o.getTp_fatura());
		getStmt().setInt(7, o.getId_ped_serv());
		getStmt().setInt(8, o.getIdFatura());
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
	
	public Fatura buscar(int id) throws Exception {
		String sql = "SELECT * FROM fatura WHERE idFatura = ?";
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
		LocalDate dataDaFatura = null;
		if (rs.getDate(3) != null)
			dataDaFatura = rs.getDate(3).toLocalDate();
		LocalDate dt_paga = null;
		if (rs.getDate(4) != null)
			dt_paga = rs.getDate(4).toLocalDate();
		Fatura o = new Fatura(rs.getInt(1), rs.getDouble(2), dataDaFatura, dt_paga,
				rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getInt(8));
		rs.close();
		fecharStmt();
		return o;
	}

	@Override
	public ArrayList<Fatura> listarTodos() throws Exception {
		ArrayList<Fatura> r = new  ArrayList<Fatura>();
		String sql = "SELECT * FROM fatura";
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
		LocalDate dataDaFatura;
		LocalDate dt_paga;
		while(rs.next()) {
			dataDaFatura = null;
			dt_paga = null;
			if (rs.getDate(3) != null)
				dataDaFatura = rs.getDate(3).toLocalDate();
			if (rs.getDate(4) != null)
				dt_paga = rs.getDate(4).toLocalDate();
			Fatura o = new Fatura(rs.getInt(1), rs.getDouble(2), dataDaFatura, dt_paga,
					rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getInt(8));
			r.add(o);
		}		
		rs.close();
		fecharStmt();
		return r;
	}
	
	@FXML public void voltar() {
		// TODO ScreenManager.setScene(ScreenManager.getInstance.);
	}

	@Override
	public void inserir(Fatura o) throws Exception {
	}

}
