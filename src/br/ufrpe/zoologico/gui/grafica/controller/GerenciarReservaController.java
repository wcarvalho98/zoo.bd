/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 29.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class GerenciarReservaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea observacoesTextField;

    @FXML
    private TableView<?> tabelaReservasRemover;

    @FXML
    private TableColumn<?, ?> colunaIdEspacoRemover;

    @FXML
    private TableColumn<?, ?> colunaCnpjRemover;

    @FXML
    private TableColumn<?, ?> colunaDtReservaRemover;

    @FXML
    private TableColumn<?, ?> colunaDtValidadeRemover;

    @FXML
    private TableColumn<?, ?> colunaHorarioInicioRemover;

    @FXML
    void cadastrarReserva(ActionEvent event) {

    }

    @FXML
    void removerReserva(ActionEvent event) {

    }

    @FXML
    void selecionarReservaRemover(MouseEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert observacoesTextField != null : "fx:id=\"observacoesTextField\" was not injected: check your FXML file 'CadastroReserva.fxml'.";
        assert tabelaReservasRemover != null : "fx:id=\"tabelaReservasRemover\" was not injected: check your FXML file 'CadastroReserva.fxml'.";
        assert colunaIdEspacoRemover != null : "fx:id=\"colunaIdEspacoRemover\" was not injected: check your FXML file 'CadastroReserva.fxml'.";
        assert colunaCnpjRemover != null : "fx:id=\"colunaCnpjRemover\" was not injected: check your FXML file 'CadastroReserva.fxml'.";
        assert colunaDtReservaRemover != null : "fx:id=\"colunaDtReservaRemover\" was not injected: check your FXML file 'CadastroReserva.fxml'.";
        assert colunaDtValidadeRemover != null : "fx:id=\"colunaDtValidadeRemover\" was not injected: check your FXML file 'CadastroReserva.fxml'.";
        assert colunaHorarioInicioRemover != null : "fx:id=\"colunaHorarioInicioRemover\" was not injected: check your FXML file 'CadastroReserva.fxml'.";

    }
}
