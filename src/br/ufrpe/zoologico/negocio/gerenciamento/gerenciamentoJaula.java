/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 30.01.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOJaula;
import br.ufrpe.zoologico.negocio.beans.Jaula;

public class gerenciamentoJaula {
	private DAOJaula jaula;
	
	
	public gerenciamentoJaula(){
		jaula = DAOJaula.getInstance();
	}
	
	public void cadastrar(Jaula o){
		try {
			jaula.inserir(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remover(Jaula o){
		try {
			jaula.remover(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Jaula o){
		try {
			jaula.alterar(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Jaula buscar(int id){
		Jaula result = null;
		try {
			result = jaula.buscar(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Jaula> listarTodos(){
		try {
			return jaula.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Jaula>();
		}
		
	
	}
}
