/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class PodeTer {
	private Jaula jaula;
	private Incidente incidente;
	private LocalDate data_incidente;
	private boolean houve_morte;
	
	
	@Override
	public String toString() {
		return "PodeTer [jaula=" + jaula + ", incidente=" + incidente + ", data_incidente=" + data_incidente
				+ ", houve_morte=" + houve_morte + "]";
	}
	/**
	 * @param jaula
	 * @param incidente
	 * @param data_incidente
	 * @param houve_morte
	 */
	public PodeTer(Jaula jaula, Incidente incidente, LocalDate data_incidente, boolean houve_morte) {
		super();
		this.jaula = jaula;
		this.incidente = incidente;
		this.data_incidente = data_incidente;
		this.houve_morte = houve_morte;
	}
	/**
	 * Metodo: getJaula
	 * @return jaula
	 */
	public Jaula getJaula() {
		return jaula;
	}
	/**
	 * Metodo: setJaula
	 * @param jaula the jaula to set
	 */
	public void setJaula(Jaula jaula) {
		this.jaula = jaula;
	}
	/**
	 * Metodo: getIncidente
	 * @return incidente
	 */
	public Incidente getIncidente() {
		return incidente;
	}
	/**
	 * Metodo: setIncidente
	 * @param incidente the incidente to set
	 */
	public void setIncidente(Incidente incidente) {
		this.incidente = incidente;
	}
	/**
	 * Metodo: getData_incidente
	 * @return data_incidente
	 */
	public LocalDate getData_incidente() {
		return data_incidente;
	}
	/**
	 * Metodo: setData_incidente
	 * @param data_incidente the data_incidente to set
	 */
	public void setData_incidente(LocalDate data_incidente) {
		this.data_incidente = data_incidente;
	}
	/**
	 * Metodo: isHouve_morte
	 * @return houve_morte
	 */
	public boolean isHouve_morte() {
		return houve_morte;
	}
	/**
	 * Metodo: setHouve_morte
	 * @param houve_morte the houve_morte to set
	 */
	public void setHouve_morte(boolean houve_morte) {
		this.houve_morte = houve_morte;
	}
	
}
