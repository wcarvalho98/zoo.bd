/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.Estoque;
import br.ufrpe.zoologico.negocio.beans.ItemEstoque;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class GerenciarEstoque {

	@FXML
	private TableView<Estoque> tabelaEstoque;

	@FXML
	private TableColumn<Estoque, String> colunaIdEstoqueEstoque;

	@FXML
	private TableColumn<Estoque, String> colunaIdZoo;

	@FXML
	private TableColumn<Estoque, String> colunaDescricao;

	@FXML
	private TableColumn<Estoque, String> colunaLocalizacao;

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
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField descricaoTextField;

	@FXML
	private TextField localizacaoTextField;

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
	private TextField descricaoTextField1;

	@FXML
	private TextField localizacaoTextField1;

	@FXML
	private TextField idAnimalTextField1;

	@FXML
	private TextField vlCompraTextField1;

	@FXML
	private TextField quantidadeTextField1;

	@FXML
	private DatePicker dtValidadeDatePicker1;

	@FXML
	private DatePicker dtEntradaDatePicker1;

	@FXML
	void cadastrarEstoque() {

	}

	@FXML
	void cadastrarItemEstoque() {

	}

	@FXML
	void editarEstoque() {

	}

	@FXML
	void editarEstoqueItem() {

	}

	@FXML
	void removerEstoque() {

	}

	@FXML
	void removerEstoqueItem() {

	}

	@FXML
	void salvarAlteracoesEstoque() {

	}

	@FXML
	void salvarAlteracoesItemEstoque() {

	}

	@FXML
	void selecionarEstoque(MouseEvent event) {

	}

	@FXML
	void selecionarEstoqueItem(MouseEvent event) {

	}

	@FXML
	void voltar() {

	}

	@FXML
	void initialize() {
		assert descricaoTextField != null : "fx:id=\"descricaoTextField\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert localizacaoTextField != null : "fx:id=\"localizacaoTextField\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert idAnimalTextField != null : "fx:id=\"idAnimalTextField\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert vlCompraTextField != null : "fx:id=\"vlCompraTextField\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert quantidadeTextField != null : "fx:id=\"quantidadeTextField\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert dtValidadeDatePicker != null : "fx:id=\"dtValidadeDatePicker\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert dtEntradaDatePicker != null : "fx:id=\"dtEntradaDatePicker\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert descricaoTextField1 != null : "fx:id=\"descricaoTextField1\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert localizacaoTextField1 != null : "fx:id=\"localizacaoTextField1\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert idAnimalTextField1 != null : "fx:id=\"idAnimalTextField1\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert vlCompraTextField1 != null : "fx:id=\"vlCompraTextField1\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert quantidadeTextField1 != null : "fx:id=\"quantidadeTextField1\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert dtValidadeDatePicker1 != null : "fx:id=\"dtValidadeDatePicker1\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert dtEntradaDatePicker1 != null : "fx:id=\"dtEntradaDatePicker1\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
	
		preencherTabelaEstoque();
	}

	private void preencherTabelaEstoque() {
    	try {
			ArrayList<Estoque> estoque = Fachada.getInstance().listarEstoque();
			
			colunaIdZoo.setCellValueFactory(new Callback<CellDataFeatures<Estoque, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Estoque, String> estoques) {
					return new SimpleStringProperty(estoques.getValue().getIdZoo() + "");
				}
			});
			
			colunaIdEstoqueEstoque.setCellValueFactory(new Callback<CellDataFeatures<Estoque, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Estoque, String> estoques) {
					return new SimpleStringProperty(estoques.getValue().getId() + "");
				}
			});
			
			colunaDescricao.setCellValueFactory(new Callback<CellDataFeatures<Estoque, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Estoque, String> estoques) {
					return new SimpleStringProperty(estoques.getValue().getDescr() + "");
				}
			});
			
			colunaLocalizacao.setCellValueFactory(new Callback<CellDataFeatures<Estoque, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Estoque, String> estoques) {
					return new SimpleStringProperty(estoques.getValue().getLocalizacao() + "");
				}
			});
			
			tabelaEstoque.setItems(FXCollections.observableArrayList(estoque));
			tabelaEstoque.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
