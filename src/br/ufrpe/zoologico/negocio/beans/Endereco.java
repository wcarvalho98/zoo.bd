/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Endereco {
	private int idEnd;
	private int idForn;
	private String bairro;
	private String rua;
	private String cep;
	private String estado;
	/**
	 * @param idEnd
	 * @param idForn
	 * @param bairro
	 * @param rua
	 * @param cep
	 * @param estado
	 */
	public Endereco(int idEnd, int idForn, String bairro, String rua, String cep, String estado) {
		super();
		this.idEnd = idEnd;
		this.idForn = idForn;
		this.bairro = bairro;
		this.rua = rua;
		this.cep = cep;
		this.estado = estado;
	}
	/**
	 * Metodo: getIdEnd
	 * @return idEnd
	 */
	public int getIdEnd() {
		return idEnd;
	}
	/**
	 * Metodo: setIdEnd
	 * @param idEnd the idEnd to set
	 */
	public void setIdEnd(int idEnd) {
		this.idEnd = idEnd;
	}
	/**
	 * Metodo: getIdForn
	 * @return idForn
	 */
	public int getIdForn() {
		return idForn;
	}
	/**
	 * Metodo: setIdForn
	 * @param idForn the idForn to set
	 */
	public void setIdForn(int idForn) {
		this.idForn = idForn;
	}
	/**
	 * Metodo: getBairro
	 * @return bairro
	 */
	public String getBairro() {
		return bairro;
	}
	/**
	 * Metodo: setBairro
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	 * Metodo: getRua
	 * @return rua
	 */
	public String getRua() {
		return rua;
	}
	/**
	 * Metodo: setRua
	 * @param rua the rua to set
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}
	/**
	 * Metodo: getCep
	 * @return cep
	 */
	public String getCep() {
		return cep;
	}
	/**
	 * Metodo: setCep
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/**
	 * Metodo: getEstado
	 * @return estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * Metodo: setEstado
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + idEnd;
		result = prime * result + idForn;
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
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
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (idEnd != other.idEnd)
			return false;
		if (idForn != other.idForn)
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Endereco [idEnd=" + idEnd + ", idForn=" + idForn + ", bairro=" + bairro + ", rua=" + rua + ", cep="
				+ cep + ", estado=" + estado + "]";
	}
	
	
}
