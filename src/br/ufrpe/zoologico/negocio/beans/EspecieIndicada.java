/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 15.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class EspecieIndicada {
	private Jaula jaula;
	private int seq;

	/**
	 * @param jaula
	 * @param seq
	 */
	public EspecieIndicada(Jaula jaula, int seq) {
		super();
		this.jaula = jaula;
		this.seq = seq;
	}

	/**
	 * Metodo: getJaula
	 * 
	 * @return jaula
	 */
	public Jaula getJaula() {
		return jaula;
	}

	/**
	 * Metodo: setJaula
	 * 
	 * @param jaula
	 *            the jaula to set
	 */
	public void setJaula(Jaula jaula) {
		this.jaula = jaula;
	}

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

}
