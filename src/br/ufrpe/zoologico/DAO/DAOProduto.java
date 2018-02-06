/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.zoologico.gui.grafica.controller.ScreenManager;
import br.ufrpe.zoologico.negocio.beans.ProdutoRef;

public class DAOProduto extends DAO<ProdutoRef> {

	@Override
	public void inserir(ProdutoRef o) throws Exception {
		/*String sql = "INSERT INTO produto_ref (`descr`,`freq_pedido`, `cod_barra`, `preco_ult_compra`, "
				+ "`qtd_total_estoque`, `qtd_min`, `subcat`, `categ`, `fornecedor`) VALUES (?,?,?,?,?,?,?,?,?)";*/
		String sql = "INSERT INTO `produto_ref` (`descr`,`freq_pedido`,`cod_barra`,`preco_ult_compra`,`qtd_total_estoque`,"
				+ "`qtd_min`,`subcat`,`categ`,`fornecedor`) VALUES (?,?,?,?,?,?,?,?,?)";
		preparar(sql);
		getStmt().setString(1, o.getDescr());
		getStmt().setInt(2, o.getFreq_pedido());
		getStmt().setString(3, o.getCod_barra());
		getStmt().setDouble(4, o.getPreco_ult_compra());
		getStmt().setInt(5, o.getQtd_total_estoque());
		getStmt().setInt(6, o.getQtd_min());
		getStmt().setInt(7, o.getSubcat());
		getStmt().setInt(8, o.getCateg());
		getStmt().setInt(9, o.getFornecedor());
		try {
			getStmt().execute();
			getCon().commit();
			ScreenManager.alertaInformativo("Inserção realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			ScreenManager.alertaErro(e.getMessage());
		} finally {
			fecharStmt();
		}
	}

	@Override
	public void remover(ProdutoRef o) throws Exception {
		String sql = "DELETE FROM produto_ref WHERE `cod` = ?";
		preparar(sql);
		getStmt().setInt(1, o.getCod());
		try {
			getStmt().execute();
			getCon().commit();
			ScreenManager.alertaInformativo("Remoção feita com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			ScreenManager.alertaErro(e.getMessage());
			e.printStackTrace();
		} finally {
			fecharStmt();
		}	
		
	}
	@Override
	public void alterar(ProdutoRef o) throws Exception {
		String sql = "UPDATE produto_ref SET `descr` = ?, `freq_pedido` = ?, `cod_barra` = ?, `preco_ult_compra` = ?, "
				+ "`qtd_total_estoque` = ?, `qtd_min` = ?, `subcat` = ?, `categ` = ?, `fornecedor` = ? "
				+ "WHERE `cod` = ?";
		preparar(sql);
		getStmt().setString(1, o.getDescr());
		getStmt().setInt(2, o.getFreq_pedido());
		getStmt().setString(3, o.getCod_barra());
		getStmt().setDouble(4, o.getPreco_ult_compra());
		getStmt().setInt(5, o.getQtd_total_estoque());
		getStmt().setInt(6, o.getQtd_min());
		getStmt().setInt(7, o.getSubcat());
		getStmt().setInt(8, o.getCateg());
		getStmt().setInt(9, o.getFornecedor());
		getStmt().setInt(10, o.getCod());
		try {
			getStmt().execute();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			ScreenManager.alertaErro(e.getMessage());
		} finally {
			fecharStmt();
		}
		
	}

	@Override
	public ArrayList<ProdutoRef> listarTodos() throws Exception {
		String sql = "SELECT * FROM produto_ref";
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
		
		ArrayList<ProdutoRef> list = new ArrayList<>();
		while (rs.next()) {
			
			ProdutoRef o = new ProdutoRef (rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));

			list.add(o);
		}
		rs.close();
		fecharStmt();
		return list;
	}

}
