/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDateTime;

public class Ponto {
	private LocalDateTime data_hora_inicial;
	private LocalDateTime data_hora_fim;
	private boolean faltou;
	private Funcionario funcionario;

	public Ponto(LocalDateTime chegou, LocalDateTime saiu, boolean faltou, Funcionario funcionario) {
		this.data_hora_inicial = chegou;
		this.data_hora_fim = saiu;
		this.faltou = faltou;
		this.funcionario = funcionario;
	}

	public LocalDateTime getData_hora_inicial() {
		return data_hora_inicial;
	}

	public void setData_hora_inicial(LocalDateTime data_hora_inicial) {
		this.data_hora_inicial = data_hora_inicial;
	}

	public LocalDateTime getData_hora_fim() {
		return data_hora_fim;
	}

	public void setData_hora_fim(LocalDateTime data_hora_fim) {
		this.data_hora_fim = data_hora_fim;
	}

	public boolean isFaltou() {
		return faltou;
	}

	public void setFaltou(boolean faltou) {
		this.faltou = faltou;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
