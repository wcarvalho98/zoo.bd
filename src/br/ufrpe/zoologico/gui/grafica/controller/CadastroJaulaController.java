/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 29.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Jaula;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroJaulaController  implements Initializable{
	
	@FXML private TextField idZoo, tratador, max, comp, larg, altura, dias, idJaula, tipo;
	@FXML private TextArea obs;
	@FXML private DatePicker dtInsp;
	@FXML private Button cadas; 
	
	private Fachada f;
	private int id;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		allDisable();
		f = Fachada.getInstance();
		id = 0;
		preencher(id);
	}
	
	@FXML
	public void voltar(){
	
	}
	
	@FXML 
	public void passar(){
		id++;
		if(id > f.listarJaulas().size() - 1)
			id = 0;
		preencher(id);
		allDisable();
	}
	
	@FXML
	public void retornar(){
		id--;
		if(id<0)
			id = f.listarJaulas().size() - 1;
		preencher(id);
		allDisable();
	}
	
	@FXML 
	public void enter(){
		
	}
	
	@FXML
	public void remover(){
		allDisable();
		idJaula.setDisable(true);
		
	}
	
	@FXML
	public void alterar(){
		allNotDisable();
		idJaula.setDisable(true);
	}
	
	@FXML
	public void inserir(){
		allNull();
		allNotDisable();
		idJaula.setDisable(true);
		cadas.setDisable(false);
		cadas.setVisible(true);
	}
	
	@FXML
	public void buscar(){
		allDisable();
		idJaula.setDisable(false);
	}
	
	@FXML
	public void fetch() {
		preencherBusca((int) Integer.valueOf(idJaula.getText()));
		idJaula.setDisable(true);
	}
	
	@FXML
	public void cadastrar(){
		// TODO Colocar o Date correto
		Jaula j;
		int idZoologico = (int) Integer.valueOf(idZoo.getText());
		String cpfTratador = tratador.getText();
		int maximo = (int) Integer.valueOf(max.getText());
		int comprimento = (int) Integer.valueOf(comp.getText());
		int alt = (int) Integer.valueOf(altura.getText());
		int largura = (int) Integer.valueOf(larg.getText());
		String obs1 = obs.getText();
		String tp = tipo.getText();
		
		j = new Jaula(0,true,tp,LocalDate.now(),maximo,obs1,0,alt,largura,comprimento,idZoologico,cpfTratador);
		
		f.cadastrarJaula(j);
	}
	
	private void allNotDisable(){
		idZoo.setDisable(false);
		tratador.setDisable(false);
		max.setDisable(false);
		comp.setDisable(false);
		larg.setDisable(false);
		altura.setDisable(false);
		dtInsp.setDisable(false);
		dias.setDisable(false);
		idJaula.setDisable(false);
		obs.setDisable(false);
	}
	
	private void allDisable(){
		idZoo.setDisable(true);
		tratador.setDisable(true);
		max.setDisable(true);
		comp.setDisable(true);
		larg.setDisable(true);
		altura.setDisable(true);
		dtInsp.setDisable(true);
		dias.setDisable(true);
		idJaula.setDisable(true);
		obs.setDisable(true);
	}
	
	private void allNull(){
		idZoo.setText(null);
		idZoo.setPromptText("ID");
		tratador.setText(null);
		tratador.setPromptText("CPF");
		max.setText(null);
		max.setPromptText("MAX");
		comp.setText(null);
		comp.setPromptText("Comp");
		larg.setText(null);
		larg.setPromptText("Larg");
		altura.setText(null);
		altura.setPromptText("Altura");
		dtInsp.setUserData(null);
		dias.setText(null);
		dias.setPromptText("DIAS");
		dtInsp.setValue(null);
		idJaula.setText(null);
		idJaula.setPromptText("ID");
		obs.setText(null);
		obs.setPromptText("Observação");
	}
	
	private void preencherBusca(int id) {
		// TODO retornar exceção caso jaula não exista
		Jaula inicio = f.buscarJaula(id);
		this.id = f.listarJaulas().indexOf(inicio);
		idZoo.setText(String.valueOf(inicio.getZoo()));
		tratador.setText(inicio.getTratador());
		max.setText(String.valueOf(inicio.getPopulacao_max()));
		comp.setText(String.valueOf(inicio.getProfundidade()));
		larg.setText(String.valueOf(inicio.getLargura()));
		altura.setText(String.valueOf(inicio.getAltura()));
		dias.setText(String.valueOf(inicio.getPerid_insp_dias()));
		idJaula.setText(String.valueOf(inicio.getId_jaula()));
		obs.setText(inicio.getObs());
		dtInsp.setValue(inicio.getDt_ultima_inspecao());;

	}
	
	private  void preencher(int id){
		Jaula inicio = f.listarJaulas().get(id);
		idZoo.setText(String.valueOf(inicio.getZoo()));
		tratador.setText(inicio.getTratador());
		max.setText(String.valueOf(inicio.getPopulacao_max()));
		comp.setText(String.valueOf(inicio.getProfundidade()));
		larg.setText(String.valueOf(inicio.getLargura()));
		altura.setText(String.valueOf(inicio.getAltura()));
		dias.setText(String.valueOf(inicio.getPerid_insp_dias()));
		idJaula.setText(String.valueOf(inicio.getId_jaula()));
		obs.setText(inicio.getObs());
		dtInsp.setValue(inicio.getDt_ultima_inspecao());;
	}
}
