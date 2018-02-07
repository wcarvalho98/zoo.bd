/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
	private int qtd_pessoas;
	private LocalDate dt_validade;
	private LocalTime horario;
	private LocalDate dt_reserva;
	private double valor;
	private String stats;
	private LocalTime hr_inicio_reser;
	private LocalTime hr_final_reser;
	private String e_cortesia;
	private String tp_evento;
	private String cnpj;
	private int id;

	/**
	 * @param qtd_pessoas
	 * @param dt_validade
	 * @param horario
	 * @param dt_reserva
	 * @param valor
	 * @param stats
	 * @param hr_inicio_reser
	 * @param hr_final_reser
	 * @param e_cortesia
	 * @param tp_evento
	 * @param cnpj
	 * @param id
	 */
	public Reserva(int qtd_pessoas, LocalDate dt_validade, LocalTime horario, LocalDate dt_reserva, double valor,
			String stats, LocalTime hr_inicio_reser, LocalTime hr_final_reser, String e_cortesia, String tp_evento,
			String cnpj, int id) {
		super();
		this.qtd_pessoas = qtd_pessoas;
		this.dt_validade = dt_validade;
		this.horario = horario;
		this.dt_reserva = dt_reserva;
		this.valor = valor;
		this.stats = stats;
		this.hr_inicio_reser = hr_inicio_reser;
		this.hr_final_reser = hr_final_reser;
		this.e_cortesia = e_cortesia;
		this.tp_evento = tp_evento;
		this.cnpj = cnpj;
		this.id = id;
	}

	/**
	 * Metodo: getQtd_pessoas
	 * 
	 * @return qtd_pessoas
	 */
	public int getQtd_pessoas() {
		return qtd_pessoas;
	}

	/**
	 * Metodo: setQtd_pessoas
	 * 
	 * @param qtd_pessoas
	 *            the qtd_pessoas to set
	 */
	public void setQtd_pessoas(int qtd_pessoas) {
		this.qtd_pessoas = qtd_pessoas;
	}

	/**
	 * Metodo: getDt_validade
	 * 
	 * @return dt_validade
	 */
	public LocalDate getDt_validade() {
		return dt_validade;
	}

	/**
	 * Metodo: setDt_validade
	 * 
	 * @param dt_validade
	 *            the dt_validade to set
	 */
	public void setDt_validade(LocalDate dt_validade) {
		this.dt_validade = dt_validade;
	}

	/**
	 * Metodo: getHorario
	 * 
	 * @return horario
	 */
	public LocalTime getHorario() {
		return horario;
	}

	/**
	 * Metodo: setHorario
	 * 
	 * @param horario
	 *            the horario to set
	 */
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	/**
	 * Metodo: getDt_reserva
	 * 
	 * @return dt_reserva
	 */
	public LocalDate getDt_reserva() {
		return dt_reserva;
	}

	/**
	 * Metodo: setDt_reserva
	 * 
	 * @param dt_reserva
	 *            the dt_reserva to set
	 */
	public void setDt_reserva(LocalDate dt_reserva) {
		this.dt_reserva = dt_reserva;
	}

	/**
	 * Metodo: getValor
	 * 
	 * @return valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * Metodo: setValor
	 * 
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
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
	 * Metodo: getHr_inicio_reser
	 * 
	 * @return hr_inicio_reser
	 */
	public LocalTime getHr_inicio_reser() {
		return hr_inicio_reser;
	}

	/**
	 * Metodo: setHr_inicio_reser
	 * 
	 * @param hr_inicio_reser
	 *            the hr_inicio_reser to set
	 */
	public void setHr_inicio_reser(LocalTime hr_inicio_reser) {
		this.hr_inicio_reser = hr_inicio_reser;
	}

	/**
	 * Metodo: getHr_final_reser
	 * 
	 * @return hr_final_reser
	 */
	public LocalTime getHr_final_reser() {
		return hr_final_reser;
	}

	/**
	 * Metodo: setHr_final_reser
	 * 
	 * @param hr_final_reser
	 *            the hr_final_reser to set
	 */
	public void setHr_final_reser(LocalTime hr_final_reser) {
		this.hr_final_reser = hr_final_reser;
	}

	/**
	 * Metodo: getE_cortesia
	 * 
	 * @return e_cortesia
	 */
	public String getE_cortesia() {
		return e_cortesia;
	}

	/**
	 * Metodo: setE_cortesia
	 * 
	 * @param e_cortesia
	 *            the e_cortesia to set
	 */
	public void setE_cortesia(String e_cortesia) {
		this.e_cortesia = e_cortesia;
	}

	/**
	 * Metodo: getTp_evento
	 * 
	 * @return tp_evento
	 */
	public String getTp_evento() {
		return tp_evento;
	}

	/**
	 * Metodo: setTp_evento
	 * 
	 * @param tp_evento
	 *            the tp_evento to set
	 */
	public void setTp_evento(String tp_evento) {
		this.tp_evento = tp_evento;
	}

	/**
	 * Metodo: getCnpj
	 * 
	 * @return cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Metodo: setCnpj
	 * 
	 * @param cnpj
	 *            the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((dt_reserva == null) ? 0 : dt_reserva.hashCode());
		result = prime * result + ((dt_validade == null) ? 0 : dt_validade.hashCode());
		result = prime * result + ((e_cortesia == null) ? 0 : e_cortesia.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
		result = prime * result + ((hr_final_reser == null) ? 0 : hr_final_reser.hashCode());
		result = prime * result + ((hr_inicio_reser == null) ? 0 : hr_inicio_reser.hashCode());
		result = prime * result + id;
		result = prime * result + qtd_pessoas;
		result = prime * result + ((stats == null) ? 0 : stats.hashCode());
		result = prime * result + ((tp_evento == null) ? 0 : tp_evento.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
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
		Reserva other = (Reserva) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (dt_reserva == null) {
			if (other.dt_reserva != null)
				return false;
		} else if (!dt_reserva.equals(other.dt_reserva))
			return false;
		if (dt_validade == null) {
			if (other.dt_validade != null)
				return false;
		} else if (!dt_validade.equals(other.dt_validade))
			return false;
		if (e_cortesia == null) {
			if (other.e_cortesia != null)
				return false;
		} else if (!e_cortesia.equals(other.e_cortesia))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (hr_final_reser == null) {
			if (other.hr_final_reser != null)
				return false;
		} else if (!hr_final_reser.equals(other.hr_final_reser))
			return false;
		if (hr_inicio_reser == null) {
			if (other.hr_inicio_reser != null)
				return false;
		} else if (!hr_inicio_reser.equals(other.hr_inicio_reser))
			return false;
		if (id != other.id)
			return false;
		if (qtd_pessoas != other.qtd_pessoas)
			return false;
		if (stats == null) {
			if (other.stats != null)
				return false;
		} else if (!stats.equals(other.stats))
			return false;
		if (tp_evento == null) {
			if (other.tp_evento != null)
				return false;
		} else if (!tp_evento.equals(other.tp_evento))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reserva [qtd_pessoas=" + qtd_pessoas + ", dt_validade=" + dt_validade + ", horario=" + horario
				+ ", dt_reserva=" + dt_reserva + ", valor=" + valor + ", stats=" + stats + ", hr_inicio_reser="
				+ hr_inicio_reser + ", hr_final_reser=" + hr_final_reser + ", e_cortesia=" + e_cortesia + ", tp_evento="
				+ tp_evento + ", cnpj=" + cnpj + ", id=" + id + "]";
	}

}
