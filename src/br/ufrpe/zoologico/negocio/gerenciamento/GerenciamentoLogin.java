/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.sql.SQLException;

import br.ufrpe.zoologico.DAO.DAOLogin;

public class GerenciamentoLogin {
	
	private DAOLogin login;
	
	public GerenciamentoLogin() {
		this.login = new DAOLogin();
	}
	
	public void fecharConexao() throws SQLException {
		login.fechar();
	}
	
	public void fazerLogin(String nome, String senha) throws ClassNotFoundException, SQLException {
		login.fazerLogin(nome, senha);
	}

}
