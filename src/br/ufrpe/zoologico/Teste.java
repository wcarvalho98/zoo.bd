/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico;

import java.time.LocalDate;

import br.ufrpe.zoologico.DAO.DAOConsultas;
import br.ufrpe.zoologico.DAO.DAOJaula;
import br.ufrpe.zoologico.negocio.beans.Consulta;
import br.ufrpe.zoologico.negocio.beans.Jaula;

public class Teste {

	/** 
	 * Metodo: main
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		Consulta a = null;
		try {
			a = DAOConsultas.getInstance().buscar(9);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Consulta id: " + a.getId_consulta());
		System.out.println("Data da consulta: " + a.getData());
		System.out.println("Obs: " + a.getObs());
		System.out.println("Veterinario: " + a.getVeterinario().getCpf());
		System.out.println("Animal: " + a.getAnimal().getId());
		LocalDate day = LocalDate.of(2018, 01, 10);
		Jaula b = new Jaula(1,true,"Foo",day,10,"",1,10.2,12,13,1,"00011122233");
		
		try {
			DAOJaula.getInstance().inserir(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Jaula c = null;
		try {
			c = DAOJaula.getInstance().buscar(b.getId_jaula());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.print(c.toString());
	}

}
