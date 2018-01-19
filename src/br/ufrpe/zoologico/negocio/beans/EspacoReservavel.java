/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;



public class EspacoReservavel {
	private int id;
	private double dimensao_area;
	private int capacidade;
	private String tipo;
	private String nome;
	private int idZoo;
	/**
	 * @param id
	 * @param dimensao_area
	 * @param capacidade
	 * @param tipo
	 * @param nome
	 * @param idZoo
	 */
	public EspacoReservavel(int id, double dimensao_area, int capacidade, String tipo, String nome, int idZoo) {
		super();
		this.id = id;
		this.dimensao_area = dimensao_area;
		this.capacidade = capacidade;
		this.tipo = tipo;
		this.nome = nome;
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
	 * Metodo: getDimensao_area
	 * @return dimensao_area
	 */
	public double getDimensao_area() {
		return dimensao_area;
	}
	/**
	 * Metodo: setDimensao_area
	 * @param dimensao_area the dimensao_area to set
	 */
	public void setDimensao_area(double dimensao_area) {
		this.dimensao_area = dimensao_area;
	}
	/**
	 * Metodo: getCapacidade
	 * @return capacidade
	 */
	public int getCapacidade() {
		return capacidade;
	}
	/**
	 * Metodo: setCapacidade
	 * @param capacidade the capacidade to set
	 */
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	/**
	 * Metodo: getTipo
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * Metodo: setTipo
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * Metodo: getNome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Metodo: setNome
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
	public String toString() {
		return "EspacoReservavel [id=" + id + ", dimensao_area=" + dimensao_area + ", capacidade=" + capacidade
				+ ", tipo=" + tipo + ", nome=" + nome + ", idZoo=" + idZoo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacidade;
		long temp;
		temp = Double.doubleToLongBits(dimensao_area);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + idZoo;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		EspacoReservavel other = (EspacoReservavel) obj;
		if (capacidade != other.capacidade)
			return false;
		if (Double.doubleToLongBits(dimensao_area) != Double.doubleToLongBits(other.dimensao_area))
			return false;
		if (id != other.id)
			return false;
		if (idZoo != other.idZoo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	
}
