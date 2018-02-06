/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.ufrpe.zoologico.DAO.DAOAnimal;
import br.ufrpe.zoologico.DAO.DAOConsultas;
import br.ufrpe.zoologico.DAO.DAOFatura;
import br.ufrpe.zoologico.DAO.DAOJaula;
import br.ufrpe.zoologico.DAO.DAOVeterinario;
import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.Consulta;
import br.ufrpe.zoologico.negocio.beans.Fatura;
import br.ufrpe.zoologico.negocio.beans.Jaula;
import br.ufrpe.zoologico.negocio.beans.Veterinario;

public class Teste {

	/** 
	 * Metodo: main
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		/*
		//Buscando uma consulta do banco
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
		
		//Inserindo uma nova consulta no banco
		Veterinario vet = null;
		Animal ani = null;
		Consulta cons = null;
		try {
			vet = DAOVeterinario.getInstance().buscar("01439264834");
			ani = DAOAnimal.getInstance().buscar(1);
			cons = new Consulta(vet, ani, 1, LocalDateTime.now(), "Tudo ok!");
			DAOConsultas.getInstance().inserir(cons);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//Inserindo uma nova jaula
		LocalDate day = LocalDate.of(2018, 01, 10);
		Jaula b = new Jaula(1,true,"Foo",day,10,"",1,10.2,12,13,1,"00011122233");
		try {
			DAOJaula.getInstance().inserir(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Fatura fat = new Fatura(0, 780, null, null, 0, null, "Débito", 0); //0 em ped_serv é o valor NULL
		try {
			DAOFatura.getInstance().inserir(fat);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}

}
