/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Zoo;

public class DAOZoo extends DAO<Zoo>{

	@Override
	public void inserir(Zoo o) throws Exception {
		String sql =  "INSERT INTO Zoologico (`cnpj`, `nome`, `razao_social`, `hr_inic_func`, `hr_fim`) VALUES (?, ?, ?, ?,?)";
		preparar(sql);
		getStmt().setString(1, o.getCnpj());
		getStmt().setString(2, o.getNome());
		getStmt().setString(3, o.getRazao_social());
		getStmt().setTime(4, Time.valueOf(o.getHr_inic_func()));
		getStmt().setTime(5, Time.valueOf(o.getHr_fim()));
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
	public void remover(Zoo o) throws Exception {
		String sql = "DELETE FROM Zoologico WHERE `idZoo` = ?";
		preparar(sql);
		getStmt().setInt(1, o.getIdZoo());
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
	public void alterar(Zoo o) throws Exception {
		String sql = "UPDATE zoologico SET `cnpj` = ?, `nome` = ?, `razao_social` = ?, `hr_inic_func` = ?, `hr_fim` = ? WHERE `idZoo` = ?";
		preparar(sql);
		getStmt().setString(1, o.getCnpj());
		getStmt().setString(2, o.getNome());
		getStmt().setString(3, o.getRazao_social());
		getStmt().setTime(4, Time.valueOf(o.getHr_inic_func()));
		getStmt().setTime(5, Time.valueOf(o.getHr_fim()));
		getStmt().setInt(6, o.getIdZoo());
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
	
	public Zoo buscar(int id) throws Exception{
		String sql = "SELECT * FROM Zoologico WHERE `idZoo` = ?";
		preparar(sql);
		getStmt().setInt(1, id);
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
		Zoo j = new Zoo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTime(5).toLocalTime(),
			rs.getTime(6).toLocalTime());
		rs.close();
		fecharStmt();
		return j;
		
		
	}

	@Override
	public ArrayList<Zoo> listarTodos() throws Exception {
		String sql = "SELECT * FROM Zoologico";
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
		ArrayList<Zoo> list = new ArrayList<Zoo>();
		while (rs.next()) {
			Zoo o = new Zoo(rs.getInt(1), rs.getString(2) ,rs.getString(3), 
					rs.getString(4), rs.getTime(5).toLocalTime(), rs.getTime(6).toLocalTime());
			list.add(o);
		}
		rs.close();
		fecharStmt();
		return list;
	}

}
