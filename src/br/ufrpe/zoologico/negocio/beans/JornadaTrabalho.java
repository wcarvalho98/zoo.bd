/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class JornadaTrabalho {
	private int id;
	private String desc;
	private boolean trabalha_sabado;
	
	public JornadaTrabalho(String desc, boolean trabalha_sabado){
		this.desc = desc;
		this.trabalha_sabado = trabalha_sabado;
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

	public boolean isTrabalha_sabado() {
		return trabalha_sabado;
	}

	public void setTrabalha_sabado(boolean trabalha_sabado) {
		this.trabalha_sabado = trabalha_sabado;
	}
	
}
