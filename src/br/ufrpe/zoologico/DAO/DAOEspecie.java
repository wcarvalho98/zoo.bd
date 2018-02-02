/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 01.02.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Especie;

public class DAOEspecie extends DAO<Especie> {

	@Override
	public void inserir(Especie o) throws Exception {
		String sql = "INSERT INTO especie (`nome`, `genero`) VALUES (?,?)";
		preparar(sql);
		getStmt().setString(1, o.getNome());
		getStmt().setInt(2, o.getGenero());
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
	public void remover(Especie o) throws Exception {
		String sql = "DELETE FROM especie WHERE `seq` = ?";
		preparar(sql);
		getStmt().setInt(1, o.getSeq());
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
	public void alterar(Especie o) throws Exception {
		String sql = "UPDATE especie SET `nome` = ?, `genero` = ? WHERE id = ?";
		preparar(sql);
		getStmt().setString(1, o.getNome());
		getStmt().setInt(2, o.getGenero());
		getStmt().setInt(3, o.getSeq());
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
	
	public Especie buscar(int id) throws Exception {
		String sql = "SELECT * FROM especie WHERE `seq` = ?";
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
		Especie o = new Especie(rs.getInt(1), rs.getString(2), rs.getInt(3));
		rs.close();
		fecharStmt();
		return o;
	}

	@Override
	public ArrayList<Especie> listarTodos() throws Exception {
		ArrayList<Especie> list = new ArrayList<>();
		String sql = "SELECT * FROM especie";
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
			Especie o = new Especie(rs.getInt(1), rs.getString(2), rs.getInt(3));
			list.add(o);
		}
		rs.close();
		fecharStmt();
		return list;
	}
	
	public boolean pertence(int idEspecie, int idGenero) throws Exception{
		String sql = "select zoologico.espePertenceGenero(?, ?)";
		preparar(sql);
		getStmt().setInt(1,idEspecie);
		getStmt().setInt(2, idGenero);
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
		boolean resp = rs.getBoolean(1);
		rs.close();
		fecharStmt();
		return resp;
	}


}
