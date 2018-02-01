/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 01.02.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;


import javafx.animation.Animation.Status;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.util.Duration;

public class FabricaTransicao {

	public static Transition fazerTransicao(double duracaoSegundos, Node stage, boolean ligar) {
		Duration duracao = new Duration(duracaoSegundos * 1000);
		int x = 0;
		int y = 1;
		Transition t = null;
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(duracao);
		fadeTransition.setNode(stage);
		if (!ligar) {
			x = 1;
			y = 0;
		}
		fadeTransition.setFromValue(x);
		fadeTransition.setToValue(y);
		fadeTransition.setInterpolator(Interpolator.LINEAR);;
		t = fadeTransition;
		t.play();
		return t;
		//while (fadeTransition.getStatus().equals(Status.RUNNING)) {
		//	System.out.println("123");
		//}
	}
	
}
