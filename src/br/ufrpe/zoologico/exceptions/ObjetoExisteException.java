/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.exceptions - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.exceptions;

@SuppressWarnings("serial")
public class ObjetoExisteException extends Exception {
	/**
	 * @param message
	 */
	public ObjetoExisteException(String message) {
		super(message);
	}
}
