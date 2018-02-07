/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Ordem {
	private int id;
	private String nome;

	/**
	 * @param id
	 * @param nome
	 */
	public Ordem(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	/**
	 * Metodo: getId
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo: setId
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo: getNome
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo: setNome
	 * 
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	@SuppressWarnings("unused")
	private boolean equals() {
		return false;
	}
}
