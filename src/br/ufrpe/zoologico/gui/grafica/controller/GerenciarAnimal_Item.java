package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.Estoque;
import br.ufrpe.zoologico.negocio.beans.ItemEstoque;
import br.ufrpe.zoologico.negocio.beans.ProdutoRef;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class GerenciarAnimal_Item implements Initializable {

	@FXML
	private TableView<Animal> tabelaAnimal;

	@FXML
	private TableColumn<Animal, String> clunaIdAnimalAnimal;

	@FXML
	private TableColumn<Animal, String> colunaNome;

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
	private Button editarItemButton;

	@FXML
	private Button salvarAlteracoesButton;

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
	private Button adicionarItemButton;

	@FXML
	private Button cadastrarItemButton;

	@FXML
	private TableView<ProdutoRef> tabelaProduto;

	@FXML
	private TableColumn<ProdutoRef, String> colunaNomeProduto;

	@FXML
	private TableView<Estoque> tabelaEstoque;

	@FXML
	private TableColumn<Estoque, String> colunaIdEstoque;

	private Animal animalSelecionado;
	private ItemEstoque itemSelecionado;
	private ProdutoRef produtoSelecionado;
	private Estoque estoqueSelecionado;

	@FXML
	void adicionarItem() {
		if (animalSelecionado != null) {
			setCamposDisable(false);
			preencherCampos(null);
			cadastrarItemButton.setDisable(false);
			salvarAlteracoesButton.setDisable(true);
		} else {
			ScreenManager.alertaErro("Nenhum animal foi selecionado.");
		}
	}

	@FXML
	void cadastrarItem() {
		if (animalSelecionado != null && produtoSelecionado != null && estoqueSelecionado != null) {
			try {
				ItemEstoque a = new ItemEstoque();
				a.setCod_prod_ref(produtoSelecionado.getCod());
				a.setIdEstoque(estoqueSelecionado.getId());
				a.setData_entrada(dtEntradaDatePicker.getValue());
				a.setData_validade(dtValidadeDatePicker.getValue());
				a.setVl_compra(Double.parseDouble(vlCompraTextField.getText()));
				a.setQtd(Integer.parseInt(quantidadeTextField.getText()));
				a.setAnimal_consome(animalSelecionado.getId());

				Fachada.getInstance().inserirItem(a);

				preencherTabelaItem();
				preencherCampos(null);
				setCamposDisable(true);

				cadastrarItemButton.setDisable(true);
				salvarAlteracoesButton.setDisable(true);
				produtoSelecionado = null;
				estoqueSelecionado = null;
			} catch (NumberFormatException e) {
				ScreenManager.alertaErro("Valores informados de maneira incorreta.");
			} catch (Exception e) {
				ScreenManager.alertaErro("Um problema ocorreu.");
			}
		} else {
			ScreenManager.alertaErro("Nenhum animal foi selecionado.");
		}
	}

	@FXML
	void editarEstoqueItem() {
		if (itemSelecionado != null) {
			setCamposDisable(false);
			preencherCampos(itemSelecionado);
			cadastrarItemButton.setDisable(true);
			salvarAlteracoesButton.setDisable(false);
		}
	}

	@FXML
	void removerEstoqueItem() {
		if (itemSelecionado != null) {
			try {
				Fachada.getInstance().removerItem(itemSelecionado);
				preencherTabelaItem();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void salvarAlteracoesItemEstoque() {
		if (animalSelecionado != null && produtoSelecionado != null && estoqueSelecionado != null) {
			try {
				itemSelecionado.setCod_prod_ref(produtoSelecionado.getCod());
				itemSelecionado.setIdEstoque(estoqueSelecionado.getId());
				itemSelecionado.setData_entrada(dtEntradaDatePicker.getValue());
				itemSelecionado.setData_validade(dtValidadeDatePicker.getValue());
				itemSelecionado.setVl_compra(Double.parseDouble(vlCompraTextField.getText()));
				itemSelecionado.setQtd(Integer.parseInt(quantidadeTextField.getText()));
				
				Fachada.getInstance().alterarItem(itemSelecionado);
				
				preencherTabelaItem();
				preencherCampos(null);
				setCamposDisable(true);
				
				cadastrarItemButton.setDisable(true);
				salvarAlteracoesButton.setDisable(true);
				produtoSelecionado = null;
				estoqueSelecionado = null;
			} catch (NumberFormatException e) {
				ScreenManager.alertaErro("Valores informados de maneira incorreta.");
			} catch (Exception e) {
				ScreenManager.alertaErro("Um problema ocorreu.");
			}
		} else {
			ScreenManager.alertaErro("Nenhum produto ou estoque ou animal selecionado");
		}
	}

	@FXML
	void selecionarAnimal() {
		animalSelecionado = tabelaAnimal.getSelectionModel().getSelectedItem();
		preencherCampos(null);
		setCamposDisable(true);
		if (animalSelecionado != null) {
			preencherTabelaItem();
		}
	}

	@FXML
	void selecionarEstoqueItem() {
		preencherCampos(null);
		setCamposDisable(true);
		itemSelecionado = tabelaItemEstoque.getSelectionModel().getSelectedItem();
	}

	@FXML
	void voltar() {
		ScreenManager.setScene(ScreenManager.getInstance().getTelaAdmin());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		preencherTabelaAnimal();
		setCamposDisable(true);
		salvarAlteracoesButton.setDisable(true);
		cadastrarItemButton.setDisable(true);
	}

	@FXML
	void selecionarEstoque() {
		estoqueSelecionado = tabelaEstoque.getSelectionModel().getSelectedItem();
	}

	@FXML
	void selecionarProduto() {
		produtoSelecionado = tabelaProduto.getSelectionModel().getSelectedItem();
	}

	private void preencherTabelaAnimal() {
		ArrayList<Animal> animais = Fachada.getInstance().listarAnimais();
		colunaNome.setCellValueFactory(new Callback<CellDataFeatures<Animal, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Animal, String> todosOsAnimais) {
				return new SimpleStringProperty(todosOsAnimais.getValue().getNome());
			}
		});

		clunaIdAnimalAnimal
				.setCellValueFactory(new Callback<CellDataFeatures<Animal, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Animal, String> todosOsAnimais) {
						return new SimpleStringProperty(Integer.valueOf(todosOsAnimais.getValue().getId()).toString());
					}
				});

		tabelaAnimal.setItems(FXCollections.observableArrayList(animais));
		tabelaAnimal.refresh();
	}

	private void preencherTabelaItem() {
		try {
			ArrayList<ItemEstoque> itens = Fachada.getInstance().listarItens();
			for (int i = 0; i < itens.size(); i++) {
				if (itens.get(i).getAnimal_consome() != animalSelecionado.getId()) {
					itens.remove(i);
				}
			}

			colunaCodProd.setCellValueFactory(
					new Callback<CellDataFeatures<ItemEstoque, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<ItemEstoque, String> todos) {
							return new SimpleStringProperty(nomeDoProduto(todos.getValue().getCod_prod_ref()));
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

	private void preencherProdutoEEstoque() {
		try {
			ArrayList<ProdutoRef> produtos = Fachada.getInstance().listarProdutos();
			ArrayList<Estoque> estoques = Fachada.getInstance().listarEstoque();

			colunaNomeProduto
					.setCellValueFactory(new Callback<CellDataFeatures<ProdutoRef, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<ProdutoRef, String> todosOsAnimais) {
							return new SimpleStringProperty(todosOsAnimais.getValue().getDescr());
						}
					});

			colunaIdEstoque
					.setCellValueFactory(new Callback<CellDataFeatures<Estoque, String>, ObservableValue<String>>() {
						@Override
						public ObservableValue<String> call(CellDataFeatures<Estoque, String> todos) {
							return new SimpleStringProperty(todos.getValue().getId() + "");
						}
					});

			tabelaProduto.setItems(FXCollections.observableArrayList(produtos));
			tabelaProduto.refresh();
			tabelaEstoque.setItems(FXCollections.observableArrayList(estoques));
			tabelaEstoque.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String nomeDoProduto(int idProd) {
		String r = "";
		try {
			ArrayList<ProdutoRef> prods = Fachada.getInstance().listarProdutos();
			for (int i = 0; i < prods.size(); i++) {
				if (prods.get(i).getCod() == idProd) {
					r = prods.get(i).getDescr();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	private void preencherCampos(ItemEstoque a) {
		if (a == null) {
			quantidadeTextField.setText("");
			vlCompraTextField.setText("");
			dtEntradaDatePicker.setValue(null);
			dtValidadeDatePicker.setValue(null);
			preencherProdutoEEstoque();
		} else {
			quantidadeTextField.setText(a.getQtd() + "");
			vlCompraTextField.setText(a.getVl_compra() + "");
			dtEntradaDatePicker.setValue(a.getData_entrada());
			dtValidadeDatePicker.setValue(a.getData_validade());
			preencherProdutoEEstoque();
		}
	}

	private void setCamposDisable(boolean a) {
		quantidadeTextField.setDisable(a);
		vlCompraTextField.setDisable(a);
		dtEntradaDatePicker.setDisable(a);
		dtValidadeDatePicker.setDisable(a);
		tabelaProduto.setVisible(!a);
		tabelaEstoque.setVisible(!a);
	}

	private void despreencherProdutoEEstoque() {
		tabelaProduto.setItems(FXCollections.observableArrayList(new ArrayList<ProdutoRef>()));
		tabelaProduto.refresh();
		tabelaEstoque.setItems(FXCollections.observableArrayList(new ArrayList<Estoque>()));
		tabelaEstoque.refresh();
	}

}
