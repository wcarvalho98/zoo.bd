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
import br.ufrpe.zoologico.negocio.beans.Genero;
import br.ufrpe.zoologico.negocio.beans.Ordem;

public class DAOEspecie extends DAO<Especie> {

	@Override
	public void inserir(Especie o) throws Exception {
		String sql = "INSERT INTO especie (`nome`, `genero`) VALUES (?,?)";
		preparar(sql);
		getStmt().setString(1, o.getNome());
		getStmt().setInt(2, o.getGenero());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void remover(Especie o) throws Exception {
		String sql = "DELETE FROM especie WHERE id = ?";
		preparar(sql);
		getStmt().setInt(1, o.getSeq());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void alterar(Especie o) throws Exception {
		String sql = "UPDATE especie SET `nome` = ?, `genero` = ? WHERE id = ?";
		preparar(sql);
		getStmt().setString(1, o.getNome());
		getStmt().setInt(2, o.getGenero());
		getStmt().setInt(3, o.getSeq());
		getStmt().execute();
		fecharStmt();
		fechar();		
	}
	
	public Especie buscar(int id) throws Exception {
		String sql = "SELECT * FROM especie WHERE id = ?";
		preparar(sql);
		getStmt().setInt(1, id);
		ResultSet rs = getStmt().executeQuery();
		rs.next();
		Especie o = new Especie(rs.getInt(1), rs.getString(2), rs.getInt(3));
		rs.close();
		fecharStmt();
		fechar();
		return o;
	}

	@Override
	public ArrayList<Especie> listarTodos() throws Exception {
		ArrayList<Especie> list = new ArrayList<>();
		String sql = "SELECT * FROM especie";
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

	/** 
	 * Metodo: buscar
	 * @param especie2
	 * @return
	 * @return Especie
	 * @throws Exception 
	 */
	public Especie buscar(int especie2) throws Exception {
		String sql = "SELECT * FROM especie WHERE `seq` = ?";
		preparar(sql);
		getStmt().setInt(1, especie2);
		ResultSet rs = getStmt().executeQuery();
		rs.next();
		Especie o = new Especie(rs.getInt(1), rs.getString(2), rs.getInt(3));
		rs.close();
		fecharStmt();
		fechar();
		return o;
	}

}
