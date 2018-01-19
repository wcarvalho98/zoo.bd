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
	
	public Veterinario(String cpf, String nome, String fone1, String fone2, String especializacao,
			LocalDate data_de_contratacao, double salario, String endereco, String crmv){
		super(cpf, nome, fone1, fone2, especializacao, data_de_contratacao, salario, endereco);
		this.crmv = crmv;
	}

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}
	
	
}
