/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico - Versao 1.0 - 2017.2
 * TODO 15.01.2018 
 */
package br.ufrpe.zoologico;

import br.ufrpe.zoologico.gui.grafica.controller.ScreenManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Principal extends Application {

	@Override
	public void start(Stage primaryStage) {
		ScreenManager.getInstance().setMainStage(primaryStage);
		ScreenManager.getMainStage().setTitle("Zoológico");
		ScreenManager.getMainStage().setResizable(false);
		ScreenManager.setScene(ScreenManager.getInstance().getTelaLogin());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
