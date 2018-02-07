/** 
 * @author igor_
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio.beans - Versao 1.0 - 2017.2
 * TODO 18.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

import java.time.LocalDate;

public class Animal {
	private int id;
	private String nome;
	private boolean vivo;
	private LocalDate dt_nasc;
	private LocalDate dt_falecimento;
	private int idade;
	private String nome_vulgar;
	private String obs;
	private int id_zoo;
	private int id_jaula;
	private int ordem, genero, especie;

	/**
	 * @param id
	 * @param nome
	 * @param vivo
	 * @param dt_nasc
	 * @param dt_falecimento
	 * @param idade
	 * @param nome_vulgar
	 * @param obs
	 * @param id_zoo
	 * @param id_jaula
	 * @param ordem
	 * @param genero
	 * @param especie
	 */
	public Animal(int id, String nome, boolean vivo, LocalDate dt_nasc, LocalDate dt_falecimento, int idade,
			String nome_vulgar, String obs, int id_zoo, int id_jaula, int ordem, int genero, int especie) {
		super();
		this.id = id;
		this.nome = nome;
		this.vivo = vivo;
		this.dt_nasc = dt_nasc;
		this.dt_falecimento = dt_falecimento;
		this.idade = idade;
		this.nome_vulgar = nome_vulgar;
		this.obs = obs;
		this.id_zoo = id_zoo;
		this.id_jaula = id_jaula;
		this.ordem = ordem;
		this.genero = genero;
		this.especie = especie;
	}

	/**
	 * Metodo: getId
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo: setId
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo: getNome
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo: setNome
	 * 
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo: isVivo
	 * 
	 * @return vivo
	 */
	public boolean isVivo() {
		return vivo;
	}

	/**
	 * Metodo: setVivo
	 * 
	 * @param vivo
	 *            the vivo to set
	 */
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	/**
	 * Metodo: getDt_nasc
	 * 
	 * @return dt_nasc
	 */
	public LocalDate getDt_nasc() {
		return dt_nasc;
	}

	/**
	 * Metodo: setDt_nasc
	 * 
	 * @param dt_nasc
	 *            the dt_nasc to set
	 */
	public void setDt_nasc(LocalDate dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	/**
	 * Metodo: getDt_falecimento
	 * 
	 * @return dt_falecimento
	 */
	public LocalDate getDt_falecimento() {
		return dt_falecimento;
	}

	/**
	 * Metodo: setDt_falecimento
	 * 
	 * @param dt_falecimento
	 *            the dt_falecimento to set
	 */
	public void setDt_falecimento(LocalDate dt_falecimento) {
		this.dt_falecimento = dt_falecimento;
	}

	/**
	 * Metodo: getIdade
	 * 
	 * @return idade
	 */
	public int getIdade() {
		return idade;
	}

	/**
	 * Metodo: setIdade
	 * 
	 * @param idade
	 *            the idade to set
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}

	/**
	 * Metodo: getNome_vulgar
	 * 
	 * @return nome_vulgar
	 */
	public String getNome_vulgar() {
		return nome_vulgar;
	}

	/**
	 * Metodo: setNome_vulgar
	 * 
	 * @param nome_vulgar
	 *            the nome_vulgar to set
	 */
	public void setNome_vulgar(String nome_vulgar) {
		this.nome_vulgar = nome_vulgar;
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
	 * Metodo: getId_zoo
	 * 
	 * @return id_zoo
	 */
	public int getId_zoo() {
		return id_zoo;
	}

	/**
	 * Metodo: setId_zoo
	 * 
	 * @param id_zoo
	 *            the id_zoo to set
	 */
	public void setId_zoo(int id_zoo) {
		this.id_zoo = id_zoo;
	}

	/**
	 * Metodo: getId_jaula
	 * 
	 * @return id_jaula
	 */
	public int getId_jaula() {
		return id_jaula;
	}

	/**
	 * Metodo: setId_jaula
	 * 
	 * @param id_jaula
	 *            the id_jaula to set
	 */
	public void setId_jaula(int id_jaula) {
		this.id_jaula = id_jaula;
	}

	/**
	 * Metodo: getOrdem
	 * 
	 * @return ordem
	 */
	public int getOrdem() {
		return ordem;
	}

	/**
	 * Metodo: setOrdem
	 * 
	 * @param ordem
	 *            the ordem to set
	 */
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	/**
	 * Metodo: getGenero
	 * 
	 * @return genero
	 */
	public int getGenero() {
		return genero;
	}

	/**
	 * Metodo: setGenero
	 * 
	 * @param genero
	 *            the genero to set
	 */
	public void setGenero(int genero) {
		this.genero = genero;
	}

	/**
	 * Metodo: getEspecie
	 * 
	 * @return especie
	 */
	public int getEspecie() {
		return especie;
	}

	/**
	 * Metodo: setEspecie
	 * 
	 * @param especie
	 *            the especie to set
	 */
	public void setEspecie(int especie) {
		this.especie = especie;
	}

	public boolean equals() {
		return false;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nome=" + nome + ", vivo=" + vivo + ", dt_nasc=" + dt_nasc + ", dt_falecimento="
				+ dt_falecimento + ", idade=" + idade + ", nome_vulgar=" + nome_vulgar + ", obs=" + obs + ", id_zoo="
				+ id_zoo + ", id_jaula=" + id_jaula + ", ordem=" + ordem + ", genero=" + genero + ", especie=" + especie
				+ "]";
	}
}
