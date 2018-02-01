/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 31.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Administrador;
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
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void remover(Zoo o) throws Exception {
		String sql = "DELETE FROM Zoologico WHERE `idZoo` = ?";
		preparar(sql);
		getStmt().setInt(1, o.getIdZoo());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void alterar(Zoo o) throws Exception {
		String sql = "UPDATE administrador SET `cnpj` = ?, `nome` = ?, `razao_social` = ?, `hr_inic_func` = ?, `hr_fim` = ? WHERE `idZoo` = ?";
		preparar(sql);
		getStmt().setString(1, o.getCnpj());
		getStmt().setString(2, o.getNome());
		getStmt().setString(3, o.getRazao_social());
		getStmt().setTime(4, Time.valueOf(o.getHr_inic_func()));
		getStmt().setTime(5, Time.valueOf(o.getHr_fim()));
		getStmt().setInt(6, o.getIdZoo());
		getStmt().execute();
		fecharStmt();
		fechar();
	}
	
	public Zoo buscar(int id) throws Exception{
		String sql = "SELECT * FROM Zoologico WHERE `idZoo` = ?";
		preparar(sql);
		getStmt().setInt(1, id);
		ResultSet result = getStmt().executeQuery();
		result.next();
		
		Zoo j = new Zoo(result.getInt(1),result.getString(2),result.getString(3), result.getString(4),result.getTime(5).toLocalTime(),result.getTime(6).toLocalTime());
		result.close();
		fecharStmt();
		fechar();
		return j;
		
		
	}

	@Override
	public ArrayList<Zoo> listarTodos() throws Exception {
		String sql = "SELECT * FROM Zoologico";
		preparar(sql);
		ResultSet result = getStmt().executeQuery(sql);
		ArrayList<Zoo> list = new ArrayList<Zoo>();
		while (result.next()) {
			Zoo o = new Zoo(result.getInt(1),result.getString(2),result.getString(3), result.getString(4),result.getTime(5).toLocalTime(),result.getTime(6).toLocalTime());
			list.add(o);
		}
		result.close();
		fecharStmt();
		fechar();
		return list;
	}

}
