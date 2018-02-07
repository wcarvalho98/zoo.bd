/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 05.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOFornecedor;
import br.ufrpe.zoologico.gui.grafica.controller.ScreenManager;
import br.ufrpe.zoologico.negocio.beans.Fornecedor;

public class GerenciamentoFornecedor {

	private DAOFornecedor fornecedor;

	public GerenciamentoFornecedor() {
		fornecedor = new DAOFornecedor();
	}

	public ArrayList<Fornecedor> listarTodos() {
		try {
			return fornecedor.listarTodos();
		} catch (Exception e) {
			ScreenManager.alertaErro("Nenhum Fornecedor cadastrado" + "\n" + e.getMessage());
			return null;
		}
	}
}
