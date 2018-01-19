/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Genero {
	private int id;
	private String nome;
	private Ordem ordem;
	
	/**
	 * @param id
	 * @param nome
	 * @param ordem
	 */
	public Genero(int id, String nome, Ordem ordem) {
		super();
		this.id = id;
		this.nome = nome;
		this.ordem = ordem;
	}
	/**
	 * Metodo: getId
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Metodo: setId
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * Metodo: getOrdem
	 * @return ordem
	 */
	public Ordem getOrdem() {
		return ordem;
	}
	/**
	 * Metodo: setOrdem
	 * @param ordem the ordem to set
	 */
	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}
	
	private boolean equals(){
		return false;
	}
}
