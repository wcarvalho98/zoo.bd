/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.util.ArrayList;

import br.ufrpe.zoologico.DAO.DAOFatura;
import br.ufrpe.zoologico.negocio.beans.Administrador;
import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.Consulta;
import br.ufrpe.zoologico.negocio.beans.Fatura;
import br.ufrpe.zoologico.negocio.beans.Funcionario;
import br.ufrpe.zoologico.negocio.beans.Instituicao;
import br.ufrpe.zoologico.negocio.beans.Jaula;
import br.ufrpe.zoologico.negocio.beans.Servico;
import br.ufrpe.zoologico.negocio.beans.Veterinario;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoAdmin;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoAnimal;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoConsultas;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoFaturas;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoFuncionario;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoInstituicao;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoVeterinario;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoJaula;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoServicos;

public class Fachada {
	private static Fachada instance = null;
	private GerenciamentoConsultas consultas;
	private GerenciamentoJaula jaulas;
	private GerenciamentoInstituicao instituicoes;
	private GerenciamentoAnimal animal;
	private GerenciamentoVeterinario veterinarios;
	private GerenciamentoFuncionario funcionarios;
	private GerenciamentoServicos servicos;
	private GerenciamentoFaturas faturas;
	private GerenciamentoAdmin admin;
	
	private Fachada() {
		consultas = new GerenciamentoConsultas();
		jaulas = new GerenciamentoJaula();
		instituicoes = new GerenciamentoInstituicao();
		animal = new GerenciamentoAnimal();
		veterinarios = new GerenciamentoVeterinario();
		funcionarios = new GerenciamentoFuncionario();
		servicos = new GerenciamentoServicos();
		faturas = new GerenciamentoFaturas();
		admin = new GerenciamentoAdmin();
	}
	
	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	/** CONSULTA */
	public void cadastrarConsulta(Consulta o) {
		consultas.cadastrarConsulta(o);
	}
	
	public void removerConsullta(Consulta o) {
		consultas.removerConsulta(o);
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
	
	/** INSTITUICAO */
	public void cadastrarInstituicao(Instituicao o) {
		instituicoes.cadastrarInstituicao(o);
	}
	
	public void removerInstituicao(Instituicao o) {
		instituicoes.removerInstituicao(o);
	}
	
	public ArrayList<Instituicao> listarInstituicoes(){
		return instituicoes.listarInstituicoes();
	}
	
	/** ANIMAL */
	public void cadastrarAnimal(Animal o) {
		animal.cadastrarAnimal(o);
	}
	
	public void removerAnimal(Animal o) {
		animal.removerAnimal(o);
	}
	
	public void alterarAnimal(Animal o) {
		animal.alterarAnimal(o);
	}
	
	public Animal buscarAnimal(int id) {
		return animal.buscarAnimal(id);
	}
	
	public ArrayList<Animal> listarAnimais(){
		return animal.listarAnimais();
	}
	
	/** VETERINARIO */
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
	
	/** FUNCIONARIO */
	public void cadastrarFuncionario(Funcionario o) {
		funcionarios.cadastrarFuncionario(o);
	}
	
	public void removerFuncionario(Funcionario o) {
		funcionarios.removerFuncionario(o);
	}
	
	public void alterarFuncionario(Funcionario o) {
		funcionarios.alterarFuncionario(o);
	}
	
	public Funcionario buscarFuncionario(String cpf) {
		return funcionarios.buscarFuncionario(cpf);
	}
	
	public ArrayList<Funcionario> listarFuncionarios(){
		return funcionarios.listarFuncionarios();
	}
	
	/** SERVICO */
	public void cadastrarServico(Servico o) {
		servicos.cadastrarServico(o);
	}

	public void removerServico(Servico o) {
		servicos.removerServico(o);
	}

	public void alterarServico(Servico o) {
		servicos.alterarServico(o);
	}
	
	public Servico buscarServico(int id) {
		return servicos.buscarServico(id);
	}
	
	public ArrayList<Servico> listarServicos(){
		return servicos.listarServicos();
	}
	
	public ArrayList<Fatura> faturasDoServico(Servico o){
		return servicos.faturasDoServico(o);
	}
	
	/** FATURA */
	public void cadastrarFatura(Fatura o) {
		faturas.cadastrarFatura(o);
	}

	public void removerFatura(Fatura o) {
		faturas.remover(o);
	}

	public void alterarFatura(Fatura o) {
		faturas.alterar(o);
	}
	
	public Fatura buscarFatura(int id) {
		return faturas.buscar(id);
	}

	public ArrayList<Fatura> listarFaturas(){
		return faturas.listarTodos();
	}
	
	/** JAULA */
	public void cadastrarJaula(Jaula o) throws Exception{
		jaulas.cadastrar(o);
	}
	
	public void removerJaula(Jaula o) throws Exception  {
		jaulas.remover(o);
	}
	
	public void alterarJaula(Jaula o) {
		jaulas.atualizar(o);
	}
	
	public Jaula buscarJaula(int id) throws Exception  {
		return jaulas.buscar(id);
	}
	
	public ArrayList<Jaula> listarJaulas() {
		return jaulas.listarTodos();
	}
	
	/** ADMINISTRADOR */
	public void cadastrarAdministrador(Administrador o) throws Exception{
		admin.cadastrarAdministrador(o);
	}
	
	public void removerAdministrador(Administrador o) throws Exception  {
		admin.removerAdministrador(o);
	}
	
	public void alterarAdministrador(Administrador o) {
		admin.alterarAdministrador(o);
	}
	
	public Administrador buscarAdministrador(String login)  throws Exception  {
		return admin.buscarAdministrador(login);
	}
	
	
	public ArrayList<Administrador> listarAdministradores() {
		return admin.listarAdministradores();
	}
	
	
}
