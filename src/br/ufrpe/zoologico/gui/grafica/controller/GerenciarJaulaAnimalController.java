package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.Jaula;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class GerenciarJaulaAnimalController implements Initializable{

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
    
	@FXML private TextField nome;
	@FXML private TextArea obs;
	@FXML private DatePicker dtNas, dtFale;
	@FXML private Label textNome, textIdade;
	@FXML private Text textAltAnimal;
	@FXML private Button altAnimalSelec;
	
	

	@FXML
	void altAnimalSelec(){
		if(animalSelecionado == null)
			ScreenManager.alertaInformativo("Selecione um animal");
		else{
			allVisible();
			allNotDisable();
			obs.setText(animalSelecionado.getObs());
			nome.setText(animalSelecionado.getNome());
			dtFale.setValue(animalSelecionado.getDt_falecimento());
			preencherTabelaJaulaNova();
		}
		
	}
	
    @FXML
    void salvarAlteracoes() {
    	animalSelecionado.setObs(obs.getText());
    	animalSelecionado.setDt_falecimento(dtFale.getValue());
    	animalSelecionado.setNome(nome.getText());
    	if(novaJaula == null)
    		ScreenManager.alertaInformativo("Selecione uma jaula");
    	else{
    		animalSelecionado.setId_jaula(novaJaula.getId_jaula());
    		Fachada.getInstance().alterarAnimal(animalSelecionado);
        	allDisable();
        	allNotVisible();
        	animalSelecionado = null;
    	}
    }

    @FXML
    void selecionarAnimal() {
    	animalSelecionado = tabelaAnimal.getSelectionModel().getSelectedItem();
    }

    @FXML
    void selecionarJaula() {
    	jaulaSelecionada = tabelaJaulas.getSelectionModel().getSelectedItem();
    	preencherTabelaAnimal(jaulaSelecionada);
    }

    @FXML
    void selecionarNovaJaula() {
    	novaJaula = tabelaNovaJaula.getSelectionModel().getSelectedItem();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherTabelaJaulaPrincipal();
	}
	
    @FXML
    void voltar() {
    	ScreenManager.setSceneLeft(ScreenManager.getInstance().getTelaAdmin());
    }

    private void preencherTabelaJaulaPrincipal() {
    	ArrayList<Jaula> jaulas = Fachada.getInstance().listarJaulas();
    	
    	colunaIdJaula.setCellValueFactory(new Callback<CellDataFeatures<Jaula, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Jaula, String> todos) {
				return new SimpleStringProperty(todos.getValue().getId_jaula() + "");
			}
		});
    	
    	colunaTipoJaula.setCellValueFactory(new Callback<CellDataFeatures<Jaula, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Jaula, String> todos) {
				return new SimpleStringProperty(todos.getValue().getTipo() + "");
			}
		});
    	
    	colunaPopMaxJaula.setCellValueFactory(new Callback<CellDataFeatures<Jaula, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Jaula, String> todos) {
				return new SimpleStringProperty(todos.getValue().getPopulacao_max() + "");
			}
		});
    	
    	colunaStatusJaula.setCellValueFactory(new Callback<CellDataFeatures<Jaula, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Jaula, String> todos) {
				return new SimpleStringProperty(todos.getValue().isStats() + "");
			}
		});
    	
    	colunaIdZooJaula.setCellValueFactory(new Callback<CellDataFeatures<Jaula, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Jaula, String> todos) {
				return new SimpleStringProperty(todos.getValue().getZoo() + "");
			}
		});
    	
    	colunaUltimaInspecJaula.setCellValueFactory(new Callback<CellDataFeatures<Jaula, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Jaula, String> todos) {
				return new SimpleStringProperty(ScreenManager.formatarLocalDate(todos.getValue().getDt_ultima_inspecao()));
			}
		});
    	
    	tabelaJaulas.setItems(FXCollections.observableArrayList(jaulas));
    	tabelaJaulas.refresh();
    }

    private void preencherTabelaJaulaNova() {
    	ArrayList<Jaula> jaulas = Fachada.getInstance().listarJaulas();
    	
    	colunaIdNovaJaula.setCellValueFactory(new Callback<CellDataFeatures<Jaula, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Jaula, String> todos) {
				return new SimpleStringProperty(todos.getValue().getId_jaula() + "");
			}
		});
    	
    	colunaTipoNovaJaula.setCellValueFactory(new Callback<CellDataFeatures<Jaula, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Jaula, String> todos) {
				return new SimpleStringProperty(todos.getValue().getTipo() + "");
			}
		});
    	
    	tabelaNovaJaula.setItems(FXCollections.observableArrayList(jaulas));
    	tabelaNovaJaula.refresh();
    	
    }
    
    private void preencherTabelaAnimal(Jaula j) {
    	ArrayList<Animal> list = new ArrayList<Animal>();
    	for(int i = 0 ; i < Fachada.getInstance().listarAnimais().size(); i++){
    		if(Fachada.getInstance().listarAnimais().get(i).getId_jaula() == j.getId_jaula()){
    			list.add(Fachada.getInstance().listarAnimais().get(i));
    		}
    	}
    	colunaIdAnimal.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Animal,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Animal, String> arg0) {
				return new SimpleStringProperty(arg0.getValue().getId() + "");
			}
		});
    	
    	colunaNomeAnimal.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Animal,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Animal, String> param) {
				return new SimpleStringProperty(param.getValue().getNome());
			}
		});
    	
    	colunaIdadeAnimal.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Animal,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Animal, String> param) {
				return new SimpleStringProperty(param.getValue().getIdade() + "");
			}
		});
    	
    	colunaOrdemAnimal.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Animal,String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Animal, String> param) {
				return new SimpleStringProperty(param.getValue().getOrdem() + "");
			}
		});
    	
    	colunaGeneroAnimal.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Animal,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Animal, String> param) {
				return new SimpleStringProperty(param.getValue().getGenero() + "");
			}
		});
    	
    	colunaEspecieAnimal.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Animal,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Animal, String> param) {
				return new SimpleStringProperty(param.getValue().getEspecie() + "");
			}
		});
    	
    	tabelaAnimal.setItems(FXCollections.observableArrayList(list));
    	tabelaAnimal.refresh();

     }
    
    private void allDisable() {
		obs.setDisable(true);
		nome.setDisable(true);
		dtFale.setDisable(true);
		tabelaNovaJaula.setDisable(true);
	}

	private void allNotDisable() {
		obs.setDisable(false);
		nome.setDisable(false);
		dtFale.setDisable(false);
		tabelaNovaJaula.setDisable(false);
	}
	
	private void allVisible(){
		obs.setVisible(true);
		nome.setVisible(true);
		dtFale.setVisible(true);
		textAltAnimal.setVisible(true);
		textNome.setVisible(true);
		tabelaNovaJaula.setVisible(true);
	}
	
	private void allNotVisible(){
		obs.setVisible(false);
		nome.setVisible(false);
		dtFale.setVisible(false);
		textAltAnimal.setVisible(false);
		textNome.setVisible(false);
		tabelaNovaJaula.setVisible(false);
	}
	
	private void allNull(){
		obs.setText("");
		nome.setText("");
		dtFale.setValue(null);
	}
}
