package br.ufrpe.zoologico.gui.grafica.controller;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdminController {

	@FXML
	private Label lblTabela;

	@FXML
	void abrirTelaAnimal() {
		ScreenManager.setSceneRight(ScreenManager.getInstance().getTelaGerenciarAnimal());
	}

	@FXML
	void abrirTelaAnimal_Item() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAnimal_Item());
	}

	@FXML
	void abrirTelaConsulta() {
		ScreenManager.setSceneRight(ScreenManager.getInstance().getTelaCadastrarConsultas());
	}

	@FXML
	void abrirTelaEstoque() {
		ScreenManager.setSceneRight(ScreenManager.getInstance().getTelaEstoque());
	}

	@FXML
	void abrirTelaFuncionario() {
		ScreenManager.setSceneRight(ScreenManager.getInstance().getTelaFuncionarios());
	}

	@FXML
	void abrirTelaInstituicoes() {
		ScreenManager.setSceneRight(ScreenManager.getInstance().getTelaCadastrarInstituicao());
	}

	@FXML
	void abrirTelaJaula() {
		ScreenManager.setSceneRight(ScreenManager.getInstance().getTelaJaula());
	}

	@FXML
	void abrirTelaJaula_Animal() {

	}

	@FXML
	void abrirTelaProduto() {
		ScreenManager.setSceneRight(ScreenManager.getInstance().getTelaProduto());
	}

	@FXML
	void abrirTelaReserva() {

	}

	@FXML
	void abrirTelaServico_Faturas() {
		ScreenManager.setSceneRight(ScreenManager.getInstance().getTelaGerenciarServicos());
	}

	@FXML
	void abrirZoologico() {
		ScreenManager.setSceneRight(ScreenManager.getInstance().getTelaZoologico());
	}

	@FXML
	void desconectar() {
		try {
			Fachada.getInstance().fecharConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ScreenManager.setScene(ScreenManager.getInstance().getTelaLogin());
	}

	@FXML
	void fechar() {
		ScreenManager.sairDoSistema();
	}

	@FXML
	void inicio() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAdmin());
	}

}
