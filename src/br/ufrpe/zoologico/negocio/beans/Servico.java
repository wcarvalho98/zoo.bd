/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Servico {
	private int id;
	private String descr;
	private double valor;
	/**
	 * @param id
	 * @param descr
	 * @param valor
	 */
	public Servico(int id, String descr, double valor) {
		super();
		this.id = id;
		this.descr = descr;
		this.valor = valor;
	}
	/**
	 * Metodo: getId
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Metodo: setId
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Metodo: getDescr
	 * @return descr
	 */
	public String getDescr() {
		return descr;
	}
	/**
	 * Metodo: setDescr
	 * @param descr the descr to set
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}
	/**
	 * Metodo: getValor
	 * @return valor
	 */
	public double getValor() {
		return valor;
	}
	/**
	 * Metodo: setValor
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Servico other = (Servico) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Servico [id=" + id + ", descr=" + descr + ", valor=" + valor + "]";
	}
	
	
}
