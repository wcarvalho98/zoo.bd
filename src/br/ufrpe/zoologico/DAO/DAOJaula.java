/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 30.01.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Jaula;

public class DAOJaula extends DAO<Jaula> {
	
	
	@Override
	public void inserir(Jaula o) throws Exception {
		String sql = "insert into Jaula ( `stats`, `tipo`, `dt_ultima_inspecao`, "
				   + "`populacao_max`, `obs`, `perid_insp_dias`, "
				   + "`altura`, `largura`, `profundidade`, `idZoo`, `cpf_tratador`) "
				   + "VALUES (?, ?, ?,?, ?, ?, ?, ?, ?,?, ?)";
		preparar(sql);
		getStmt().setBoolean(1,o.isStats());
		getStmt().setString(2, o.getTipo());
		getStmt().setString(3, o.getDt_ultima_inspecao().toString());
		getStmt().setInt(4, o.getPopulacao_max());
		getStmt().setString(5, o.getObs());
		getStmt().setInt(6, o.getPerid_insp_dias());
		getStmt().setDouble(7, o.getAltura());
		getStmt().setDouble(8, o.getLargura());
		getStmt().setDouble(9, o.getProfundidade());
		getStmt().setInt(10, o.getZoo());
		getStmt().setString(11, o.getTratador());
		getStmt().execute();
		fecharStmt();
		fechar();		

	}

	@Override
	public void remover(Jaula o) throws Exception {
		String sql = "delete from Jaula where `idZoo` = ?, `id_Jaula` = ?";
		preparar(sql);
		getStmt().setInt(1, o.getZoo());
		getStmt().setInt(2, o.getId_jaula());
		getStmt().execute();
		fecharStmt();
		fechar();
	}

	@Override
	public void alterar(Jaula o) throws Exception {
	}

	@Override
	public ArrayList<Jaula> listarTodos() throws Exception {
		return null;
	}
	
/*	public Jaula buscar(int id) throws Exception{
		String sql = "Select ";
	}
*/
}
