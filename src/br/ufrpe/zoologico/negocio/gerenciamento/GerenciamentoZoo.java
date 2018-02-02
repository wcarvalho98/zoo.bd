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
	
	private DAOZoo zoo;
	
	public GerenciamentoZoo(){
		this.zoo = new DAOZoo();
	}
	
	public void inserir(Zoo o){
		try {
			zoo.inserir(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remover(Zoo o){
		try {
			zoo.remover(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Zoo buscar(int id){
		try {
			return zoo.buscar(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Zoo> listar() throws Exception{
		return zoo.listarTodos();
	}
	
}
