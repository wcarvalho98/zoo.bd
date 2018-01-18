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

	public void conectar(){
		try {  
			con = ConFactory.conexao(URL, NOME, SENHA);  
			comando = con.createStatement();    
		} catch (ClassNotFoundException e) {  
			//vou ver
		} catch (SQLException e) {  
			//vou ver			  
		}
	}
	
	public void fechar() {  
		try {
			comando.close();
		    con.close();    
		}
		catch (SQLException e) {  
			//vou ver  
		}
	}
	
	public void executar(String sql){
		conectar();
		
		try{
			comando.executeUpdate(sql);
		}
		catch(SQLException e){
			//vou ver
		}
		finally{
			fechar();
		}
	}
	
	public abstract void inserir(T o) throws Exception;
	
	public abstract void remover(int id) throws Exception;
	
	public abstract void alterar(T o) throws Exception;
	
	public abstract T buscar(int id) throws Exception;
	
	public abstract ArrayList<T> listarTodos() throws Exception;
	
	
}
