/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 29.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Consulta;
import br.ufrpe.zoologico.negocio.beans.Instituicao;

public class DAOConsultas extends DAO<Consulta>{

	@Override
	public void inserir(Consulta o) throws Exception {
		String sql = "insert into Consulta values (`id_consulta`, `dat_consulta`, `obs`, `id_veterinario`, `id_animal`) VALUES (?, ?, ?, ?, ?)";
		preparar(sql);
		getStmt().setInt(1, o.getId_consulta());
		LocalDateTime a = o.getData();
		Timestamp t = Timestamp.valueOf(a);
		getStmt().setTimestamp(2, t);
		getStmt().setString(3, o.getObs());
		getStmt().setString(4, o.getVeterinario().getCpf());
		getStmt().setInt(5, o.getAnimal().getId());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void remover(Consulta o) throws Exception {
		String sql = "delete from Consulta where `id_consulta` = ?";
		preparar(sql);
		getStmt().setInt(1, o.getId_consulta());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void alterar(Consulta o) throws Exception {
	
	}

	public Consulta buscar(int id) throws Exception {
		String sql = "select * from Consulta where `id_consulta` = ?";
		preparar(sql);
		getStmt().setString(1, cnpj);
		ResultSet rs = getStmt().executeQuery();
		rs.next();
		
		Consulta o = new Consulta(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getString(6), rs.getString(7));
		rs.close();
		fecharStmt();
		fechar();
		return o;
	}

	@Override
	public ArrayList<Consulta> listarTodos() throws Exception {
		return null;
	}

}
