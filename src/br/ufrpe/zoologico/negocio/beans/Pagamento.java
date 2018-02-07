/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class Pagamento {
	private int cod;
	private LocalDate data_pagamento;
	private String stats;
	private double vl_pago;
	private String tipo_pag;
	private int idFatura;
	private int nfe;

	/**
	 * @param cod
	 * @param data_pagamento
	 * @param stats
	 * @param vl_pago
	 * @param tipo_pag
	 * @param idFatura
	 * @param nfe
	 */
	public Pagamento(int cod, LocalDate data_pagamento, String stats, double vl_pago, String tipo_pag, int idFatura,
			int nfe) {
		super();
		this.cod = cod;
		this.data_pagamento = data_pagamento;
		this.stats = stats;
		this.vl_pago = vl_pago;
		this.tipo_pag = tipo_pag;
		this.idFatura = idFatura;
		this.nfe = nfe;
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
	 * Metodo: getData_pagamento
	 * 
	 * @return data_pagamento
	 */
	public LocalDate getData_pagamento() {
		return data_pagamento;
	}

	/**
	 * Metodo: setData_pagamento
	 * 
	 * @param data_pagamento
	 *            the data_pagamento to set
	 */
	public void setData_pagamento(LocalDate data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	/**
	 * Metodo: getStats
	 * 
	 * @return stats
	 */
	public String getStats() {
		return stats;
	}

	/**
	 * Metodo: setStats
	 * 
	 * @param stats
	 *            the stats to set
	 */
	public void setStats(String stats) {
		this.stats = stats;
	}

	/**
	 * Metodo: getVl_pago
	 * 
	 * @return vl_pago
	 */
	public double getVl_pago() {
		return vl_pago;
	}

	/**
	 * Metodo: setVl_pago
	 * 
	 * @param vl_pago
	 *            the vl_pago to set
	 */
	public void setVl_pago(double vl_pago) {
		this.vl_pago = vl_pago;
	}

	/**
	 * Metodo: getTipo_pag
	 * 
	 * @return tipo_pag
	 */
	public String getTipo_pag() {
		return tipo_pag;
	}

	/**
	 * Metodo: setTipo_pag
	 * 
	 * @param tipo_pag
	 *            the tipo_pag to set
	 */
	public void setTipo_pag(String tipo_pag) {
		this.tipo_pag = tipo_pag;
	}

	/**
	 * Metodo: getIdFatura
	 * 
	 * @return idFatura
	 */
	public int getIdFatura() {
		return idFatura;
	}

	/**
	 * Metodo: setIdFatura
	 * 
	 * @param idFatura
	 *            the idFatura to set
	 */
	public void setIdFatura(int idFatura) {
		this.idFatura = idFatura;
	}

	/**
	 * Metodo: getNfe
	 * 
	 * @return nfe
	 */
	public int getNfe() {
		return nfe;
	}

	/**
	 * Metodo: setNfe
	 * 
	 * @param nfe
	 *            the nfe to set
	 */
	public void setNfe(int nfe) {
		this.nfe = nfe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod;
		result = prime * result + ((data_pagamento == null) ? 0 : data_pagamento.hashCode());
		result = prime * result + idFatura;
		result = prime * result + nfe;
		result = prime * result + ((stats == null) ? 0 : stats.hashCode());
		result = prime * result + ((tipo_pag == null) ? 0 : tipo_pag.hashCode());
		long temp;
		temp = Double.doubleToLongBits(vl_pago);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Pagamento other = (Pagamento) obj;
		if (cod != other.cod)
			return false;
		if (data_pagamento == null) {
			if (other.data_pagamento != null)
				return false;
		} else if (!data_pagamento.equals(other.data_pagamento))
			return false;
		if (idFatura != other.idFatura)
			return false;
		if (nfe != other.nfe)
			return false;
		if (stats == null) {
			if (other.stats != null)
				return false;
		} else if (!stats.equals(other.stats))
			return false;
		if (tipo_pag == null) {
			if (other.tipo_pag != null)
				return false;
		} else if (!tipo_pag.equals(other.tipo_pag))
			return false;
		if (Double.doubleToLongBits(vl_pago) != Double.doubleToLongBits(other.vl_pago))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pagamento [cod=" + cod + ", data_pagamento=" + data_pagamento + ", stats=" + stats + ", vl_pago="
				+ vl_pago + ", tipo_pag=" + tipo_pag + ", idFatura=" + idFatura + ", nfe=" + nfe + "]";
	}

}
