package br.ufrpe.zoologico.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.zoologico.util.ConFactory;

public abstract class DAO<T> {
	private final String URL = "jdbc:mysql://localhost/zoologico", NOME = "root", SENHA = "123456";
	private Connection con;
	private PreparedStatement stmt;
	
	public PreparedStatement getStmt() {
		return stmt;
	}
	
	public void conectar() throws ClassNotFoundException, SQLException{
		con = ConFactory.conexao(URL, NOME, SENHA);  
	}
	
	public void fechar() throws SQLException{  
		con.close();
	}
	
	public void preparar(String sql) throws Exception{
			conectar();
			stmt = con.prepareStatement(sql);
	}
	
	public abstract void inserir(T o) throws Exception;
	
	public abstract void remover(T o) throws Exception;
	
	public abstract void alterar(T o) throws Exception;
	
	public abstract ArrayList<T> listarTodos() throws Exception;
	
	
}
