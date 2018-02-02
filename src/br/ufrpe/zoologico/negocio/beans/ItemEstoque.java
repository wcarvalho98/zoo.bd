/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class ItemEstoque {
	private int cod_prod_ref;
	private int qtd;
	private LocalDate data_entrada;
	private double vl_compra;
	private LocalDate data_validade;
	private String animal_consome;
	private int idEstoque;
	/**
	 * @param cod_prod_ref
	 * @param qtd
	 * @param data_entrada
	 * @param vl_compra
	 * @param data_validade
	 * @param animal_consome
	 */
	public ItemEstoque(int cod_prod_ref, int idEstoque, int qtd, LocalDate data_entrada, double vl_compra, LocalDate data_validade,
			String animal_consome) {
		super();
		this.cod_prod_ref = cod_prod_ref;
		this.qtd = qtd;
		this.data_entrada = data_entrada;
		this.vl_compra = vl_compra;
		this.data_validade = data_validade;
		this.animal_consome = animal_consome;
		this.idEstoque = idEstoque;
	}
	/**
	 * Metodo: getCod_prod_ref
	 * @return cod_prod_ref
	 */
	public int getCod_prod_ref() {
		return cod_prod_ref;
	}
	/**
	 * Metodo: setCod_prod_ref
	 * @param cod_prod_ref the cod_prod_ref to set
	 */
	public void setCod_prod_ref(int cod_prod_ref) {
		this.cod_prod_ref = cod_prod_ref;
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
	 * Metodo: getData_entrada
	 * @return data_entrada
	 */
	public LocalDate getData_entrada() {
		return data_entrada;
	}
	/**
	 * Metodo: setData_entrada
	 * @param data_entrada the data_entrada to set
	 */
	public void setData_entrada(LocalDate data_entrada) {
		this.data_entrada = data_entrada;
	}
	/**
	 * Metodo: getVl_compra
	 * @return vl_compra
	 */
	public double getVl_compra() {
		return vl_compra;
	}
	/**
	 * Metodo: setVl_compra
	 * @param vl_compra the vl_compra to set
	 */
	public void setVl_compra(double vl_compra) {
		this.vl_compra = vl_compra;
	}
	/**
	 * Metodo: getData_validade
	 * @return data_validade
	 */
	public LocalDate getData_validade() {
		return data_validade;
	}
	/**
	 * Metodo: setData_validade
	 * @param data_validade the data_validade to set
	 */
	public void setData_validade(LocalDate data_validade) {
		this.data_validade = data_validade;
	}
	/**
	 * Metodo: getAnimal_consome
	 * @return animal_consome
	 */
	public String getAnimal_consome() {
		return animal_consome;
	}
	/**
	 * Metodo: setAnimal_consome
	 * @param animal_consome the animal_consome to set
	 */
	public void setAnimal_consome(String animal_consome) {
		this.animal_consome = animal_consome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animal_consome == null) ? 0 : animal_consome.hashCode());
		result = prime * result + cod_prod_ref;
		result = prime * result + ((data_entrada == null) ? 0 : data_entrada.hashCode());
		result = prime * result + ((data_validade == null) ? 0 : data_validade.hashCode());
		result = prime * result + qtd;
		long temp;
		temp = Double.doubleToLongBits(vl_compra);
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
		ItemEstoque other = (ItemEstoque) obj;
		if (animal_consome == null) {
			if (other.animal_consome != null)
				return false;
		} else if (!animal_consome.equals(other.animal_consome))
			return false;
		if (cod_prod_ref != other.cod_prod_ref)
			return false;
		if (data_entrada == null) {
			if (other.data_entrada != null)
				return false;
		} else if (!data_entrada.equals(other.data_entrada))
			return false;
		if (data_validade == null) {
			if (other.data_validade != null)
				return false;
		} else if (!data_validade.equals(other.data_validade))
			return false;
		if (qtd != other.qtd)
			return false;
		if (Double.doubleToLongBits(vl_compra) != Double.doubleToLongBits(other.vl_compra))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ItemEstoque [cod_prod_ref=" + cod_prod_ref + ", qtd=" + qtd + ", data_entrada=" + data_entrada
				+ ", vl_compra=" + vl_compra + ", data_validade=" + data_validade + ", animal_consome=" + animal_consome
				+ "]";
	}
	/**
	 * Metodo: getIdEstoque
	 * @return idEstoque
	 */
	public int getIdEstoque() {
		return idEstoque;
	}
	/**
	 * Metodo: setIdEstoque
	 * @param idEstoque the idEstoque to set
	 */
	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}
	
	
}
