package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.Fatura;
import br.ufrpe.zoologico.negocio.beans.Servico;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class GerenciarServicosController implements Initializable {

	@FXML
	private TableView<Servico> tabelaServicos;

	@FXML
	private TableColumn<Servico, String> colunaIdServico;

	@FXML
	private TableColumn<Servico, String> colunaDescricao;

	@FXML
	private TableView<Fatura> tabelaFatura;

	@FXML
	private TableColumn<Fatura, String> colunaIdFatura;

	@FXML
	private TableColumn<Fatura, String> colunaValorFatura;

	@FXML
	private TableColumn<Fatura, String> colunaDataFatura;

	@FXML
	private TableColumn<Fatura, String> colunaDataPaga;

	@FXML
	private TableColumn<Fatura, String> colunaValorMulta;

	@FXML
	private TableColumn<Fatura, String> colunaStatus;

	@FXML
	private TableColumn<Fatura, String> colunaTipoFiatura;

	@FXML
	private TextField valorDaFaturaTextField;

	@FXML
	private TextField valorDaMultaTextField;

	@FXML
	private DatePicker dataDaFaturaDatePicker;

	@FXML
	private DatePicker dstaDePagamentoDatePicker;

	@FXML
	private TextField statusTextField;

	@FXML
	private TextField tipoDeFaturaTextField;
	@FXML
	private TextField valorServiçoTextField;

	@FXML
	private TextField descricaoServiçoTextField;

	private Servico servicoSelecionado;
	private Fatura faturaSelecionada;


	@FXML
	void cadastrarServico() {
		if (!descricaoServiçoTextField.getText().equals("")
				&& Double.parseDouble(valorServiçoTextField.getText()) >= 0) {
			Servico a = new Servico();
			a.setDescr(descricaoServiçoTextField.getText());
			a.setValor(Double.parseDouble(valorServiçoTextField.getText()));
			Fachada.getInstance().cadastrarServico(a);
			preencherTabelaServicos();
		}
	}

	@FXML
	void editarFatura() {
		if (faturaSelecionada != null) {
			preencherCamposEdicao(faturaSelecionada);
		}
	}
	
	@FXML public void removerServico() {
		if (servicoSelecionado != null) {
			Fachada.getInstance().removerServico(servicoSelecionado);
			preencherTabelaServicos();
		}
	}

	@FXML
	void salvarAlteracoes() {
		if (dataDaFaturaDatePicker.getValue() != null && Double.parseDouble(valorDaMultaTextField.getText()) >= 0
				&& Double.parseDouble(valorDaFaturaTextField.getText()) >= 0) {
			faturaSelecionada.setValor(Double.parseDouble(valorDaFaturaTextField.getText()));
			faturaSelecionada.setVl_multa(Double.parseDouble(valorDaMultaTextField.getText()));
			faturaSelecionada.setDataDaFatura(dataDaFaturaDatePicker.getValue());
			faturaSelecionada.setDt_paga(dstaDePagamentoDatePicker.getValue());
			faturaSelecionada.setStats(statusTextField.getText());
			faturaSelecionada.setTp_fatura(tipoDeFaturaTextField.getText());
			Fachada.getInstance().alterarFatura(faturaSelecionada);
			preencherCamposEdicao(null);
			preencherTabelaFaturas();
		}
	}

	@FXML
	void selecionarFatura() {
		faturaSelecionada = tabelaFatura.getSelectionModel().getSelectedItem();
	}

	@FXML
	void selecionarServico() {
		faturaSelecionada = null;
		preencherCamposEdicao(null);
		servicoSelecionado = tabelaServicos.getSelectionModel().getSelectedItem();
		if (servicoSelecionado != null) {
			preencherTabelaFaturas();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabelaServicos();
	}

	private void preencherTabelaServicos() {
		ArrayList<Servico> servicos = Fachada.getInstance().listarServicos();

		colunaIdServico.setCellValueFactory(new Callback<CellDataFeatures<Servico, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Servico, String> todosOsServicos) {
				return new SimpleStringProperty(todosOsServicos.getValue().getId() + "");
			}
		});

		colunaDescricao.setCellValueFactory(new Callback<CellDataFeatures<Servico, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Servico, String> todosOsServicos) {
				return new SimpleStringProperty(todosOsServicos.getValue().getDescr());
			}
		});

		tabelaServicos.setItems(FXCollections.observableArrayList(servicos));
		tabelaServicos.refresh();

	}

	private void preencherTabelaFaturas() {
		ArrayList<Fatura> faturas = Fachada.getInstance().faturasDoServico(servicoSelecionado);

		colunaIdFatura.setCellValueFactory(new Callback<CellDataFeatures<Fatura, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Fatura, String> todosOsServicos) {
				return new SimpleStringProperty(todosOsServicos.getValue().getIdFatura() + "");
			}
		});

		colunaValorFatura
				.setCellValueFactory(new Callback<CellDataFeatures<Fatura, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Fatura, String> todosOsServicos) {
						return new SimpleStringProperty(todosOsServicos.getValue().getValor() + "");
					}
				});

		colunaDataFatura.setCellValueFactory(new Callback<CellDataFeatures<Fatura, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Fatura, String> todosOsServicos) {
				return new SimpleStringProperty(
						ScreenManager.formatarLocalDate(todosOsServicos.getValue().getDataDaFatura()));
			}
		});

		colunaDataPaga.setCellValueFactory(new Callback<CellDataFeatures<Fatura, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Fatura, String> todosOsServicos) {
				return new SimpleStringProperty(
						ScreenManager.formatarLocalDate(todosOsServicos.getValue().getDt_paga()));
			}
		});

		colunaValorMulta.setCellValueFactory(new Callback<CellDataFeatures<Fatura, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Fatura, String> todosOsServicos) {
				return new SimpleStringProperty(todosOsServicos.getValue().getVl_multa() + "");
			}
		});

		colunaStatus.setCellValueFactory(new Callback<CellDataFeatures<Fatura, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Fatura, String> todosOsServicos) {
				return new SimpleStringProperty(todosOsServicos.getValue().getStats());
			}
		});

		colunaTipoFiatura
				.setCellValueFactory(new Callback<CellDataFeatures<Fatura, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Fatura, String> todosOsServicos) {
						return new SimpleStringProperty(todosOsServicos.getValue().getTp_fatura());
					}
				});

		tabelaFatura.setItems(FXCollections.observableArrayList(faturas));
		tabelaFatura.refresh();
	}

	private void preencherCamposEdicao(Fatura a) {
		if (a == null) {
			valorDaFaturaTextField.setText("");
			valorDaMultaTextField.setText("");
			dataDaFaturaDatePicker.setValue(null);
			dstaDePagamentoDatePicker.setValue(null);
			statusTextField.setText("");
			tipoDeFaturaTextField.setText("");
		} else {
			valorDaFaturaTextField.setText(a.getValor() + "");
			valorDaMultaTextField.setText(a.getVl_multa() + "");
			dataDaFaturaDatePicker.setValue(a.getDataDaFatura());
			dstaDePagamentoDatePicker.setValue(a.getDt_paga());
			statusTextField.setText(a.getStats());
			tipoDeFaturaTextField.setText(a.getTp_fatura());
		}
	}

	@FXML
	public void voltar() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAdmin()); 
	}

}
