/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Especie {
	private int seq;
	private String nome;
	private Genero genero;
	
	
	@Override
	public String toString() {
		return "Especie [seq=" + seq + ", nome=" + nome + ", genero=" + genero + "]";
	}
	/**
	 * @param seq
	 * @param nome
	 * @param genero
	 */
	public Especie(int seq, String nome, Genero genero) {
		super();
		this.seq = seq;
		this.nome = nome;
		this.genero = genero;
	}
	/**
	 * Metodo: getSeq
	 * @return seq
	 */
	public int getSeq() {
		return seq;
	}
	/**
	 * Metodo: setSeq
	 * @param seq the seq to set
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}
	/**
	 * Metodo: getNome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Metodo: setNome
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Metodo: getGenero
	 * @return genero
	 */
	public Genero getGenero() {
		return genero;
	}
	/**
	 * Metodo: setGenero
	 * @param genero the genero to set
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public boolean equals(){
		return false;
	}
}
