/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 05.02.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.ufrpe.zoologico.negocio.beans.Categoria;
import br.ufrpe.zoologico.negocio.beans.Fornecedor;
import br.ufrpe.zoologico.negocio.beans.ProdutoRef;
import br.ufrpe.zoologico.negocio.beans.SubCategoria;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class CadastroProdutoController implements Initializable {

	@FXML
	private Button inserir, remover, alterar, confirmarCadastro, confirmarRemorcao, confirmarAlteracao;
	@FXML
	private TextField descricaoTextField, codBarrasTextField, freqPedido, qtdMinTextField, idProduto, precoUltCompra,
			quantEstoq;

	// TABELA FORNECEDOR
	@FXML
	private TableView<Fornecedor> tbFornecedor;
	@FXML
	private TableColumn<Fornecedor, String> tcIdFornecedor, tcNome, tcCnpj;

	// TABELA CATEGORIA
	@FXML
	private TableView<Categoria> tbCateg;
	@FXML
	private TableColumn<Categoria, String> tcIdCateg, tcCateg;

	// TABELA SUB_CATEGORIA
	@FXML
	private TableView<SubCategoria> tbSubCateg;
	@FXML
	private TableColumn<SubCategoria, String> tcIdSubCateg, tcSubCateg;

	private Fachada f;
	private int i;
	private Fornecedor fAtual;
	private Categoria cAtual;
	private SubCategoria scAtual;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		f = Fachada.getInstance();
		i = 0;
		this.select();
		preencherTabelaCategoria(f.listarTodasCategorias());
		preencherTabelaFornecedor(f.listarTodosFornecedores());
		preencherTabelaSubCategoria(f.listarTodasSubCategorias());
	}

	@FXML
	public void voltar() {
		ScreenManager.setSceneLeft(ScreenManager.getInstance().getTelaAdmin());
	}

	@FXML
	public void ir() throws Exception {
		allDisable();
		idProduto.setVisible(true);
		i++;
		if (i > f.listarProdutos().size() - 1)
			i = 0;
		preencherProduto(i);
	}

	@FXML
	public void retornar() throws Exception {
		allDisable();
		idProduto.setVisible(true);
		i--;
		if (i < 0)
			i = f.listarProdutos().size() - 1;
		preencherProduto(i);
	}

	@FXML
	public void inserir() {
		confirmarCadastro.setVisible(true);
		confirmarCadastro.setDisable(false);
		confirmarRemorcao.setVisible(false);
		confirmarRemorcao.setDisable(true);
		confirmarAlteracao.setDisable(true);
		confirmarAlteracao.setVisible(false);
		preencherTabelaCategoria(f.listarTodasCategorias());
		preencherTabelaFornecedor(f.listarTodosFornecedores());
		preencherTabelaSubCategoria(f.listarTodasSubCategorias());
		allNotDisable();
		allNull();
		idProduto.setVisible(false);
	}

	@FXML
	public void remover() {
		/*
		 * confirmarRemorcao.setVisible(true); confirmarRemorcao.setDisable(false);
		 */
		confirmarCadastro.setVisible(false);
		confirmarCadastro.setDisable(true);
		confirmarAlteracao.setDisable(true);
		confirmarAlteracao.setVisible(false);

		try {
			ProdutoRef p = pegarTudo();
			f.removerProduto(p);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			allNull();
			allDisable();
		}
	}

	@FXML
	public void alterar() {
		confirmarAlteracao.setDisable(false);
		confirmarAlteracao.setVisible(true);
		confirmarRemorcao.setVisible(false);
		confirmarRemorcao.setDisable(true);
		confirmarCadastro.setVisible(false);
		confirmarCadastro.setDisable(true);
		allNotDisable();
		idProduto.setVisible(true);
	}

	@FXML
	public void confirmarCadastro() {
		ProdutoRef p = pegarTudo();
		try {
			f.inserirProduto(p);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			allNull();
		}
	}

	// TODO Retira isso!
	@FXML
	public void confirmarRemorcao() {

	}

	@FXML
	public void confirmarAlteracao() {

		try {
			ProdutoRef p = pegarTudo();
			f.alterarProduto(p);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			allNull();
		}
	}

	public void preencherTabelaFornecedor(ArrayList<Fornecedor> o) {
		tcIdFornecedor.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Fornecedor, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<Fornecedor, String> param) {
						return new SimpleStringProperty(Integer.valueOf(param.getValue().getCod()).toString());
					}
				});

		tcNome.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Fornecedor, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<Fornecedor, String> param) {
						return new SimpleStringProperty(param.getValue().getNome());
					}
				});

		tcCnpj.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Fornecedor, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<Fornecedor, String> param) {
						return new SimpleStringProperty(param.getValue().getCnpj());
					}
				});

		tbFornecedor.setItems(FXCollections.observableArrayList(o));
	}

	public void preencherTabelaCategoria(ArrayList<Categoria> o) {
		tcIdCateg.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Categoria, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<Categoria, String> param) {
						return new SimpleStringProperty(Integer.valueOf(param.getValue().getCod()).toString());
					}
				});

		tcCateg.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Categoria, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<Categoria, String> param) {
						return new SimpleStringProperty(param.getValue().getDescr());
					}
				});

		tbCateg.setItems(FXCollections.observableArrayList(o));
	}

	public void preencherTabelaSubCategoria(ArrayList<SubCategoria> o) {
		tcIdSubCateg.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<SubCategoria, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<SubCategoria, String> param) {
						return new SimpleStringProperty(Integer.valueOf(param.getValue().getCod()).toString());
					}
				});

		tcSubCateg.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<SubCategoria, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<SubCategoria, String> param) {
						return new SimpleStringProperty(param.getValue().getDescr());
					}
				});
		;

		tbSubCateg.setItems(FXCollections.observableArrayList(o));
	}

	private void select() {
		tbFornecedor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Fornecedor>() {

			@Override
			public void changed(ObservableValue<? extends Fornecedor> observable, Fornecedor oldValue,
					Fornecedor newValue) {
				fAtual = newValue;
			}
		});

		tbCateg.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Categoria>() {

			@Override
			public void changed(ObservableValue<? extends Categoria> observable, Categoria oldValue,
					Categoria newValue) {
				cAtual = newValue;
			}
		});

		tbSubCateg.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SubCategoria>() {

			@Override
			public void changed(ObservableValue<? extends SubCategoria> observable, SubCategoria oldValue,
					SubCategoria newValue) {
				scAtual = newValue;
			}
		});
	}

	public void allDisable() {
		descricaoTextField.setDisable(true);
		codBarrasTextField.setDisable(true);
		freqPedido.setDisable(true);
		qtdMinTextField.setDisable(true);
		precoUltCompra.setDisable(true);
		quantEstoq.setDisable(true);
	}

	public void allNotDisable() {
		descricaoTextField.setDisable(false);
		codBarrasTextField.setDisable(false);
		freqPedido.setDisable(false);
		qtdMinTextField.setDisable(false);
		precoUltCompra.setDisable(false);
		quantEstoq.setDisable(false);
	}

	public void allNull() {
		descricaoTextField.setText(null);
		codBarrasTextField.setText(null);
		freqPedido.setText(null);
		qtdMinTextField.setText(null);
		precoUltCompra.setText(null);
		quantEstoq.setText(null);
	}

	public void preencherProduto(int i) {
		try {
			ProdutoRef p = f.listarProdutos().get(i);
			preencherTabelaCategoria(buscarC(p.getCateg()));
			preencherTabelaFornecedor(buscarF(p.getFornecedor()));
			preencherTabelaSubCategoria(buscarSB(p.getSubcat()));
			descricaoTextField.setText(p.getDescr());
			codBarrasTextField.setText(p.getCod_barra());
			freqPedido.setText(Integer.valueOf(p.getFreq_pedido()).toString());
			qtdMinTextField.setText(Integer.valueOf(p.getQtd_min()).toString());
			idProduto.setText(Integer.valueOf(p.getCod()).toString());
			precoUltCompra.setText(Double.valueOf(p.getPreco_ult_compra()).toString());
			quantEstoq.setText(Integer.valueOf(p.getQtd_total_estoque()).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ArrayList<Fornecedor> buscarF(int id) {
		ArrayList<Fornecedor> list = new ArrayList<Fornecedor>();
		for (int i = 0; i < f.listarTodosFornecedores().size(); i++) {
			if (f.listarTodosFornecedores().get(i).getCod() == id)
				list.add(f.listarTodosFornecedores().get(i));
		}
		return list;
	}

	private ArrayList<Categoria> buscarC(int cod) {
		ArrayList<Categoria> list = new ArrayList<Categoria>();
		for (int i = 0; i < f.listarTodasCategorias().size(); i++) {
			if (f.listarTodasCategorias().get(i).getCod() == cod)
				list.add(f.listarTodasCategorias().get(i));
		}
		return list;
	}

	private ArrayList<SubCategoria> buscarSB(int id) {
		ArrayList<SubCategoria> list = new ArrayList<SubCategoria>();
		for (int i = 0; i < f.listarTodasSubCategorias().size(); i++) {
			if (f.listarTodasSubCategorias().get(i).getCod() == id)
				list.add(f.listarTodasSubCategorias().get(i));
		}
		return list;
	}

	private ProdutoRef pegarTudo() {
		String val1 = descricaoTextField.getText();
		String val2 = codBarrasTextField.getText();
		int val3 = Integer.valueOf(freqPedido.getText());
		int val4 = Integer.valueOf(qtdMinTextField.getText());
		double val5 = Double.valueOf(precoUltCompra.getText());
		int val6 = Integer.valueOf(quantEstoq.getText());
		int val7 = Integer.valueOf(idProduto.getText());
		ProdutoRef p = new ProdutoRef(val7, val1, val3, val2, val5, val6, val4, scAtual.getCod(), cAtual.getCod(),
				fAtual.getCod());
		return p;
	}

}
