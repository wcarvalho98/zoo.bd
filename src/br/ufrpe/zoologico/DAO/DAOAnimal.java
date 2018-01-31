/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 22.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Animal;

public class DAOAnimal extends DAO<Animal>{

	@Override
	public void inserir(Animal o) throws Exception {
		String sql = "INSERT INTO animal (`nome`,`vivo`,`dt_nasc`,`dt_falecimento`,"
				+ "`idade`,`nome_vulgar`,`obs`,`id_zoo`,`id_jaula`,`ordem`,`genero`,`especie`) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?)";
		preparar(sql);
		getStmt().setString(1, o.getNome());
		getStmt().setBoolean(2, o.isVivo());
		getStmt().setDate(3, Date.valueOf(o.getDt_nasc()));
		getStmt().setDate(4, Date.valueOf(o.getDt_falecimento()));
		getStmt().setInt(5, o.getIdade());
		getStmt().setString(6, o.getNome_vulgar());
		getStmt().setString(7, o.getObs());
		getStmt().setInt(8, o.getId_zoo());
		getStmt().setInt(9, o.getId_jaula());
		getStmt().setInt(10, o.getOrdem());
		getStmt().setInt(11, o.getGenero());
		getStmt().setInt(12, o.getEspecie());
		getStmt().execute();
		fecharStmt();
		fechar();		
	}

	@Override
	public void remover(Animal o) throws Exception {
		String sql = "DELETE FROM animal WHERE `id` = ?";
		preparar(sql);
		getStmt().setInt(1, o.getId());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void alterar(Animal o) throws Exception {
		String sql = "UPDATE animal SET "
				+ "`nome` = ?,`vivo` = ?,`dt_nasc` = ?,`dt_falecimento` = ?"
				+ "`idade` = ?,`nome_vulgar` = ?,`obs` = ?,`id_zoo` = ?,"
				+ "`id_jaula` = ?,`ordem` = ?,`genero` = ?,`especie` = ?"
				+ "WHERE `id` = ?";
		preparar(sql);
		getStmt().setString(1, o.getNome());
		getStmt().setBoolean(2, o.isVivo());
		getStmt().setDate(3, Date.valueOf(o.getDt_nasc()));
		getStmt().setDate(4, Date.valueOf(o.getDt_falecimento()));
		getStmt().setInt(5, o.getIdade());
		getStmt().setString(6, o.getNome_vulgar());
		getStmt().setString(7, o.getObs());
		getStmt().setInt(8, o.getId_zoo());
		getStmt().setInt(9, o.getId_jaula());
		getStmt().setInt(10, o.getOrdem());
		getStmt().setInt(11, o.getGenero());
		getStmt().setInt(12, o.getEspecie());
		getStmt().setInt(13, o.getId());
		getStmt().execute();
		fecharStmt();
		fechar();
	}
	
	public Animal buscar(int id) throws Exception {
		String sql = "SELECT * FROM animal WHERE `id` = ?";
		preparar(sql);
		getStmt().setInt(1, id);
		ResultSet rs = getStmt().executeQuery();
		rs.next();
		Animal o = new Animal(rs.getInt(1), rs.getString(2), rs.getBoolean(3),
				rs.getDate(4).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				rs.getDate(5).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),
				rs.getInt(12), rs.getInt(13));
		rs.close();
		fecharStmt();
		fechar();
		return o;
	}

	@Override
	public ArrayList<Animal> listarTodos() throws Exception {
		ArrayList<Animal> list = new ArrayList<Animal>();
		String sql = "SELECT * FROM animal";
		preparar(sql);
		ResultSet rs = getStmt().executeQuery();
		while(rs.next()) {
			Animal o = new Animal(rs.getInt(1), rs.getString(2), rs.getBoolean(3),
					rs.getDate(4).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
					rs.getDate(5).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
					rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),
					rs.getInt(12), rs.getInt(13));
			list.add(o);
		}
		rs.close();
		fecharStmt();
		fechar();
		return list;
	}

}
