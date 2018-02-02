/** 
 * @author henrique
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 29.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.ufrpe.zoologico.negocio.beans.Instituicao;

public class DAOInstituicoes extends DAO<Instituicao> {

	@Override
	public void inserir(Instituicao o) throws Exception {
		String sql = "INSERT INTO Instituicao (`cnpj`, `nome_contato`, `email`, `telefone_1`, "
				+ "`telefone_2`, `razao_social`, `tipo_instituicao`) VALUES (?, ?, ?, ?, ?, ?, ?)";
		preparar(sql);
		getStmt().setString(1, o.getCnpj());
		getStmt().setString(2, o.getNome_contato());
		getStmt().setString(3, o.getEmail());
		getStmt().setString(4, o.getTelefone1());
		getStmt().setString(5, o.getTelefone2());
		getStmt().setString(6, o.getRazao_social());
		getStmt().setString(7, o.getTipo_instituicao());
		try {
			getStmt().execute();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			e.printStackTrace();
		} finally {
			fecharStmt();
		}
	}

	@Override
	public void remover(Instituicao o) throws Exception {
		String sql = "delete from `Instituicao` where `cnpj` = ?";
		preparar(sql);
		getStmt().setString(1, o.getCnpj());
		try {
			getStmt().execute();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			e.printStackTrace();
		} finally {
			fecharStmt();
		}

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
		try {
			getStmt().execute();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			e.printStackTrace();
		} finally {
			fecharStmt();
		}
	}

	public Instituicao buscar(String cnpj) throws Exception {
		String sql = "SELECT * FROM Instituicao WHERE `cnpj` = ?";
		preparar(sql);
		getStmt().setString(1, cnpj);
		ResultSet rs = null;
		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			fecharStmt();
			e.printStackTrace();
		}
		rs.next();
		Instituicao o = new Instituicao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getString(6), rs.getString(7));
		rs.close();
		fecharStmt();
		return o;
	}

	@Override
	public ArrayList<Instituicao> listarTodos() throws Exception {
		String sql = "SELECT * FROM `Instituicao`";
		preparar(sql);
		ResultSet rs;
		rs= null;
		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			fecharStmt();
			e.printStackTrace();
		}
		ArrayList<Instituicao> listaDeInstituicoes = new ArrayList<Instituicao>();
		while (rs.next()) {
			Instituicao a = new Instituicao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7));
			listaDeInstituicoes.add(a);
		}
		fecharStmt();
		return listaDeInstituicoes;

	}

}
