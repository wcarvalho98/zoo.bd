/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOEstoque_ItemEstoque;
import br.ufrpe.zoologico.negocio.beans.Estoque;
import br.ufrpe.zoologico.negocio.beans.ItemEstoque;

public class GerenciamentoDAOEstoque_ItemEstoque {

	private DAOEstoque_ItemEstoque estoque;
	
	public GerenciamentoDAOEstoque_ItemEstoque() {
		this.estoque = new DAOEstoque_ItemEstoque();
	}
	
	public void inserir(Estoque o) throws Exception {
		estoque.inserir(o);
	}
	
	public void remover(Estoque o) throws Exception {
		estoque.remover(o);
	}
	
	public void alterar(Estoque o) throws Exception {
		estoque.alterar(o);
	}
	
	public ArrayList<Estoque> listarTodos() throws Exception {
		return estoque.listarTodos();
	}
	
	public void inserirItem(ItemEstoque o) throws Exception {
		estoque.inserirItem(o);
	}
	
	public void removerItem(ItemEstoque o) throws Exception {
		
	}
	
	public void alterarItem(ItemEstoque o) throws Exception {
		
	}

	public ArrayList<ItemEstoque> listarItens() throws Exception {
		return null;
	}
	
}
