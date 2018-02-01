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
	public void cadastrar(Jaula o) throws Exception{
		if(o != null){
			if(this.listarTodos().contains(o))
				throw new ObjetoExisteException("Objeto já cadastrado");
			else
				jaula.inserir(o);
		}else
			throw new IllegalArgumentException();
	}
	
	public void remover(Jaula o) throws Exception{
		if(o != null){
			if(!this.listarTodos().contains(o))
				throw new ObjetoNaoExisteException("Objeto não existe no banco");
			else
				jaula.remover(o);
		}else
			throw new IllegalArgumentException();
	}
	
	public void atualizar(Jaula o){
		try {
			jaula.alterar(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Jaula buscar(int id) throws Exception{
		for (int i = 0; i < listarTodos().size(); i++){
			if(listarTodos().get(i).getId_jaula() == id)
				return jaula.buscar(id);
		}
		throw new ObjetoNaoExisteException("Jaula não existe");
	}
	
	public ArrayList<Jaula> listarTodos() throws Exception{
		return jaula.listarTodos();
	}

	
	
}
