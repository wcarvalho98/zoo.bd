/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico;

import br.ufrpe.zoologico.DAO.DAOConsultas;
import br.ufrpe.zoologico.negocio.beans.Consulta;

public class Teste {

	/** 
	 * Metodo: main
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		Consulta a = null;
		try {
			a = DAOConsultas.getInstance().buscar(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Consulta id: " + a.getId_consulta());
		System.out.println("Data da consulta: " + a.getData());
		System.out.println("Obs: " + a.getObs());
		System.out.println("Veterinario: " + a.getVeterinario().getCpf());
		System.out.println("Animal: " + a.getAnimal().getId());
	}

}
