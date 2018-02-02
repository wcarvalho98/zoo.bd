/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.ProdutoRef;

public class DAOProduto extends DAO<ProdutoRef> {

	@Override
	public void inserir(ProdutoRef o) throws Exception {
		String sql = "INSERT INTO produto_ref (`descr`,`freq_pedido`, `cod_barra`, `preco_ult_compra`, "
				+ "`qtd_total_estoque`, `qtd_min`, `subcat`, `categ`, `fornecedor`) VALUES (?,?,?,?,?,?,?,?,?)";
		preparar(sql);
		getStmt().setString(1, o.getDescr());
		getStmt().setInt(2, o.getFreq_pedido());
		getStmt().setString(3, o.getCod_barra());
		getStmt().setDouble(4, o.getPreco_ult_compra());
		getStmt().setInt(5, o.getQtd_estoque());
		getStmt().setInt(6, o.getQtd_min());
		getStmt().setInt(7, o.getSubcat());
		getStmt().setInt(8, o.getCateg());
		getStmt().setInt(9, o.getFornecedor());
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
	public void remover(ProdutoRef o) throws Exception {
	}

	@Override
	public void alterar(ProdutoRef o) throws Exception {
	}

	@Override
	public ArrayList<ProdutoRef> listarTodos() throws Exception {
		return null;
	}

}
