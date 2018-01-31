/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico - Versao 1.0 - 2017.2
 * TODO 15.01.2018 
 */
package br.ufrpe.zoologico;

import br.ufrpe.zoologico.gui.grafica.controller.Telas;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {

	@Override
	public void start(Stage primaryStage) {

		Telas t = Telas.getInstance();
		t.setStage(primaryStage);
		t.setP(new Principal());

		t.setDialogStage(new Stage());
		t.setCena(new Scene((Parent) t.carregarFXML("Principal")));
		t.abrirTelaDialogo();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
