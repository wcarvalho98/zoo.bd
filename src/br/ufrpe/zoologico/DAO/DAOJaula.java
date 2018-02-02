/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 30.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Jaula;

public class DAOJaula extends DAO<Jaula> {
	
	@Override
	public void inserir(Jaula o) throws Exception {
		String sql = "INSERT INTO jaula ( `stats`, `tipo`, `dt_ultima_inspecao`, "
				   + "`populacao_max`, `obs`, `perid_insp_dias`, "
				   + "`altura`, `largura`, `profundidade`, `idZoo`, `cpf_tratador`) "
				   + "VALUES (?, ?, ?,?, ?, ?, ?, ?, ?,?, ?)";
		preparar(sql);
		getStmt().setBoolean(1,o.isStats());
		getStmt().setString(2, o.getTipo());
		getStmt().setString(3, o.getDt_ultima_inspecao().toString());
		getStmt().setInt(4, o.getPopulacao_max());
		getStmt().setString(5, o.getObs());
		getStmt().setInt(6, o.getPerid_insp_dias());
		getStmt().setDouble(7, o.getAltura());
		getStmt().setDouble(8, o.getLargura());
		getStmt().setDouble(9, o.getProfundidade());
		getStmt().setInt(10, o.getZoo());
		getStmt().setString(11, o.getTratador());
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
	public void remover(Jaula o) throws Exception {
		String sql = "DELETE FROM jaula WHERE `id_Jaula` = ?";
		preparar(sql);
		getStmt().setInt(1, o.getId_jaula());
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
	public void alterar(Jaula o) throws Exception {
		String sql =  "UPDATE jaula SET `stats` = ?, `tipo` = ?, `dt_ultima_inspecao` = ?, "
				   + "`populacao_max` = ?, `obs` = ?, `perid_insp_dias` = ?, "
				   + "`altura` = ?, `largura` = ?, `profundidade` = ?, `idZoo` = ?, `cpf_tratador` = ?"
				   + "  WHERE `id_Jaula` = ?";
		preparar(sql);
		getStmt().setBoolean(1,o.isStats());
		getStmt().setString(2, o.getTipo());
		getStmt().setString(3, o.getDt_ultima_inspecao().toString());
		getStmt().setInt(4, o.getPopulacao_max());
		getStmt().setString(5, o.getObs());
		getStmt().setInt(6, o.getPerid_insp_dias());
		getStmt().setDouble(7, o.getAltura());
		getStmt().setDouble(8, o.getLargura());
		getStmt().setDouble(9, o.getProfundidade());
		getStmt().setInt(10, o.getZoo());
		getStmt().setString(11, o.getTratador());
		getStmt().setInt(12, o.getId_jaula());
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
	
	public Jaula buscar(int id) throws Exception{
		String sql = "SELECT * FROM jaula WHERE `id_Jaula` = ?";
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
		Jaula j = new Jaula(rs.getInt(1), rs.getBoolean(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getInt(5), rs.getString(6), 
				rs.getInt(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getInt(11), rs.getString(12));
		rs.close();
		fecharStmt();
		return j;
	}
	
	@Override
	public ArrayList<Jaula> listarTodos() throws Exception {
		ArrayList<Jaula> r = new  ArrayList<Jaula>();
		String sql = "select * from Jaula";
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
		while(rs.next()){
			Jaula j = new Jaula(rs.getInt(1), rs.getBoolean(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getInt(5), rs.getString(6), 
					rs.getInt(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getInt(11), rs.getString(12));
			r.add(j);
		}
		fecharStmt();
		return r;
	}

}
