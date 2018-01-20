/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.repositorio - Versao 1.0 - 2017.2
 * TODO 20.01.2018 
 */
package br.ufrpe.zoologico.repositorio;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.PedidoServico;
import br.ufrpe.zoologico.repositorio.Interfaces.IRepositorio;

public class RepositorioPedidoDeServico implements IRepositorio<PedidoServico>{

	private ArrayList<PedidoServico> r;
	private static IRepositorio<PedidoServico> i;
	
   /**
	 * 
	 */
	private RepositorioPedidoDeServico() {
		r = new ArrayList<PedidoServico>();
	}
	
	private static IRepositorio<PedidoServico> getInstance(){
		if(i == null){
			i = new RepositorioPedidoDeServico();
		}
		
		return i;
	}
	
	@Override
	public void cadastrar(PedidoServico obj) {
		r.add(obj);
	}

	@Override
	public void atualizar(PedidoServico newObj) {
		r.set(newObj.getId(),newObj);
	}

	@Override
	public void remover(PedidoServico obj) {
		r.remove(obj);
	}

	@Override
	public PedidoServico buscar(int id) {
		return null;
	}

	@Override
	public ArrayList<PedidoServico> listarTodos() {
		return r;
	}

}
