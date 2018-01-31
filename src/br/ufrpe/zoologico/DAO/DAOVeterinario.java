/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 30.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Funcionario;
import br.ufrpe.zoologico.negocio.beans.Veterinario;

public class DAOVeterinario extends DAO<Veterinario> {

	private static DAOVeterinario instance;
	private ArrayList<Veterinario> r;
	
	private DAOVeterinario() {
		r = new ArrayList<Veterinario>();
	}
	
	public static DAOVeterinario getInstance() {
		if (instance == null) {
			instance = new DAOVeterinario();
		}
		return instance;
	}
	
	@Override
	public void inserir(Veterinario o) throws Exception {
		Funcionario f = new Funcionario(o.getCpf(), o.getNome(),
				o.getFone_1(), o.getFone_2(), o.getEspecializacao(), o.getData_de_contratacao(),
				o.getSalario(), o.getEndereco(), o.getJornada_trabalho(), o.getId_zoo());
		DAOFuncionario.getInstance().inserir(f);
		String sql = "INSERT INTO `veterinario` (`CPF`,`estado`,`CRMV`) VALUES (?,?,?)";
		preparar(sql);
		getStmt().setString(1, o.getCpf());
		getStmt().setString(2, o.getEstado());
		getStmt().setString(3, o.getCrmv());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void remover(Veterinario o) throws Exception {
		Funcionario f = new Funcionario(o.getCpf(), o.getNome(),
				o.getFone_1(), o.getFone_2(), o.getEspecializacao(), o.getData_de_contratacao(),
				o.getSalario(), o.getEndereco(), o.getJornada_trabalho(), o.getId_zoo());
		DAOFuncionario.getInstance().remover(f);
		String sql = "DELETE FROM `veterinario` WHERE `CPF` = ?";
		preparar(sql);
		getStmt().setString(1, o.getCpf());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void alterar(Veterinario o) throws Exception {
		Funcionario f = new Funcionario(o.getCpf(), o.getNome(),
				o.getFone_1(), o.getFone_2(), o.getEspecializacao(), o.getData_de_contratacao(),
				o.getSalario(), o.getEndereco(), o.getJornada_trabalho(), o.getId_zoo());
		DAOFuncionario.getInstance().alterar(f);
		String sql = "UPDATE `veterinario` SET `estado` = ?,`CRMV` = ? WHERE `CPF` = ?";
		preparar(sql);
		getStmt().setString(1, o.getEstado());
		getStmt().setString(2, o.getCrmv());
		getStmt().setString(3, o.getCpf());
		getStmt().execute();
		fecharStmt();
		fechar();
	}
	
	public Veterinario buscar(String cpf) throws Exception {
		String sqlFunc = "SELECT * FROM `funcionario` WHERE `CPF` = ?";
		String sqlVet = "SELECT * FROM `veterinario` WHERE `CPF` = ?";
		preparar(sqlFunc);
		getStmt().setString(1, cpf);
		ResultSet rs = getStmt().executeQuery();
		preparar(sqlVet);
		getStmt().setString(1, cpf);
		ResultSet rt = getStmt().executeQuery();
		rs.next();
		rt.next();
		Veterinario o = new Veterinario(rs.getString(1), rs.getString(2),
				rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getDate(6).toLocalDate(),
				rs.getDouble(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rt.getString(2), rt.getString(3));
		rs.close();
		rt.close();
		fecharStmt();
		fechar();
		return o;
	}

	@Override
	public ArrayList<Veterinario> listarTodos() throws Exception {
		String sqlFunc = "SELECT * FROM `funcionario` WHERE `CPF` = ?";
		String sqlVet = "SELECT * FROM `veterinario`";
		preparar(sqlVet);
		ResultSet rt = getStmt().executeQuery();
		preparar(sqlFunc);
		ResultSet rs = null;
		while(rt.next()) {
			getStmt().setString(1, rt.getString(1));
			rs = getStmt().executeQuery();
			rs.next();
			Veterinario o = new Veterinario(rs.getString(1), rs.getString(2),
				rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getDate(6).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				rs.getDouble(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rt.getString(2), rt.getString(3));
			r.add(o);
		}
		rs.close();
		rt.close();
		fecharStmt();
		fechar();
		return r;
	}

}
