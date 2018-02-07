/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 05.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOCategoria;
import br.ufrpe.zoologico.gui.grafica.controller.ScreenManager;
import br.ufrpe.zoologico.negocio.beans.Categoria;

public class GerenciamentoCategoria {

	private DAOCategoria categoria;

	public GerenciamentoCategoria() {
		categoria = new DAOCategoria();
	}

	public ArrayList<Categoria> listarTodas() {
		try {
			return categoria.listarTodos();
		} catch (Exception e) {
			ScreenManager.alertaErro("Nenhuma categoria cadastrada" + "\n" + e.getMessage());
			return null;
		}
	}
}
