/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.gerenciamento - Versao 1.0 - 2017.2
 * TODO 02.02.2018 
 */
package br.ufrpe.zoologico.negocio.gerenciamento;

import br.ufrpe.zoologico.DAO.DAODiagnostico;
import br.ufrpe.zoologico.negocio.beans.Diagnostico;

public class GerenciamentoDiagnostico {

	private DAODiagnostico diagnostico;

	public GerenciamentoDiagnostico() {
		this.diagnostico = new DAODiagnostico();
	}

	public void inserir(Diagnostico o) throws Exception {
		diagnostico.inserir(o);
	}

	public void remover(Diagnostico o) throws Exception {
		diagnostico.remover(o);
	}

	public void remover(int id_consulta) throws Exception {
		diagnostico.remover(id_consulta);
	}

	public void remover(String id_doenca) throws Exception {
		diagnostico.remover(id_doenca);
	}

	public void alterar(Diagnostico o) throws Exception {
		diagnostico.alterar(o);
	}

}
