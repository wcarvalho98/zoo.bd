/** 
 * @author henrique
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 28.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.Consulta;
import br.ufrpe.zoologico.negocio.beans.Veterinario;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class GerenciarConsultasController implements Initializable {

	@FXML
	private TableView<Veterinario> tabelaVeterinarios;

	@FXML
	private TableColumn<Veterinario, String> colunaNomeVeterinario;

	@FXML
	private TableColumn<Veterinario, String> colunaCpfVeterinario;

	@FXML
	private TableView<Animal> tabelaAnimais;

	@FXML
	private TableColumn<Animal, String> colunaNomeAnimal;

	@FXML
	private TableColumn<Animal, String> colunaIdAnimal;

	@FXML
	private DatePicker dataDaConsultaDatePicker;

	@FXML
	private TextArea observacoesTextField;

	@FXML
	private TableView<Consulta> tabelaConsultasRemover;

	@FXML
	private TableColumn<Consulta, String> colunaNomeAnimalRemover;

	@FXML
	private TableColumn<Consulta, String> colunaidAnimalRemover;

	@FXML
	private TableColumn<Consulta, String> colunaNomeVeterinarioRemover;

	@FXML
	private TableColumn<Consulta, String> colunaIdVeterinarioRemover;

	@FXML
	private TableColumn<Consulta, String> colunaDataDaConsultaRemover;

	@FXML
	private Label idConsultaLabel;

	@FXML
	private Label nomeMedicoLabel;

	@FXML
	private Label nomeAnimalLabel;

	@FXML
	private Label horarioLabel;

	@FXML
	private Label obsLabel;

	@FXML
	private TableView<Animal> tabelaAnimais1;

	@FXML
	private TableColumn<Animal, String> colunaNomeAnimal1;

	@FXML
	private TableColumn<Animal, String> colunaIdAnimal1;

	@FXML
	private TableView<Veterinario> tabelaVeterinarios1;

	@FXML
	private TableColumn<Veterinario, String> colunaNomeVeterinario1;

	@FXML
	private TableColumn<Veterinario, String> colunaCpfVeterinario1;

	@FXML
	private DatePicker dataDaConsultaDatePicker1;

	@FXML
	private TextArea observacoesTextField1;

	@FXML
	private TextField minutoTextField;
	@FXML
	private TextField minutoTextField1;
	@FXML
	private TextField horaTextField;
	@FXML
	private TextField horaTextField1;
	

	private Consulta aRemover;
	private Animal animalSelecionado;
	private Veterinario veterinarioSelecionado;
	private Animal animalSelecionado1;
	private Veterinario veterinarioSelecionado1;
	private int idAtual = 0;
	private Consulta consultaAtual;

	@FXML
	void salvar() {
		LocalDateTime aux = LocalDateTime.of(dataDaConsultaDatePicker1.getValue(),
				LocalTime.of(Integer.parseInt(horaTextField1.getText()), Integer.parseInt(minutoTextField1.getText())));
		if (veterinarioSelecionado1 != null && animalSelecionado1 != null && (aux.isAfter(LocalDateTime.now()) || aux.isEqual(consultaAtual.getData()))) {
			consultaAtual.setAnimal(animalSelecionado1);
			consultaAtual.setVeterinario(veterinarioSelecionado1);
			consultaAtual.setData(aux);
			consultaAtual.setObs(observacoesTextField1.getText());
			Fachada.getInstance().alterarConsulta(consultaAtual);
			preencherCamposVisao();
			despreencherTabelas1();
			dataDaConsultaDatePicker1.setValue(LocalDate.now());
			horaTextField1.setText("");
			minutoTextField1.setText("");
			preencherTabelas();
		} else if (!aux.isAfter(LocalDateTime.now())) {
			ScreenManager.alertaErro("O novo horário da consulta não é futuro.");
		} else if (veterinarioSelecionado1 == null) {
			ScreenManager.alertaErro("Nenhum veterinário selecionado");
		} else if (animalSelecionado1 == null) {
			ScreenManager.alertaErro("Nenhum animal selecionado");
		} 
	}

	@FXML
	void anterior() {
		this.idAtual += -1;
		ArrayList<Consulta> aux = Fachada.getInstance().listarConsultas();
		if (this.idAtual == -1) {
			this.idAtual = aux.size() - 1;
		}
		consultaAtual = aux.get(idAtual);
		
		horaTextField1.setText("");
		minutoTextField1.setText("");
		observacoesTextField1.setText("");
		preencherCamposVisao();
		despreencherTabelas1();
	}

	@FXML
	void editar() {
		preencherTabelas1();
		dataDaConsultaDatePicker1.setValue(consultaAtual.getData().toLocalDate());
		horaTextField1.setText(consultaAtual.getData().getHour() + "");
		minutoTextField1.setText(consultaAtual.getData().getMinute() + "");
		observacoesTextField1.setText(consultaAtual.getObs());
	}
	
	@FXML
	void proximo() {
		this.idAtual += 1;
		ArrayList<Consulta> aux = Fachada.getInstance().listarConsultas();
		if (this.idAtual == aux.size()) {
			this.idAtual = 0;
		}
		consultaAtual = aux.get(idAtual);
		horaTextField1.setText("");
		minutoTextField1.setText("");
		observacoesTextField1.setText("");
		preencherCamposVisao();
		despreencherTabelas1();
	}

	@FXML
	void cadastrarConsulta() {
		LocalDateTime aux = LocalDateTime.of(dataDaConsultaDatePicker.getValue(),
				LocalTime.of(Integer.parseInt(horaTextField.getText()), Integer.parseInt(minutoTextField.getText())));
		if (animalSelecionado != null && veterinarioSelecionado != null && aux.isAfter(LocalDateTime.now())) {
			Consulta nova = new Consulta();
			nova.setAnimal(animalSelecionado);
			nova.setVeterinario(veterinarioSelecionado);
			nova.setObs(observacoesTextField.getText());
			nova.setData(aux);
			Fachada.getInstance().cadastrarConsulta(nova);
			preencherTabelas();
			preencherTabelas1();
			
			horaTextField.setText("");
			minutoTextField.setText("");
			observacoesTextField.setText("");
			animalSelecionado = null;
			veterinarioSelecionado = null;
		} else if (!aux.isAfter(LocalDateTime.now())) {
			ScreenManager.alertaErro("O novo horário da consulta não é futuro.");
		} else if (veterinarioSelecionado1 == null) {
			ScreenManager.alertaErro("Nenhum veterinário selecionado");
		} else if (animalSelecionado1 == null) {
			ScreenManager.alertaErro("Nenhum animal selecionado");
		} 
	}

	@FXML
	void removerConsulta() {
		if (aRemover != null) {
			Fachada.getInstance().removerConsulta(aRemover);
			preencherTabelas();
			preencherTabelas1();
			preencherCamposVisao();
		}
	}

	@FXML
	void selecionarAnimal() {
		animalSelecionado = tabelaAnimais.getSelectionModel().getSelectedItem();
	}

	@FXML
	void selecionarConsultaRemover() {
		aRemover = tabelaConsultasRemover.getSelectionModel().getSelectedItem();
	}

	@FXML
	void selecionarVeterinario() {
		veterinarioSelecionado = tabelaVeterinarios.getSelectionModel().getSelectedItem();
	}

	@FXML
	void selecionarVeterinario1() {
		veterinarioSelecionado1 = tabelaVeterinarios1.getSelectionModel().getSelectedItem();
	}

	@FXML
	void selecionarAnimal1() {
		animalSelecionado1 = tabelaAnimais1.getSelectionModel().getSelectedItem();
	}

	@FXML
	void voltar() {
		ScreenManager.setSceneLeft(ScreenManager.getInstance().getTelaAdmin()); 
	}

	private void preencherTabelas() {
		ArrayList<Animal> listaDeAnimais = Fachada.getInstance().listarAnimais();
		ArrayList<Veterinario> listaDeVeterinarios = Fachada.getInstance().listarVeterinarios();
		ArrayList<Consulta> listaDeConsultas = Fachada.getInstance().listarConsultas();

		colunaNomeAnimal.setCellValueFactory(new Callback<CellDataFeatures<Animal, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Animal, String> todosOsAnimais) {
				return new SimpleStringProperty(todosOsAnimais.getValue().getNome());
			}
		});

		colunaIdAnimal.setCellValueFactory(new Callback<CellDataFeatures<Animal, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Animal, String> todosOsAnimais) {
				return new SimpleStringProperty(Integer.valueOf(todosOsAnimais.getValue().getId()).toString());
			}
		});

		colunaNomeVeterinario
				.setCellValueFactory(new Callback<CellDataFeatures<Veterinario, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Veterinario, String> todosOsVeterinarios) {
						return new SimpleStringProperty(todosOsVeterinarios.getValue().getNome());
					}
				});
		colunaCpfVeterinario
				.setCellValueFactory(new Callback<CellDataFeatures<Veterinario, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Veterinario, String> todosOsVeterinarios) {
						return new SimpleStringProperty(todosOsVeterinarios.getValue().getCpf());
					}
				});
		colunaNomeAnimalRemover
				.setCellValueFactory(new Callback<CellDataFeatures<Consulta, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Consulta, String> todosOsVeterinarios) {
						return new SimpleStringProperty(todosOsVeterinarios.getValue().getAnimal().getNome());
					}
				});
		colunaidAnimalRemover
				.setCellValueFactory(new Callback<CellDataFeatures<Consulta, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Consulta, String> todosOsVeterinarios) {
						return new SimpleStringProperty(
								Integer.valueOf(todosOsVeterinarios.getValue().getAnimal().getId()).toString());
					}
				});

		colunaNomeVeterinarioRemover
				.setCellValueFactory(new Callback<CellDataFeatures<Consulta, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Consulta, String> todosOsVeterinarios) {
						return new SimpleStringProperty(todosOsVeterinarios.getValue().getVeterinario().getNome());
					}
				});

		colunaIdVeterinarioRemover
				.setCellValueFactory(new Callback<CellDataFeatures<Consulta, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Consulta, String> todosOsVeterinarios) {
						return new SimpleStringProperty(todosOsVeterinarios.getValue().getVeterinario().getCpf());
					}
				});

		colunaDataDaConsultaRemover
				.setCellValueFactory(new Callback<CellDataFeatures<Consulta, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Consulta, String> todosOsVeterinarios) {
						return new SimpleStringProperty(todosOsVeterinarios.getValue().getData().toString()); // TODO
																												// opcional
																												// Formatar
																												// LocalDate
					}
				});

		tabelaAnimais.setItems(FXCollections.observableArrayList(listaDeAnimais));
		tabelaAnimais.refresh();

		tabelaVeterinarios.setItems(FXCollections.observableArrayList(listaDeVeterinarios));
		tabelaVeterinarios.refresh();

		tabelaConsultasRemover.setItems(FXCollections.observableArrayList(listaDeConsultas));
		tabelaConsultasRemover.refresh();

	}

	private void preencherCamposVisao() {
		idConsultaLabel.setText(consultaAtual.getId_consulta() + "");
		nomeMedicoLabel.setText(consultaAtual.getVeterinario().getNome() + "\nCPF: " + consultaAtual.getVeterinario().getCpf());
		nomeAnimalLabel.setText(consultaAtual.getAnimal().getNome() + " ID: " + consultaAtual.getAnimal().getId());
		horarioLabel.setText(ScreenManager.formatarLocalDateTime(consultaAtual.getData()));
		obsLabel.setText(consultaAtual.getObs());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabelas();
		preencherTabelas1();
		if (Fachada.getInstance().listarConsultas().size() > 0) {
			consultaAtual = Fachada.getInstance().listarConsultas().get(idAtual);
			preencherCamposVisao();
		}
	}

	private void preencherTabelas1() {
		ArrayList<Animal> listaDeAnimais = Fachada.getInstance().listarAnimais();
		ArrayList<Veterinario> listaDeVeterinarios = Fachada.getInstance().listarVeterinarios();

		colunaNomeAnimal1
				.setCellValueFactory(new Callback<CellDataFeatures<Animal, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Animal, String> todosOsAnimais) {
						return new SimpleStringProperty(todosOsAnimais.getValue().getNome());
					}
				});

		colunaIdAnimal1.setCellValueFactory(new Callback<CellDataFeatures<Animal, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Animal, String> todosOsAnimais) {
				return new SimpleStringProperty(Integer.valueOf(todosOsAnimais.getValue().getId()).toString());
			}
		});

		colunaNomeVeterinario1
				.setCellValueFactory(new Callback<CellDataFeatures<Veterinario, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Veterinario, String> todosOsVeterinarios) {
						return new SimpleStringProperty(todosOsVeterinarios.getValue().getNome());
					}
				});
		colunaCpfVeterinario1
				.setCellValueFactory(new Callback<CellDataFeatures<Veterinario, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Veterinario, String> todosOsVeterinarios) {
						return new SimpleStringProperty(todosOsVeterinarios.getValue().getCpf());
					}
				});

		tabelaAnimais1.setItems(FXCollections.observableArrayList(listaDeAnimais));
		tabelaAnimais1.refresh();

		tabelaVeterinarios1.setItems(FXCollections.observableArrayList(listaDeVeterinarios));
		tabelaVeterinarios1.refresh();

	}
	
	private void despreencherTabelas1() {
		ArrayList<Animal> listaDeAnimais = new ArrayList<Animal>();
		ArrayList<Veterinario> listaDeVeterinarios = new ArrayList<Veterinario>();
		
		tabelaAnimais1.setItems(FXCollections.observableArrayList(listaDeAnimais));
		tabelaAnimais1.refresh();

		tabelaVeterinarios1.setItems(FXCollections.observableArrayList(listaDeVeterinarios));
		tabelaVeterinarios1.refresh();
	}

}
