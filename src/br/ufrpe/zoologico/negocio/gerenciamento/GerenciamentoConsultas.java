/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOConsultas;
import br.ufrpe.zoologico.negocio.beans.Consulta;

public class GerenciamentoConsultas {
	private DAOConsultas consultas = DAOConsultas.getInstance();
	
	public void cadastrarConsulta(Consulta o) {
		try {
			if (o != null) {
				consultas.inserir(o);
			} else {
				System.err.println("A consulta que passado como parâmetro é null");
			}
		} catch (Exception e) {System.err.println("O comando consultas.inserir() falhou em GerenciamentoConsultas.java");}
	}
	
	public void removerConsullta(Consulta o) {
		try {
			if (o != null) {
				consultas.remover(o);
			} else {
				System.err.println("A consulta que passado como parâmetro é null");
			}
		} catch (Exception e) {System.err.println("O comando consultas.remover() falhou em GerenciamentoConsultas.java");}
	}
	
	public Consulta buscarConsulta(int id) {
		try {
			return consultas.buscar(id);
		} catch (Exception e) {
			System.err.println("O comando consultas.buscar(id) falhou em GerenciamentoConsultas.java");
			return null;
		}
	}
	
	public ArrayList<Consulta> listarConsultas(){
		try {
			return consultas.listarTodos();
		} catch (Exception e) {
			System.err.println("O comando consultas.listarTodos() falhou em GerenciamentoConsultas.java");
			return new ArrayList<Consulta>();
		}
	}
	
}
