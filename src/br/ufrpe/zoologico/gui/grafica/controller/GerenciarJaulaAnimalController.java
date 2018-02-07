package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.Jaula;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class GerenciarJaulaAnimalController implements Initializable{

    @FXML
    private TableView<Animal> tabelaAnimal;

    @FXML
    private TableColumn<Animal, String> colunaIdAnimal;

    @FXML
    private TableColumn<Animal, String> colunaNomeAnimal;

    @FXML
    private TableColumn<Animal, String> colunaIdadeAnimal;

    @FXML
    private TableColumn<Animal, String> colunaGeneroAnimal;

    @FXML
    private TableColumn<Animal, String> colunaOrdemAnimal;

    @FXML
    private TableColumn<Animal, String> colunaEspecieAnimal;

    @FXML
    private TableView<Jaula> tabelaJaulas;

    @FXML
    private TableColumn<Jaula, String> colunaIdJaula;

    @FXML
    private TableColumn<Jaula, String> colunaTipoJaula;

    @FXML
    private TableColumn<Jaula, String> colunaStatusJaula;

    @FXML
    private TableColumn<Jaula, String> colunaPopMaxJaula;

    @FXML
    private TableColumn<Jaula, String> colunaIdZooJaula;

    @FXML
    private TableColumn<Jaula, String> colunaUltimaInspecJaula;

    @FXML
    private TableView<Jaula> tabelaNovaJaula;

    @FXML
    private TableColumn<Jaula, String> colunaIdNovaJaula;

    @FXML
    private TableColumn<Jaula, String> colunaTipoNovaJaula;
    
    private Jaula jaulaSelecionada;
    private Animal animalSelecionado;
    private Jaula novaJaula;

    @FXML
    void salvarAlteracoes() {

    }

    @FXML
    void selecionarAnimal() {
    	animalSelecionado = tabelaAnimal.getSelectionModel().getSelectedItem();
    }

    @FXML
    void selecionarJaula() {
    	jaulaSelecionada = tabelaJaulas.getSelectionModel().getSelectedItem();
    }

    @FXML
    void selecionarNovaJaula() {
    	novaJaula = tabelaNovaJaula.getSelectionModel().getSelectedItem();
    }

    @FXML
    void trocarDeJaula() {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabelaJaulaPrincipal();
	}
	
    @FXML
    void voltar() {
    	ScreenManager.setScene(ScreenManager.getInstance().getTelaAdmin());
    }

    private void preencherTabelaJaulaPrincipal() {
    	ArrayList<Jaula> jaulas = Fachada.getInstance().listarJaulas();
    	
    	colunaIdJaula.setCellValueFactory(new Callback<CellDataFeatures<Jaula, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Jaula, String> todos) {
				return new SimpleStringProperty(todos.getValue().getId_jaula() + "");
			}
		});
    	
    	colunaTipoJaula.setCellValueFactory(new Callback<CellDataFeatures<Jaula, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Jaula, String> todos) {
				return new SimpleStringProperty(todos.getValue().getTipo() + "");
			}
		});
    	
    	colunaPopMaxJaula.setCellValueFactory(new Callback<CellDataFeatures<Jaula, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Jaula, String> todos) {
				return new SimpleStringProperty(todos.getValue().getPopulacao_max() + "");
			}
		});
    	
    	colunaStatusJaula.setCellValueFactory(new Callback<CellDataFeatures<Jaula, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Jaula, String> todos) {
				return new SimpleStringProperty(todos.getValue().isStats() + "");
			}
		});
    	
    	colunaIdZooJaula.setCellValueFactory(new Callback<CellDataFeatures<Jaula, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Jaula, String> todos) {
				return new SimpleStringProperty(todos.getValue().getZoo() + "");
			}
		});
    	
    	colunaUltimaInspecJaula.setCellValueFactory(new Callback<CellDataFeatures<Jaula, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Jaula, String> todos) {
				return new SimpleStringProperty(ScreenManager.formatarLocalDate(todos.getValue().getDt_ultima_inspecao()));
			}
		});
    	
    	tabelaJaulas.setItems(FXCollections.observableArrayList(jaulas));
    	tabelaJaulas.refresh();
    }
    
    private void preencherTabelaJaulaNova() {
    	
    }
    
    private void preencherTabelaAnimal() {
    	
    }

}
