/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class EmpresaTerceira {
	private String cnpj;
	private String fone;
	private String email;
	/**
	 * @param cnpj
	 * @param fone
	 * @param email
	 */
	public EmpresaTerceira(String cnpj, String fone, String email) {
		super();
		this.cnpj = cnpj;
		this.fone = fone;
		this.email = email;
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
	 * Metodo: getFone
	 * @return fone
	 */
	public String getFone() {
		return fone;
	}
	/**
	 * Metodo: setFone
	 * @param fone the fone to set
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}
	/**
	 * Metodo: getEmail
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Metodo: setEmail
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		EmpresaTerceira other = (EmpresaTerceira) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EmpresaTerceira [cnpj=" + cnpj + ", fone=" + fone + ", email=" + email + "]";
	}
	
	
}
