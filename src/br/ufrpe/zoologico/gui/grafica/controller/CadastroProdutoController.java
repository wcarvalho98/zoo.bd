/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 05.02.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Categoria;
import br.ufrpe.zoologico.negocio.beans.Fornecedor;
import br.ufrpe.zoologico.negocio.beans.SubCategoria;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CadastroProdutoController implements Initializable {

	@FXML private Button inserir, remover, alterar, confirmarCadastro, confirmarRemorcao, confirmarAlteracao;
	@FXML private TextField descricaoTextField, codBarrasTextField, freqPedido, qtdMinTextField; 
	
	// TABELA FORNECEDOR
	@FXML private TableView<Fornecedor> tbFornecedor;
	@FXML private TableColumn<Fornecedor, String> tcIdFornecedor, tcNome, tcCnpj;
	
	// TABELA CATEGORIA
	@FXML private TableView<Categoria> tbCateg;
	@FXML private TableColumn<Categoria, String> tcIdCateg, tcCateg;
	
	// TABELA SUB_CATEGORIA
	@FXML private TableView<SubCategoria> tbSubCateg;
	@FXML private TableColumn<SubCategoria, String> tcIdSubCateg, tcSubCateg;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@FXML
	public void voltar(){
		ScreenManager.setSceneLeft(ScreenManager.getInstance().getTelaAdmin());
	}
	
	@FXML 
	public void ir(){
		
	}
	
	@FXML
	public void retornar(){
		
	}
	
	@FXML 
	public void inserir(){
		
	}
	
	@FXML
	public void remover(){
		
	}
	
	@FXML 
	public void alterar(){
		
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
	
	public void allDisable(){
		
	}
	
	public void allNotDisable(){
		
	}
	
	public void allNull(){
		
	}
	
}
