/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Estoque {
	private int id;
	private int idZoo;
	private String descr;
	private String localizacao;

	/**
	 * @param id
	 * @param idZoo
	 * @param descr
	 * @param localizacao
	 */
	public Estoque(int id, int idZoo, String descr, String localizacao) {
		super();
		this.id = id;
		this.idZoo = idZoo;
		this.descr = descr;
		this.localizacao = localizacao;
	}

	public Estoque() {

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
	 * Metodo: getDescr
	 * 
	 * @return descr
	 */
	public String getDescr() {
		return descr;
	}

	/**
	 * Metodo: setDescr
	 * 
	 * @param descr
	 *            the descr to set
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}

	/**
	 * Metodo: getLocalizacao
	 * 
	 * @return localizacao
	 */
	public String getLocalizacao() {
		return localizacao;
	}

	/**
	 * Metodo: setLocalizacao
	 * 
	 * @param localizacao
	 *            the localizacao to set
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + id;
		result = prime * result + idZoo;
		result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
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
		Estoque other = (Estoque) obj;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (id != other.id)
			return false;
		if (idZoo != other.idZoo)
			return false;
		if (localizacao == null) {
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", idZoo=" + idZoo + ", descr=" + descr + ", localizacao=" + localizacao + "]";
	}
}
