/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Fornecedor {
	private int cod;
	private String nome;
	private String cnpj;
	private String telefone1;
	private String telefone2;
	private boolean ativo;

	/**
	 * @param cod
	 * @param nome
	 * @param cnpj
	 * @param telefone
	 * @param ativo
	 */
	public Fornecedor(int cod, String nome, String cnpj, String telefone1, String telefone2, boolean ativo) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.cnpj = cnpj;
		this.setTelefone1(telefone1);
		this.setTelefone2(telefone2);
		this.ativo = ativo;
	}

	/**
	 * Metodo: getCod
	 * 
	 * @return cod
	 */
	public int getCod() {
		return cod;
	}

	/**
	 * Metodo: setCod
	 * 
	 * @param cod
	 *            the cod to set
	 */
	public void setCod(int cod) {
		this.cod = cod;
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

	/**
	 * Metodo: getCnpj
	 * 
	 * @return cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Metodo: setCnpj
	 * 
	 * @param cnpj
	 *            the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * Metodo: isAtivo
	 * 
	 * @return ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/**
	 * Metodo: setAtivo
	 * 
	 * @param ativo
	 *            the ativo to set
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

		return true;
	}

	@Override
	public String toString() {
		return "Fornecedor [cod=" + cod + ", nome=" + nome + ", cnpj=" + cnpj + ", telefone=" + telefone1 + ", ativo="
				+ ativo + "]";
	}

	/**
	 * Metodo: getTelefone1
	 * 
	 * @return telefone1
	 */
	public String getTelefone1() {
		return telefone1;
	}

	/**
	 * Metodo: setTelefone1
	 * 
	 * @param telefone1
	 *            the telefone1 to set
	 */
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	/**
	 * Metodo: getTelefone2
	 * 
	 * @return telefone2
	 */
	public String getTelefone2() {
		return telefone2;
	}

	/**
	 * Metodo: setTelefone2
	 * 
	 * @param telefone2
	 *            the telefone2 to set
	 */
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

}
