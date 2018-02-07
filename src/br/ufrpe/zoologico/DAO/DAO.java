package br.ufrpe.zoologico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.ufrpe.zoologico.gui.grafica.controller.Fachada;
import br.ufrpe.zoologico.util.ConFactory;

@SuppressWarnings("unused")
public abstract class DAO<T> {

	private Connection con;
	private PreparedStatement stmt;

	public PreparedStatement getStmt() {
		return stmt;
	}

	public Connection getCon() {
		return con;
	}

	public void fecharStmt() throws SQLException {
		stmt.close();
	}

	public void preparar(String sql) throws Exception {
		con = Fachada.getInstance().getConnection();
		stmt = con.prepareStatement(sql);
	}

	public abstract void inserir(T o) throws Exception;

	public abstract void remover(T o) throws Exception;

	public abstract void alterar(T o) throws Exception;

	public abstract ArrayList<T> listarTodos() throws Exception;

}
