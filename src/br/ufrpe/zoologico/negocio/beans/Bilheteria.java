/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;
import java.time.LocalTime;

public class Bilheteria {
	private int id;
	private double total_inteira;
	private double total_cortesia;
	private boolean status_biblheteria;
	private LocalDate data_bilheteria;
	private double reda_do_dia;
	private LocalTime hr_abertura;
	private double duracao;
	private LocalTime hr_fecha;
	private int idZoo;
	/**
	 * @param id
	 * @param total_inteira
	 * @param total_cortesia
	 * @param status_biblheteria
	 * @param data_bilheteria
	 * @param reda_do_dia
	 * @param hr_abertura
	 * @param duracao
	 * @param hr_fecha
	 * @param idZoo
	 */
	public Bilheteria(int id, double total_inteira, double total_cortesia, boolean status_biblheteria,
			LocalDate data_bilheteria, double reda_do_dia, LocalTime hr_abertura, double duracao, LocalTime hr_fecha,
			int idZoo) {
		super();
		this.id = id;
		this.total_inteira = total_inteira;
		this.total_cortesia = total_cortesia;
		this.status_biblheteria = status_biblheteria;
		this.data_bilheteria = data_bilheteria;
		this.reda_do_dia = reda_do_dia;
		this.hr_abertura = hr_abertura;
		this.duracao = duracao;
		this.hr_fecha = hr_fecha;
		this.idZoo = idZoo;
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
	 * Metodo: getTotal_inteira
	 * @return total_inteira
	 */
	public double getTotal_inteira() {
		return total_inteira;
	}
	/**
	 * Metodo: setTotal_inteira
	 * @param total_inteira the total_inteira to set
	 */
	public void setTotal_inteira(double total_inteira) {
		this.total_inteira = total_inteira;
	}
	/**
	 * Metodo: getTotal_cortesia
	 * @return total_cortesia
	 */
	public double getTotal_cortesia() {
		return total_cortesia;
	}
	/**
	 * Metodo: setTotal_cortesia
	 * @param total_cortesia the total_cortesia to set
	 */
	public void setTotal_cortesia(double total_cortesia) {
		this.total_cortesia = total_cortesia;
	}
	/**
	 * Metodo: isStatus_biblheteria
	 * @return status_biblheteria
	 */
	public boolean isStatus_biblheteria() {
		return status_biblheteria;
	}
	/**
	 * Metodo: setStatus_biblheteria
	 * @param status_biblheteria the status_biblheteria to set
	 */
	public void setStatus_biblheteria(boolean status_biblheteria) {
		this.status_biblheteria = status_biblheteria;
	}
	/**
	 * Metodo: getData_bilheteria
	 * @return data_bilheteria
	 */
	public LocalDate getData_bilheteria() {
		return data_bilheteria;
	}
	/**
	 * Metodo: setData_bilheteria
	 * @param data_bilheteria the data_bilheteria to set
	 */
	public void setData_bilheteria(LocalDate data_bilheteria) {
		this.data_bilheteria = data_bilheteria;
	}
	/**
	 * Metodo: getReda_do_dia
	 * @return reda_do_dia
	 */
	public double getReda_do_dia() {
		return reda_do_dia;
	}
	/**
	 * Metodo: setReda_do_dia
	 * @param reda_do_dia the reda_do_dia to set
	 */
	public void setReda_do_dia(double reda_do_dia) {
		this.reda_do_dia = reda_do_dia;
	}
	/**
	 * Metodo: getHr_abertura
	 * @return hr_abertura
	 */
	public LocalTime getHr_abertura() {
		return hr_abertura;
	}
	/**
	 * Metodo: setHr_abertura
	 * @param hr_abertura the hr_abertura to set
	 */
	public void setHr_abertura(LocalTime hr_abertura) {
		this.hr_abertura = hr_abertura;
	}
	/**
	 * Metodo: getDuracao
	 * @return duracao
	 */
	public double getDuracao() {
		return duracao;
	}
	/**
	 * Metodo: setDuracao
	 * @param duracao the duracao to set
	 */
	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
	/**
	 * Metodo: getHr_fecha
	 * @return hr_fecha
	 */
	public LocalTime getHr_fecha() {
		return hr_fecha;
	}
	/**
	 * Metodo: setHr_fecha
	 * @param hr_fecha the hr_fecha to set
	 */
	public void setHr_fecha(LocalTime hr_fecha) {
		this.hr_fecha = hr_fecha;
	}
	/**
	 * Metodo: getIdZoo
	 * @return idZoo
	 */
	public int getIdZoo() {
		return idZoo;
	}
	/**
	 * Metodo: setIdZoo
	 * @param idZoo the idZoo to set
	 */
	public void setIdZoo(int idZoo) {
		this.idZoo = idZoo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_bilheteria == null) ? 0 : data_bilheteria.hashCode());
		long temp;
		temp = Double.doubleToLongBits(duracao);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((hr_abertura == null) ? 0 : hr_abertura.hashCode());
		result = prime * result + ((hr_fecha == null) ? 0 : hr_fecha.hashCode());
		result = prime * result + id;
		result = prime * result + idZoo;
		temp = Double.doubleToLongBits(reda_do_dia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (status_biblheteria ? 1231 : 1237);
		temp = Double.doubleToLongBits(total_cortesia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(total_inteira);
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
		Bilheteria other = (Bilheteria) obj;
		if (data_bilheteria == null) {
			if (other.data_bilheteria != null)
				return false;
		} else if (!data_bilheteria.equals(other.data_bilheteria))
			return false;
		if (Double.doubleToLongBits(duracao) != Double.doubleToLongBits(other.duracao))
			return false;
		if (hr_abertura == null) {
			if (other.hr_abertura != null)
				return false;
		} else if (!hr_abertura.equals(other.hr_abertura))
			return false;
		if (hr_fecha == null) {
			if (other.hr_fecha != null)
				return false;
		} else if (!hr_fecha.equals(other.hr_fecha))
			return false;
		if (id != other.id)
			return false;
		if (idZoo != other.idZoo)
			return false;
		if (Double.doubleToLongBits(reda_do_dia) != Double.doubleToLongBits(other.reda_do_dia))
			return false;
		if (status_biblheteria != other.status_biblheteria)
			return false;
		if (Double.doubleToLongBits(total_cortesia) != Double.doubleToLongBits(other.total_cortesia))
			return false;
		if (Double.doubleToLongBits(total_inteira) != Double.doubleToLongBits(other.total_inteira))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bilheteria [id=" + id + ", total_inteira=" + total_inteira + ", total_cortesia=" + total_cortesia
				+ ", status_biblheteria=" + status_biblheteria + ", data_bilheteria=" + data_bilheteria
				+ ", reda_do_dia=" + reda_do_dia + ", hr_abertura=" + hr_abertura + ", duracao=" + duracao
				+ ", hr_fecha=" + hr_fecha + ", idZoo=" + idZoo + "]";
	}
	
	
}
