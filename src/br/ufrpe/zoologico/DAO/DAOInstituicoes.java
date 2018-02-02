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
		String sql = "INSERT INTO Instituicao (`cnpj`, `nome_contato`, `email`, `telefone_1`, `telefone_2`, `razao_social`, `tipo_instituicao`) VALUES (?, ?, ?, ?, ?, ?, ?)";
		preparar(sql);
		getStmt().setString(1, o.getCnpj());
		getStmt().setString(2, o.getNome_contato());
		getStmt().setString(3, o.getEmail());
		getStmt().setString(4, o.getTelefone1());
		getStmt().setString(5, o.getTelefone2());
		getStmt().setString(6, o.getRazao_social());
		getStmt().setString(7, o.getTipo_instituicao());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void remover(Instituicao o) throws Exception {
		String sql = "delete from `Instituicao` where `cnpj` = ?";
		preparar(sql);
		getStmt().setString(1, o.getCnpj());
		getStmt().execute();
		fecharStmt();
		fechar();

	}

	@Override
	public void alterar(Instituicao o) throws Exception {
		String sql = "update `instituicao` set `telefone_1` = ?, `telefone_2` = ?, `razao_social` = ?, `nome_contato` = ?, `email` = ? where `cnpj` = ?";
		preparar(sql);
		getStmt().setString(1, o.getTelefone1());
		getStmt().setString(2, o.getTelefone2());
		getStmt().setString(3, o.getRazao_social());
		getStmt().setString(4, o.getNome_contato());
		getStmt().setString(5, o.getEmail());
		getStmt().setString(6, o.getCnpj());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	public Instituicao buscar(String cnpj) throws Exception {
		String sql = "SELECT * FROM Instituicao WHERE `cnpj` = ?";
		preparar(sql);
		getStmt().setString(1, cnpj);
		ResultSet rs = getStmt().executeQuery();
		rs.next();
		Instituicao o = new Instituicao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getString(6), rs.getString(7));
		rs.close();
		fecharStmt();
		fechar();
		return o;
	}

	@Override
	public ArrayList<Instituicao> listarTodos() throws Exception {
		String sql = "SELECT * FROM `Instituicao`";
		preparar(sql);
		ResultSet rst;
		rst = getStmt().executeQuery();
		ArrayList<Instituicao> listaDeInstituicoes = new ArrayList<Instituicao>();
		while (rst.next()) {
			Instituicao a = new Instituicao(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),
					rst.getString(5), rst.getString(6), rst.getString(7));
			listaDeInstituicoes.add(a);
		}
		fecharStmt();
		fechar();
		return listaDeInstituicoes;

	}

}
