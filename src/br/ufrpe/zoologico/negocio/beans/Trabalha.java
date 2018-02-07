/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class Trabalha {
	private int idBilheteria;
	private String cpf_secretario;
	private LocalDate data_trab;

	/**
	 * @param idBilheteria
	 * @param cpf_secretario
	 * @param data_trab
	 */
	public Trabalha(int idBilheteria, String cpf_secretario, LocalDate data_trab) {
		super();
		this.idBilheteria = idBilheteria;
		this.cpf_secretario = cpf_secretario;
		this.data_trab = data_trab;
	}

	/**
	 * Metodo: getIdBilheteria
	 * 
	 * @return idBilheteria
	 */
	public int getIdBilheteria() {
		return idBilheteria;
	}

	/**
	 * Metodo: setIdBilheteria
	 * 
	 * @param idBilheteria
	 *            the idBilheteria to set
	 */
	public void setIdBilheteria(int idBilheteria) {
		this.idBilheteria = idBilheteria;
	}

	/**
	 * Metodo: getCpf_secretario
	 * 
	 * @return cpf_secretario
	 */
	public String getCpf_secretario() {
		return cpf_secretario;
	}

	/**
	 * Metodo: setCpf_secretario
	 * 
	 * @param cpf_secretario
	 *            the cpf_secretario to set
	 */
	public void setCpf_secretario(String cpf_secretario) {
		this.cpf_secretario = cpf_secretario;
	}

	/**
	 * Metodo: getData_trab
	 * 
	 * @return data_trab
	 */
	public LocalDate getData_trab() {
		return data_trab;
	}

	/**
	 * Metodo: setData_trab
	 * 
	 * @param data_trab
	 *            the data_trab to set
	 */
	public void setData_trab(LocalDate data_trab) {
		this.data_trab = data_trab;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf_secretario == null) ? 0 : cpf_secretario.hashCode());
		result = prime * result + ((data_trab == null) ? 0 : data_trab.hashCode());
		result = prime * result + idBilheteria;
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
		Trabalha other = (Trabalha) obj;
		if (cpf_secretario == null) {
			if (other.cpf_secretario != null)
				return false;
		} else if (!cpf_secretario.equals(other.cpf_secretario))
			return false;
		if (data_trab == null) {
			if (other.data_trab != null)
				return false;
		} else if (!data_trab.equals(other.data_trab))
			return false;
		if (idBilheteria != other.idBilheteria)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trabalha [idBilheteria=" + idBilheteria + ", cpf_secretario=" + cpf_secretario + ", data_trab="
				+ data_trab + "]";
	}

}
