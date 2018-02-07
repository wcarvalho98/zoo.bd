/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 07.02.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.EspacoReservavel;
import br.ufrpe.zoologico.negocio.beans.Instituicao;
import br.ufrpe.zoologico.negocio.beans.Reserva;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class GerenciarReservasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField valorTextField;

    @FXML
    private TextField statsTextField;

    @FXML
    private TextField tpEventoTextField;

    @FXML
    private TextField cortesiaTextField;

    @FXML
    private TextField quantidadeTextField;

    @FXML
    private DatePicker dtValidadeDatePicker;

    @FXML
    private DatePicker dtReservaDatePicker;

    @FXML
    private TextField hrTextField;

    @FXML
    private TextField minutoTextField;

    @FXML
    private TextField hrInicioTextField;

    @FXML
    private TextField minutoInicioTextField;

    @FXML
    private TextField hrFimTextField;

    @FXML
    private TextField minutoFimTextField;

    @FXML
    private Label valorLabel;

    @FXML
    private Label cortesiaLabel;

    @FXML
    private Label hrFinalLabel;

    @FXML
    private Label hrInicioLabel;

    @FXML
    private Label hrLabel;

    @FXML
    private Label dtReservaLabel;

    @FXML
    private Label dtValidadeLabel;

    @FXML
    private Label qtdLabel;

    @FXML
    private Label idEspacoLabel;

    @FXML
    private Label statsLabel;

    @FXML
    private Label tpEventoLabel;

    @FXML
    private TableView<Instituicao> tabelaInstituicao;

    @FXML
    private TableColumn<Instituicao, String> colunaNomeInstituicao;

    @FXML
    private TableColumn<Instituicao, String> colunaCnpjInstituicao;

    @FXML
    private TableView<EspacoReservavel> tabelaEspaco;

    @FXML
    private TableColumn<EspacoReservavel, String> colunaNomeEspaco;

    @FXML
    private TableColumn<EspacoReservavel, String> colunaIdEspaco;

    @FXML
    private TableView<Reserva> tabelaReservaRemover;

    @FXML
    private TableColumn<Reserva, String> colunaCnpjRemover;

    @FXML
    private TableColumn<Reserva, String> colunaIdEspacoRemover;

    @FXML
    private TableColumn<Reserva, String> colunaDataDaReservaRemover;

    @FXML
    private TableColumn<Reserva, String> colunaDataValidadeRemover;

    @FXML
    private TableColumn<Reserva, String> colunaStatsRemover;
    
    private Reserva reservaAtual;
    private Instituicao instituicaoAtual;
    private EspacoReservavel espacoAtual;
    private int indice;
    private boolean insere;

    @FXML
    void anterior(ActionEvent event) {
    	
    }

    @FXML
    void editar(ActionEvent event) {
    	this.insere = false;
    }

    @FXML
    void inserir(ActionEvent event) {
    	this.insere = true;
    }

    @FXML
    void proximo(ActionEvent event) {

    }

    @FXML
    void removerReserva(ActionEvent event) {
    	
    }

    @FXML
    void salvar(ActionEvent event) {
    	if (instituicaoAtual != null && espacoAtual != null) {
    		reservaAtual.setCnpj(instituicaoAtual.getCnpj());
    		reservaAtual.setId(espacoAtual.getId());
    		reservaAtual.setValor(Double.parseDouble(valorTextField.getText()));
    		reservaAtual.setStats(statsTextField.getText());
    		reservaAtual.setTp_evento(tpEventoTextField.getText());
    		reservaAtual.setE_cortesia(cortesiaTextField.getText());
    		reservaAtual.setQtd_pessoas(Integer.parseInt(quantidadeTextField.getText()));
    		reservaAtual.setDt_validade(dtValidadeDatePicker.getValue());
    		reservaAtual.setDt_reserva(dtReservaDatePicker.getValue());
    		reservaAtual.setHorario(LocalTime.of(Integer.parseInt(hrTextField.getText()), Integer.parseInt(minutoTextField.getText())));
    		reservaAtual.setHr_inicio_reser(LocalTime.of(Integer.parseInt(hrInicioTextField.getText()), Integer.parseInt(minutoInicioTextField.getText())));
    		reservaAtual.setHr_final_reser(LocalTime.of(Integer.parseInt(hrFimTextField.getText()), Integer.parseInt(minutoFimTextField.getText())));
    		if (insere)
    			Fachada.getInstance().cadastrarReserva(reservaAtual);
    		else
    			Fachada.getInstance().alterarReserva(reservaAtual);
    	} else {
    		ScreenManager.alertaErro("Instituição ou espaço reservável não selecionado!");
    	}
    }

    @FXML
    void selecionarInstituicao(MouseEvent event) {

    }

    @FXML
    void selecionarEspaco(MouseEvent event) {

    }

    @FXML
    void selecionarReservaRemover(MouseEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
    	ScreenManager.setSceneLeft(ScreenManager.getInstance().getTelaAdmin());
    }

    @FXML
    void initialize() {
       this.reservaAtual = null;
       this.instituicaoAtual = null;
       this.espacoAtual = null;
       this.indice = 0;
       this.insere = false;
    }
}

