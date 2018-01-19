/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 15.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Tratador {
	private String cpf;
	private String situacao;
	
	/**
	 * Metodo: getCpf
	 * @return cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * Metodo: setCpf
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * Metodo: getSituacao
	 * @return situacao
	 */
	public String getSituacao() {
		return situacao;
	}
	/**
	 * Metodo: setSituacao
	 * @param situacao the situacao to set
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	/**
	 * @param cpf
	 * @param situacao
	 */
	public Tratador(String cpf, String situacao) {
		super();
		this.cpf = cpf;
		this.situacao = situacao;
	}
}
