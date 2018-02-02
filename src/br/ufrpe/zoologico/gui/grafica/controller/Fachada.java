/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.gui.grafica.controller - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.gui.grafica.controller;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Administrador;
import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.Consulta;
import br.ufrpe.zoologico.negocio.beans.Especie;
import br.ufrpe.zoologico.negocio.beans.Fatura;
import br.ufrpe.zoologico.negocio.beans.Funcionario;
import br.ufrpe.zoologico.negocio.beans.Genero;
import br.ufrpe.zoologico.negocio.beans.Instituicao;
import br.ufrpe.zoologico.negocio.beans.Jaula;
import br.ufrpe.zoologico.negocio.beans.JornadaTrabalho;
import br.ufrpe.zoologico.negocio.beans.Ordem;
import br.ufrpe.zoologico.negocio.beans.Reserva;
import br.ufrpe.zoologico.negocio.beans.Servico;
import br.ufrpe.zoologico.negocio.beans.Veterinario;
import br.ufrpe.zoologico.negocio.beans.Zoo;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoAdmin;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoAnimal;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoConsultas;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoEspecie;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoFaturas;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoFuncionario;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoGenero;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoInstituicao;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoJaula;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoOrdem;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoReserva;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoServicos;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoVeterinario;
import br.ufrpe.zoologico.negocio.gerenciamento.GerenciamentoZoo;

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
	private GerenciamentoEspecie especie;
	private GerenciamentoOrdem ordem;
	private GerenciamentoGenero genero;
	private GerenciamentoZoo zoo;
	private GerenciamentoAdmin admin;
	private GerenciamentoReserva reserva;
	private GerenciamentoJornadaDeTrabalho jornada;
	
	private Fachada() {
		consultas = new GerenciamentoConsultas();
		jaulas = new GerenciamentoJaula();
		instituicoes = new GerenciamentoInstituicao();
		animal = new GerenciamentoAnimal();
		veterinarios = new GerenciamentoVeterinario();
		funcionarios = new GerenciamentoFuncionario();
		servicos = new GerenciamentoServicos();
		faturas = new GerenciamentoFaturas();
		especie = new GerenciamentoEspecie();
		ordem = new GerenciamentoOrdem();
		genero = new GerenciamentoGenero();
		zoo = new GerenciamentoZoo();
		admin = new GerenciamentoAdmin();
		reserva = new GerenciamentoReserva();
		jornada = new GerenciamentoJornadaDeTrabalho();
	}
	
	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	public ArrayList<Zoo> listarZoo() throws Exception{
		return zoo.listar();
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

	public void alterarInstituicao(Instituicao o) {
		instituicoes.alterarInstituicao(o);
	}
	
	public Instituicao buscarInstituicao(String cnpj) {
		return null;
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
	
	public Ordem buscarOrdem(int id) throws Exception{
		return ordem.buscar(id);
	}
	public ArrayList<Especie> listarEspecie() throws Exception{
		return especie.listarTodos();
	}
	public ArrayList<Ordem> listarOrdem() throws Exception{
		return ordem.listarTodos();
	}
	
	public ArrayList<Genero> listarGenero() throws Exception{
		return genero.listarTodos();
	}
	
	public Genero buscarGenero(int genero2) throws Exception{
		return genero.buscaGenero(genero2);
	}
	
	public Especie buscarEspecie(int especie2) throws Exception {
		return especie.buscar(especie2);
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
	public void cadastrarJaula(Jaula o) {
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
	
	
	/** ADMINISTRADOR */
	public void cadastrarAdministrador(Administrador o) {
		admin.cadastrarAdministrador(o);
	}
	
	public void removerAdministrador(Administrador o) {
		admin.removerAdministrador(o);
	}
	
	public void alterarAdministrador(Administrador o) {
		admin.alterarAdministrador(o);
	}
	
	public Administrador buscarAdministrador(String login) {
		return admin.buscarAdministrador(login);
	}
	
	public ArrayList<Administrador> listarAdministradores() {
		return admin.listarAdministradores();
	}

	/** RESERVA */
	public void cadastrarReserva(Reserva o) {
		reserva.inserir(o);
	}
	
	public void removerReserva(Reserva o) {
		reserva.remover(o);
	}
	
	public void removerReserva(String cnpj) {
		reserva.remover(cnpj);
	}
	
	public void removerReserva(int id) {
		reserva.remover(id);
	}
	
	public void alterarReserva(Reserva o) {
		reserva.alterar(o);
	}
	
	public Reserva buscarReserva(String cnpj, int id_espaco) {
		return reserva.buscar(cnpj, id_espaco);
	}
	
	public ArrayList<Reserva> listarReservas() {
		return reserva.listarTodos();
	}
	
	/** JORNADA_DE_TRABALHO */
	public void cadastrarJornada(JornadaTrabalho o) {
		jornada.inserir(o);
	}
	
	public void removerJornada(JornadaTrabalho o) {
		jornada.remover(o);
	}
	
	public void alterarJornada(JornadaTrabalho o) {
		jornada.alterar(o);
	}
	
	public JornadaTrabalho buscarJornada(int id) {
		return jornada.buscar(id);
	}
	
	public ArrayList<JornadaTrabalho> listarJornada() {
		return jornada.listarTodos();
	}

	/** 
	 * Metodo: buscarZoo
	 * @param id_zoo
	 * @return
	 * @return Zoo
	 */
	public Zoo buscarZoo(int id_zoo) {
		return zoo.buscar(id_zoo);
	}

	
}
