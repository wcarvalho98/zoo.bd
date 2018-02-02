/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.DAO - Versao 1.0 - 2017.2
 * TODO 01.02.2018 
 */
package br.ufrpe.zoologico.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import br.ufrpe.zoologico.negocio.beans.Reserva;

public class DAOReserva extends DAO<Reserva> {

	@Override
	public void inserir(Reserva o) throws Exception {
		String sql = "INSERT INTO reserva VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		preparar(sql);
		getStmt().setInt(1, o.getQtd_pessoas());
		getStmt().setDate(2, Date.valueOf(o.getDt_validade()));
		getStmt().setTime(3, Time.valueOf(o.getHorario()));
		getStmt().setDate(4, Date.valueOf(o.getDt_reserva()));
		getStmt().setDouble(5, o.getValor());
		getStmt().setString(6, o.getStats());
		getStmt().setTime(7, Time.valueOf(o.getHr_inicio_reser()));
		getStmt().setTime(8, Time.valueOf(o.getHr_final_reser()));
		getStmt().setString(9, o.getE_cortesia());
		getStmt().setString(10, o.getTp_evento());
		getStmt().setString(11, o.getCnpj());
		getStmt().setInt(12, o.getId());
		try {
			getStmt().execute();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			e.printStackTrace();
		} finally {
			fecharStmt();
		}
	}

	@Override
	public void remover(Reserva o) throws Exception {
		String sql = "DELETE FROM reserva WHERE cnpj = ?, id_espaco = ?";
		preparar(sql);
		getStmt().setString(1, o.getCnpj());
		getStmt().setInt(2, o.getId());
		try {
			getStmt().execute();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			e.printStackTrace();
		} finally {
			fecharStmt();
		}
	}
	
	public void remover(String cnpj) throws Exception {
		String sql = "DELETE FROM reserva WHERE cnpj = ?";
		preparar(sql);
		getStmt().setString(1, cnpj);
		try {
			getStmt().execute();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			e.printStackTrace();
		} finally {
			fecharStmt();
		}
	}
	
	public void remover(int id_espaco) throws Exception {
		String sql = "DELETE FROM reserva WHERE id_espaco = ?";
		preparar(sql);
		getStmt().setInt(1, id_espaco);
		try {
			getStmt().execute();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			e.printStackTrace();
		} finally {
			fecharStmt();
		}
	}

	@Override
	public void alterar(Reserva o) throws Exception {
		String sql = "UPDATE reserva SET `qtd_pessoas` = ?, `dt_validade` = ?, `horario` = ?, `dt_reserva` = ?"
				+ ", `valor` = ?, `stats` = ?, `hr_inicio_reser` = ?, `hr_final_reser` = ?, `e_cortesia` = ?, `tp_evento` = ?"
				+ "WHERE cnpj = ?, id_espaco = ?";
		preparar(sql);
		getStmt().setInt(1, o.getQtd_pessoas());
		getStmt().setDate(2, Date.valueOf(o.getDt_validade()));
		getStmt().setTime(3, Time.valueOf(o.getHorario()));
		getStmt().setDate(4, Date.valueOf(o.getDt_reserva()));
		getStmt().setDouble(5, o.getValor());
		getStmt().setString(6, o.getStats());
		getStmt().setTime(7, Time.valueOf(o.getHr_inicio_reser()));
		getStmt().setTime(8, Time.valueOf(o.getHr_final_reser()));
		getStmt().setString(9, o.getE_cortesia());
		getStmt().setString(10, o.getTp_evento());
		getStmt().setString(11, o.getCnpj());
		getStmt().setInt(12, o.getId());
		try {
			getStmt().execute();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			e.printStackTrace();
		} finally {
			fecharStmt();
		}
	}
	
	public Reserva buscar(String cnpj, int id_espaco) throws Exception {
		String sql = "SELECT * FROM reserva WHERE cnpj = ?, id_espaco = ?";
		preparar(sql);
		getStmt().setString(1, cnpj);
		getStmt().setInt(2, id_espaco);
		ResultSet rs = null;
		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			fecharStmt();
			e.printStackTrace();
		}
		
		rs.next();
		
		LocalDate dt_validade = null;
		LocalTime horario = null;
		LocalDate dt_reserva = null;
		LocalTime hr_inicio_reser = null;
		LocalTime hr_final_reser = null;
		
		if(rs.getDate(2) != null)
			dt_validade = rs.getDate(2).toLocalDate();
		if(rs.getTime(3) != null)
			horario = rs.getTime(3).toLocalTime();
		if(rs.getDate(4) != null)
			dt_reserva = rs.getDate(4).toLocalDate();
		if(rs.getTime(7) != null)
			hr_inicio_reser = rs.getTime(7).toLocalTime();
		if(rs.getTime(8) != null)
			hr_final_reser = rs.getTime(8).toLocalTime();
		
		Reserva o = new Reserva(rs.getInt(1), dt_validade, horario, dt_reserva, rs.getDouble(5),
				rs.getString(6), hr_inicio_reser, hr_final_reser, rs.getString(9), rs.getString(10),
				rs.getString(11), rs.getInt(12));
		
		rs.close();
		fecharStmt();
		return o;
	}

	@Override
	public ArrayList<Reserva> listarTodos() throws Exception {
		ArrayList<Reserva> r = new ArrayList<Reserva>();
		String sql = "SELECT * FROM reserva";
		preparar(sql);
		ResultSet rs = null;
		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			fecharStmt();
			e.printStackTrace();
		}
		
		LocalDate dt_validade;
		LocalTime horario;
		LocalDate dt_reserva;
		LocalTime hr_inicio_reser;
		LocalTime hr_final_reser;
		
		while(rs.next()) {
			dt_validade = null;
			horario = null;
			dt_reserva = null;
			hr_inicio_reser = null;
			hr_final_reser = null;
			if(rs.getDate(2) != null)
				dt_validade = rs.getDate(2).toLocalDate();
			if(rs.getTime(3) != null)
				horario = rs.getTime(3).toLocalTime();
			if(rs.getDate(4) != null)
				dt_reserva = rs.getDate(4).toLocalDate();
			if(rs.getTime(7) != null)
				hr_inicio_reser = rs.getTime(7).toLocalTime();
			if(rs.getTime(8) != null)
				hr_final_reser = rs.getTime(8).toLocalTime();
			Reserva o = new Reserva(rs.getInt(1), dt_validade, horario, dt_reserva, rs.getDouble(5),
					rs.getString(6), hr_inicio_reser, hr_final_reser, rs.getString(9), rs.getString(10),
					rs.getString(11), rs.getInt(12));
			r.add(o);
		}
		rs.close();
		fecharStmt();
		return r;
	}

}
