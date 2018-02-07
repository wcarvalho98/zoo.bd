/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 29.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Administrador;

public class DAOAdmin extends DAO<Administrador> {

	@Override
	public void inserir(Administrador o) throws Exception {
		String sql = "INSERT INTO administrador (`cpf`, `senha_de_acesso`, `idZoo`, `login`) VALUES (?, ?, ?, ?)";
		preparar(sql);
		getStmt().setString(1, o.getCpf());
		getStmt().setString(2, o.getSenha_de_acesso());
		getStmt().setInt(3, o.getIdZoo());
		getStmt().setString(4, o.getLogin());
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
	public void remover(Administrador o) throws Exception {
		String sql = "DELETE FROM administrador WHERE `idZoo` = ? , `cpf` = ?";
		preparar(sql);
		getStmt().setInt(1, o.getIdZoo());
		getStmt().setString(2, o.getCpf());
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
	public void alterar(Administrador o) throws Exception {
		String sql = "UPDATE administrador SET `senha_de_acesso` = ?, `login` = ?, `idZoo` = ? WHERE `cpf` = ?";
		preparar(sql);
		getStmt().setString(1, o.getSenha_de_acesso());
		getStmt().setString(2, o.getLogin());
		getStmt().setInt(3, o.getIdZoo());
		getStmt().setString(4, o.getCpf());
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

	public Administrador buscar(String login) throws Exception {
		String sql = "SELECT * FROM administrador WHERE `login` = ?";
		preparar(sql);
		getStmt().setString(1, login);
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
		Administrador o = new Administrador(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
		rs.close();
		fecharStmt();
		return o;
	}

	public Administrador buscar(int idZoo, String cpf) throws Exception {
		String sql = "SELECT * FROM administrador WHERE `idZoo` = ?, `cpf` = ?";
		preparar(sql);
		getStmt().setInt(1, idZoo);
		getStmt().setString(2, cpf);
		ResultSet rs = null;
		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			fecharStmt();
			e.printStackTrace();
		}
		Administrador o = new Administrador(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
		rs.close();
		fecharStmt();
		return o;
	}

	@Override
	public ArrayList<Administrador> listarTodos() throws Exception {
		String sql = "SELECT * FROM administrador;";
		preparar(sql);
		ResultSet rs = null;
		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			fecharStmt();
			e.printStackTrace();
		}
		ArrayList<Administrador> list = new ArrayList<Administrador>();
		while (rs.next()) {
			Administrador o = new Administrador(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			list.add(o);
		}
		rs.close();
		fecharStmt();
		return list;
	}

}
