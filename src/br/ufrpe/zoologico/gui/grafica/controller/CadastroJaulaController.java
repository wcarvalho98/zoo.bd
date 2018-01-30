/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 29.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroJaulaController  implements Initializable{
	
	@FXML private TextField idZoo, tratador, max, comp, larg, altura, dias, idJaula;
	@FXML private TextArea obs;
	@FXML private DatePicker dtInsp;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		allDisable();
	}
	
	@FXML
	public void voltar(){
		
	}
	
	@FXML 
	public void passar(){
		
	}
	
	@FXML
	public void retornar(){
		
	}
	
	@FXML 
	public void enter(){
		
	}
	
	@FXML
	public void remover(){
		allDisable();
		idJaula.setDisable(true);
	}
	
	@FXML
	public void alterar(){
		allNotDisable();
		idJaula.setDisable(true);
	}
	
	@FXML
	public void inserir(){
		allNull();
		allNotDisable();
		idJaula.setDisable(true);
		
	}
	
	@FXML
	public void buscar(){
		allDisable();
		idJaula.setDisable(false);
	}
	
	private void allNotDisable(){
		idZoo.setDisable(false);
		tratador.setDisable(false);
		max.setDisable(false);
		comp.setDisable(false);
		larg.setDisable(false);
		altura.setDisable(false);
		dtInsp.setDisable(false);
		dias.setDisable(false);
		idJaula.setDisable(false);
		obs.setDisable(false);
	}
	
	private void allDisable(){
		idZoo.setDisable(true);
		tratador.setDisable(true);
		max.setDisable(true);
		comp.setDisable(true);
		larg.setDisable(true);
		altura.setDisable(true);
		dtInsp.setDisable(true);
		dias.setDisable(true);
		idJaula.setDisable(true);
		obs.setDisable(true);
	}
	
	private void allNull(){
		idZoo.setPromptText("ID");
		tratador.setPromptText("CPF");
		max.setPromptText("MAX");
		comp.setPromptText("Comp");
		larg.setPromptText("Larg");
		altura.setPromptText("Altura");
		dtInsp.setUserData(null);
		dias.setPromptText("DIAS");
		idJaula.setPromptText("ID");
		obs.setPromptText("Observação");
	}
}
