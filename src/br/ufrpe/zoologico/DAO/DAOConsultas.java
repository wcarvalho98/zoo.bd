/** 
 * @author henri
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 29.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import br.ufrpe.zoologico.negocio.beans.Animal;
import br.ufrpe.zoologico.negocio.beans.Consulta;
import br.ufrpe.zoologico.negocio.beans.Veterinario;

public class DAOConsultas extends DAO<Consulta>{
	
	private static DAOConsultas instance;
	private ArrayList<Consulta> r;
	
	private DAOConsultas() {
		r = new ArrayList<Consulta>();
	}
	
	public static DAOConsultas getInstance() {
		if (instance == null) {
			instance = new DAOConsultas();
		}
		return instance;
	}

	@Override
	public void inserir(Consulta o) throws Exception {
		String sql = "INSERT INTO `consulta` (`dat_consulta`, `obs`, `id_veterinario`, `id_animal`) VALUES (?, ?, ?, ?)";
		preparar(sql);
		Timestamp t = Timestamp.valueOf(o.getData());
		getStmt().setTimestamp(1, t);
		getStmt().setString(2, o.getObs());
		getStmt().setString(3, o.getVeterinario().getCpf());
		getStmt().setInt(4, o.getAnimal().getId());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void remover(Consulta o) throws Exception {
		String sql = "DELETE FROM `consulta`s WHERE `id_consulta` = ?";
		preparar(sql);
		getStmt().setInt(1, o.getId_consulta());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void alterar(Consulta o) throws Exception {
		String sql = "UPDATE `consulta` SET `dat_consulta` = ?, `obs` = ?, `id_veterinario` = ?, `id_animal` = ?"
				+ "WHERE `id_consulta` = ?";
		preparar(sql);
		Timestamp t = Timestamp.valueOf(o.getData());
		getStmt().setTimestamp(1, t);
		getStmt().setString(2, o.getObs());
		getStmt().setString(3, o.getVeterinario().getCpf());
		getStmt().setInt(4, o.getAnimal().getId());
		getStmt().setInt(5, o.getId_consulta());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	public Consulta buscar(int id) throws Exception {
		String sql = "SELECT * FROM `consulta` WHERE `id_consulta` = ?";
		preparar(sql);
		getStmt().setInt(1, id);
		ResultSet rs = getStmt().executeQuery();
		rs.next();
		Veterinario vet = DAOVeterinario.getInstance().buscar(rs.getString(4));
		Animal ani = DAOAnimal.getInstance().buscar(rs.getInt(5));
		Consulta o = new Consulta(vet, ani, rs.getInt(1), rs.getTimestamp(2).toLocalDateTime(), rs.getString(3));
		rs.close();
		fecharStmt();
		fechar();
		return o;
	}

	@Override
	public ArrayList<Consulta> listarTodos() throws Exception {
		String sql = "SELECT * FROM `consulta`";
		preparar(sql);
		ResultSet rs = getStmt().executeQuery();
		while(rs.next()) {
			Veterinario vet = DAOVeterinario.getInstance().buscar(rs.getString(4));
			Animal ani = DAOAnimal.getInstance().buscar(rs.getInt(5));
			Consulta o = new Consulta(vet, ani, rs.getInt(1), rs.getTimestamp(2).toLocalDateTime(), rs.getString(3));
			r.add(o);
		}
		rs.close();
		fecharStmt();
		fechar();
		return r;
	}

}
