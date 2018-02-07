/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Administrador {
	private String cpf;
	private String senha_de_acesso;
	private int idZoo;
	private String login;

	/**
	 * @param cpf
	 * @param senha_de_acesso
	 * @param idZoo
	 * @param login
	 */
	public Administrador(String cpf, String senha_de_acesso, int idZoo, String login) {
		super();
		this.cpf = cpf;
		this.senha_de_acesso = senha_de_acesso;
		this.idZoo = idZoo;
		this.login = login;
	}

	/**
	 * Metodo: getCpf
	 * 
	 * @return cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Metodo: setCpf
	 * 
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Metodo: getSenha_de_acesso
	 * 
	 * @return senha_de_acesso
	 */
	public String getSenha_de_acesso() {
		return senha_de_acesso;
	}

	/**
	 * Metodo: setSenha_de_acesso
	 * 
	 * @param senha_de_acesso
	 *            the senha_de_acesso to set
	 */
	public void setSenha_de_acesso(String senha_de_acesso) {
		this.senha_de_acesso = senha_de_acesso;
	}

	/**
	 * Metodo: getIdZoo
	 * 
	 * @return idZoo
	 */
	public int getIdZoo() {
		return idZoo;
	}

	/**
	 * Metodo: setIdZoo
	 * 
	 * @param idZoo
	 *            the idZoo to set
	 */
	public void setIdZoo(int idZoo) {
		this.idZoo = idZoo;
	}

	/**
	 * Metodo: getLogin
	 * 
	 * @return login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Metodo: setLogin
	 * 
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Administrador other = (Administrador) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Administrador [cpf=" + cpf + ", senha_de_acesso=" + senha_de_acesso + ", idZoo=" + idZoo + ", login="
				+ login + "]";
	}

}
