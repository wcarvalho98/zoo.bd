/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 01.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOGenero;
import br.ufrpe.zoologico.negocio.beans.Genero;

public class GerenciamentoGenero {
	
	private DAOGenero genero;
	
	public GerenciamentoGenero(){
		this.genero = new DAOGenero(); 
	}
	
	public ArrayList<Genero> listarTodos() {
		try {
			return genero.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Genero>();
		}
	}

	/** 
	 * Metodo: buscaGenero
	 * @param genero2 
	 * @return
	 * @return Genero
	 */
	public Genero buscaGenero(int genero2) throws Exception{
		return genero.busca(genero2);
	}
	
	public boolean pertence(int idGenero, int idOrdem) {
		try {
			return genero.pertence(idGenero, idOrdem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
