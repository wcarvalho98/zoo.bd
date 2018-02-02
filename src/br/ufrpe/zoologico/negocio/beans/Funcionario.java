/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 17.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class Funcionario {
	private String cpf;
	private String Nome;
	private String fone_1;
	private String fone_2;
	private String especializacao;
	private LocalDate data_de_contratacao;
	private double salario;
	private String endereco;
	private int jornada_trabalho;
	private int id_zoo;

	public Funcionario(String cpf, String nome, String especializacao, String fone1, String fone2, 
			LocalDate data_de_contratacao, double salario, String endereco, int jornada_trabalho, int id_zoo) {
		this.cpf = cpf;
		this.Nome = nome;
		this.fone_1 = fone1;
		this.fone_2 = fone2;
		this.especializacao = especializacao;
		this.data_de_contratacao = data_de_contratacao;
		this.salario = salario;
		this.endereco = endereco;
		this.setJornada_trabalho(jornada_trabalho);
		this.setId_zoo(id_zoo);
	}
	
	public Funcionario() {
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getFone_1() {
		return fone_1;
	}

	public void setFone_1(String fone_1) {
		this.fone_1 = fone_1;
	}

	public String getFone_2() {
		return fone_2;
	}

	public void setFone_2(String fone_2) {
		this.fone_2 = fone_2;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	public LocalDate getData_de_contratacao() {
		return data_de_contratacao;
	}

	public void setData_de_contratacao(LocalDate data_de_contratacao) {
		this.data_de_contratacao = data_de_contratacao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getJornada_trabalho() {
		return jornada_trabalho;
	}

	public void setJornada_trabalho(int jornada_trabalho) {
		this.jornada_trabalho = jornada_trabalho;
	}

	public int getId_zoo() {
		return id_zoo;
	}

	public void setId_zoo(int id_zoo) {
		this.id_zoo = id_zoo;
	}
	
	
}
