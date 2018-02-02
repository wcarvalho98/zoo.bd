/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import br.ufrpe.zoologico.util.ConFactory;

public class DAOLogin {
	
	private final String URL = "jdbc:mysql://localhost:3306/zoologico";
	private String nome;
	private String senha;
	private Connection con;

	public void fechar() throws SQLException {  
		con.close();
	}
	
	public void fazerLogin(String nome, String senha) throws ClassNotFoundException, SQLException {
		nome += "@localhost";
		setNome(nome);
		setSenha(senha);
		con = ConFactory.conexao(URL, nome, senha);
	}

	private void setNome(String nome) {
		this.nome = nome;
	}
	private void setSenha(String senha) {
		this.senha = senha;
	}
	
}
