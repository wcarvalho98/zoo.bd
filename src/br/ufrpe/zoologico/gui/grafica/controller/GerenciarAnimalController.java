/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 01.02.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ArrayList;import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Especie;
import br.ufrpe.zoologico.negocio.beans.Genero;
import br.ufrpe.zoologico.negocio.beans.Jaula;
import br.ufrpe.zoologico.negocio.beans.Ordem;
import br.ufrpe.zoologico.negocio.beans.Zoo;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class GerenciarAnimalController implements Initializable{

	//TABLE ESPECIE
	@FXML private TableView<Especie> tbEspecie;
	@FXML private TableColumn<Especie, String> tcIdEspecie;
	@FXML private TableColumn<Especie, String> tcEspecie;
	
	//TABLE GENERO
	@FXML private TableView<Genero> tbGenero;
	@FXML private TableColumn<Genero, String> tcIdGenero;
	@FXML private TableColumn<Genero, String> tcGenero;
 	
	//TABLE ORDEM
	@FXML private TableView<Ordem> tbOrdem;
	@FXML private TableColumn<Ordem, String> tcIdOrdem;
	@FXML private TableColumn<Ordem, String> tcOrdem;
 	
	//TABLE ZOOLOGICO
	@FXML private TableView<Zoo> tbZoo;
	@FXML private TableColumn<Zoo, String> tcIdZoo;
	@FXML private TableColumn<Zoo, String> tcZoo;
 	
	//TABLE JAULA
	@FXML private TableView<Jaula> tbJaula;
	@FXML private TableColumn<Jaula, String> tcIdJaula;
	@FXML private TableColumn<Jaula, String> tcJaula;
	
	@FXML private TextField idAnimal, idade, nome;
	@FXML private TextArea obs;
	@FXML private DatePicker dtNas, dtFale;
 	
	private Fachada f;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		f = Fachada.getInstance();
		preencherTabelaGenero();
		preencherTabelaEspecie();
		preencherTabelaJaula();
		preencherTabelaZoo();
		preencherTabelaOrdem();
	}
	
	
	private void preencherTabelaGenero(){
		try {
			ArrayList<Genero> g = f.listarGenero();
			tcIdGenero.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Genero,String>, ObservableValue<String>>() {
				
				@Override
				public ObservableValue<String> call(CellDataFeatures<Genero, String> arg0) {
					return new SimpleStringProperty(Integer.valueOf(arg0.getValue().getId()).toString());
				}
			});
			
			tcGenero.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Genero,String>, ObservableValue<String>>() {

				@Override
				public ObservableValue<String> call(CellDataFeatures<Genero, String> param) {
					return new SimpleStringProperty(param.getValue().getNome());
				}
			});
			
			tbGenero.setItems(FXCollections.observableArrayList(g));
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Erro");
			a.setHeaderText(null);
			a.setContentText(e.getMessage());
			a.showAndWait();
		}
	}
	
	private void preencherTabelaEspecie(){
		try {
			ArrayList<Especie> e = f.listarEspecie();
			tcIdEspecie.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Especie,String>, ObservableValue<String>>() {

				@Override
				public ObservableValue<String> call(CellDataFeatures<Especie, String> param) {
					return new SimpleStringProperty(Integer.valueOf(param.getValue().getSeq()).toString());
				}
			});
			
			tcEspecie.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Especie,String>, ObservableValue<String>>() {

				@Override
				public ObservableValue<String> call(CellDataFeatures<Especie, String> param) {
					return new SimpleStringProperty(param.getValue().getNome());
				}
			});
			
			tbEspecie.setItems(FXCollections.observableArrayList(e));
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Erro");
			a.setHeaderText(null);
			a.setContentText(e.getMessage());
			a.showAndWait();
		}
	}
	
	private void preencherTabelaJaula(){
		try {
			ArrayList<Jaula> j = f.listarJaulas();
			tcIdJaula.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Jaula,String>, ObservableValue<String>>() {

				@Override
				public ObservableValue<String> call(CellDataFeatures<Jaula, String> param) {
					return new SimpleStringProperty(Integer.valueOf(param.getValue().getId_jaula()).toString());
				}
			});
			
			tcJaula.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Jaula,String>, ObservableValue<String>>() {

				@Override
				public ObservableValue<String> call(CellDataFeatures<Jaula, String> param) {
					return new SimpleStringProperty(param.getValue().getTipo());
				}
			});
			
			tbJaula.setItems(FXCollections.observableArrayList(j));
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Erro");
			a.setHeaderText(null);
			a.setContentText(e.getMessage());
			a.showAndWait();
		}
	}
	
	private void preencherTabelaZoo(){
		try {
			ArrayList<Zoo> z = f.listarZoo();
			tcIdZoo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Zoo,String>, ObservableValue<String>>() {

				@Override
				public ObservableValue<String> call(CellDataFeatures<Zoo, String> param) {
					return new SimpleStringProperty(Integer.valueOf(param.getValue().getIdZoo()).toString());
				}
			});
			
			tcZoo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Zoo,String>, ObservableValue<String>>() {

				@Override
				public ObservableValue<String> call(CellDataFeatures<Zoo, String> param) {
					return new SimpleStringProperty(param.getValue().getNome());
				}
			});
			
			tbZoo.setItems(FXCollections.observableArrayList(z));
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Erro");
			a.setHeaderText(null);
			a.setContentText(e.getMessage());
			a.showAndWait();
		}
	}
	
	/** 
	 * Metodo: preencherTabelaOrdem
	 * @return void
	 */
	private void preencherTabelaOrdem() {
		try {
			ArrayList<Ordem> o = f.listarOrdem();
			tcIdOrdem.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordem,String>, ObservableValue<String>>() {

				@Override
				public ObservableValue<String> call(CellDataFeatures<Ordem, String> param) {
					return new SimpleStringProperty(Integer.valueOf(param.getValue().getId()).toString());
				}
			});
			
			tcOrdem.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ordem,String>, ObservableValue<String>>() {

				@Override
				public ObservableValue<String> call(CellDataFeatures<Ordem, String> param) {
					return new SimpleStringProperty(param.getValue().getNome());
				}
			});
			
			tbOrdem.setItems(FXCollections.observableArrayList(o));

		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Erro");
			a.setHeaderText(null);
			a.setContentText(e.getMessage());
			a.showAndWait();
		}
	}
	
	private void allDisable(){
		idAnimal.setDisable(true);
		idade.setDisable(true);
		obs.setDisable(true);
		nome.setDisable(true);
		dtNas.setDisable(true);
		dtFale.setDisable(true);
	}
	
	private void allNotDisable(){
		idAnimal.setDisable(false);
		idade.setDisable(false);
		obs.setDisable(false);
		nome.setDisable(false);
		dtNas.setDisable(false);
		dtFale.setDisable(false);
	}
	
	private void allNull(){
		idAnimal.setText(null);
		idAnimal.setPromptText("ID");
		idade.setText(null);
		idade.setPromptText("Idade");
		obs.setText(null);
		obs.setPromptText("OBS");
		nome.setText(null);
		nome.setPromptText("Nome");
		dtNas.setValue(null);
		dtFale.setValue(null);
	}
	
	

}
