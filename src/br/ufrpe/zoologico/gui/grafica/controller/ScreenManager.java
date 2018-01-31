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

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager {
	private Scene telaCadastrarConsultas;
	private Scene telaLogin;
	private Scene telaAdmin;

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

	public static String formatarLocalDate(LocalDate a) {
		return a.getDayOfMonth() + "/" + a.getMonthValue() + "/" + a.getYear();
	}

	public static String formatarLocalTime(LocalTime a) {
		return a.getHour() + ":" + a.getMinute();
	}

	public static String formatarLocalDateTime(LocalDateTime a) {
		return formatarLocalDate(a.toLocalDate()) + " às " + formatarLocalTime(a.toLocalTime());
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
		mainStage.setScene(a);
		mainStage.show();
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

}
