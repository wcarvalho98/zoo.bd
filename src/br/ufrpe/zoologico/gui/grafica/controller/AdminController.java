/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 17.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Funcionario;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		clmPrincipal.setText(null);
		clmSecundaria.setText(null);
		tbvPrincipal.setDisable(true);
	}
	
	@FXML
	public void fechar() {
		ScreenManager.sairDoSistema();
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
		ScreenManager.setScene(ScreenManager.getInstance().getTelaJaula());
		
	}
	
	@FXML
	public void editar() {
		
	}
	
	@FXML
	public void remover() {
		
	}

}
