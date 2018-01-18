/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDateTime;

public class Sintoma {
	private int idZoo;  
    private String cnpj;  
    private String nome;  
    private String razao_social;  
    private LocalDateTime hr_inic_func;  
    private LocalDateTime hr_fim;
	
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
	public LocalDateTime getHr_inic_func() {
		return hr_inic_func;
	}
	/**
	 * Metodo: setHr_inic_func
	 * @param hr_inic_func the hr_inic_func to set
	 */
	public void setHr_inic_func(LocalDateTime hr_inic_func) {
		this.hr_inic_func = hr_inic_func;
	}
	/**
	 * Metodo: getHr_fim
	 * @return hr_fim
	 */
	public LocalDateTime getHr_fim() {
		return hr_fim;
	}
	/**
	 * Metodo: setHr_fim
	 * @param hr_fim the hr_fim to set
	 */
	public void setHr_fim(LocalDateTime hr_fim) {
		this.hr_fim = hr_fim;
	} 
	
	public boolean equals(Object o){
		boolean res = false;
		if(o != null && o.getClass() == this.getClass()){
			if(this.getIdZoo().equals(((Sintoma) o).getIdZoo())){
				res = true;
			}
		}
		return res;
	}
}
