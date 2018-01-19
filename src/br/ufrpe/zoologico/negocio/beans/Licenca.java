/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class Licenca {
	private int id_liceca;
	private String descr;
	private LocalDate data_de_expiracao;
	private Zoo zoo;
	
	/**
	 * @param id_liceca
	 * @param descr
	 * @param data_de_expiracao
	 * @param zoo
	 */
	public Licenca(int id_liceca, String descr, LocalDate data_de_expiracao, Zoo zoo) {
		super();
		this.id_liceca = id_liceca;
		this.descr = descr;
		this.data_de_expiracao = data_de_expiracao;
		this.zoo = zoo;
	}

	/**
	 * Metodo: getId_liceca
	 * @return id_liceca
	 */
	public int getId_liceca() {
		return id_liceca;
	}

	/**
	 * Metodo: setId_liceca
	 * @param id_liceca the id_liceca to set
	 */
	public void setId_liceca(int id_liceca) {
		this.id_liceca = id_liceca;
	}

	/**
	 * Metodo: getDescr
	 * @return descr
	 */
	public String getDescr() {
		return descr;
	}

	/**
	 * Metodo: setDescr
	 * @param descr the descr to set
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}

	/**
	 * Metodo: getData_de_expiracao
	 * @return data_de_expiracao
	 */
	public LocalDate getData_de_expiracao() {
		return data_de_expiracao;
	}

	/**
	 * Metodo: setData_de_expiracao
	 * @param data_de_expiracao the data_de_expiracao to set
	 */
	public void setData_de_expiracao(LocalDate data_de_expiracao) {
		this.data_de_expiracao = data_de_expiracao;
	}

	/**
	 * Metodo: getZoo
	 * @return zoo
	 */
	public Zoo getZoo() {
		return zoo;
	}

	/**
	 * Metodo: setZoo
	 * @param zoo the zoo to set
	 */
	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}

	@Override
	public String toString() {
		return "Licenca [id_liceca=" + id_liceca + ", descr=" + descr + ", data_de_expiracao=" + data_de_expiracao
				+ ", zoo=" + zoo + "]";
	}
}
