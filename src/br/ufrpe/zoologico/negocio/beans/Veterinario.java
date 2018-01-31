/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class Veterinario extends Funcionario{
	
	private String crmv;
	private String estado;
	
	public Veterinario(String cpf, String nome, String fone1, String fone2, String especializacao, LocalDate data_de_contratacao,
			double salario, String endereco, int jornada_trabalho, int id_zoo, String crmv, String estado){
		super(cpf, nome, fone1, fone2, especializacao, data_de_contratacao, salario, endereco, jornada_trabalho, id_zoo);
		this.crmv = crmv;
		this.setEstado(estado);
	}

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
