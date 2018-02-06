/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalTime;

public class Zoo {
	private int idZoo;  
    private String cnpj;  
    private String nome;  
    private String razao_social;  
    private LocalTime hr_inic_func;  
    private LocalTime hr_fim;
	
    
    /**
	 * @param idZoo
	 * @param cnpj
	 * @param nome
	 * @param razao_social
	 * @param hr_inic_func
	 * @param hr_fim
	 */
	public Zoo(int idZoo, String cnpj, String nome, String razao_social, LocalTime hr_inic_func, LocalTime hr_fim) {
		super();
		this.idZoo = idZoo;
		this.cnpj = cnpj;
		this.nome = nome;
		this.razao_social = razao_social;
		this.hr_inic_func = hr_inic_func;
		this.hr_fim = hr_fim;
	}
	
	public Zoo() {
		
	}
	/**
	 * Metodo: getIdZoo
	 * @return idZoo
	 */
	public Integer getIdZoo() {
		return idZoo;
	}
	/**
	 * Metodo: setIdZoo
	 * @param idZoo the idZoo to set
	 */
	public void setIdZoo(Integer idZoo) {
		this.idZoo = idZoo;
	}
	/**
	 * Metodo: getCnpj
	 * @return cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}
	/**
	 * Metodo: setCnpj
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	 * Metodo: getRazao_social
	 * @return razao_social
	 */
	public String getRazao_social() {
		return razao_social;
	}
	/**
	 * Metodo: setRazao_social
	 * @param razao_social the razao_social to set
	 */
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	/**
	 * Metodo: getHr_inic_func
	 * @return hr_inic_func
	 */
	public LocalTime getHr_inic_func() {
		return hr_inic_func;
	}
	/**
	 * Metodo: setHr_inic_func
	 * @param hr_inic_func the hr_inic_func to set
	 */
	public void setHr_inic_func(LocalTime hr_inic_func) {
		this.hr_inic_func = hr_inic_func;
	}
	/**
	 * Metodo: getHr_fim
	 * @return hr_fim
	 */
	public LocalTime getHr_fim() {
		return hr_fim;
	}
	/**
	 * Metodo: setHr_fim
	 * @param hr_fim the hr_fim to set
	 */
	public void setHr_fim(LocalTime hr_fim) {
		this.hr_fim = hr_fim;
	}
	@Override
	public String toString() {
		return "Zoo [idZoo=" + idZoo + ", cnpj=" + cnpj + ", nome=" + nome + ", razao_social=" + razao_social
				+ ", hr_inic_func=" + hr_inic_func + ", hr_fim=" + hr_fim + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + idZoo;
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
		Zoo other = (Zoo) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (idZoo != other.idZoo)
			return false;
		return true;
	} 
	
	
}
