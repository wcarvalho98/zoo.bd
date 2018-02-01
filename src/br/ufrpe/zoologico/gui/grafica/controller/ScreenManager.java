/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ScreenManager {
	private Scene telaCadastrarConsultas;
	private Scene telaLogin;
	private Scene telaAdmin;
	private Scene telaJaula;
	private Scene telaCadastrarInstituicao;
	private Scene telaGerenciarServicos;

	private static Stage mainStage;

	private static ScreenManager instance;

	private ScreenManager() {

	}

	public static ScreenManager getInstance() {
		if (instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}
	
	public static boolean sairDoSistema() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Desconectar");
		alert.setHeaderText(null);
		alert.setContentText("Deseja fechar o programa?");

		Optional<ButtonType> result = alert.showAndWait();
		
		if (result.get().equals(ButtonType.OK)) {
			System.exit(0);
		} else {
			alert.close();
		}
		return false;
	}

	public static String formatarLocalDate(LocalDate a) {
		if (a != null) {
		return a.getDayOfMonth() + "/" + a.getMonthValue() + "/" + a.getYear();
		} else {
			return "--/--/----";
		}
	}

	public static String formatarLocalTime(LocalTime a) {
		return a.getHour() + ":" + a.getMinute();
	}

	public static String formatarLocalDateTime(LocalDateTime a) {
		return formatarLocalDate(a.toLocalDate()) + " as " + formatarLocalTime(a.toLocalTime());
	}

	public static String formatarDayOfWeek(DayOfWeek a) {
		if (a.equals(DayOfWeek.MONDAY)) {
			return "Segunda-Feira";
		} else if (a.equals(DayOfWeek.TUESDAY)) {
			return "Terça-Feira";
		} else if (a.equals(DayOfWeek.WEDNESDAY)) {
			return "Quarta-Feira";
		} else if (a.equals(DayOfWeek.THURSDAY)) {
			return "Quinta-Feira";
		} else if (a.equals(DayOfWeek.FRIDAY)) {
			return "Sexta-Feira";
		} else if (a.equals(DayOfWeek.SATURDAY)) {
			return "Sábado";
		} else {
			return "Domingo";
		}
	}

	public static void setScene(Scene a) {
		if (mainStage.getScene()!= null)
			FabricaTransicao.fazerTransicao(0.5, mainStage.getScene().getRoot(), false);
		else
			a.getRoot().setOpacity(0);
		mainStage.setScene(a);
		mainStage.show();
		FabricaTransicao.fazerTransicao(0.5, a.getRoot(), true);
	}

	public static Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage stage) {
		mainStage = stage;
	}

	public Scene getTelaLogin() {
		try {
			telaLogin = new Scene(
					FXMLLoader.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/Principal.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaLogin;
	}

	public Scene getTelaAdmin() {
		try {
			telaAdmin = new Scene(
					FXMLLoader.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/Admin.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaAdmin;
	}
	
	public Scene getTelaJaula() {
		try {
			telaJaula = new Scene(
					FXMLLoader.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/CadastroJaula.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaJaula;
	}

	public Scene getTelaCadastrarConsultas() {
		try {
			telaCadastrarConsultas = new Scene(
					FXMLLoader.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/CadastrarConsultas.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaCadastrarConsultas;
	}

	public Scene getTelaCadastrarInstituicao() {
		try {
			telaCadastrarInstituicao = new Scene(
					FXMLLoader.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/CadastroInstituicoes.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaCadastrarInstituicao;
	}

	public Scene getTelaGerenciarServicos() {
		try {
			telaGerenciarServicos = new Scene(
					FXMLLoader.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/GerenciarServicos.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaGerenciarServicos;
	}

}
