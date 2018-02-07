/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Incidente {
	private int seq;
	private String descr;

	/**
	 * Metodo: getSeq
	 * 
	 * @return seq
	 */
	public int getSeq() {
		return seq;
	}

	/**
	 * Metodo: setSeq
	 * 
	 * @param seq
	 *            the seq to set
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}

	/**
	 * Metodo: getDescr
	 * 
	 * @return descr
	 */
	public String getDescr() {
		return descr;
	}

	/**
	 * Metodo: setDescr
	 * 
	 * @param descr
	 *            the descr to set
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}

	/**
	 * @param seq
	 * @param descr
	 */
	public Incidente(int seq, String descr) {
		super();
		this.seq = seq;
		this.descr = descr;
	}

	public boolean equals() {
		return false;
	}
}
