/** 
 * @author WILDER.CARVALHO
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Fatura;
import br.ufrpe.zoologico.negocio.beans.Servico;

public class DAOServico extends DAO<Servico> {

	@Override
	public void inserir(Servico o) throws Exception {
		String sql = "INSERT INTO servico (`descr`,`valor`) VALUES (?,?)";
		preparar(sql);
		getStmt().setString(1, o.getDescr());
		getStmt().setDouble(2, o.getValor());
		try {
			getStmt().execute();
			// TODO FAZER
			// Fatura a = new Fatura(0, o.getValor(), LocalDate.now(), null, )
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			e.printStackTrace();
		} finally {
			fecharStmt();
		}
	}

	@Override
	public void remover(Servico o) throws Exception {
		String sql = "delete FROM `servico` WHERE `id` = ?";
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
	public void alterar(Servico o) throws Exception {
		String sql = "UPDATE servico SET descr = ?, valor = ? WHERE id = ?";
		preparar(sql);
		getStmt().setString(1, o.getDescr());
		getStmt().setDouble(2, o.getValor());
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

	public Servico buscar(int id) throws Exception {
		String sql = "SELECT * FROM servico WHERE id = ?";
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
		Servico o = new Servico(rs.getInt(1), rs.getString(2), rs.getDouble(3));
		rs.close();
		fecharStmt();
		return o;
	}

	@Override
	public ArrayList<Servico> listarTodos() throws Exception {
		ArrayList<Servico> r = new ArrayList<Servico>();
		String sql = "SELECT * FROM servico";
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
			Servico o = new Servico(rs.getInt(1), rs.getString(2), rs.getDouble(3));
			r.add(o);
		}
		rs.close();
		fecharStmt();
		return r;
	}

	public ArrayList<Fatura> faturasDoServico(Servico o) throws Exception {
		ArrayList<Fatura> r = new ArrayList<Fatura>();
		String sql = "select fatura.* from servico join item_servico join pedido_servico join fatura where servico.id = item_servico.idServ and item_servico.idPed = pedido_servico.id and fatura.id_ped_serv = pedido_servico.id and servico.id = ?";
		preparar(sql);
		getStmt().setInt(1, o.getId());
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
			Fatura b = new Fatura(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3).toLocalDateTime().toLocalDate(),
					rs.getTimestamp(4).toLocalDateTime().toLocalDate(), rs.getDouble(5), rs.getString(6),
					rs.getString(7), rs.getInt(8));
			r.add(b);
		}
		rs.close();
		fecharStmt();
		return r;
	}

}
