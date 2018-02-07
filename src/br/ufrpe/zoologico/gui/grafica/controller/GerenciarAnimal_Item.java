package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.ItemEstoque;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class GerenciarAnimal_Item implements Initializable{

    @FXML
    private TableView<Animal> tabelaAnimal;

    @FXML
    private TableColumn<Animal, String> clunaIdAnimalAnimal;

    @FXML
    private TableColumn<Animal, String> colunaNome;

    @FXML
    private TableView<ItemEstoque> tabelaItemEstoque;

    @FXML
    private TableColumn<ItemEstoque, String> colunaCodProd;

    @FXML
    private TableColumn<ItemEstoque, String> colunaIdEstoqueItem;

    @FXML
    private TableColumn<ItemEstoque, String> colunaQtd;

    @FXML
    private TableColumn<ItemEstoque, String> colunaDtEntrada;

    @FXML
    private TableColumn<ItemEstoque, String> colunaVlCompra;

    @FXML
    private TableColumn<ItemEstoque, String> colunaDtValidade;

    @FXML
    private TableColumn<ItemEstoque, String> colunaIdAnimal;

    @FXML
    private Button editarItemButton;

    @FXML
    private Button salvarAlteracoesButton;

    @FXML
    private TextField idAnimalTextField;

    @FXML
    private TextField vlCompraTextField;

    @FXML
    private TextField quantidadeTextField;

    @FXML
    private DatePicker dtValidadeDatePicker;

    @FXML
    private DatePicker dtEntradaDatePicker;

    @FXML
    private Button adicionarItemButton;

    @FXML
    private Button cadastrarItemButton;

    @FXML
    void adicionarItem() {

    }

    @FXML
    void cadastrarItem() {

    }

    @FXML
    void editarEstoqueItem() {

    }

    @FXML
    void removerEstoqueItem() {

    }

    @FXML
    void salvarAlteracoesItemEstoque() {

    }

    @FXML
    void selecionarAnimal() {

    }

    @FXML
    void selecionarEstoqueItem() {

    }

    @FXML
    void voltar() {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		preencherTabelaAnimal();
	}

    
    private void preencherTabelaAnimal(){
    	ArrayList<Animal> animais = Fachada.getInstance().listarAnimais();
    	colunaNome.setCellValueFactory(new Callback<CellDataFeatures<Animal, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Animal, String> todosOsAnimais) {
				return new SimpleStringProperty(todosOsAnimais.getValue().getNome());
			}
		});

		clunaIdAnimalAnimal.setCellValueFactory(new Callback<CellDataFeatures<Animal, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Animal, String> todosOsAnimais) {
				return new SimpleStringProperty(Integer.valueOf(todosOsAnimais.getValue().getId()).toString());
			}
		});
		
		tabelaAnimal.setItems(FXCollections.observableArrayList(animais));
		tabelaAnimal.refresh();
    }

}
