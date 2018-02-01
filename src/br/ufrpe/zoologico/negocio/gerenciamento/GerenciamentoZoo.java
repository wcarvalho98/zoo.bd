/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOZoo;
import br.ufrpe.zoologico.negocio.beans.Zoo;

public class GerenciamentoZoo {
	private DAOZoo z;
	
	public GerenciamentoZoo(){
		z = new DAOZoo();
	}
	
	public void inserir(Zoo o){
		try {
			z.inserir(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remover(Zoo o){
		try {
			z.remover(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Zoo buscar(int id){
		try {
			return z.buscar(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Zoo> listar(){
		try {
			return z.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
