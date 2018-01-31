/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 17.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Funcionario;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AdminController implements Initializable {

	@FXML
	private TableView<Funcionario> tbvPrincipal;
	@FXML
	private Button btnCuidador;
	@FXML
	private Button btnVeterinario;
	@FXML
	private Button btnFuncionario;
	@FXML
	private Button btnCadastrar;
	@FXML
	private Button btnEditar;
	@FXML
	private Button btnRemover;
	@FXML
	private TableColumn<?, ?> clmPrincipal;
	@FXML
	private TableColumn<?, ?> clmSecundaria;
	@FXML
	private Label lblTabela;
	
	private Telas t;
	
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
		clmPrincipal.setText(null);
		clmSecundaria.setText(null);
		tbvPrincipal.setDisable(true);
	}
	
	@FXML
	public void fechar() {
		t.sairDoSistema();
	}
	
	@FXML
	public void voltar() {
		
	}
	
	@FXML
	public void desconectar() {
		
	}
	
	@FXML
	public void inicio() {
		
	}
	
	@FXML
	public void populaTabelaVeterinario() {
		lblTabela.setText("Veterinário");
		
	}
	
	@FXML
	public void populaTabelaCuidador() {
		lblTabela.setText("Cuidador");
	}
	
	@FXML
	public void populaTabelaFuncionario() {
		lblTabela.setText("Funcionário");
	}
	
	@FXML
	public void cadastrar() {
		t.setScene(new Scene((Parent) t.carregarFXML("CadastroJaula")));
		t.setDialogStage(new Stage());
		t.getDialogStage().initModality(Modality.WINDOW_MODAL);
		t.getDialogStage().initOwner(t.getStage());
		t.abrirTelaDialogo();
		
	}
	
	@FXML
	public void editar() {
		
	}
	
	@FXML
	public void remover() {
		
	}

}
