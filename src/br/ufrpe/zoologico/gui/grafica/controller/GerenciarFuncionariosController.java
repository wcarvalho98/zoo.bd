package br.ufrpe.zoologico.gui.grafica.controller;

import br.ufrpe.zoologico.negocio.beans.Funcionario;
import br.ufrpe.zoologico.negocio.beans.JornadaTrabalho;
import br.ufrpe.zoologico.negocio.beans.Zoo;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GerenciarFuncionariosController {

    @FXML
    private TableView<Funcionario> tabelaFuncionarios;

    @FXML
    private TableColumn<Funcionario, String> colunaCpf;

    @FXML
    private TableColumn<Funcionario, String> colunaNome;

    @FXML
    private TableColumn<Funcionario, String> colunaEspecializacao;

    @FXML
    private TableColumn<Funcionario, String> colunaTelefone;

    @FXML
    private TableColumn<Funcionario, String> colunaDataContrato;

    @FXML
    private TableColumn<Funcionario, String> colunaSalario;

    @FXML
    private TableColumn<Funcionario, String> colunaEndereco;

    @FXML
    private TextField nomeTextField1;

    @FXML
    private TextField telefone1TextField1;

    @FXML
    private TextField telefone2TextField1;

    @FXML
    private TextField salarioTextField1;

    @FXML
    private TextField enderecoTextField1;

    @FXML
    private DatePicker contratoDatePicker1;

    @FXML
    private TextField cpfTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField telefone1TextField;

    @FXML
    private TextField telefone2TextField;

    @FXML
    private TextField salarioTextField;

    @FXML
    private TextField enderecoTextField;

    @FXML
    private TableView<Zoo> tbZoo;

    @FXML
    private TableColumn<Zoo, String> tcIdZoo;

    @FXML
    private TableColumn<Zoo, String> tcZoo;

    @FXML
    private TableView<JornadaTrabalho> tabelaJornadaTrabalho;

    @FXML
    private TableColumn<JornadaTrabalho, String> colunaIdJornada;

    @FXML
    private TableColumn<JornadaTrabalho, String> colunaDescricaoJornada;

    @FXML
    private RadioButton radioTratador;

    @FXML
    private RadioButton radioVeterinario;

    @FXML
    private RadioButton radioSecretario;

    @FXML
    private RadioButton radioAdministrador;

    @FXML
    private RadioButton radioNenhum;

    @FXML
    private DatePicker contratoDatePicker;
    
    private Funcionario funcionarioSelecionado;
    private Zoo zoologicoSelecionado;
    private JornadaTrabalho jornadaSelecionada;

    @FXML
    void cadastrarFuncionario() {

    }

    @FXML
    void editarFuncionario() {

    }

    @FXML
    void removerFuncionario() {

    }

    @FXML
    void selecionarAdministrador() {
    	radioAdministrador.setSelected(true);
    	radioVeterinario.setSelected(false);
    	radioTratador.setSelected(false);
    	radioNenhum.setSelected(false);
    	radioSecretario.setSelected(false);
    }

    @FXML
    void selecionarFuncionario() {
    	funcionarioSelecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();
    }

    @FXML
    void selecionarJornada() {
    	jornadaSelecionada = tabelaJornadaTrabalho.getSelectionModel().getSelectedItem();
    }

    @FXML
    void selecionarNenhum() {
    	radioAdministrador.setSelected(false);
    	radioVeterinario.setSelected(false);
    	radioTratador.setSelected(false);
    	radioNenhum.setSelected(true);
    	radioSecretario.setSelected(false);
    }

    @FXML
    void selecionarSecretario() {
    	radioAdministrador.setSelected(false);
    	radioVeterinario.setSelected(false);
    	radioTratador.setSelected(false);
    	radioNenhum.setSelected(false);
    	radioSecretario.setSelected(true);
    }

    @FXML
    void selecionarTratador() {
    	radioAdministrador.setSelected(false);
    	radioVeterinario.setSelected(false);
    	radioTratador.setSelected(true);
    	radioNenhum.setSelected(false);
    	radioSecretario.setSelected(false);
    }

    @FXML
    void selecionarVeterinario() {
    	radioAdministrador.setSelected(false);
    	radioVeterinario.setSelected(true);
    	radioTratador.setSelected(false);
    	radioNenhum.setSelected(false);
    	radioSecretario.setSelected(false);
    }

    @FXML
    void selecionarZoologico() {
    	zoologicoSelecionado = tbZoo.getSelectionModel().getSelectedItem();
    }
    
    @FXML public void voltar() {
    	ScreenManager.setScene(ScreenManager.getInstance().getTelaAdmin());
    }
}
