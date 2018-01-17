/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.WindowEvent;

public class PrincipalController implements Initializable{
	
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

	private Telas t;
	
	@FXML
	public void validaLogin() {
		String usuario = loginId.getText();
		String senha = senhaId.getText();
		
		if (usuario.isEmpty())
			tooltipLogin.show(t.getCena().get(0).getWindow());
		else
			tooltipLogin.hide();
		if (senha.isEmpty())
			tooltipSenha.show(t.getCena().get(0).getWindow());
		else
			tooltipSenha.hide();
		if (!senha.isEmpty() && !usuario.isEmpty()) {
			progressId.setVisible(true);
			loginId.setEditable(false);
			senhaId.setEditable(false);
		}
			
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		t = Telas.getInstance();
		t.getDialogStage().setResizable(false);
		t.getDialogStage().setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
				t.sairDoSistema();
			}

		});
	}

}
