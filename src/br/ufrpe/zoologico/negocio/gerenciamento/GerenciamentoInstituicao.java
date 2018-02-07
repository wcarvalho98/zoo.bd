/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOInstituicoes;
import br.ufrpe.zoologico.negocio.beans.Instituicao;

public class GerenciamentoInstituicao {

	private DAOInstituicoes instituicoes;

	public GerenciamentoInstituicao() {
		this.instituicoes = new DAOInstituicoes();
	}

	public void cadastrarInstituicao(Instituicao o) {
		try {
			if (o != null) {
				instituicoes.inserir(o);
			}
		} catch (Exception e) {
			System.err.println("O comando de instituicoes.inserir() falhou em GerenciamentoInstituicao.java");
		}
	}

	public void removerInstituicao(Instituicao o) {
		try {
			if (o != null) {
				instituicoes.remover(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Instituicao buscarInstituicao(String cnpj) {
		try {
			return instituicoes.buscar(cnpj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Instituicao> listarInstituicoes() {
		try {
			return instituicoes.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Instituicao>();
		}
	}

	public void alterarInstituicao(Instituicao o) {
		try {
			instituicoes.alterar(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
