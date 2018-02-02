/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOServico;
import br.ufrpe.zoologico.negocio.beans.Fatura;
import br.ufrpe.zoologico.negocio.beans.Servico;

public class GerenciamentoServicos {
	
	private DAOServico servicos;
	
	public GerenciamentoServicos() {
		this.servicos = new DAOServico();
	}
	
	public void cadastrarServico(Servico o) {
		try {
			if (o != null) {
				servicos.inserir(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removerServico(Servico o) {
		try {
			if (o != null) {
				servicos.remover(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterarServico(Servico o) {
		try {
			servicos.alterar(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Servico buscarServico(int id) {
		try {
			return servicos.buscar(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Servico> listarServicos(){
		try {
			return servicos.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Servico>();
		}
	}
	
	public ArrayList<Fatura> faturasDoServico(Servico o){
		try {
			return servicos.faturasDoServico(o);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Fatura>();
		}
	}
}
