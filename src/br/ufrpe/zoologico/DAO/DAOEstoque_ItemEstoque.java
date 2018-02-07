/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.zoologico.gui.grafica.controller.ScreenManager;
import br.ufrpe.zoologico.negocio.beans.Estoque;
import br.ufrpe.zoologico.negocio.beans.ItemEstoque;

public class DAOEstoque_ItemEstoque extends DAO<Estoque> {

	@Override
	public void inserir(Estoque o) throws Exception {
		String sql = "INSERT INTO estoque (`idZoo`,`descr`,`localizacao`) VALUES ( ?, ?, ?)";
		preparar(sql);
		getStmt().setInt(1, 1);
		getStmt().setString(2, o.getDescr());
		getStmt().setString(3, o.getLocalizacao());
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
	public void remover(Estoque o) throws Exception {
		String sql = " DELETE FROM estoque WHERE id = ?";
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
	public void alterar(Estoque o) throws Exception {
		String sql = "UPDATE estoque SET descr = ?, localizacao = ? WHERE id = ?";
		preparar(sql);
		getStmt().setString(1, o.getDescr());
		getStmt().setString(2, o.getLocalizacao());
		getStmt().setInt(3, o.getId());
		try {
			getStmt().execute();
			getCon().commit();
			ScreenManager.alertaInformativo("Alteração realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			ScreenManager.alertaErro("Não foi possível remover!");
		} finally {
			fecharStmt();
		}
	}

	@Override
	public ArrayList<Estoque> listarTodos() throws Exception {
		ArrayList<Estoque> r = new ArrayList<Estoque>();
		String sql = "SELECT * FROM estoque";
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
			Estoque o = new Estoque(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
			r.add(o);
		}
		rs.close();
		fecharStmt();
		return r;
	}

	public void inserirItem(ItemEstoque o) throws Exception {
		String sql = "INSERT INTO item_estoque (`cod_prod_ref`,`id`,`qtd`,`data_entrada`,`vl_compra`,`data_validade`,`id_animal`)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		preparar(sql);
		getStmt().setInt(1, o.getCod_prod_ref());
		getStmt().setInt(2, o.getIdEstoque());
		getStmt().setInt(3, o.getQtd());
		getStmt().setDate(4, Date.valueOf(o.getData_entrada()));
		getStmt().setDouble(5, o.getVl_compra());
		getStmt().setDate(6, Date.valueOf(o.getData_validade()));
		getStmt().setInt(7, o.getAnimal_consome());
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

	public void removerItem(ItemEstoque o) throws Exception {
		String sql = "DELETE FROM item_estoque WHERE id = ? and cod_prod_ref = ?";
		preparar(sql);
		getStmt().setInt(1, o.getIdEstoque());
		getStmt().setInt(2, o.getCod_prod_ref());
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

	public void alterarItem(ItemEstoque o) throws Exception {
		String sql = "UPDATE item_estoque SET qtd = ?, data_entrada = ?, vl_compra = ?, "
				+ "data_validade = ?, id_animal = ? WHERE id = ? and cod_prod_ref = ?";
		preparar(sql);
		getStmt().setInt(1, o.getQtd());
		getStmt().setDate(2, Date.valueOf(o.getData_entrada()));
		getStmt().setDouble(3, o.getVl_compra());
		getStmt().setDate(4, Date.valueOf(o.getData_validade()));
		getStmt().setInt(5, o.getAnimal_consome());
		getStmt().setInt(6, o.getIdEstoque());
		getStmt().setInt(7, o.getCod_prod_ref());
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

	public ArrayList<ItemEstoque> listarItens() throws Exception {
		ArrayList<ItemEstoque> r = new ArrayList<ItemEstoque>();
		String sql = "SELECT * FROM item_estoque";
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
			ItemEstoque o = new ItemEstoque(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4).toLocalDate(),
					rs.getDouble(5), rs.getDate(6).toLocalDate(), rs.getInt(7));
			r.add(o);
		}
		rs.close();
		fecharStmt();
		return r;
	}

}
