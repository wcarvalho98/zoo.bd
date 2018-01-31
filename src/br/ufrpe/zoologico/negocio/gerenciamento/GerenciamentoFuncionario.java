/** 
 * @author WILDER.CARVALHO
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOFuncionario;
import br.ufrpe.zoologico.negocio.beans.Funcionario;

public class GerenciamentoFuncionario {
	
	private DAOFuncionario funcionario;
	
	public GerenciamentoFuncionario() {
		this.funcionario = new DAOFuncionario();
	}
	
	public void cadastrarFuncionario(Funcionario o) {
		try {
			funcionario.inserir(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removerFuncionario(Funcionario o) {
		try {
			funcionario.remover(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterarFuncionario(Funcionario o) {
		try {
			funcionario.alterar(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Funcionario buscarFuncionario(String cpf) {
		try {
			return funcionario.buscar(cpf);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Funcionario> listarFuncionarios(){
		try {
			return funcionario.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Funcionario>();
		}
	}

}
