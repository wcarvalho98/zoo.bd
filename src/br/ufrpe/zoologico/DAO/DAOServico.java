/** 
 * @author WILDER.CARVALHO
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Servico;

public class DAOServico extends DAO<Servico> {

	private static DAOServico instance;
	private ArrayList<Servico> r;
	
	private DAOServico() {
		r = new ArrayList<Servico>();
	}
	
	public static DAOServico getInstance() {
		if (instance == null) {
			instance = new DAOServico();
		}
		return instance;
	}
	
	@Override
	public void inserir(Servico o) throws Exception {
		String sql = "INSERT INTO servico (`descr`,`valor`) VALUES (?,?)";
		preparar(sql);
		getStmt().setString(1, o.getDescr());
		getStmt().setDouble(2, o.getValor());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void remover(Servico o) throws Exception {
		String sql = "REMOVE FROM servico WHERE id = ?";
		preparar(sql);
		getStmt().setInt(1, o.getId());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void alterar(Servico o) throws Exception {
		String sql = "UPDATE servico SET descr = ?, valor = ? WHERE id = ?";
		preparar(sql);
		getStmt().setString(1, o.getDescr());
		getStmt().setDouble(2, o.getValor());
		getStmt().setInt(3, o.getId());
		getStmt().execute();
		fecharStmt();
		fechar();
	}
	
	public Servico buscar(int id) throws Exception {
		String sql = "SELECT * FROM servico WHERE id = ?";
		preparar(sql);
		getStmt().setInt(1, id);
		ResultSet rs = getStmt().executeQuery();
		rs.next();
		Servico o = new Servico(rs.getInt(1), rs.getString(2), rs.getDouble(3));
		rs.close();
		fecharStmt();
		fechar();
		return o;
	}

	@Override
	public ArrayList<Servico> listarTodos() throws Exception {
		String sql = "SELECT * FROM servico";
		preparar(sql);
		ResultSet rs = getStmt().executeQuery();
		while(rs.next()) {
			Servico o = new Servico(rs.getInt(1), rs.getString(2), rs.getDouble(3));
			r.add(o);
		}
		rs.close();
		fecharStmt();
		fechar();
		return r;
	}

}
