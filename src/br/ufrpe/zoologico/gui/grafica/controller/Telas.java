/** 
 * @author Pedro

 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 16.01.2018
 * Faltando AbrirTelaLogin 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import br.ufrpe.zoologico.Principal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Telas {
	private Stage stage;
	private Stage dialogStage;
	private Principal p;
	private static Telas instance;
	private ArrayList<Scene> cena;
	private FXMLLoader f;
	
	private Telas(){
		cena = new ArrayList<Scene>();
	}

	/**
	 * Metodo: getStage
	 * @return stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * Metodo: setStage
	 * @param stage the stage to set
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Metodo: getDialogStage
	 * @return dialogStage
	 */
	public Stage getDialogStage() {
		return dialogStage;
	}

	/**
	 * Metodo: setDialogStage
	 * @param dialogStage the dialogStage to set
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Metodo: getP
	 * @return p
	 */
	public Principal getP() {
		return p;
	}

	/**
	 * Metodo: setP
	 * @param p the p to set
	 */
	public void setP(Principal p) {
		this.p = p;
	}

	/**
	 * Metodo: getInstance
	 * @return instance
	 */
	public static Telas getInstance() {
		if (instance == null) {
			instance = new Telas();
		}

		return instance;
	}

	/**
	 * Metodo: getCena
	 * @return cena
	 */
	public ArrayList<Scene> getCena() {
		return cena;
	}

	/**
	 * Metodo: setCena
	 * @param cena the cena to set
	 */
	public void setCena(Scene cena) {
		this.cena.add(cena);
	}

	/**
	 * Metodo: getF
	 * @return f
	 */
	public FXMLLoader getF() {
		return f;
	}

	/**
	 * Metodo: setF
	 * @param f the f to set
	 */
	public void setF(FXMLLoader f) {
		this.f = f;
	}
	
	/** 
	 * Metodo: abrirTelaDialogo
	 * @return void
	 */
	public void abrirTelaDialogo() {
		dialogStage.setScene(cena.get(cena.size() - 1));
		dialogStage.showAndWait();
	}

	/** 
	 * Metodo: fecharTelaDialogo
	 * @return void
	 */
	public void fecharTelaDialogo() {
		this.cena.remove(cena.size() - 1);
		dialogStage.close();
	}

	/** 
	 * Metodo: abrirTela
	 * @return void
	 */
	public void abrirTela() {
		stage.setScene(this.cena.get(cena.size() - 1));
		stage.show();
	}

	/** 
	 * Metodo: fecharTela
	 * @return void
	 */
	public void fecharTela() {
		stage.close();
	}

	/** 
	 * Metodo: carregarFXML
	 * @param tela
	 * @return Node
	 */
	public Node carregarFXML(String tela) {
		String r = "gui/grafica/FXML/" + tela + ".fxml";
		Node root = null;
		f = new FXMLLoader(p.getClass().getResource(r));
		try {
			root = f.load();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return root;
	}
	
	/** 
	 * Metodo: voltarTela
	 * @return void
	 */
	public void voltarTela() {
		this.cena.remove(cena.size() - 1);
	}
	
	/** 
	 * Metodo: sairDoSistema
	 * @return void
	 */
	public void sairDoSistema() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirma��o");
		alert.setHeaderText("Sair");
		alert.setContentText("Deseja fechar o programa?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			System.exit(0);
		} else {
			alert.close();
		}
	}
	
	public void setScene(Scene s) {
		this.cena.add(s);
	}

}
