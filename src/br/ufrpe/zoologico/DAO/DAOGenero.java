/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 01.02.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Genero;
import br.ufrpe.zoologico.negocio.beans.Ordem;

public class DAOGenero extends DAO<Genero>{



	@Override
	public void inserir(Genero o) throws Exception {
	}

	@Override
	public void remover(Genero o) throws Exception {
	}

	@Override
	public void alterar(Genero o) throws Exception {
	}

	@Override
	public ArrayList<Genero> listarTodos() throws Exception {
		ArrayList<Genero> list = new ArrayList<>();
		String sql = "SELECT * from Genero";
		preparar(sql);
		ResultSet rs = getStmt().executeQuery();
		while (rs.next()) {
			Genero o = new Genero(rs.getInt(1), rs.getString(2), rs.getInt(3));
			list.add(o);
		}
		rs.close();
		fecharStmt();
		fechar();
		return list;
	}
	
	public Genero busca(int id) throws Exception{
		String sql = "SELECT * FROM genero WHERE `seq` = ?";
		preparar(sql);
		getStmt().setInt(1, id);
		ResultSet rs = getStmt().executeQuery();
		rs.next();
		Genero o = new Genero(rs.getInt(1), rs.getString(2), rs.getInt(3));
		rs.close();
		fecharStmt();
		fechar();
		return o;
	}

}
