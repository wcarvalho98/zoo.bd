/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 17.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class Fatura {
	private int idFatura;
	private double valor;
	private LocalDate dataDaFatura;
	private LocalDate dt_paga;
	private double vl_multa;
	private String stats;
	private String tp_fatura;
	private int id_ped_serv;
	/**
	 * @param idFatura
	 * @param valor
	 * @param dataDaFatura
	 * @param vl_multa
	 * @param stats
	 * @param tp_fatura
	 * @param id_ped_serv
	 */
	public Fatura(int idFatura, double valor, LocalDate dataDaFatura, LocalDate dt_paga, double vl_multa, String stats, String tp_fatura,
			int id_ped_serv) {
		super();
		this.idFatura = idFatura;
		this.valor = valor;
		this.dataDaFatura = dataDaFatura;
		this.setDt_paga(dt_paga);
		this.vl_multa = vl_multa;
		this.stats = stats;
		this.tp_fatura = tp_fatura;
		this.id_ped_serv = id_ped_serv;
	}
	/**
	 * Metodo: getIdFatura
	 * @return idFatura
	 */
	public int getIdFatura() {
		return idFatura;
	}
	/**
	 * Metodo: setIdFatura
	 * @param idFatura the idFatura to set
	 */
	public void setIdFatura(int idFatura) {
		this.idFatura = idFatura;
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
	/**
	 * Metodo: getDataDaFatura
	 * @return dataDaFatura
	 */
	public LocalDate getDataDaFatura() {
		return dataDaFatura;
	}
	/**
	 * Metodo: setDataDaFatura
	 * @param dataDaFatura the dataDaFatura to set
	 */
	public void setDataDaFatura(LocalDate dataDaFatura) {
		this.dataDaFatura = dataDaFatura;
	}
	/**
	 * Metodo: getVl_multa
	 * @return vl_multa
	 */
	public double getVl_multa() {
		return vl_multa;
	}
	/**
	 * Metodo: setVl_multa
	 * @param vl_multa the vl_multa to set
	 */
	public void setVl_multa(double vl_multa) {
		this.vl_multa = vl_multa;
	}
	/**
	 * Metodo: getStats
	 * @return stats
	 */
	public String getStats() {
		return stats;
	}
	/**
	 * Metodo: setStats
	 * @param stats the stats to set
	 */
	public void setStats(String stats) {
		this.stats = stats;
	}
	/**
	 * Metodo: getTp_fatura
	 * @return tp_fatura
	 */
	public String getTp_fatura() {
		return tp_fatura;
	}
	/**
	 * Metodo: setTp_fatura
	 * @param tp_fatura the tp_fatura to set
	 */
	public void setTp_fatura(String tp_fatura) {
		this.tp_fatura = tp_fatura;
	}
	/**
	 * Metodo: getId_ped_serv
	 * @return id_ped_serv
	 */
	public int getId_ped_serv() {
		return id_ped_serv;
	}
	/**
	 * Metodo: setId_ped_serv
	 * @param id_ped_serv the id_ped_serv to set
	 */
	public void setId_ped_serv(int id_ped_serv) {
		this.id_ped_serv = id_ped_serv;
	}
	public LocalDate getDt_paga() {
		return dt_paga;
	}
	public void setDt_paga(LocalDate dt_paga) {
		this.dt_paga = dt_paga;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDaFatura == null) ? 0 : dataDaFatura.hashCode());
		result = prime * result + idFatura;
		result = prime * result + id_ped_serv;
		result = prime * result + ((stats == null) ? 0 : stats.hashCode());
		result = prime * result + ((tp_fatura == null) ? 0 : tp_fatura.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vl_multa);
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
		Fatura other = (Fatura) obj;
		if (dataDaFatura == null) {
			if (other.dataDaFatura != null)
				return false;
		} else if (!dataDaFatura.equals(other.dataDaFatura))
			return false;
		if (idFatura != other.idFatura)
			return false;
		if (id_ped_serv != other.id_ped_serv)
			return false;
		if (stats == null) {
			if (other.stats != null)
				return false;
		} else if (!stats.equals(other.stats))
			return false;
		if (tp_fatura == null) {
			if (other.tp_fatura != null)
				return false;
		} else if (!tp_fatura.equals(other.tp_fatura))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		if (Double.doubleToLongBits(vl_multa) != Double.doubleToLongBits(other.vl_multa))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Fatura [idFatura=" + idFatura + ", valor=" + valor + ", dataDaFatura=" + dataDaFatura + ", vl_multa="
				+ vl_multa + ", stats=" + stats + ", tp_fatura=" + tp_fatura + ", id_ped_serv=" + id_ped_serv + "]";
	}
	
	
}
