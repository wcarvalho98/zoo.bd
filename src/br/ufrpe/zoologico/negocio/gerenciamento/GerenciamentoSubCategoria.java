/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 05.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOSubCategoria;
import br.ufrpe.zoologico.gui.grafica.controller.ScreenManager;
import br.ufrpe.zoologico.negocio.beans.SubCategoria;

public class GerenciamentoSubCategoria {
	
	private DAOSubCategoria subCateg;
	
	public GerenciamentoSubCategoria(){
		subCateg = new DAOSubCategoria();
	}
	
	public ArrayList<SubCategoria> listarTodas(){
		try {
			return subCateg.listarTodos();
		} catch (Exception e) {
			ScreenManager.alertaErro("Nenhuma Sub Categoria Cadastrada no Banco" + "\n" + e.getMessage());
			return null;
		}
	}
}
