/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.Consulta;
import br.ufrpe.zoologico.negocio.beans.Instituicao;
import br.ufrpe.zoologico.negocio.beans.Jaula;
import br.ufrpe.zoologico.negocio.beans.Veterinario;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoAnimal;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoConsultas;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoInstituicao;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoVeterinario;
import br.ufrpe.zoologico.negocio.gerenciamento.gerenciamentoJaula;

public class Fachada {
	private static Fachada instance = null;
	private GerenciamentoConsultas consultas;
	private gerenciamentoJaula jaulas;
	private GerenciamentoInstituicao instituicoes;
	private GerenciamentoAnimal animal;
	private GerenciamentoVeterinario veterinarios;
	
	private Fachada() {
		consultas = new GerenciamentoConsultas();
		jaulas = new gerenciamentoJaula();
		instituicoes = new GerenciamentoInstituicao();
		animal = new GerenciamentoAnimal();
		veterinarios = new GerenciamentoVeterinario();
	}
	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	public void cadastrarConsulta(Consulta o) {
		consultas.cadastrarConsulta(o);
	}
	
	public void removerConsullta(Consulta o) {
		consultas.removerConsullta(o);
	}
	
	public void alterarConsulta(Consulta o) {
		consultas.alterarConsulta(o);
	}
	
	public Consulta buscarConsulta(int id) {
		return consultas.buscarConsulta(id);
	}
	
	public ArrayList<Consulta> listarConsultas(){
		return consultas.listarConsultas();
	}
	
	public void cadastrarJaula(Jaula o){
		jaulas.cadastrar(o);
	}
	
	public void removerJaula(Jaula o) {
		jaulas.remover(o);
	}
	
	public void alterarJaula(Jaula o) {
		jaulas.atualizar(o);
	}
	
	public Jaula buscarJaula(int id) {
		return jaulas.buscar(id);
	}
	
	public ArrayList<Jaula> listarJaulas() {
		return jaulas.listarTodos();
	}
	
	public void cadastrarInstituicao(Instituicao o) {
		instituicoes.cadastrarInstituicao(o);
	}
	
	public void removerInstituicao(Instituicao o) {
		instituicoes.removerInstituicao(o);
	}
	
	public ArrayList<Instituicao> listarInstituicoes(){
		return instituicoes.listarInstituicoes();
	}
	
	public void cadastrarAnimal(Animal o) {
		animal.cadastrarAnimal(o);
	}
	
	public void removerAnimal(Animal o) {
		animal.removerAnimal(o);
	}
	
	public void alterarAnimal(Animal o) {
		animal.alterarAnimal(o);
	}
	
	public Animal buscar(int id) {
		return animal.buscar(id);
	}
	
	public ArrayList<Animal> listarAnimais(){
		return animal.listarTodos();
	}
	
	public void cadastrarVeterinario(Veterinario o) {
		veterinarios.cadastrarVeterinario(o);
	}
	public void removerVeterinario(Veterinario o) {
		veterinarios.removerVeterinario(o);
	}
	
	public void alterarVeterinario(Veterinario o) {
		veterinarios.alterarVeterinario(o);
	}
	
	public Veterinario buscarVeterinario(String cpf) {
		return veterinarios.buscarVeterinario(cpf);
	}
	
	public ArrayList<Veterinario> listarVeterinarios(){
		return veterinarios.listarVeterinarios();
	}
}
