/** 
 * @author henrique
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 28.01.2018 
 */

package br.ufrpe.zoologico.gui.grafica.controller;

import br.ufrpe.zoologico.negocio.beans.Instituicao;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class CadastroInstituicaoController {

    @FXML
    private TextField nomeUsualTextField;

    @FXML
    private TextField cnpjTextField;

    @FXML
    private TextField razaoSocialTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField telefone1TextField;

    @FXML
    private TextField telefone2TextField;
    
    @FXML private RadioButton escolaRadioButton;

    @FXML private RadioButton empresaRadioButton;

    @FXML
    void confirmarCadastro() {
    	if(!nomeUsualTextField.getText().equals("") &&
    			!cnpjTextField.getText().equals("") &&
    			!razaoSocialTextField.getText().equals("") &&
    			!emailTextField.getText().equals("") &&
    			!telefone1TextField.getText().equals("") &&
    			!telefone2TextField.getText().equals("") ){
    		if(escolaRadioButton.isSelected()){
    			Fachada.getInstance().cadastrarInstituicao(new Instituicao(cnpjTextField.getText(), nomeUsualTextField.getText(), emailTextField.getText(), telefone1TextField.getText(), telefone2TextField.getText(), razaoSocialTextField.getText(), "Escola"));
        		esvaziarCampos();
    		} else if(empresaRadioButton.isSelected()){
    			Fachada.getInstance().cadastrarInstituicao(new Instituicao(cnpjTextField.getText(), nomeUsualTextField.getText(), emailTextField.getText(), telefone1TextField.getText(), telefone2TextField.getText(), razaoSocialTextField.getText(), "Empresa"));
        		esvaziarCampos();
    		} else{
    			System.err.println("Nenhum campo Escola ou Empresa selecionado");
    		}
    	}
    }

    @FXML
    void setEmpresaSelecionado() {
    	empresaRadioButton.setSelected(true);
    	escolaRadioButton.setSelected(false);
    }

    @FXML
    void setEscolaSelecionado() {
    	empresaRadioButton.setSelected(false);
    	escolaRadioButton.setSelected(true);
    }

    @FXML
    void voltar() {
		Telas.getInstance().setCena(new Scene((Parent) Telas.getInstance().carregarFXML("Principal")));
		Telas.getInstance().abrirTelaDialogo();
    }
    
    private void esvaziarCampos(){
    	nomeUsualTextField.setText("");
    	cnpjTextField.setText("");
    	razaoSocialTextField.setText("");
    	emailTextField.setText("");
    	telefone1TextField.setText("");
    	telefone2TextField.setText("");
    }

}

