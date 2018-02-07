/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.ufrpe.zoologico.negocio.beans.Funcionario;

public class DAOFuncionario extends DAO<Funcionario> {

	@Override
	public void inserir(Funcionario o) throws Exception {
		String sql = "INSERT INTO `funcionario` (`CPF`,`Nome`,`especializacao`,`fone_1`,`fone_2`,`data_de_contratacao`,"
				+ "`salario`,`ender`,`jornada_trabalho`,`idZoo`) VALUES " + "(?,?,?,?,?,?,?,?,?,?)";
		preparar(sql);
		getStmt().setString(1, o.getCpf());
		getStmt().setString(2, o.getNome());
		getStmt().setString(3, o.getEspecializacao());
		getStmt().setString(4, o.getFone_1());
		getStmt().setString(5, o.getFone_2());
		getStmt().setDate(6, Date.valueOf(o.getData_de_contratacao()));
		getStmt().setDouble(7, o.getSalario());
		getStmt().setString(8, o.getEndereco());
		getStmt().setInt(9, o.getJornada_trabalho());
		getStmt().setInt(10, o.getId_zoo());
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
	public void remover(Funcionario o) throws Exception {
		String sql = "DELETE FROM funcionario WHERE `CPF` = ?";
		preparar(sql);
		getStmt().setString(1, o.getCpf());
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
	public void alterar(Funcionario o) throws Exception {
		String sql = "UPDATE `funcionario` SET `Nome` = ?,`especializacao` = ?,`fone_1` = ?,"
				+ "`fone_2` = ?,`data_de_contratacao` = ?,"
				+ "`salario` = ?,`ender` = ?,`jornada_trabalho` = ?,`idZoo` = ? " + "WHERE `CPF` = ?";
		preparar(sql);
		getStmt().setString(1, o.getNome());
		getStmt().setString(2, o.getEspecializacao());
		getStmt().setString(3, o.getFone_1());
		getStmt().setString(4, o.getFone_2());
		getStmt().setDate(5, Date.valueOf(o.getData_de_contratacao()));
		getStmt().setDouble(6, o.getSalario());
		getStmt().setString(7, o.getEndereco());
		getStmt().setInt(8, o.getJornada_trabalho());
		getStmt().setInt(9, o.getId_zoo());
		getStmt().setString(10, o.getCpf());
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

	public Funcionario buscar(String cpf) throws Exception {
		String sql = "SELECT * FROM `funcionario` WHERE `CPF` = ?";
		preparar(sql);
		getStmt().setString(1, cpf);
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
		Funcionario o = new Funcionario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDouble(7), rs.getString(8), rs.getInt(9),
				rs.getInt(10));
		rs.close();
		fecharStmt();
		return o;
	}

	@Override
	public ArrayList<Funcionario> listarTodos() throws Exception {
		ArrayList<Funcionario> r = new ArrayList<Funcionario>();
		String sql = "SELECT * FROM `funcionario`";
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
		while (rs.next()) {
			Funcionario o = new Funcionario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDouble(7), rs.getString(8), rs.getInt(9),
					rs.getInt(10));
			r.add(o);
		}
		rs.close();
		fecharStmt();
		return r;

	}

}
