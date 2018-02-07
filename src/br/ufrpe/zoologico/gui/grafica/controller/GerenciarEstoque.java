/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Estoque;
import br.ufrpe.zoologico.negocio.beans.ItemEstoque;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class GerenciarEstoque {

	@FXML
	private TableView<Estoque> tabelaEstoque;

	@FXML
	private TableColumn<Estoque, String> colunaIdEstoqueEstoque;

	@FXML
	private TableColumn<Estoque, String> colunaIdZoo;

	@FXML
	private TableColumn<Estoque, String> colunaDescricao;

	@FXML
	private TableColumn<Estoque, String> colunaLocalizacao;

	@FXML
	private TableView<ItemEstoque> tabelaItemEstoque;

	@FXML
	private TableColumn<ItemEstoque, String> colunaCodProd;
	@FXML
	private TableColumn<ItemEstoque, String> colunaIdEstoqueItem;

	@FXML
	private TableColumn<ItemEstoque, String> colunaQtd;

	@FXML
	private TableColumn<ItemEstoque, String> colunaDtEntrada;

	@FXML
	private TableColumn<ItemEstoque, String> colunaVlCompra;

	@FXML
	private TableColumn<ItemEstoque, String> colunaDtValidade;

	@FXML
	private TableColumn<ItemEstoque, String> colunaIdAnimal;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField codProdTextField;

	@FXML
	private TextField idEstoqueTextField;

	@FXML
	private TextField descricaoTextField;

	@FXML
	private TextField localizacaoTextField;

	@FXML
	private TextField idAnimalTextField;

	@FXML
	private TextField vlCompraTextField;

	@FXML
	private TextField quantidadeTextField;

	@FXML
	private DatePicker dtValidadeDatePicker;

	@FXML
	private DatePicker dtEntradaDatePicker;

	@FXML
	private TextField descricaoTextField1;

	@FXML
	private TextField localizacaoTextField1;

	@FXML
	private TextField idAnimalTextField1;

	@FXML
	private TextField vlCompraTextField1;

	@FXML
	private TextField quantidadeTextField1;

	@FXML
	private DatePicker dtValidadeDatePicker1;

	@FXML
	private DatePicker dtEntradaDatePicker1;

	private Estoque estoqueSelecionado;

	private ItemEstoque itemSelecionado;

	@FXML
	void cadastrarEstoque() {
		try {
			Estoque a = new Estoque();
			a.setDescr(descricaoTextField1.getText());
			a.setLocalizacao(localizacaoTextField1.getText());
			Fachada.getInstance().inserirEstoque(a);
			preencherTabelaEstoque();
			preencherCamposEstoque1(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void cadastrarItemEstoque() {
		try {
			if (Integer.parseInt(codProdTextField.getText()) >= 0 && Integer.parseInt(idEstoqueTextField.getText()) >= 0
					&& Integer.parseInt(idAnimalTextField1.getText()) >= 0) {
				ItemEstoque a = new ItemEstoque();
				a.setAnimal_consome(Integer.parseInt(idAnimalTextField1.getText()));
				a.setVl_compra(Double.parseDouble(vlCompraTextField1.getText()));
				a.setData_entrada(dtEntradaDatePicker1.getValue());
				a.setData_validade(dtValidadeDatePicker1.getValue());
				a.setIdEstoque(Integer.parseInt(idEstoqueTextField.getText()));
				a.setCod_prod_ref(Integer.parseInt(codProdTextField.getText()));
				Fachada.getInstance().inserirItem(a);
				preencherCamposItem1(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void editarEstoque() {
		preencherCamposEstoque(estoqueSelecionado);
		preencherCamposItem(null);
	}

	@FXML
	void editarEstoqueItem() {
		preencherCamposEstoque(null);
		preencherCamposItem(itemSelecionado);
	}

	@FXML
	void removerEstoque() {
		try {
			if (estoqueSelecionado != null) {
				Fachada.getInstance().removerEstoque(estoqueSelecionado);
				estoqueSelecionado = null;
				preencherTabelaEstoque();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void removerEstoqueItem() {
		try {
			if (itemSelecionado != null) {
				Fachada.getInstance().removerItem(itemSelecionado);
				itemSelecionado = null;
				preencherTabelaItem();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void salvarAlteracoesEstoque() {
		try {
			if (estoqueSelecionado != null) {
				estoqueSelecionado.setDescr(descricaoTextField.getText());
				estoqueSelecionado.setLocalizacao(localizacaoTextField.getText());
				Fachada.getInstance().alterarEstoque(estoqueSelecionado);
				preencherTabelaEstoque();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void salvarAlteracoesItemEstoque() {
		try {
			if (itemSelecionado != null && Integer.parseInt(idAnimalTextField.getText()) >= 0) {
				itemSelecionado.setData_entrada(dtEntradaDatePicker.getValue());
				itemSelecionado.setData_validade(dtValidadeDatePicker.getValue());
				itemSelecionado.setAnimal_consome(Integer.parseInt(idAnimalTextField.getText()));
				itemSelecionado.setQtd(Integer.parseInt(quantidadeTextField.getText()));
				itemSelecionado.setVl_compra(Double.parseDouble(vlCompraTextField.getText()));
				Fachada.getInstance().alterarItem(itemSelecionado);
				preencherTabelaItem();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void selecionarEstoque() {
		estoqueSelecionado = tabelaEstoque.getSelectionModel().getSelectedItem();
		if (estoqueSelecionado != null) {
			preencherTabelaItem();
		}
	}

	@FXML
	void selecionarEstoqueItem() {
		itemSelecionado = tabelaItemEstoque.getSelectionModel().getSelectedItem();
	}

	@FXML
	void voltar() {
		ScreenManager.setSceneLeft(ScreenManager.getInstance().getTelaAdmin());
	}

	@FXML
	void initialize() {
		assert descricaoTextField != null : "fx:id=\"descricaoTextField\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert localizacaoTextField != null : "fx:id=\"localizacaoTextField\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert idAnimalTextField != null : "fx:id=\"idAnimalTextField\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert vlCompraTextField != null : "fx:id=\"vlCompraTextField\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert quantidadeTextField != null : "fx:id=\"quantidadeTextField\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert dtValidadeDatePicker != null : "fx:id=\"dtValidadeDatePicker\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert dtEntradaDatePicker != null : "fx:id=\"dtEntradaDatePicker\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert descricaoTextField1 != null : "fx:id=\"descricaoTextField1\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert localizacaoTextField1 != null : "fx:id=\"localizacaoTextField1\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert idAnimalTextField1 != null : "fx:id=\"idAnimalTextField1\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert vlCompraTextField1 != null : "fx:id=\"vlCompraTextField1\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert quantidadeTextField1 != null : "fx:id=\"quantidadeTextField1\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert dtValidadeDatePicker1 != null : "fx:id=\"dtValidadeDatePicker1\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";
		assert dtEntradaDatePicker1 != null : "fx:id=\"dtEntradaDatePicker1\" was not injected: check your FXML file 'GerenciarEstoque.fxml'.";

		preencherTabelaEstoque();
	}

	private void preencherTabelaEstoque() {
		try {
			ArrayList<Estoque> estoque = Fachada.getInstance().listarEstoque();

			colunaIdZoo.setCellValueFactory(new Callback<CellDataFeatures<Estoque, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Estoque, String> estoques) {
					return new SimpleStringProperty("" + estoques.getValue().getIdZoo());
				}
			});

			colunaIdEstoqueEstoque
					.setCellValueFactory(new Callback<CellDataFeatures<Estoque, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<Estoque, String> estoques) {
							return new SimpleStringProperty("" + estoques.getValue().getId());
						}
					});

			colunaDescricao
					.setCellValueFactory(new Callback<CellDataFeatures<Estoque, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<Estoque, String> estoques) {
							return new SimpleStringProperty(estoques.getValue().getDescr());
						}
					});

			colunaLocalizacao
					.setCellValueFactory(new Callback<CellDataFeatures<Estoque, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<Estoque, String> estoques) {
							return new SimpleStringProperty(estoques.getValue().getLocalizacao());
						}
					});

			tabelaEstoque.setItems(FXCollections.observableArrayList(estoque));
			tabelaEstoque.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void preencherTabelaItem() {
		try {
			ArrayList<ItemEstoque> itens = Fachada.getInstance().listarItensDoEstoque(estoqueSelecionado);

			colunaCodProd.setCellValueFactory(
					new Callback<CellDataFeatures<ItemEstoque, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<ItemEstoque, String> estoques) {
							return new SimpleStringProperty(estoques.getValue().getCod_prod_ref() + "");
						}
					});

			colunaIdEstoqueItem.setCellValueFactory(
					new Callback<CellDataFeatures<ItemEstoque, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<ItemEstoque, String> estoques) {
							return new SimpleStringProperty(estoques.getValue().getIdEstoque() + "");
						}
					});

			colunaDtEntrada.setCellValueFactory(
					new Callback<CellDataFeatures<ItemEstoque, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<ItemEstoque, String> estoques) {
							return new SimpleStringProperty(
									ScreenManager.formatarLocalDate(estoques.getValue().getData_entrada()));
						}
					});

			colunaVlCompra.setCellValueFactory(
					new Callback<CellDataFeatures<ItemEstoque, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<ItemEstoque, String> estoques) {
							return new SimpleStringProperty(estoques.getValue().getVl_compra() + "");
						}
					});

			colunaDtValidade.setCellValueFactory(
					new Callback<CellDataFeatures<ItemEstoque, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<ItemEstoque, String> estoques) {
							return new SimpleStringProperty(
									ScreenManager.formatarLocalDate(estoques.getValue().getData_validade()));
						}
					});

			colunaIdAnimal.setCellValueFactory(
					new Callback<CellDataFeatures<ItemEstoque, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<ItemEstoque, String> estoques) {
							return new SimpleStringProperty(estoques.getValue().getAnimal_consome() + "");
						}
					});

			colunaQtd.setCellValueFactory(
					new Callback<CellDataFeatures<ItemEstoque, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<ItemEstoque, String> estoques) {
							return new SimpleStringProperty(estoques.getValue().getQtd() + "");
						}
					});

			tabelaItemEstoque.setItems(FXCollections.observableArrayList(itens));
			tabelaItemEstoque.refresh();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void preencherCamposEstoque(Estoque a) {
		if (a == null) {
			descricaoTextField.setText("");
			localizacaoTextField.setText("");
		} else {
			descricaoTextField.setText(a.getDescr());
			localizacaoTextField.setText(a.getLocalizacao());
		}
	}

	private void preencherCamposEstoque1(Estoque a) {
		if (a == null) {
			descricaoTextField1.setText("");
			localizacaoTextField1.setText("");
		} else {
			descricaoTextField1.setText(a.getDescr());
			localizacaoTextField1.setText(a.getLocalizacao());
		}
	}

	private void preencherCamposItem(ItemEstoque a) {
		if (a == null) {
			quantidadeTextField.setText("");
			vlCompraTextField.setText("");
			idAnimalTextField.setText("");
			dtEntradaDatePicker.setValue(null);
			dtValidadeDatePicker.setValue(null);
		} else {
			quantidadeTextField.setText(a.getQtd() + "");
			vlCompraTextField.setText(a.getVl_compra() + "");
			idAnimalTextField.setText(a.getAnimal_consome() + "");
			dtEntradaDatePicker.setValue(a.getData_entrada());
			dtValidadeDatePicker.setValue(a.getData_validade());
		}
	}

	private void preencherCamposItem1(ItemEstoque a) {
		if (a == null) {
			quantidadeTextField1.setText("");
			vlCompraTextField1.setText("");
			idAnimalTextField1.setText("");
			dtEntradaDatePicker1.setValue(null);
			dtValidadeDatePicker1.setValue(null);
			idEstoqueTextField.setText("");
			codProdTextField.setText("");
		} else {
			quantidadeTextField1.setText(a.getQtd() + "");
			vlCompraTextField1.setText(a.getVl_compra() + "");
			idAnimalTextField1.setText(a.getAnimal_consome() + "");
			dtEntradaDatePicker1.setValue(a.getData_entrada());
			dtValidadeDatePicker1.setValue(a.getData_validade());
		}
	}
}
