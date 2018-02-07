/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Medicamento {
	private int id;
	private String nome;
	private boolean isAtivo;
	private String descricao_da_frequencia;

	public Medicamento(String nome, boolean isAtivo, String descricao_da_frequencia) {
		this.nome = nome;
		this.isAtivo = isAtivo;
		this.descricao_da_frequencia = descricao_da_frequencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public String getDescricao_da_frequencia() {
		return descricao_da_frequencia;
	}

	public void setDescricao_da_frequencia(String descricao_da_frequencia) {
		this.descricao_da_frequencia = descricao_da_frequencia;
	}
}
