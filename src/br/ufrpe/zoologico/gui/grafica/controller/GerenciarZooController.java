package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Zoo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class GerenciarZooController implements Initializable {

	@FXML
	private Button saveButton;

	@FXML
	private Label idZooLabel;

	@FXML
	private Label cnpjLabel;

	@FXML
	private Label nomeLabel;

	@FXML
	private Label razaoLabel;

	@FXML
	private Label horaAbreLabel;

	@FXML
	private Label horaFechaLabel;

	@FXML
	private TextField nomeTextField1;

	@FXML
	private TextField razaoTextField1;

	@FXML
	private TextField horaAbreTextField1;

	@FXML
	private TextField minutoAbreTextField1;

	@FXML
	private TextField horaFechaTextField1;

	@FXML
	private TextField minutoFechaTextField1;

	@FXML
	private TextField cnpjTextField;

	@FXML
	private TextField nomeTextField;

	@FXML
	private TextField razaoTextField;

	@FXML
	private TextField horaAbreTextField;

	@FXML
	private TextField minutoAbreTextField;

	@FXML
	private TextField horaFechaTextField;

	@FXML
	private TextField minutoFechaTextField;

	private int idAtual = 0;
	private Zoo zooAtual = null;

	@FXML
	void anterior() {
		try {
			setCamposDisable(true);
			idAtual += -1;
			ArrayList<Zoo> aux = Fachada.getInstance().listarZoo();
			if (idAtual == -1) {
				idAtual = aux.size() - 1;
			}
			zooAtual = aux.get(idAtual);
			preencherLabels();
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Erro");
			a.setHeaderText(null);
			a.setContentText(e.getMessage());
			a.showAndWait();
		}
	}

	@FXML
	void cadastrarZoologico() {
		try {
			if (!cnpjTextField.getText().equals("") && Integer.parseInt(horaAbreTextField.getText()) >= 0
					&& Integer.parseInt(horaFechaTextField.getText()) >= 0
					&& Integer.parseInt(minutoAbreTextField.getText()) >= 0
					&& Integer.parseInt(minutoFechaTextField.getText()) >= 0
					&& !nomeTextField.equals("")
					&& !razaoTextField.equals("")) {
				Zoo a = new Zoo();
				a.setCnpj(cnpjTextField.getText());
				a.setNome(nomeTextField.getText());
				a.setRazao_social(razaoTextField.getText());
				a.setHr_inic_func(LocalTime.of(Integer.parseInt(horaAbreTextField.getText()), Integer.parseInt(minutoAbreTextField.getText())));
				a.setHr_fim(LocalTime.of(Integer.parseInt(horaFechaTextField.getText()), Integer.parseInt(minutoFechaTextField.getText())));
			
				Fachada.getInstance().cadastrarZoo(a);
				preencherLabels();
				esvaziarCamposCadastro();
			}
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Erro");
			a.setHeaderText(null);
			a.setContentText(e.getMessage());
			a.showAndWait();
		}
	}

	@FXML
	void editar() {
		setCamposDisable(false);
		preencherCamposEdicao();
	}

	@FXML
	void proximo() {
		setCamposDisable(true);
		try {
			setCamposDisable(true);
			idAtual += 1;
			ArrayList<Zoo> aux = Fachada.getInstance().listarZoo();
			if (idAtual == aux.size()) {
				idAtual = 0;
			}
			zooAtual = aux.get(idAtual);
			preencherLabels();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void remover() {
		try {
			setCamposDisable(true);
			if (zooAtual != null && Fachada.getInstance().listarZoo().size() > 1) {
				Fachada.getInstance().removerZoo(zooAtual);
				idAtual = 0;
				zooAtual = Fachada.getInstance().listarZoo().get(idAtual);
				preencherLabels();
			} else {
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("Erro");
				a.setHeaderText(null);
				a.setContentText("Não pode ficar sem zológicos cadastrados no sistema");
				a.showAndWait();
			}
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Erro");
			a.setHeaderText(null);
			a.setContentText(e.getMessage());
			a.showAndWait();
		}
	}

	@FXML
	void salvarAlteracoes() {
		try {
			if (Integer.parseInt(horaAbreTextField1.getText()) >= 0
					&& Integer.parseInt(horaFechaTextField1.getText()) >= 0
					&& Integer.parseInt(minutoAbreTextField1.getText()) >= 0
					&& Integer.parseInt(minutoFechaTextField1.getText()) >= 0
					&& !nomeTextField1.equals("")
					&& !razaoTextField1.equals("")) {
				
				zooAtual.setNome(nomeTextField1.getText());
				zooAtual.setRazao_social(razaoTextField1.getText());
				zooAtual.setHr_inic_func(LocalTime.of(Integer.parseInt(horaAbreTextField1.getText()), Integer.parseInt(minutoAbreTextField1.getText())));
				zooAtual.setHr_fim(LocalTime.of(Integer.parseInt(horaFechaTextField1.getText()), Integer.parseInt(minutoFechaTextField1.getText())));
				Fachada.getInstance().alterarZoo(zooAtual);;
				preencherLabels();
				esvaziarCamposEdicao();
				setCamposDisable(true);
			}
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Erro");
			a.setHeaderText(null);
			a.setContentText(e.getMessage());
			a.showAndWait();
		}
	}

	@FXML
	void voltar() {
		ScreenManager.setSceneLeft(ScreenManager.getInstance().getTelaAdmin());
	}

	private void setCamposDisable(boolean is) {
		horaAbreTextField1.setDisable(is);
		horaFechaTextField1.setDisable(is);
		minutoAbreTextField1.setDisable(is);
		minutoFechaTextField1.setDisable(is);
		nomeTextField1.setDisable(is);
		razaoTextField1.setDisable(is);
		saveButton.setDisable(is);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			setCamposDisable(true);
			zooAtual = Fachada.getInstance().listarZoo().get(idAtual);
			preencherLabels();

		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Erro");
			a.setHeaderText(null);
			a.setContentText(e.getMessage());
			a.showAndWait();
		}
	}

	private void preencherLabels() {
		cnpjLabel.setText(zooAtual.getCnpj());
		idZooLabel.setText(zooAtual.getIdZoo() + "");
		horaAbreLabel.setText(ScreenManager.formatarLocalTime(zooAtual.getHr_inic_func()));
		horaFechaLabel.setText(ScreenManager.formatarLocalTime(zooAtual.getHr_fim()));
		nomeLabel.setText(zooAtual.getNome());
		razaoLabel.setText(zooAtual.getRazao_social());
	}

	private void preencherCamposEdicao() {
		nomeTextField1.setText(zooAtual.getNome());
		razaoTextField1.setText(zooAtual.getRazao_social());
		horaAbreTextField1.setText(zooAtual.getHr_inic_func().getHour() + "");
		minutoAbreTextField1.setText(zooAtual.getHr_inic_func().getMinute() + "");
		horaFechaTextField1.setText(zooAtual.getHr_fim().getHour() + "");
		minutoFechaTextField1.setText(zooAtual.getHr_fim().getMinute() + "");
	}

	private void esvaziarCamposEdicao() {
		nomeTextField1.setText("");
		razaoTextField1.setText("");
		horaAbreTextField1.setText("");
		minutoAbreTextField1.setText("");
		horaFechaTextField1.setText("");
		minutoFechaTextField1.setText("");
	}

	private void esvaziarCamposCadastro() {
		nomeTextField.setText("");
		razaoTextField.setText("");
		horaAbreTextField.setText("");
		minutoAbreTextField.setText("");
		horaFechaTextField.setText("");
		minutoFechaTextField.setText("");
		cnpjTextField.setText("");
	}

}
