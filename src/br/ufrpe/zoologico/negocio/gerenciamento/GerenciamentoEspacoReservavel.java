/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 07.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOEspacoReservavel;
import br.ufrpe.zoologico.negocio.beans.EspacoReservavel;

public class GerenciamentoEspacoReservavel {
	
	private DAOEspacoReservavel espaco;
	
	public GerenciamentoEspacoReservavel() {
		this.espaco = new DAOEspacoReservavel();
	}
	
	public void inserir(EspacoReservavel o) throws Exception {
		espaco.inserir(o);
	}
	
	public void remover(EspacoReservavel o) throws Exception {
		espaco.remover(o);
	}
	
	public void alterar(EspacoReservavel o) throws Exception {
		espaco.alterar(o);
	}
	
	public EspacoReservavel buscar(int id_espaco) throws Exception {
		return espaco.buscar(id_espaco);
	}
	
	public ArrayList<EspacoReservavel> listarTodos() throws Exception {
		return espaco.listarTodos();
	}

}
