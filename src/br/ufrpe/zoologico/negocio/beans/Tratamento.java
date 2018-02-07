/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 15.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class Tratamento {
	private int id;
	private boolean em_andamento;
	private LocalDate dt_inicio;
	private LocalDate dt_fim;
	private String resultado;
	private String obs;

	public Tratamento(boolean em_andamento, LocalDate dt_inicio, LocalDate dt_fim, String resultado, String obs) {
		this.em_andamento = em_andamento;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
		this.resultado = resultado;
		this.obs = obs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEm_andamento() {
		return em_andamento;
	}

	public void setEm_andamento(boolean em_andamento) {
		this.em_andamento = em_andamento;
	}

	public LocalDate getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(LocalDate dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public LocalDate getDt_fim() {
		return dt_fim;
	}

	public void setDt_fim(LocalDate dt_fim) {
		this.dt_fim = dt_fim;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}
