/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class GerenciarEstoque {

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
    void cadastrarEstoque(ActionEvent event) {

    }

    @FXML
    void cadastrarItemEstoque(ActionEvent event) {

    }

    @FXML
    void editarEstoque(ActionEvent event) {

    }

    @FXML
    void editarEstoqueItem(ActionEvent event) {

    }

    @FXML
    void removerEstoque(ActionEvent event) {

    }

    @FXML
    void removerEstoqueItem(ActionEvent event) {

    }

    @FXML
    void salvarAlteracoesEstoque(ActionEvent event) {

    }

    @FXML
    void salvarAlteracoesItemEstoque(ActionEvent event) {

    }

    @FXML
    void selecionarEstoque(MouseEvent event) {

    }

    @FXML
    void selecionarEstoqueItem(MouseEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

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

    }
}

