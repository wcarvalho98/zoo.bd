/** 
 * @author henrique
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 28.01.2018 
 */

package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Fatura;
import br.ufrpe.zoologico.negocio.beans.Instituicao;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class CadastroInstituicaoController implements Initializable{

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
    private TextField nomeUsualTextField1;

    @FXML
    private TextField razaoSocialTextField1;

    @FXML
    private TextField emailTextField1;

    @FXML
    private TextField telefone1TextField1;

    @FXML
    private TextField telefone2TextField1;

    @FXML
    private TableView<Instituicao> tabelaInstituicao;

    @FXML
    private TableColumn<Instituicao, String> colunaCnpj;

    @FXML
    private TableColumn<Instituicao, String> colunaNome;

    @FXML
    private TableColumn<Instituicao, String> colunaRazaoSocial;

    @FXML
    private TableColumn<Instituicao, String> colunaTipo;
    
    private Instituicao instituicaoSelecionada;

    @FXML
    void editarInstituicao() {
    	if (instituicaoSelecionada != null) {
			preencherCampos1(instituicaoSelecionada);
			disableCampos1(false);
		}
    }

    @FXML
    void removerInstituicao() {
    	if (instituicaoSelecionada != null) {
			Fachada.getInstance().removerInstituicao(instituicaoSelecionada);
	    	ScreenManager.alertaInformativo("Instituicao removida com sucesso!");
			preencherTabela();
		}
    }

    @FXML
    void salvarAlteracoes() {
    	instituicaoSelecionada.setTelefone1(telefone1TextField1.getText());
    	instituicaoSelecionada.setTelefone2(telefone2TextField1.getText());
    	instituicaoSelecionada.setEmail(emailTextField1.getText());
    	instituicaoSelecionada.setNome_contato(nomeUsualTextField1.getText());
    	instituicaoSelecionada.setRazao_social(razaoSocialTextField1.getText());
    	
    	Fachada.getInstance().alterarInstituicao(instituicaoSelecionada);
    	preencherTabela();
    	preencherCampos1(null);
    	disableCampos1(true);
    	ScreenManager.alertaInformativo("Dados alterados com sucesso!");
    }

    @FXML
    void selecionarInstituicao() {
    	preencherCampos1(null);
    	instituicaoSelecionada = tabelaInstituicao.getSelectionModel().getSelectedItem();
    }

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
    	    	ScreenManager.alertaInformativo("Instituicao cadastrada com sucesso!");
        		esvaziarCampos();
    		} else if(empresaRadioButton.isSelected()){
    			Fachada.getInstance().cadastrarInstituicao(new Instituicao(cnpjTextField.getText(), nomeUsualTextField.getText(), emailTextField.getText(), telefone1TextField.getText(), telefone2TextField.getText(), razaoSocialTextField.getText(), "Empresa"));
    	    	ScreenManager.alertaInformativo("Instituicao cadastrada com sucesso!");
    			esvaziarCampos();
    		} else{
    			ScreenManager.alertaErro("Nenhum campo Escola ou Empresa selecionado!");
    		}
    		preencherTabela();
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
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAdmin()); 
	}
    
    private void esvaziarCampos(){
    	nomeUsualTextField.setText("");
    	cnpjTextField.setText("");
    	razaoSocialTextField.setText("");
    	emailTextField.setText("");
    	telefone1TextField.setText("");
    	telefone2TextField.setText("");
    }
    
    private void preencherCampos1(Instituicao a) {
    	if (a == null) {
    		emailTextField1.setText("");
			nomeUsualTextField1.setText("");
			razaoSocialTextField1.setText("");
			telefone2TextField1.setText("");
			telefone1TextField1.setText("");
		} else {
			emailTextField1.setText(a.getEmail());
			nomeUsualTextField1.setText(a.getNome_contato());
			razaoSocialTextField1.setText(a.getRazao_social());
			telefone2TextField1.setText(a.getTelefone2());
			telefone1TextField1.setText(a.getTelefone1());
		}
    }
    
    private void disableCampos1(boolean t) {
    	emailTextField1.setDisable(t);
		nomeUsualTextField1.setDisable(t);
		razaoSocialTextField1.setDisable(t);
		telefone2TextField1.setDisable(t);
		telefone1TextField1.setDisable(t);
    }
    
    private void preencherTabela() {
    	ArrayList<Instituicao> instituicoes = Fachada.getInstance().listarInstituicoes();

		colunaCnpj.setCellValueFactory(new Callback<CellDataFeatures<Instituicao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Instituicao, String> todosAsInstituicoes) {
				return new SimpleStringProperty(todosAsInstituicoes.getValue().getCnpj());
			}
		});
		
		colunaNome.setCellValueFactory(new Callback<CellDataFeatures<Instituicao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Instituicao, String> todosAsInstituicoes) {
				return new SimpleStringProperty(todosAsInstituicoes.getValue().getNome_contato());
			}
		});
		
		colunaRazaoSocial.setCellValueFactory(new Callback<CellDataFeatures<Instituicao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Instituicao, String> todosAsInstituicoes) {
				return new SimpleStringProperty(todosAsInstituicoes.getValue().getRazao_social());
			}
		});
		
		colunaTipo.setCellValueFactory(new Callback<CellDataFeatures<Instituicao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Instituicao, String> todosAsInstituicoes) {
				return new SimpleStringProperty(todosAsInstituicoes.getValue().getTipo_instituicao());
			}
		});
		
		tabelaInstituicao.setItems(FXCollections.observableArrayList(instituicoes));
		tabelaInstituicao.refresh();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabela();
		disableCampos1(true);
	}

}

