/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 17.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class PedidoServico {
	private int id;
	private boolean status_pedido;
	private LocalDate dt_excurcao;
	private double vl_total;
	private LocalDate dt_pedido;
	private int idZoo;
	/**
	 * @param id
	 * @param status_pedido
	 * @param dt_excurcao
	 * @param vl_total
	 * @param dt_pedido
	 * @param idZoo
	 */
	public PedidoServico(int id, boolean status_pedido, LocalDate dt_excurcao, double vl_total, LocalDate dt_pedido,
			int idZoo) {
		super();
		this.id = id;
		this.status_pedido = status_pedido;
		this.dt_excurcao = dt_excurcao;
		this.vl_total = vl_total;
		this.dt_pedido = dt_pedido;
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
	 * Metodo: isStatus_pedido
	 * @return status_pedido
	 */
	public boolean isStatus_pedido() {
		return status_pedido;
	}
	/**
	 * Metodo: setStatus_pedido
	 * @param status_pedido the status_pedido to set
	 */
	public void setStatus_pedido(boolean status_pedido) {
		this.status_pedido = status_pedido;
	}
	/**
	 * Metodo: getDt_excurcao
	 * @return dt_excurcao
	 */
	public LocalDate getDt_excurcao() {
		return dt_excurcao;
	}
	/**
	 * Metodo: setDt_excurcao
	 * @param dt_excurcao the dt_excurcao to set
	 */
	public void setDt_excurcao(LocalDate dt_excurcao) {
		this.dt_excurcao = dt_excurcao;
	}
	/**
	 * Metodo: getVl_total
	 * @return vl_total
	 */
	public double getVl_total() {
		return vl_total;
	}
	/**
	 * Metodo: setVl_total
	 * @param vl_total the vl_total to set
	 */
	public void setVl_total(double vl_total) {
		this.vl_total = vl_total;
	}
	/**
	 * Metodo: getDt_pedido
	 * @return dt_pedido
	 */
	public LocalDate getDt_pedido() {
		return dt_pedido;
	}
	/**
	 * Metodo: setDt_pedido
	 * @param dt_pedido the dt_pedido to set
	 */
	public void setDt_pedido(LocalDate dt_pedido) {
		this.dt_pedido = dt_pedido;
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
		PedidoServico other = (PedidoServico) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PedidoServico [id=" + id + ", status_pedido=" + status_pedido + ", dt_excurcao=" + dt_excurcao
				+ ", vl_total=" + vl_total + ", dt_pedido=" + dt_pedido + ", idZoo=" + idZoo + "]";
	}
	
	
}
