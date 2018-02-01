/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 17.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.Funcionario;
import br.ufrpe.zoologico.negocio.beans.Veterinario;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

public class AdminController implements Initializable {

	@FXML
	private TableView<Veterinario> tbvPrincipal;
	@FXML
	private TableView<Funcionario> tbvFunc;
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
	private TableColumn<Veterinario, String> clmNomeVet;
	@FXML
	private TableColumn<Veterinario, String> clmCpfVet;
	@FXML
	private TableColumn<Funcionario, String> clmNomeFunc;
	@FXML
	private TableColumn<Funcionario, String> clmCpfFunc;
	@FXML
	private Label lblTabela;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		populaTabelaVeterinario();
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
		tbvFunc.setDisable(true);
		tbvFunc.setVisible(false);
		lblTabela.setText("Veterinário");
		ArrayList<Veterinario> listaDeVeterinarios = Fachada.getInstance().listarVeterinarios();
		
		clmNomeVet
		.setCellValueFactory(new Callback<CellDataFeatures<Veterinario, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Veterinario, String> todosOsVeterinarios) {
				return new SimpleStringProperty(todosOsVeterinarios.getValue().getNome());
			}
		});
		
		clmCpfVet
		.setCellValueFactory(new Callback<CellDataFeatures<Veterinario, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Veterinario, String> todosOsVeterinarios) {
				return new SimpleStringProperty(todosOsVeterinarios.getValue().getCpf());
			}
		});
		
		tbvPrincipal.setItems(FXCollections.observableArrayList(listaDeVeterinarios));
		tbvPrincipal.refresh();
		tbvPrincipal.setDisable(false);
		tbvPrincipal.setVisible(true);
	}
	
	@FXML
	public void populaTabelaFuncionario() {
		tbvPrincipal.setDisable(true);
		tbvPrincipal.setVisible(false);
		lblTabela.setText("Funcionário");
		ArrayList<Funcionario> listaDeFuncionarios = Fachada.getInstance().listarFuncionarios();
		
		clmNomeFunc
		.setCellValueFactory(new Callback<CellDataFeatures<Funcionario, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Funcionario, String> todosOsFuncionarios) {
				return new SimpleStringProperty(todosOsFuncionarios.getValue().getNome());
			}
		});
		
		clmCpfFunc
		.setCellValueFactory(new Callback<CellDataFeatures<Funcionario, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Funcionario, String> todosOsFuncionarios) {
				return new SimpleStringProperty(todosOsFuncionarios.getValue().getCpf());
			}
		});
		
		tbvFunc.setItems(FXCollections.observableArrayList(listaDeFuncionarios));
		tbvFunc.refresh();
		tbvFunc.setDisable(false);
		tbvFunc.setVisible(true);
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
