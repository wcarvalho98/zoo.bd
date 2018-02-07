/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class Calendario {
	private int seq;
	private LocalDate dia;
	private boolean fim_de_semana;
	private boolean feriado;
	private String obs;
	private String lembrete_1;
	private String lembrete_2;
	private String todo_list;

	/**
	 * @param seq
	 * @param dia
	 * @param fim_de_semana
	 * @param feriado
	 * @param obs
	 * @param lembrete_1
	 * @param lembrete_2
	 * @param todo_list
	 */
	public Calendario(int seq, LocalDate dia, boolean fim_de_semana, boolean feriado, String obs, String lembrete_1,
			String lembrete_2, String todo_list) {
		super();
		this.seq = seq;
		this.dia = dia;
		this.fim_de_semana = fim_de_semana;
		this.feriado = feriado;
		this.obs = obs;
		this.lembrete_1 = lembrete_1;
		this.lembrete_2 = lembrete_2;
		this.todo_list = todo_list;
	}

	/**
	 * Metodo: getSeq
	 * 
	 * @return seq
	 */
	public int getSeq() {
		return seq;
	}

	/**
	 * Metodo: setSeq
	 * 
	 * @param seq
	 *            the seq to set
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}

	/**
	 * Metodo: getDia
	 * 
	 * @return dia
	 */
	public LocalDate getDia() {
		return dia;
	}

	/**
	 * Metodo: setDia
	 * 
	 * @param dia
	 *            the dia to set
	 */
	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	/**
	 * Metodo: isFim_de_semana
	 * 
	 * @return fim_de_semana
	 */
	public boolean isFim_de_semana() {
		return fim_de_semana;
	}

	/**
	 * Metodo: setFim_de_semana
	 * 
	 * @param fim_de_semana
	 *            the fim_de_semana to set
	 */
	public void setFim_de_semana(boolean fim_de_semana) {
		this.fim_de_semana = fim_de_semana;
	}

	/**
	 * Metodo: isFeriado
	 * 
	 * @return feriado
	 */
	public boolean isFeriado() {
		return feriado;
	}

	/**
	 * Metodo: setFeriado
	 * 
	 * @param feriado
	 *            the feriado to set
	 */
	public void setFeriado(boolean feriado) {
		this.feriado = feriado;
	}

	/**
	 * Metodo: getObs
	 * 
	 * @return obs
	 */
	public String getObs() {
		return obs;
	}

	/**
	 * Metodo: setObs
	 * 
	 * @param obs
	 *            the obs to set
	 */
	public void setObs(String obs) {
		this.obs = obs;
	}

	/**
	 * Metodo: getLembrete_1
	 * 
	 * @return lembrete_1
	 */
	public String getLembrete_1() {
		return lembrete_1;
	}

	/**
	 * Metodo: setLembrete_1
	 * 
	 * @param lembrete_1
	 *            the lembrete_1 to set
	 */
	public void setLembrete_1(String lembrete_1) {
		this.lembrete_1 = lembrete_1;
	}

	/**
	 * Metodo: getLembrete_2
	 * 
	 * @return lembrete_2
	 */
	public String getLembrete_2() {
		return lembrete_2;
	}

	/**
	 * Metodo: setLembrete_2
	 * 
	 * @param lembrete_2
	 *            the lembrete_2 to set
	 */
	public void setLembrete_2(String lembrete_2) {
		this.lembrete_2 = lembrete_2;
	}

	/**
	 * Metodo: getTodo_list
	 * 
	 * @return todo_list
	 */
	public String getTodo_list() {
		return todo_list;
	}

	/**
	 * Metodo: setTodo_list
	 * 
	 * @param todo_list
	 *            the todo_list to set
	 */
	public void setTodo_list(String todo_list) {
		this.todo_list = todo_list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + (feriado ? 1231 : 1237);
		result = prime * result + (fim_de_semana ? 1231 : 1237);
		result = prime * result + ((lembrete_1 == null) ? 0 : lembrete_1.hashCode());
		result = prime * result + ((lembrete_2 == null) ? 0 : lembrete_2.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result + seq;
		result = prime * result + ((todo_list == null) ? 0 : todo_list.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calendario other = (Calendario) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (feriado != other.feriado)
			return false;
		if (fim_de_semana != other.fim_de_semana)
			return false;
		if (lembrete_1 == null) {
			if (other.lembrete_1 != null)
				return false;
		} else if (!lembrete_1.equals(other.lembrete_1))
			return false;
		if (lembrete_2 == null) {
			if (other.lembrete_2 != null)
				return false;
		} else if (!lembrete_2.equals(other.lembrete_2))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
			return false;
		if (seq != other.seq)
			return false;
		if (todo_list == null) {
			if (other.todo_list != null)
				return false;
		} else if (!todo_list.equals(other.todo_list))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Calendario [seq=" + seq + ", dia=" + dia + ", fim_de_semana=" + fim_de_semana + ", feriado=" + feriado
				+ ", obs=" + obs + ", lembrete_1=" + lembrete_1 + ", lembrete_2=" + lembrete_2 + ", todo_list="
				+ todo_list + "]";
	}

}
