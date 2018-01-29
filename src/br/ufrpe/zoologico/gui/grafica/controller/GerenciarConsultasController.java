/** 
 * @author henrique
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 28.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.Consulta;
import br.ufrpe.zoologico.negocio.beans.Veterinario;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class GerenciarConsultasController implements Initializable {

	@FXML
	private TableView<Veterinario> tabelaVeterinarios;

	@FXML
	private TableColumn<Veterinario, String> colunaNomeVeterinario;

	@FXML
	private TableColumn<Veterinario, String> colunaCrmVeterinario;

	@FXML
	private TableView<Animal> tabelaAnimais;

	@FXML
	private TableColumn<Animal, String> colunaNomeAnimal;

	@FXML
	private TableColumn<Animal, String> colunaIdAnimal;

	@FXML
	private DatePicker dataDaConsultaDatePicker;

	@FXML
	private TextArea observacoesTextField;

	@FXML
	private TableView<Consulta> tabelaConsultasRemover;

	@FXML
	private TableColumn<Consulta, String> colunaNomeAnimalRemover;

	@FXML
	private TableColumn<Consulta, String> colunaidAnimalRemover;

	@FXML
	private TableColumn<Consulta, String> colunaNomeVeterinarioRemover;

	@FXML
	private TableColumn<Consulta, String> colunaIdVeterinarioRemover;

	@FXML
	private TableColumn<Consulta, String> colunaDataDaConsultaRemover;

	private Consulta aRemover;
	private Animal animalSelecionado;
	private Veterinario veterinarioSelecionado;

	@FXML
	void cadastrarConsulta() {
		if (animalSelecionado != null && veterinarioSelecionado != null
				&& dataDaConsultaDatePicker.getValue().isAfter(LocalDate.now())) {
			// cadastrarConsulta new Consulta(veterinarioSelecionado, animalSelecionado, dataDaConsultaDatePicker.getValue(), observacoesTextField.getText());
			animalSelecionado = null;
			veterinarioSelecionado = null;
		}
	}

	@FXML
	void removerConsulta() {
		if (aRemover != null) {
			// TODO removerConsulta(aRemover)
		}
	}

	@FXML
	void selecionarAnimal() {
		animalSelecionado = tabelaAnimais.getSelectionModel().getSelectedItem();
	}

	@FXML
	void selecionarConsultaRemover() {
		aRemover = tabelaConsultasRemover.getSelectionModel().getSelectedItem();
	}

	@FXML
	void selecionarVeterinario() {
		veterinarioSelecionado = tabelaVeterinarios.getSelectionModel().getSelectedItem();
	}

	@FXML
	void voltar() {
		// TODO Voltar
	}
	
	private void preencherTabelas(){
		ArrayList<Animal> listaDeAnimais = new ArrayList<Animal>(); //TODO listarTodosOsAnimais();
		ArrayList<Veterinario> listaDeVeterinarios = new ArrayList<Veterinario>(); // TODO listarTodosOsVeterinarios();
		ArrayList<Consulta> listaDeConsultas = new ArrayList<Consulta>(); //TODO listarTodasAsConsultas();
		
		colunaNomeAnimal.setCellValueFactory(new Callback<CellDataFeatures<Animal, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Animal, String> todosOsAnimais) {
				return new SimpleStringProperty(todosOsAnimais.getValue().getNome());
			}
		});
		
		colunaIdAnimal.setCellValueFactory(new Callback<CellDataFeatures<Animal, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Animal, String> todosOsAnimais) {
				return new SimpleStringProperty(Integer.valueOf(todosOsAnimais.getValue().getId()).toString());
			}
		});
		
		colunaNomeVeterinario.setCellValueFactory(new Callback<CellDataFeatures<Veterinario, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Veterinario, String> todosOsVeterinarios) {
				return new SimpleStringProperty(todosOsVeterinarios.getValue().getNome());
			}
		});
		colunaCrmVeterinario.setCellValueFactory(new Callback<CellDataFeatures<Veterinario, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Veterinario, String> todosOsVeterinarios) {
				return new SimpleStringProperty(todosOsVeterinarios.getValue().getCrmv());
			}
		});
		colunaNomeAnimalRemover.setCellValueFactory(new Callback<CellDataFeatures<Consulta, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Consulta, String> todosOsVeterinarios) {
				return new SimpleStringProperty(todosOsVeterinarios.getValue().getAnimal().getNome());
			}
		});
		colunaidAnimalRemover.setCellValueFactory(new Callback<CellDataFeatures<Consulta, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Consulta, String> todosOsVeterinarios) {
				return new SimpleStringProperty(Integer.valueOf(todosOsVeterinarios.getValue().getAnimal().getId()).toString());
			}
		});
		
		colunaNomeVeterinarioRemover.setCellValueFactory(new Callback<CellDataFeatures<Consulta, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Consulta, String> todosOsVeterinarios) {
				return new SimpleStringProperty(todosOsVeterinarios.getValue().getVeterinario().getNome());
			}
		});
		
		colunaIdVeterinarioRemover.setCellValueFactory(new Callback<CellDataFeatures<Consulta, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Consulta, String> todosOsVeterinarios) {
				return new SimpleStringProperty(todosOsVeterinarios.getValue().getVeterinario().getCrmv());
			}
		});
		
		colunaDataDaConsultaRemover.setCellValueFactory(new Callback<CellDataFeatures<Consulta, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Consulta, String> todosOsVeterinarios) {
				return new SimpleStringProperty(todosOsVeterinarios.getValue().getData().toString()); //TODO opcional Formatar LocalDate
			}
		});
		

		tabelaAnimais.setItems(FXCollections.observableArrayList(listaDeAnimais));
		tabelaAnimais.refresh();

		tabelaVeterinarios.setItems(FXCollections.observableArrayList(listaDeVeterinarios));
		tabelaVeterinarios.refresh();

		tabelaConsultasRemover.setItems(FXCollections.observableArrayList(listaDeConsultas));
		tabelaConsultasRemover.refresh();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabelas();
	}

}
