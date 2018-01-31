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
	private DAOConsultas consultas = new DAOConsultas();
	
	public void cadastrarConsulta(Consulta o) {
		try {
			consultas.inserir(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removerConsullta(Consulta o) {
		try {
			consultas.remover(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Consulta buscarConsulta(int id) {
		try {
			return consultas.buscar(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Consulta> listarConsultas(){
		try {
			return consultas.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Consulta>();
		}
	}
	
}
