/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 01.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOReserva;
import br.ufrpe.zoologico.negocio.beans.Reserva;

public class GerenciamentoReserva {
	
	private DAOReserva reserva;
	
	public GerenciamentoReserva() {
		this.reserva = new DAOReserva();
	}

	public void inserir(Reserva o) {
		try {
			reserva.inserir(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remover(Reserva o) {
		try {
			reserva.remover(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remover(String cnpj) {
		try {
			reserva.remover(cnpj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remover(int id) {
		try {
			reserva.remover(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Reserva o) {
		try {
			reserva.alterar(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Reserva buscar(String cnpj, int id_espaco) {
		try {
			return reserva.buscar(cnpj, id_espaco);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Reserva> listarTodos() {
		try {
			return reserva.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Reserva>();
		}
	}
	
}
