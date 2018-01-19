/** 
 * @author Pedro
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 16.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class Jaula {
	private boolean stats;
	private LocalDate dt_ultima_inspecao;
	private int populacao_max;
	private String obs;
	private int perid_insp_dias;
	private double altura;
	private double largura;
	private double profundidade;
	private Zoo zoo;
	private Tratador tratador;
	
	
	
	/**
	 * @param stats
	 * @param dt_ultima_inspecao
	 * @param populacao_max
	 * @param obs
	 * @param perid_insp_dias
	 * @param altura
	 * @param largura
	 * @param profundidade
	 * @param zoo
	 * @param tratador
	 * @param id_jaula
	 */
	public Jaula(boolean stats, LocalDate dt_ultima_inspecao, int populacao_max, String obs, int perid_insp_dias,
			double altura, double largura, double profundidade, Zoo zoo, Tratador tratador, int id_jaula) {
		super();
		this.stats = stats;
		this.dt_ultima_inspecao = dt_ultima_inspecao;
		this.populacao_max = populacao_max;
		this.obs = obs;
		this.perid_insp_dias = perid_insp_dias;
		this.altura = altura;
		this.largura = largura;
		this.profundidade = profundidade;
		this.zoo = zoo;
		this.tratador = tratador;
		this.id_jaula = id_jaula;
	}

	private int id_jaula;
	/**
	 * Metodo: getId_jaula
	 * @return id_jaula
	 */
	public int getId_jaula() {
		return id_jaula;
	}
	/**
	 * Metodo: setId_jaula
	 * @param id_jaula the id_jaula to set
	 */
	public void setId_jaula(int id_jaula) {
		this.id_jaula = id_jaula;
	}
	/**
	 * Metodo: isStats
	 * @return stats
	 */
	public boolean isStats() {
		return stats;
	}
	/**
	 * Metodo: setStats
	 * @param stats the stats to set
	 */
	public void setStats(boolean stats) {
		this.stats = stats;
	}
	/**
	 * Metodo: getDt_ultima_inspecao
	 * @return dt_ultima_inspecao
	 */
	public LocalDate getDt_ultima_inspecao() {
		return dt_ultima_inspecao;
	}
	/**
	 * Metodo: setDt_ultima_inspecao
	 * @param dt_ultima_inspecao the dt_ultima_inspecao to set
	 */
	public void setDt_ultima_inspecao(LocalDate dt_ultima_inspecao) {
		this.dt_ultima_inspecao = dt_ultima_inspecao;
	}
	/**
	 * Metodo: getPopulacao_max
	 * @return populacao_max
	 */
	public int getPopulacao_max() {
		return populacao_max;
	}
	/**
	 * Metodo: setPopulacao_max
	 * @param populacao_max the populacao_max to set
	 */
	public void setPopulacao_max(int populacao_max) {
		this.populacao_max = populacao_max;
	}
	/**
	 * Metodo: getObs
	 * @return obs
	 */
	public String getObs() {
		return obs;
	}
	/**
	 * Metodo: setObs
	 * @param obs the obs to set
	 */
	public void setObs(String obs) {
		this.obs = obs;
	}
	/**
	 * Metodo: getPerid_insp_dias
	 * @return perid_insp_dias
	 */
	public int getPerid_insp_dias() {
		return perid_insp_dias;
	}
	/**
	 * Metodo: setPerid_insp_dias
	 * @param perid_insp_dias the perid_insp_dias to set
	 */
	public void setPerid_insp_dias(int perid_insp_dias) {
		this.perid_insp_dias = perid_insp_dias;
	}
	/**
	 * Metodo: getAltura
	 * @return altura
	 */
	public double getAltura() {
		return altura;
	}
	/**
	 * Metodo: setAltura
	 * @param altura the altura to set
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}
	/**
	 * Metodo: getLargura
	 * @return largura
	 */
	public double getLargura() {
		return largura;
	}
	/**
	 * Metodo: setLargura
	 * @param largura the largura to set
	 */
	public void setLargura(double largura) {
		this.largura = largura;
	}
	/**
	 * Metodo: getProfundidade
	 * @return profundidade
	 */
	public double getProfundidade() {
		return profundidade;
	}
	/**
	 * Metodo: setProfundidade
	 * @param profundidade the profundidade to set
	 */
	public void setProfundidade(double profundidade) {
		this.profundidade = profundidade;
	}
	/**
	 * Metodo: getZoo
	 * @return zoo
	 */
	public Zoo getZoo() {
		return zoo;
	}
	/**
	 * Metodo: setZoo
	 * @param zoo the zoo to set
	 */
	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}
	/**
	 * Metodo: getTratador
	 * @return tratador
	 */
	public Tratador getTratador() {
		return tratador;
	}
	/**
	 * Metodo: setTratador
	 * @param tratador the tratador to set
	 */
	public void setTratador(Tratador tratador) {
		this.tratador = tratador;
	}
	
	public boolean equals(){
		return false;
	}
}
