/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDateTime;

public class Fornecedor {
	private int cod;
	private String nome;
	private String cnpj;
	private String telefone;
	private boolean ativo;
	/**
	 * @param cod
	 * @param nome
	 * @param cnpj
	 * @param telefone
	 * @param ativo
	 */
	public Fornecedor(int cod, String nome, String cnpj, String telefone, boolean ativo) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.ativo = ativo;
	}
	/**
	 * Metodo: getCod
	 * @return cod
	 */
	public int getCod() {
		return cod;
	}
	/**
	 * Metodo: setCod
	 * @param cod the cod to set
	 */
	public void setCod(int cod) {
		this.cod = cod;
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
	 * Metodo: getCnpj
	 * @return cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}
	/**
	 * Metodo: setCnpj
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	/**
	 * Metodo: getTelefone
	 * @return telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * Metodo: setTelefone
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/**
	 * Metodo: isAtivo
	 * @return ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}
	/**
	 * Metodo: setAtivo
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + cod;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (ativo != other.ativo)
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (cod != other.cod)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Fornecedor [cod=" + cod + ", nome=" + nome + ", cnpj=" + cnpj + ", telefone=" + telefone + ", ativo="
				+ ativo + "]";
	}
	
	
}
