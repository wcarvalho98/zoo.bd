package br.ufrpe.zoologico.gui.grafica.controller;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class AdminController {

    @FXML
    private Label lblTabela;

    @FXML
    void abrirTelaAnimal() {
    	ScreenManager.setScene(ScreenManager.getInstance().getTelaGerenciarAnimal());
    }

    @FXML
    void abrirTelaAnimal_Item() {
    	
    }

    @FXML
    void abrirTelaConsulta() {
    	ScreenManager.setScene(ScreenManager.getInstance().getTelaCadastrarConsultas());
    }

    @FXML
    void abrirTelaEstoque() {
    	ScreenManager.setScene(ScreenManager.getInstance().getTelaEstoque());
    }

    @FXML
    void abrirTelaFuncionario() {
    	ScreenManager.setScene(ScreenManager.getInstance().getTelaFuncionarios());
    }

    @FXML
    void abrirTelaInstituicoes() {
    	ScreenManager.setScene(ScreenManager.getInstance().getTelaCadastrarInstituicao());
    }

    @FXML
    void abrirTelaJaula() {
    	ScreenManager.setScene(ScreenManager.getInstance().getTelaJaula());
    }

    @FXML
    void abrirTelaJaula_Animal() {

    }

    @FXML
    void abrirTelaProduto() {

    }

    @FXML
    void abrirTelaReserva() {

    }

    @FXML
    void abrirTelaServico_Faturas() {
    	ScreenManager.setScene(ScreenManager.getInstance().getTelaGerenciarServicos());
    }

    @FXML
    void abrirZoologico() {
    	ScreenManager.setScene(ScreenManager.getInstance().getTelaZoologico());
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
    	
    }

    @FXML
    void inicio() {

    }

}
