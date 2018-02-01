/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 01.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOOrdem;
import br.ufrpe.zoologico.negocio.beans.Ordem;

public class GerenciamentoOrdem {
	private DAOOrdem ordem;
	
	public GerenciamentoOrdem(){
		ordem = new DAOOrdem();
	}
	
	public ArrayList<Ordem> listarTodos() throws Exception{
		return ordem.listarTodos();
	}
}
