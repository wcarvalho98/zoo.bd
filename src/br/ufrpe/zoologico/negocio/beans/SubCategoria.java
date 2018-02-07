/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 15.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class SubCategoria {
	private int cod;
	private String descr;
	private int categ;

	/**
	 * @param cod
	 * @param descr
	 * @param categ
	 */
	public SubCategoria(int cod, String descr, int categ) {
		super();
		this.cod = cod;
		this.descr = descr;
		this.categ = categ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categ;
		result = prime * result + cod;
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
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
		SubCategoria other = (SubCategoria) obj;
		if (categ != other.categ)
			return false;
		if (cod != other.cod)
			return false;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		return true;
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
	 * Metodo: getCateg
	 * 
	 * @return categ
	 */
	public int getCateg() {
		return categ;
	}

	/**
	 * Metodo: setCateg
	 * 
	 * @param categ
	 *            the categ to set
	 */
	public void setCateg(int categ) {
		this.categ = categ;
	}

	@Override
	public String toString() {
		return "SubCategoria [cod=" + cod + ", descr=" + descr + ", categ=" + categ + "]";
	}

}
