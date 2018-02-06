/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOEstoque_ItemEstoque;
import br.ufrpe.zoologico.negocio.beans.Estoque;
import br.ufrpe.zoologico.negocio.beans.ItemEstoque;

public class GerenciamentoEstoque {
	
	private DAOEstoque_ItemEstoque estoque;
	
	public GerenciamentoEstoque() {
		this.estoque = new DAOEstoque_ItemEstoque();
	}
	
	public void inserirEstoque(Estoque o) throws Exception {
		estoque.inserir(o);
	}

	public void removerEstoque(Estoque o) throws Exception {
		estoque.remover(o);
	}

	
	public void alterarEstoque(Estoque o) throws Exception {
		estoque.alterar(o);
	}

	
	public ArrayList<Estoque> listarEstoque() throws Exception {
		return estoque.listarTodos();
	}

	public void inserirItem(ItemEstoque o) throws Exception {
		estoque.inserirItem(o);
	}

	public void removerItem(ItemEstoque o) throws Exception {
		estoque.removerItem(o);
	}

	public void alterarItem(ItemEstoque o) throws Exception {
		estoque.alterarItem(o);
	}

	public ArrayList<ItemEstoque> listarItens() throws Exception {
		return estoque.listarItens();
	}
	
	public ArrayList<ItemEstoque> listarItensDoEstoque(Estoque a) throws Exception{
		ArrayList<ItemEstoque> saida = new ArrayList<ItemEstoque>();
		ArrayList<ItemEstoque> todos = listarItens();
		for (int i = 0; i < todos.size(); i++) {
			if (todos.get(i).getIdEstoque() == a.getId()) {
				saida.add(todos.get(i));
			}
		}
		return saida;
	}
	
}
