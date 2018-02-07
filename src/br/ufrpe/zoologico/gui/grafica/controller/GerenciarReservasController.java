/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 07.02.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.EspacoReservavel;
import br.ufrpe.zoologico.negocio.beans.Instituicao;
import br.ufrpe.zoologico.negocio.beans.Reserva;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class GerenciarReservasController implements Initializable {

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
    
    @FXML
    private Label doisPontosUmLabel;
    
    @FXML
    private Label doisPontosDoisLabel;
    
    @FXML
    private Label doisPontosTresLabel;
    
    @FXML
    private Button saveButton;
    
    private Reserva reservaAtual;
    private Instituicao instituicaoAtual;
    private EspacoReservavel espacoAtual;
    private int indice;
    private boolean insere;

    @FXML
    void anterior(ActionEvent event) {
    	this.indice -= 1;
    	ArrayList<Reserva> res = Fachada.getInstance().listarReservas();
    	if (this.indice == -1)
    		this.indice = res.size() - 1;
    	preencheLabel();
    	preencheTabela();
    	if (valorTextField.isVisible())
    		alteraVisibilidade(false);
    }

    @FXML
    void editar(ActionEvent event) {
    	this.insere = false;
    	preencheCamposEdicao();
    	preencheTabelaGerencia();
    }

    @FXML
    void inserir(ActionEvent event) {
    	this.insere = true;
    	preencheCamposInsercao();
    	preencheTabelaGerencia();
    }

    @FXML
    void proximo(ActionEvent event) {
    	this.indice += 1;
    	ArrayList<Reserva> res = Fachada.getInstance().listarReservas();
    	if (this.indice >= res.size())
    		this.indice = 0;
    	preencheLabel();
    	preencheTabela();
    	if (valorTextField.isVisible())
    		alteraVisibilidade(false);
    }

    @FXML
    void removerReserva(ActionEvent event) {
    	if (reservaAtual != null) {
    		Fachada.getInstance().removerReserva(reservaAtual);
    		this.indice = 0;
    		preencheTabela();
    		preencheLabel();
        	instituicaoAtual = null;
        	espacoAtual = null;
        	reservaAtual = null;
    	} else {
    		ScreenManager.alertaErro("Reserva não foi selecionada!");
    	}
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
    	preencheLabel();
    	preencheTabela();
    	instituicaoAtual = null;
    	espacoAtual = null;
    	reservaAtual = null;
    }

    @FXML
    void selecionarInstituicao(MouseEvent event) {
    	instituicaoAtual = tabelaInstituicao.getSelectionModel().getSelectedItem();
    }

    @FXML
    void selecionarEspaco(MouseEvent event) {
    	espacoAtual = tabelaEspaco.getSelectionModel().getSelectedItem();
    }

    @FXML
    void selecionarReservaRemover(MouseEvent event) {
    	reservaAtual = tabelaReservaRemover.getSelectionModel().getSelectedItem();
    }

    @FXML
    void voltar(ActionEvent event) {
    	ScreenManager.setSceneLeft(ScreenManager.getInstance().getTelaAdmin());
    }
    
    private void alteraVisibilidade(boolean visivel) {
    	valorTextField.setVisible(visivel);
    	statsTextField.setVisible(visivel);
    	tpEventoTextField.setVisible(visivel);
    	cortesiaTextField.setVisible(visivel);
    	quantidadeTextField.setVisible(visivel);
    	dtValidadeDatePicker.setVisible(visivel);
    	dtReservaDatePicker.setVisible(visivel);
    	hrTextField.setVisible(visivel);
    	minutoTextField.setVisible(visivel);
    	hrInicioTextField.setVisible(visivel);
    	minutoInicioTextField.setVisible(visivel);
    	hrFimTextField.setVisible(visivel);
    	minutoFimTextField.setVisible(visivel);
    	doisPontosUmLabel.setVisible(visivel);
    	doisPontosDoisLabel.setVisible(visivel);
    	doisPontosTresLabel.setVisible(visivel);
    	saveButton.setVisible(visivel);
    }
    
    private void preencheLabel() {
        alteraVisibilidade(false);
    	ArrayList<Reserva> res = Fachada.getInstance().listarReservas();
    	idEspacoLabel.setText(res.get(indice).getId() + "");
    	valorLabel.setText(res.get(indice).getValor() + "");
    	statsLabel.setText(res.get(indice).getStats());
    	tpEventoLabel.setText(res.get(indice).getTp_evento());
    	cortesiaLabel.setText(res.get(indice).getE_cortesia());
    	qtdLabel.setText(res.get(indice).getQtd_pessoas() + "");
    	dtValidadeLabel.setText(ScreenManager.formatarLocalDate(res.get(indice).getDt_validade()));
    	dtReservaLabel.setText(ScreenManager.formatarLocalDate(res.get(indice).getDt_reserva()));
    	hrLabel.setText(ScreenManager.formatarLocalTime(res.get(indice).getHorario()));
    	hrInicioLabel.setText(ScreenManager.formatarLocalTime(res.get(indice).getHr_inicio_reser()));
    	hrFinalLabel.setText(ScreenManager.formatarLocalTime(res.get(indice).getHr_final_reser()));
    }
    
    private void preencheCamposEdicao() {
        alteraVisibilidade(true);
    	ArrayList<Reserva> res = Fachada.getInstance().listarReservas();
    	valorTextField.setText(res.get(indice).getValor() + "");
    	statsTextField.setText(res.get(indice).getStats());
    	tpEventoTextField.setText(res.get(indice).getTp_evento());
    	cortesiaTextField.setText(res.get(indice).getE_cortesia());
    	quantidadeTextField.setText(res.get(indice).getQtd_pessoas() + "");
    	dtValidadeDatePicker.setValue(res.get(indice).getDt_validade());
    	dtReservaDatePicker.setValue(res.get(indice).getDt_reserva());
    	hrTextField.setText(res.get(indice).getHorario().getHour() + "");
    	minutoTextField.setText(res.get(indice).getHorario().getMinute() + "");
    	hrInicioTextField.setText(res.get(indice).getHr_inicio_reser().getHour() + "");
    	minutoInicioTextField.setText(res.get(indice).getHr_inicio_reser().getMinute() + "");
    	hrFimTextField.setText(res.get(indice).getHr_final_reser().getHour() + "");
    	minutoFimTextField.setText(res.get(indice).getHr_final_reser().getMinute() + "");
    }
    
    private void preencheCamposInsercao() {
        alteraVisibilidade(true);
    	valorTextField.setText(null);
    	statsTextField.setText(null);
    	tpEventoTextField.setText(null);
    	cortesiaTextField.setText(null);
    	quantidadeTextField.setText(null);
    	dtValidadeDatePicker.setValue(null);
    	dtReservaDatePicker.setValue(LocalDate.now());
    	hrTextField.setText(null);
    	minutoTextField.setText(null);
    	hrInicioTextField.setText(null);
    	minutoInicioTextField.setText(null);
    	hrFimTextField.setText(null);
    	minutoFimTextField.setText(null);
    }
    
    private void preencheTabela() {
    	ArrayList<Instituicao> listaDeInstituicoes = new ArrayList<Instituicao>();
    	ArrayList<EspacoReservavel> listaDeEspacos = new ArrayList<EspacoReservavel>();
    	ArrayList<Reserva> res = Fachada.getInstance().listarReservas();
    	
    	listaDeInstituicoes.add(Fachada.getInstance().buscarInstituicao(res.get(indice).getCnpj()));
    	listaDeEspacos.add(Fachada.getInstance().buscarEspacoReservavel(res.get(indice).getId()));
    	
    	colunaCnpjInstituicao.setCellValueFactory(new Callback<CellDataFeatures<Instituicao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Instituicao, String> instituicao) {
				return new SimpleStringProperty(instituicao.getValue().getCnpj());
			}
		});
    	
    	colunaNomeInstituicao.setCellValueFactory(new Callback<CellDataFeatures<Instituicao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Instituicao, String> instituicao) {
				return new SimpleStringProperty(instituicao.getValue().getRazao_social());
			}
		});
    	
    	colunaNomeEspaco.setCellValueFactory(new Callback<CellDataFeatures<EspacoReservavel, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<EspacoReservavel, String> espaco) {
				return new SimpleStringProperty(espaco.getValue().getNome());
			}
		});
    	
    	colunaIdEspaco.setCellValueFactory(new Callback<CellDataFeatures<EspacoReservavel, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<EspacoReservavel, String> espaco) {
				return new SimpleStringProperty(espaco.getValue().getId() + "");
			}
		});
    	
    	colunaCnpjRemover.setCellValueFactory(new Callback<CellDataFeatures<Reserva, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Reserva, String> todasAsReservas) {
				return new SimpleStringProperty(todasAsReservas.getValue().getCnpj());
			}
		});
    	
    	colunaIdEspacoRemover.setCellValueFactory(new Callback<CellDataFeatures<Reserva, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Reserva, String> todasAsReservas) {
				return new SimpleStringProperty(todasAsReservas.getValue().getId() + "");
			}
		});
    	
    	colunaDataDaReservaRemover.setCellValueFactory(new Callback<CellDataFeatures<Reserva, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Reserva, String> todasAsReservas) {
				return new SimpleStringProperty(ScreenManager.formatarLocalDate(todasAsReservas.getValue().getDt_reserva()));
			}
		});
    	
    	colunaDataValidadeRemover.setCellValueFactory(new Callback<CellDataFeatures<Reserva, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Reserva, String> todasAsReservas) {
				return new SimpleStringProperty(ScreenManager.formatarLocalDate(todasAsReservas.getValue().getDt_validade()));
			}
		});
    	
    	colunaStatsRemover.setCellValueFactory(new Callback<CellDataFeatures<Reserva, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Reserva, String> todasAsReservas) {
				return new SimpleStringProperty(todasAsReservas.getValue().getStats());
			}
		});
    	
    	tabelaInstituicao.setItems(FXCollections.observableArrayList(listaDeInstituicoes));
    	tabelaInstituicao.refresh();
    	
    	tabelaEspaco.setItems(FXCollections.observableArrayList(listaDeEspacos));
    	tabelaEspaco.refresh();
    	
    	tabelaReservaRemover.setItems(FXCollections.observableArrayList(res));
    	tabelaReservaRemover.refresh();
    }
    
    private void preencheTabelaGerencia() {
    	ArrayList<Instituicao> listaDeInstituicoes = Fachada.getInstance().listarInstituicoes();
    	ArrayList<EspacoReservavel> listaDeEspacos = Fachada.getInstance().listarTodosEspacosReservaveis();
    	
    	colunaCnpjInstituicao.setCellValueFactory(new Callback<CellDataFeatures<Instituicao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Instituicao, String> instituicaoAtual) {
				return new SimpleStringProperty(instituicaoAtual.getValue().getCnpj());
			}
		});
    	
    	colunaNomeInstituicao.setCellValueFactory(new Callback<CellDataFeatures<Instituicao, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Instituicao, String> instituicaoAtual) {
				return new SimpleStringProperty(instituicaoAtual.getValue().getNome_contato());
			}
		});
    	
    	colunaNomeEspaco.setCellValueFactory(new Callback<CellDataFeatures<EspacoReservavel, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<EspacoReservavel, String> espacoAtual) {
				return new SimpleStringProperty(espacoAtual.getValue().getNome());
			}
		});
    	
    	colunaIdEspaco.setCellValueFactory(new Callback<CellDataFeatures<EspacoReservavel, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<EspacoReservavel, String> espacoAtual) {
				return new SimpleStringProperty(espacoAtual.getValue().getId() + "");
			}
		});
    	
    	tabelaInstituicao.setItems(FXCollections.observableArrayList(listaDeInstituicoes));
    	tabelaInstituicao.refresh();
    	
    	tabelaEspaco.setItems(FXCollections.observableArrayList(listaDeEspacos));
    	tabelaEspaco.refresh();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.reservaAtual = null;
		this.instituicaoAtual = null;
		this.espacoAtual = null;
		this.indice = 0;
		this.insere = false;
		preencheLabel();
		preencheTabela();
	}
}

