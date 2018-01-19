/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 17.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class Presta {
	private int idEmpreTerc;
	private int idSev;
	private LocalDate dt_inicio, dt_fim;
	/**
	 * @param idEmpreTerc
	 * @param idSev
	 * @param dt_inicio
	 * @param dt_fim
	 */
	public Presta(int idEmpreTerc, int idSev, LocalDate dt_inicio, LocalDate dt_fim) {
		super();
		this.idEmpreTerc = idEmpreTerc;
		this.idSev = idSev;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
	}
	/**
	 * Metodo: getIdEmpreTerc
	 * @return idEmpreTerc
	 */
	public int getIdEmpreTerc() {
		return idEmpreTerc;
	}
	/**
	 * Metodo: setIdEmpreTerc
	 * @param idEmpreTerc the idEmpreTerc to set
	 */
	public void setIdEmpreTerc(int idEmpreTerc) {
		this.idEmpreTerc = idEmpreTerc;
	}
	/**
	 * Metodo: getIdSev
	 * @return idSev
	 */
	public int getIdSev() {
		return idSev;
	}
	/**
	 * Metodo: setIdSev
	 * @param idSev the idSev to set
	 */
	public void setIdSev(int idSev) {
		this.idSev = idSev;
	}
	/**
	 * Metodo: getDt_inicio
	 * @return dt_inicio
	 */
	public LocalDate getDt_inicio() {
		return dt_inicio;
	}
	/**
	 * Metodo: setDt_inicio
	 * @param dt_inicio the dt_inicio to set
	 */
	public void setDt_inicio(LocalDate dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	/**
	 * Metodo: getDt_fim
	 * @return dt_fim
	 */
	public LocalDate getDt_fim() {
		return dt_fim;
	}
	/**
	 * Metodo: setDt_fim
	 * @param dt_fim the dt_fim to set
	 */
	public void setDt_fim(LocalDate dt_fim) {
		this.dt_fim = dt_fim;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmpreTerc;
		result = prime * result + idSev;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Presta other = (Presta) obj;
		if (idEmpreTerc != other.idEmpreTerc)
			return false;
		if (idSev != other.idSev)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Presta [idEmpreTerc=" + idEmpreTerc + ", idSev=" + idSev + ", dt_inicio=" + dt_inicio + ", dt_fim="
				+ dt_fim + "]";
	}
	
	
}
