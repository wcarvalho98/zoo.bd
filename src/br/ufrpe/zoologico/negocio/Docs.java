/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio;

public class Docs {
	private int idZoo;
	private String arq;
	private int idDoc;
	
	
	public Docs(int idZoo, String arq, int idDoc){
		this.setIdZoo(idZoo);
		this.setArq(arq);
		this.setIdDoc(idDoc);
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
	/**
	 * Metodo: getArq
	 * @return arq
	 */
	public String getArq() {
		return arq;
	}
	/**
	 * Metodo: setArq
	 * @param arq the arq to set
	 */
	public void setArq(String arq) {
		this.arq = arq;
	}
	/**
	 * Metodo: getIdDoc
	 * @return idDoc
	 */
	public int getIdDoc() {
		return idDoc;
	}
	/**
	 * Metodo: setIdDoc
	 * @param idDoc the idDoc to set
	 */
	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
	}
}
