/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalTime;

public class Turno {
	private int cod;
	private String descricao;
	private LocalTime hr_inicio;
	private LocalTime hr_fim;

	/**
	 * 
	 */
	public Turno(String desc, LocalTime hora_inicio, LocalTime hora_fim) {
		this.descricao = desc;
		this.hr_fim = hora_fim;
		this.hr_inicio = hora_inicio;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalTime getHr_inicio() {
		return hr_inicio;
	}

	public void setHr_inicio(LocalTime hr_inicio) {
		this.hr_inicio = hr_inicio;
	}

	public LocalTime getHr_fim() {
		return hr_fim;
	}

	public void setHr_fim(LocalTime hr_fim) {
		this.hr_fim = hr_fim;
	}

}
