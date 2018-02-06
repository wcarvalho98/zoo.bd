/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 05.02.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Categoria;
import br.ufrpe.zoologico.negocio.beans.Fornecedor;
import br.ufrpe.zoologico.negocio.beans.ProdutoRef;
import br.ufrpe.zoologico.negocio.beans.SubCategoria;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class CadastroProdutoController implements Initializable {

	@FXML private Button inserir, remover, alterar, confirmarCadastro, confirmarRemorcao, confirmarAlteracao;
	@FXML private TextField descricaoTextField, codBarrasTextField, freqPedido, qtdMinTextField, idProduto; 
	
	// TABELA FORNECEDOR
	@FXML private TableView<Fornecedor> tbFornecedor;
	@FXML private TableColumn<Fornecedor, String> tcIdFornecedor, tcNome, tcCnpj;
	
	// TABELA CATEGORIA
	@FXML private TableView<Categoria> tbCateg;
	@FXML private TableColumn<Categoria, String> tcIdCateg, tcCateg;
	
	// TABELA SUB_CATEGORIA
	@FXML private TableView<SubCategoria> tbSubCateg;
	@FXML private TableColumn<SubCategoria, String> tcIdSubCateg, tcSubCateg;
	
	private Fachada f;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		f = Fachada.getInstance();
		preencherTabelaCategoria(f.listarTodasCategorias());
		preencherTabelaFornecedor(f.listarTodosFornecedores());
		preencherTabelaSubCategoria(f.listarTodasSubCategorias());
	}

	@FXML
	public void voltar(){
		ScreenManager.setSceneLeft(ScreenManager.getInstance().getTelaAdmin());
	}
	
	@FXML 
	public void ir(){
		allDisable();
		idProduto.setVisible(true);
	}
	
	@FXML
	public void retornar(){
		allDisable();
		idProduto.setVisible(true);
	}
	
	@FXML 
	public void inserir(){
		confirmarCadastro.setVisible(true);
		confirmarCadastro.setDisable(false);
		confirmarRemorcao.setVisible(false);
		confirmarRemorcao.setDisable(true);
		confirmarAlteracao.setDisable(true);
		confirmarAlteracao.setVisible(false);
		allNotDisable();
		allNull();
		idProduto.setVisible(false);
	}
	
	@FXML
	public void remover(){
		/*confirmarRemorcao.setVisible(true);
		confirmarRemorcao.setDisable(false);*/
		confirmarCadastro.setVisible(false);
		confirmarCadastro.setDisable(true);
		confirmarAlteracao.setDisable(true);
		confirmarAlteracao.setVisible(false);
	}
	
	@FXML 
	public void alterar(){
		confirmarAlteracao.setDisable(false);
		confirmarAlteracao.setVisible(true);
		confirmarRemorcao.setVisible(false);
		confirmarRemorcao.setDisable(true);
		confirmarCadastro.setVisible(false);
		confirmarCadastro.setDisable(true);
		allNotDisable();
		allNull();
		idProduto.setVisible(false);
	}
	
	@FXML
	public void confirmarCadastro(){
		
	}
	
	@FXML
	public void confirmarRemorcao(){
		
	}
	
	@FXML
	public void confirmarAlteracao(){
		
	}
	
	public void preencherTabelaFornecedor(ArrayList<Fornecedor> o){
		tcIdFornecedor.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Fornecedor,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Fornecedor, String> param) {
				return new SimpleStringProperty(Integer.valueOf(param.getValue().getCod()).toString());
			}
		});
		
		tcNome.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Fornecedor,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Fornecedor, String> param) {
				return new SimpleStringProperty(param.getValue().getNome());
			}
		});
		
		tcCnpj.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Fornecedor,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Fornecedor, String> param) {
				return new SimpleStringProperty(param.getValue().getCnpj());
			}
		});
		
		tbFornecedor.setItems(FXCollections.observableArrayList(o));
	}
	
	public void preencherTabelaCategoria(ArrayList<Categoria> o){
		tcIdCateg.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Categoria,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Categoria, String> param) {
				return new SimpleStringProperty(Integer.valueOf(param.getValue().getCod()).toString());
			}
		});
		
		tcCateg.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Categoria,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Categoria, String> param) {
				return new SimpleStringProperty(param.getValue().getDescr());
			}
		});
		
		tbCateg.setItems(FXCollections.observableArrayList(o));
	}
	
	public void preencherTabelaSubCategoria(ArrayList<SubCategoria> o){
		tcIdSubCateg.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SubCategoria,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<SubCategoria, String> param) {
				return new SimpleStringProperty(Integer.valueOf(param.getValue().getCod()).toString());
			}
		});
		
		tcSubCateg.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SubCategoria,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<SubCategoria, String> param) {
				return new SimpleStringProperty(param.getValue().getDescr());
			}
		});;
		
		tbSubCateg.setItems(FXCollections.observableArrayList(o));
	}
	
	
	public void allDisable(){
		descricaoTextField.setDisable(true);
		codBarrasTextField.setDisable(true);
		freqPedido.setDisable(true);
		qtdMinTextField.setDisable(true);
	}
	
	public void allNotDisable(){
		descricaoTextField.setDisable(false);
		codBarrasTextField.setDisable(false);
		freqPedido.setDisable(false);
		qtdMinTextField.setDisable(false);
	}
	
	public void allNull(){
		descricaoTextField.setText(null);
		codBarrasTextField.setText(null);
		freqPedido.setText(null);
		qtdMinTextField.setText(null);
	}
	
	
	
}
