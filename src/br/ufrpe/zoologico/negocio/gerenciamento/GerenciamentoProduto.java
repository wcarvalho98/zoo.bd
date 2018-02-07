/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOProduto;
import br.ufrpe.zoologico.negocio.beans.ProdutoRef;

public class GerenciamentoProduto {
	private DAOProduto produtos;

	public GerenciamentoProduto() {
		produtos = new DAOProduto();
	}

	public void cadastrarProduto(ProdutoRef o) throws Exception {
		if (o == null)
			throw new NullPointerException("Produto nulo");
		else {
			produtos.inserir(o);
		}
	}

	public void removerProduto(ProdutoRef o) throws Exception {
		if (o == null)
			throw new NullPointerException("Produto nulo");
		else {
			produtos.remover(o);
		}

	}

	public void alterarProduto(ProdutoRef o) throws Exception {
		if (o == null)
			throw new NullPointerException("Produto nulo");
		else {
			produtos.alterar(o);
		}
	}

	public ArrayList<ProdutoRef> listarTodos() throws Exception {
		return produtos.listarTodos();
	}

}
