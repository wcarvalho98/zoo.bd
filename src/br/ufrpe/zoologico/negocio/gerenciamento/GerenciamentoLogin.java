/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import java.sql.SQLException;

import br.ufrpe.zoologico.DAO.DAOLogin;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GerenciamentoLogin {
	
	private DAOLogin login;
	
	public GerenciamentoLogin() {
		this.login = new DAOLogin();
	}
	
	public void fecharConexao() {
		try {
			login.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void fazerLogin(String nome, String senha) {
		try {
			login.fazerLogin(nome, senha);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro!");
			alert.setHeaderText(null);
			alert.setContentText("Dados incorretos!");
			alert.showAndWait();
			
			e.printStackTrace();
		}
	}

}
