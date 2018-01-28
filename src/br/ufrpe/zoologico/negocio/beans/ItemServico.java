/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class ItemServico {
	private int idPed;
	private int idServ;
	private int qtd;
	private double vl_unitario;
	private boolean status_item;
	private LocalDate dtRealiazcao;
	/**
	 * @param idPed
	 * @param idServ
	 * @param qtd
	 * @param vl_unitario
	 * @param status_item
	 * @param dtRealiazcao
	 */
	public ItemServico(int idPed, int idServ, int qtd, double vl_unitario, boolean status_item,
			LocalDate dtRealiazcao) {
		super();
		this.idPed = idPed;
		this.idServ = idServ;
		this.qtd = qtd;
		this.vl_unitario = vl_unitario;
		this.status_item = status_item;
		this.dtRealiazcao = dtRealiazcao;
	}
	/**
	 * Metodo: getIdPed
	 * @return idPed
	 */
	public int getIdPed() {
		return idPed;
	}
	/**
	 * Metodo: setIdPed
	 * @param idPed the idPed to set
	 */
	public void setIdPed(int idPed) {
		this.idPed = idPed;
	}
	/**
	 * Metodo: getIdServ
	 * @return idServ
	 */
	public int getIdServ() {
		return idServ;
	}
	/**
	 * Metodo: setIdServ
	 * @param idServ the idServ to set
	 */
	public void setIdServ(int idServ) {
		this.idServ = idServ;
	}
	/**
	 * Metodo: getQtd
	 * @return qtd
	 */
	public int getQtd() {
		return qtd;
	}
	/**
	 * Metodo: setQtd
	 * @param qtd the qtd to set
	 */
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	/**
	 * Metodo: getVl_unitario
	 * @return vl_unitario
	 */
	public double getVl_unitario() {
		return vl_unitario;
	}
	/**
	 * Metodo: setVl_unitario
	 * @param vl_unitario the vl_unitario to set
	 */
	public void setVl_unitario(double vl_unitario) {
		this.vl_unitario = vl_unitario;
	}
	/**
	 * Metodo: isStatus_item
	 * @return status_item
	 */
	public boolean isStatus_item() {
		return status_item;
	}
	/**
	 * Metodo: setStatus_item
	 * @param status_item the status_item to set
	 */
	public void setStatus_item(boolean status_item) {
		this.status_item = status_item;
	}
	/**
	 * Metodo: getDtRealiazcao
	 * @return dtRealiazcao
	 */
	public LocalDate getDtRealiazcao() {
		return dtRealiazcao;
	}
	/**
	 * Metodo: setDtRealiazcao
	 * @param dtRealiazcao the dtRealiazcao to set
	 */
	public void setDtRealiazcao(LocalDate dtRealiazcao) {
		this.dtRealiazcao = dtRealiazcao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPed;
		result = prime * result + idServ;
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
		ItemServico other = (ItemServico) obj;
		if (idPed != other.idPed)
			return false;
		if (idServ != other.idServ)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ItemServico [idPed=" + idPed + ", idServ=" + idServ + ", qtd=" + qtd + ", vl_unitario=" + vl_unitario
				+ ", status_item=" + status_item + ", dtRealiazcao=" + dtRealiazcao + "]";
	}
	
	
}
