/** 
 * @author henrique
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 29.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Instituicao;

public class DAOInstituicoes extends DAO<Instituicao> {

	@Override
	public void inserir(Instituicao o) throws Exception {
		String sql = "INSERT INTO Instituicao VALUES (" + o.getCnpj() + ", '" + o.getNome_contato() + ", '"
				+ o.getTelefone1() + ", '" + o.getTelefone2() + ", '" + o.getRazao_social() + ", '"
				+ o.getTipo_instituicao() + "')";
		getComando().executeQuery(sql);
	}

	@Override
	public void remover(Instituicao o) throws Exception {
		String sql = "delete from Instituicao where cnpj = '" + o.getCnpj() + "'";
		getComando().executeQuery(sql);
		}

	@Override
	public void alterar(Instituicao o) throws Exception {
		// String sql = "";
	}

	@Override
	public ArrayList<Instituicao> listarTodos() throws Exception {
		String sql = "select * from Instituicao";
		ResultSet rst;
		rst = getComando().executeQuery(sql);
		ArrayList<Instituicao> listaDeInstituicoes = new ArrayList<Instituicao>();
		while(rst.next()) {
			Instituicao a = new Instituicao(rst.getString("cnpj"), rst.getString("nome_contato"), rst.getString("email"), rst.getString("telefone_1"), rst.getString("telefone_2"), rst.getString("razao_social"), rst.getString("tipo_instituicao"));
			listaDeInstituicoes.add(a);
		}
		return listaDeInstituicoes;
		
	}

}
