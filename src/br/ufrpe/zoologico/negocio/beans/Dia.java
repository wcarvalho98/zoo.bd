/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Dia {
	private String fone;
	private int idZoo;
	
	public Dia(String fone, int idZoo){
		this.setFone(fone);
		this.setIdZoo(idZoo);
	}
	
	/**
	 * Metodo: getFone
	 * @return fone
	 */
	public String getFone() {
		return fone;
	}
	/**
	 * Metodo: setFone
	 * @param fone the fone to set
	 */
	public void setFone(String fone) {
		this.fone = fone;
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
	
}
