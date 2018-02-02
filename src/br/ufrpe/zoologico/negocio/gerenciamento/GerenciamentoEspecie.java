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
	
	private DAOEspecie especie;
	
	public GerenciamentoEspecie(){
		this.especie = new DAOEspecie();
	}
	
	public void inserir(Especie o) {
		try {
			especie.inserir(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remover(Especie o) {
		try {
			especie.remover(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Especie o) {
		try {
			especie.alterar(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Especie buscar(int id) {
		try {
			return especie.buscar(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Especie> listarTodos() {
		try {
			return especie.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Especie>();
		}
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
