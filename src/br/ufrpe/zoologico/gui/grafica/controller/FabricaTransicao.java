/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 01.02.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
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
		fadeTransition.setInterpolator(Interpolator.LINEAR);
		;
		t = fadeTransition;
		t.play();
		return t;
	}

	public static Transition fazerTransicaoRight(double duracaoSegundos, Node stage, boolean ligar) {
		Duration duracao = new Duration(duracaoSegundos * 1000);
		int x = 0;
		int y = 1;
		TranslateTransition translateTransition = new TranslateTransition(duracao, stage);
		FadeTransition fadeTransition = new FadeTransition(duracao, stage);
		if (!ligar) {
			x = 1;
			y = 0;
			translateTransition.setFromX(0f);
			translateTransition.setToX(-300f);
		} else {
			translateTransition.setFromX(300f);
			translateTransition.setToX(0f);
		}
		fadeTransition.setFromValue(x);
		fadeTransition.setToValue(y);
		fadeTransition.setInterpolator(Interpolator.LINEAR);
		translateTransition.setInterpolator(Interpolator.LINEAR);
		ParallelTransition pl = new ParallelTransition(stage, fadeTransition, translateTransition);
		pl.play();
		return pl;
	}

	public static Transition fazerTransicaoLeft(double duracaoSegundos, Node stage, boolean ligar) {
		Duration duracao = new Duration(duracaoSegundos * 1000);
		TranslateTransition translateTransition = new TranslateTransition(duracao, stage);
		FadeTransition fadeTransition = new FadeTransition(duracao, stage);
		int x = 0;
		int y = 1;
		if (!ligar) {
			x = 1;
			y = 0;
			translateTransition.setFromX(0f);
			translateTransition.setToX(300f);
		} else {
			translateTransition.setFromX(-300f);
			translateTransition.setToX(0f);
		}
		fadeTransition.setFromValue(x);
		fadeTransition.setToValue(y);
		fadeTransition.setInterpolator(Interpolator.LINEAR);
		translateTransition.setInterpolator(Interpolator.LINEAR);
		ParallelTransition pl = new ParallelTransition(stage, fadeTransition, translateTransition);
		pl.play();
		return pl;
	}

}
