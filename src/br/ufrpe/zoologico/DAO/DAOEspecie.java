/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 01.02.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Especie;
import br.ufrpe.zoologico.negocio.beans.Ordem;

public class DAOEspecie extends DAO<Especie> {

	@Override
	public void inserir(Especie o) throws Exception {
	}

	@Override
	public void remover(Especie o) throws Exception {
	}

	@Override
	public void alterar(Especie o) throws Exception {
	}

	@Override
	public ArrayList<Especie> listarTodos() throws Exception {
		ArrayList<Especie> list = new ArrayList<>();
		String sql = "SELECT * from Especie";
		preparar(sql);
		ResultSet rs = getStmt().executeQuery();
		while (rs.next()) {
			Especie o = new Especie(rs.getInt(1), rs.getString(2), rs.getInt(3));
			list.add(o);
		}
		rs.close();
		fecharStmt();
		fechar();
		return list;
	}

}
