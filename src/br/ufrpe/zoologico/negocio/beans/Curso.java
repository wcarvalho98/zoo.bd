/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 17.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class Curso {
	private int id;
	private String desc;
	private int carga_hor;
	private String tipo;

	public Curso(String desc, int carga_horaria, String tipo) {
		this.desc = desc;
		this.carga_hor = carga_horaria;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getCarga_hor() {
		return carga_hor;
	}

	public void setCarga_hor(int carga_hor) {
		this.carga_hor = carga_hor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
