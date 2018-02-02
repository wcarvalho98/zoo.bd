/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 01.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOAdmin;
import br.ufrpe.zoologico.negocio.beans.Administrador;

public class GerenciamentoAdmin {

	private DAOAdmin admin;
	
	public GerenciamentoAdmin() {
		this.admin = new DAOAdmin();
	}
	
	public void cadastrarAdministrador(Administrador o) {
		try {
			if (o != null) {
				admin.inserir(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void removerAdministrador(Administrador o) {
		try {
			if (o != null) {
				admin.remover(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterarAdministrador(Administrador o) {
		try {
			admin.alterar(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Administrador buscarAdministrador(String login) {
		try {
			return admin.buscar(login);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Administrador> listarAdministradores(){
		try {
			return admin.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Administrador>();
		}
	}
	
	
}
