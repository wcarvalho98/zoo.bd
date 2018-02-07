/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class TipoPagamento {
	private int cod;
	private String desc;

	/**
	 * @param cod
	 * @param desc
	 */
	public TipoPagamento(int cod, String desc) {
		super();
		this.cod = cod;
		this.desc = desc;
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
	 * Metodo: getDesc
	 * 
	 * @return desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Metodo: setDesc
	 * 
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
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
		TipoPagamento other = (TipoPagamento) obj;
		if (cod != other.cod)
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoPagamento [cod=" + cod + ", desc=" + desc + "]";
	}

}
