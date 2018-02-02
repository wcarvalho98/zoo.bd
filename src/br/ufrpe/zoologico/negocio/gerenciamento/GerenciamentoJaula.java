/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 30.01.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOJaula;
import br.ufrpe.zoologico.exceptions.ObjetoExisteException;
import br.ufrpe.zoologico.exceptions.ObjetoNaoExisteException;
import br.ufrpe.zoologico.negocio.beans.Jaula;

public class GerenciamentoJaula {
	
	private DAOJaula jaula;
	
	public GerenciamentoJaula(){
		jaula = new DAOJaula();
	}
	
	public void cadastrar(Jaula o) {
		if(o != null) {
			try {
				if(this.listarTodos().contains(o))
					throw new ObjetoExisteException("Objeto já cadastrado");
				else
					jaula.inserir(o);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			throw new IllegalArgumentException();
	}
	
	public void remover(Jaula o) {
		if(o != null){
			try {
				if(!this.listarTodos().contains(o))
					throw new ObjetoNaoExisteException("Objeto não existe no banco");
				else
					jaula.remover(o);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			throw new IllegalArgumentException();
	}
	
	public void atualizar(Jaula o) {
		try {
			jaula.alterar(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Jaula buscar(int id) {
		try {
			for (int i = 0; i < listarTodos().size(); i++){
				if(listarTodos().get(i).getId_jaula() == id)
					return jaula.buscar(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			throw new ObjetoNaoExisteException("Jaula não existe");
		} catch (ObjetoNaoExisteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Jaula> listarTodos() {
		try {
			return jaula.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Jaula>();
		}
	}
}
