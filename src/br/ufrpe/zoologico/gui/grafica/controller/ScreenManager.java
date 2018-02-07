/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	private Scene telaAnimal;
	private Scene telaGerenciarServicos;
	private Scene telaFuncionarios;
	private Scene telaZoologico;
	private Scene telaEstoque;
	private Scene telaProduto;
	private Scene telaAnimal_Item;
	

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
			Transition t = FabricaTransicao.fazerTransicao(0.5, mainStage.getScene().getRoot(), false);
			t.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					try {
						Fachada.getInstance().fecharConexao();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						System.exit(0);
					}
				}
			});
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
		a.getRoot().setOpacity(0);
		if (mainStage.getScene() != null) {
			Transition t = FabricaTransicao.fazerTransicao(0.5, mainStage.getScene().getRoot(), false);
			t.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					mainStage.setScene(a);
					mainStage.show();
					FabricaTransicao.fazerTransicao(0.7, a.getRoot(), true);
				}
			});
		} else {
			mainStage.setScene(a);
			mainStage.show();
			FabricaTransicao.fazerTransicao(0.7, a.getRoot(), true);
		}
	}

	public static void setSceneRight(Scene a) {
		a.getRoot().setOpacity(0);
		if (mainStage.getScene() != null) {
			Transition t = FabricaTransicao.fazerTransicaoRight(0.5, mainStage.getScene().getRoot(), false);
			t.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					mainStage.setScene(a);
					mainStage.show();
					FabricaTransicao.fazerTransicaoRight(0.7, a.getRoot(), true);
				}
			});
		} else {
			mainStage.setScene(a);
			mainStage.show();
			FabricaTransicao.fazerTransicao(0.7, a.getRoot(), true);
		}
	}

	public static void setSceneLeft(Scene a) {
		a.getRoot().setOpacity(0);
		if (mainStage.getScene() != null) {
			Transition t = FabricaTransicao.fazerTransicaoLeft(0.5, mainStage.getScene().getRoot(), false);
			t.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					mainStage.setScene(a);
					mainStage.show();
					FabricaTransicao.fazerTransicaoLeft(0.7, a.getRoot(), true);
				}
			});
		} else {
			mainStage.setScene(a);
			mainStage.show();
			FabricaTransicao.fazerTransicao(0.7, a.getRoot(), true);
		}
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

	public Scene getTelaGerenciarAnimal() {
		try {
			telaAnimal = new Scene(FXMLLoader
					.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/GerenciamentoAnimal.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaAnimal;
	}

	public Scene getTelaCadastrarConsultas() {
		try {
			telaCadastrarConsultas = new Scene(FXMLLoader
					.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/CadastrarConsultas.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaCadastrarConsultas;
	}

	public Scene getTelaCadastrarInstituicao() {
		try {
			telaCadastrarInstituicao = new Scene(FXMLLoader
					.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/CadastroInstituicoes.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaCadastrarInstituicao;
	}

	public Scene getTelaGerenciarServicos() {
		try {
			telaGerenciarServicos = new Scene(FXMLLoader
					.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/GerenciarServicos.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaGerenciarServicos;
	}

	public Scene getTelaFuncionarios() {
		try {
			telaFuncionarios = new Scene(FXMLLoader
					.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/GerenciarFuncionarios.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaFuncionarios;
	}

	public static void alertaInformativo(String informacao) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Caixa de Alerta");
		alert.setHeaderText(null);
		alert.setContentText(informacao);

		alert.showAndWait();
	}

	public static void alertaErro(String informacao) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro!");
		alert.setHeaderText(null);
		alert.setContentText(informacao);

		alert.showAndWait();
	}

	/**
	 * Metodo: getTelaZoologico
	 * 
	 * @return telaZoologico
	 */
	public Scene getTelaZoologico() {
		try {
			telaZoologico = new Scene(
					FXMLLoader.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/GerenciarZoo.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaZoologico;
	}

	/**
	 * Metodo: getTelaEstoque
	 * 
	 * @return telaEstoque
	 */
	public Scene getTelaEstoque() {
		try {
			telaEstoque = new Scene(FXMLLoader
					.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/GerenciarEstoque.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaEstoque;
	}

	/**
	 * Metodo: getTelaProduto
	 * 
	 * @return
	 * @return Scene
	 */
	public Scene getTelaProduto() {
		try {
			telaProduto = new Scene(FXMLLoader
					.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/CadastroProduto.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaProduto;
	}

	/**
	 * Metodo: getTelaAnimal_Item
	 * @return telaAnimal_Item
	 */
	public Scene getTelaAnimal_Item() {
		try {
			telaAnimal_Item = new Scene(FXMLLoader
					.load(getClass().getResource("/br/ufrpe/zoologico/gui/grafica/FXML/GerenciamentoAnimal_Item.fxml")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return telaAnimal_Item;
	}

}
