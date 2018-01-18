package br.ufrpe.zoologico.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ufrpe.zoologico.util.ConFactory;

public abstract class DAO<T> {
	private final String URL = "jdbc:mysql://localhost/zoologico", NOME = "root", SENHA = "123456";
	private Connection con;
	private Statement comando;
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Statement getComando() {
		return comando;
	}

	public void setComando(Statement comando) {
		this.comando = comando;
	}

	public void conectar() throws ClassNotFoundException, SQLException{
		con = ConFactory.conexao(URL, NOME, SENHA);  
		comando = con.createStatement();    
	}
	
	public void fechar() throws SQLException{  
		comando.close();
		con.close();    
	}
	
	public void executar(String sql) throws Exception{
		conectar();
		comando.executeUpdate(sql);
	}
	
	public abstract void inserir(T o) throws Exception;
	
	public abstract void remover(T o) throws Exception;
	
	public abstract void alterar(T o) throws Exception;
	
	public abstract T buscar(int id) throws Exception;
	
	public abstract ArrayList<T> listarTodos() throws Exception;
	
	
}
