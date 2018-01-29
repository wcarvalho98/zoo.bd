/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 28.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class CadastroProdutoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField descricaoTextField;

    @FXML
    private TextField codBarrasTextField;

    @FXML
    private MenuButton freqPedidoMnuBtn;

    @FXML
    private MenuItem zeroMnuItm;

    @FXML
    private MenuItem umMnuItm;

    @FXML
    private MenuItem doisMnuItm;

    @FXML
    private MenuItem tresMnuItm;

    @FXML
    private MenuItem quatroMnuItm;

    @FXML
    private MenuItem cincoMnuItm;

    @FXML
    private MenuItem seisMnuItm;

    @FXML
    private MenuItem seteMnuItm;

    @FXML
    private MenuItem oitoMnuItm;

    @FXML
    private MenuItem noveMnuItm;

    @FXML
    private MenuItem dezMnuItm;

    @FXML
    private TextField qtdMinTextField;

    @FXML
    private MenuButton categMnuBtn;

    @FXML
    private MenuButton subcategoriaMnuBtn;

    @FXML
    private MenuButton fornecedorMnuBtn;

    @FXML
    void confirmarCadastro(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert descricaoTextField != null : "fx:id=\"descricaoTextField\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert codBarrasTextField != null : "fx:id=\"codBarrasTextField\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert freqPedidoMnuBtn != null : "fx:id=\"freqPedidoMnuBtn\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert zeroMnuItm != null : "fx:id=\"zeroMnuItm\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert umMnuItm != null : "fx:id=\"umMnuItm\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert doisMnuItm != null : "fx:id=\"doisMnuItm\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert tresMnuItm != null : "fx:id=\"tresMnuItm\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert quatroMnuItm != null : "fx:id=\"quatroMnuItm\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert cincoMnuItm != null : "fx:id=\"cincoMnuItm\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert seisMnuItm != null : "fx:id=\"seisMnuItm\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert seteMnuItm != null : "fx:id=\"seteMnuItm\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert oitoMnuItm != null : "fx:id=\"oitoMnuItm\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert noveMnuItm != null : "fx:id=\"noveMnuItm\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert dezMnuItm != null : "fx:id=\"dezMnuItm\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert qtdMinTextField != null : "fx:id=\"qtdMinTextField\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert categMnuBtn != null : "fx:id=\"categMnuBtn\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert subcategoriaMnuBtn != null : "fx:id=\"subcategoriaMnuBtn\" was not injected: check your FXML file 'CadastroProduto.fxml'.";
        assert fornecedorMnuBtn != null : "fx:id=\"fornecedorMnuBtn\" was not injected: check your FXML file 'CadastroProduto.fxml'.";

    }
}
