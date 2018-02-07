/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class Secretario extends Funcionario {
	public Secretario(String cpf, String nome, String fone1, String fone2, String especializacao,
			LocalDate data_de_contratacao, double salario, String endereco, int jornada_trabalho, int id_zoo) {
		super(cpf, nome, fone1, fone2, especializacao, data_de_contratacao, salario, endereco, jornada_trabalho,
				id_zoo);
	}
}
