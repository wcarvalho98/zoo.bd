/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 01.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOEspecie;
import br.ufrpe.zoologico.negocio.beans.Especie;

public class GerenciamentoEspecie {
	private DAOEspecie esp;
	
	public GerenciamentoEspecie(){
		esp = new DAOEspecie();
	}
	
	public ArrayList<Especie> listarTodos() throws Exception{
		return esp.listarTodos();
	}

	/** 
	 * Metodo: buscar
	 * @param especie2
	 * @return
	 * @return Especie
	 */
	public Especie buscar(int especie2) throws Exception {
		return esp.buscar(especie2);
	}

}
