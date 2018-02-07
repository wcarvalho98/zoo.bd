/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOJornadaDeTrabalho;
import br.ufrpe.zoologico.negocio.beans.JornadaTrabalho;

public class GerenciamentoJornadaDeTrabalho {

	private DAOJornadaDeTrabalho jornada;

	public GerenciamentoJornadaDeTrabalho() {
		this.jornada = new DAOJornadaDeTrabalho();
	}

	public void inserir(JornadaTrabalho o) {
		try {
			jornada.inserir(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void remover(JornadaTrabalho o) {
		try {
			jornada.remover(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterar(JornadaTrabalho o) {
		try {
			jornada.alterar(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JornadaTrabalho buscar(int id) {
		try {
			return jornada.buscar(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<JornadaTrabalho> listarTodos() {
		try {
			return jornada.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<JornadaTrabalho>();
		}
	}

}
