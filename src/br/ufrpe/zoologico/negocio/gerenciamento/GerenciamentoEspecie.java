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

	public GerenciamentoEspecie() {
		this.especie = new DAOEspecie();
	}

	public void inserir(Especie o) throws Exception {
		especie.inserir(o);
	}

	public void remover(Especie o) throws Exception {
		especie.remover(o);
	}

	public void alterar(Especie o) throws Exception {
		especie.alterar(o);
	}

	public ArrayList<Especie> listarTodos() throws Exception {
		return especie.listarTodos();
	}

	/**
	 * Metodo: buscar
	 * 
	 * @param especie2
	 * @return
	 * @return Especie
	 */
	public Especie buscar(int especie2) throws Exception {
		return especie.buscar(especie2);
	}

	public boolean pertence(int idEspecie, int idGenero) throws Exception {
		return especie.pertence(idEspecie, idGenero);
	}

}
