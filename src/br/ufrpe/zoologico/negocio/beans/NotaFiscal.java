/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class NotaFiscal {
	private int nfe;
	private double icms;
	private double valor_total;
	private double vl_total_desconto;
	private LocalDate data_nf;

	/**
	 * @param nfe
	 * @param icms
	 * @param valor_total
	 * @param vl_total_desconto
	 * @param data_nf
	 */
	public NotaFiscal(int nfe, double icms, double valor_total, double vl_total_desconto, LocalDate data_nf) {
		super();
		this.nfe = nfe;
		this.icms = icms;
		this.valor_total = valor_total;
		this.vl_total_desconto = vl_total_desconto;
		this.data_nf = data_nf;
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

	/**
	 * Metodo: getIcms
	 * 
	 * @return icms
	 */
	public double getIcms() {
		return icms;
	}

	/**
	 * Metodo: setIcms
	 * 
	 * @param icms
	 *            the icms to set
	 */
	public void setIcms(double icms) {
		this.icms = icms;
	}

	/**
	 * Metodo: getValor_total
	 * 
	 * @return valor_total
	 */
	public double getValor_total() {
		return valor_total;
	}

	/**
	 * Metodo: setValor_total
	 * 
	 * @param valor_total
	 *            the valor_total to set
	 */
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	/**
	 * Metodo: getVl_total_desconto
	 * 
	 * @return vl_total_desconto
	 */
	public double getVl_total_desconto() {
		return vl_total_desconto;
	}

	/**
	 * Metodo: setVl_total_desconto
	 * 
	 * @param vl_total_desconto
	 *            the vl_total_desconto to set
	 */
	public void setVl_total_desconto(double vl_total_desconto) {
		this.vl_total_desconto = vl_total_desconto;
	}

	/**
	 * Metodo: getData_nf
	 * 
	 * @return data_nf
	 */
	public LocalDate getData_nf() {
		return data_nf;
	}

	/**
	 * Metodo: setData_nf
	 * 
	 * @param data_nf
	 *            the data_nf to set
	 */
	public void setData_nf(LocalDate data_nf) {
		this.data_nf = data_nf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_nf == null) ? 0 : data_nf.hashCode());
		long temp;
		temp = Double.doubleToLongBits(icms);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + nfe;
		temp = Double.doubleToLongBits(valor_total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vl_total_desconto);
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
		NotaFiscal other = (NotaFiscal) obj;
		if (data_nf == null) {
			if (other.data_nf != null)
				return false;
		} else if (!data_nf.equals(other.data_nf))
			return false;
		if (Double.doubleToLongBits(icms) != Double.doubleToLongBits(other.icms))
			return false;
		if (nfe != other.nfe)
			return false;
		if (Double.doubleToLongBits(valor_total) != Double.doubleToLongBits(other.valor_total))
			return false;
		if (Double.doubleToLongBits(vl_total_desconto) != Double.doubleToLongBits(other.vl_total_desconto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NotaFiscal [nfe=" + nfe + ", icms=" + icms + ", valor_total=" + valor_total + ", vl_total_desconto="
				+ vl_total_desconto + ", data_nf=" + data_nf + "]";
	}
}
