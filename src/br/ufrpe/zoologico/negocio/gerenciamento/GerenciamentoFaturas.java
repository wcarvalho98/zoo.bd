/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOFatura;
import br.ufrpe.zoologico.negocio.beans.Fatura;

public class GerenciamentoFaturas {

	private DAOFatura fatura;

	public GerenciamentoFaturas() {
		this.fatura = new DAOFatura();
	}

	public void cadastrarFatura(Fatura o) {
		try {
			if (o != null) {
				fatura.inserir(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void remover(Fatura o) {
		try {
			if (o != null) {
				fatura.remover(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterar(Fatura o) {
		try {
			if (o != null) {
				fatura.alterar(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Fatura buscar(int id) {
		try {
			return fatura.buscar(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int buscarReserva(String cnpj, int id_espaco) {
		try {
			return fatura.buscarReserva(cnpj, id_espaco);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public ArrayList<Fatura> listarTodos() {
		try {
			return fatura.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Fatura>();
		}
	}
}
