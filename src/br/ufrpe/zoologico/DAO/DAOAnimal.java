/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 22.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.Date;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Animal;

public class DAOAnimal extends DAO<Animal>{

	@Override
	public void inserir(Animal o) throws Exception {
		String sql = "INSERT INTO Animal (nome,vivo,dt_nasc,dt_falecimento,idade,nome_vulgar,obs,id_zoo,id_jaula,ordem,"
				+ "genero,especie) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		preparar(sql);
		getStmt().setString(2, o.getNome());
		getStmt().setBoolean(3, o.isVivo());
		getStmt().setDate(4, Date.valueOf(o.getDt_nasc()));
		getStmt().setDate(5, Date.valueOf(o.getDt_falecimento()));
		getStmt().setInt(6, o.getIdade());
		getStmt().setString(7, o.getNome_vulgar());
		getStmt().setString(8, o.getObs());
		getStmt().setInt(9, o.getId_zoo());
		getStmt().setInt(10, o.getId_jaula());
		getStmt().setInt(11, o.getOrdem());
		getStmt().setInt(12, o.getGenero());
		getStmt().setInt(13, o.getEspecie());
		getStmt().execute();
		fechar();
	}

	@Override
	public void remover(Animal o) throws Exception {
		String sql = "DELETE FROM Animal WHERE id = ?";
		preparar(sql);
		getStmt().setInt(1, o.getId());
		getStmt().execute();
		fechar();
	}

	@Override
	public void alterar(Animal o) throws Exception {
	}

	public Animal buscar(int id) throws Exception {
		return null;
	}

	@Override
	public ArrayList<Animal> listarTodos() throws Exception {
		return null;
	}

}
