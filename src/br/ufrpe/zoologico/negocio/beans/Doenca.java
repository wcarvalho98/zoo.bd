/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Doenca {
	
	private String id_doenca;
	private String descricao;
	
	
	public Doenca(String id_doenca, String descricao){
		this.setId_doenca(id_doenca);
		this.setDescricao(descricao);
	}


	public String getId_doenca() {
		return id_doenca;
	}


	public void setId_doenca(String id_doenca) {
		this.id_doenca = id_doenca;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
