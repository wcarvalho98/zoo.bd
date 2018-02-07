/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 17.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Instituicao {
	private String cnpj;
	private String nome_contato;
	private String email;
	private String telefone1;
	private String telefone2;
	private String razao_social;
	private String tipo_instituicao;

	/**
	 * @param cnpj
	 * @param nome_contato
	 * @param email
	 * @param telefone1
	 * @param telefone2
	 * @param razao_social
	 * @param tipo_instituicao
	 */
	public Instituicao(String cnpj, String nome_contato, String email, String telefone1, String telefone2,
			String razao_social, String tipo_instituicao) {
		super();
		this.cnpj = cnpj;
		this.nome_contato = nome_contato;
		this.email = email;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.razao_social = razao_social;
		this.tipo_instituicao = tipo_instituicao;
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
	 * Metodo: getNome_contato
	 * 
	 * @return nome_contato
	 */
	public String getNome_contato() {
		return nome_contato;
	}

	/**
	 * Metodo: setNome_contato
	 * 
	 * @param nome_contato
	 *            the nome_contato to set
	 */
	public void setNome_contato(String nome_contato) {
		this.nome_contato = nome_contato;
	}

	/**
	 * Metodo: getEmail
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo: setEmail
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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

	/**
	 * Metodo: getRazao_social
	 * 
	 * @return razao_social
	 */
	public String getRazao_social() {
		return razao_social;
	}

	/**
	 * Metodo: setRazao_social
	 * 
	 * @param razao_social
	 *            the razao_social to set
	 */
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	/**
	 * Metodo: getTipo_instituicao
	 * 
	 * @return tipo_instituicao
	 */
	public String getTipo_instituicao() {
		return tipo_instituicao;
	}

	/**
	 * Metodo: setTipo_instituicao
	 * 
	 * @param tipo_instituicao
	 *            the tipo_instituicao to set
	 */
	public void setTipo_instituicao(String tipo_instituicao) {
		this.tipo_instituicao = tipo_instituicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome_contato == null) ? 0 : nome_contato.hashCode());
		result = prime * result + ((razao_social == null) ? 0 : razao_social.hashCode());
		result = prime * result + ((telefone1 == null) ? 0 : telefone1.hashCode());
		result = prime * result + ((telefone2 == null) ? 0 : telefone2.hashCode());
		result = prime * result + ((tipo_instituicao == null) ? 0 : tipo_instituicao.hashCode());
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
		Instituicao other = (Instituicao) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome_contato == null) {
			if (other.nome_contato != null)
				return false;
		} else if (!nome_contato.equals(other.nome_contato))
			return false;
		if (razao_social == null) {
			if (other.razao_social != null)
				return false;
		} else if (!razao_social.equals(other.razao_social))
			return false;
		if (telefone1 == null) {
			if (other.telefone1 != null)
				return false;
		} else if (!telefone1.equals(other.telefone1))
			return false;
		if (telefone2 == null) {
			if (other.telefone2 != null)
				return false;
		} else if (!telefone2.equals(other.telefone2))
			return false;
		if (tipo_instituicao == null) {
			if (other.tipo_instituicao != null)
				return false;
		} else if (!tipo_instituicao.equals(other.tipo_instituicao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Instituicao [cnpj=" + cnpj + ", nome_contato=" + nome_contato + ", email=" + email + ", telefone1="
				+ telefone1 + ", telefone2=" + telefone2 + ", razao_social=" + razao_social + ", tipo_instituicao="
				+ tipo_instituicao + "]";
	}
}
