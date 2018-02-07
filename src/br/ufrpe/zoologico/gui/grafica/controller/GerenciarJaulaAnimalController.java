package br.ufrpe.zoologico.gui.grafica.controller;

import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.Jaula;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GerenciarJaulaAnimalController {

    @FXML
    private TableView<Animal> tabelaAnimal;

    @FXML
    private TableColumn<Animal, String> colunaIdAnimal;

    @FXML
    private TableColumn<Animal, String> colunaNomeAnimal;

    @FXML
    private TableColumn<Animal, String> colunaIdadeAnimal;

    @FXML
    private TableColumn<Animal, String> colunaGeneroAnimal;

    @FXML
    private TableColumn<Animal, String> colunaOrdemAnimal;

    @FXML
    private TableColumn<Animal, String> colunaEspecieAnimal;

    @FXML
    private TableView<Jaula> tabelaJaulas;

    @FXML
    private TableColumn<Jaula, String> colunaIdJaula;

    @FXML
    private TableColumn<Jaula, String> colunaTipoJaula;

    @FXML
    private TableColumn<Jaula, String> colunaStatusJaula;

    @FXML
    private TableColumn<Jaula, String> colunaPopMaxJaula;

    @FXML
    private TableColumn<Jaula, String> colunaIdZooJaula;

    @FXML
    private TableColumn<Jaula, String> colunaUltimaInspecJaula;

    @FXML
    private TableView<Jaula> tabelaNovaJaula;

    @FXML
    private TableColumn<Jaula, String> colunaIdNovaJaula;

    @FXML
    private TableColumn<Jaula, String> colunaTipoNovaJaula;
    
    private Jaula jaulaSelecionada;
    private Animal animalSelecionado;
    private Jaula novaJaula;

    @FXML
    void salvarAlteracoes() {

    }

    @FXML
    void selecionarAnimal() {
    	animalSelecionado = tabelaAnimal.getSelectionModel().getSelectedItem();
    }

    @FXML
    void selecionarJaula() {
    	jaulaSelecionada = tabelaJaulas.getSelectionModel().getSelectedItem();
    }

    @FXML
    void selecionarNovaJaula() {
    	novaJaula = tabelaNovaJaula.getSelectionModel().getSelectedItem();
    }

    @FXML
    void trocarDeJaula() {

    }

    @FXML
    void voltar() {
    	ScreenManager.setScene(ScreenManager.getInstance().getTelaAdmin());
    }

    private void preencherTabelaJaulaPrincipal() {
    	
    }
    
    private void preencherTabelaJaulaNova() {
    	
    }
    
    private void preencherTabelaAnimal() {
    	
    }
}
