/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.DAO.DAOAdmin;
import br.ufrpe.zoologico.negocio.beans.Administrador;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.WindowEvent;

public class PrincipalController implements Initializable {
	
	@FXML
	private TextField loginId;
	@FXML
	private PasswordField senhaId;
	@FXML
	private ProgressIndicator progressId;
	@FXML
	private Tooltip tooltipLogin;
	@FXML
	private Tooltip tooltipSenha;
	
	@FXML
	public void validaLogin() {
		String nome = loginId.getText();
		String senha = senhaId.getText();
		
		if (nome.isEmpty())
			tooltipLogin.show(ScreenManager.getMainStage().getOwner());
		else
			tooltipLogin.hide();
		if (senha.isEmpty())
			tooltipSenha.show(ScreenManager.getMainStage().getOwner());
		else
			tooltipSenha.hide();
		if (!senha.isEmpty() && !nome.isEmpty()) {
			Fachada.getInstance().fazerLogin(nome, senha);
			/**
			Administrador o = null;
			try {
				o = Fachada.getInstance().buscarAdministrador(nome);
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro!");
				alert.setHeaderText(null);
				alert.setContentText("Usuário inexistente!");

				alert.showAndWait();
			}
			if (o.getLogin().equals(usuario) && o.getSenha_de_acesso().equals(senha)) {
				progressId.setVisible(true);
				loginId.setEditable(false);
				senhaId.setEditable(false);
				ScreenManager.setScene(ScreenManager.getInstance().getTelaAdmin());
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro!");
				alert.setHeaderText(null);
				alert.setContentText("Senha incorreta!");

				alert.showAndWait();
			}*/
			
		}
			
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ScreenManager.getMainStage().setResizable(false);
		ScreenManager.getMainStage().setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				if (!ScreenManager.sairDoSistema())
					arg0.consume();
			}

		});
		
		//FabricaTransicao.fazerTransicao(1, ScreenManager.getMainStage(), true);
	}

}
