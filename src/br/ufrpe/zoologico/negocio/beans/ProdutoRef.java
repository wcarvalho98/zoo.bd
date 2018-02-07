/** 
 * @author Wilder
 * UFRPE - Banco de dados
 * br.ufrpe.zoologico.negocio - Versao 1.0 - 2017.2
 * TODO 15.01.2018 
 */
package br.ufrpe.zoologico.negocio.beans;

public class ProdutoRef {
	private int cod;
	private String descr;
	private int freq_pedido;
	private String cod_barra;
	private double preco_ult_compra;
	private int qtd_total_estoque;
	private int qtd_min;
	private int subcat;
	private int categ;
	private int fornecedor;

	/**
	 * @param cod
	 * @param descr
	 * @param freq_pedido
	 * @param cod_barra
	 * @param qtd_estoque
	 * @param preco_ult_compra
	 * @param qtd_total_estoque
	 * @param qtd_min
	 * @param subcat
	 * @param categ
	 * @param fornecedor
	 */
	public ProdutoRef(int cod, String descr, int freq_pedido, String cod_barra, double preco_ult_compra,
			int qtd_total_estoque, int qtd_min, int subcat, int categ, int fornecedor) {
		super();
		this.cod = cod;
		this.descr = descr;
		this.freq_pedido = freq_pedido;
		this.cod_barra = cod_barra;
		this.preco_ult_compra = preco_ult_compra;
		this.qtd_total_estoque = qtd_total_estoque;
		this.qtd_min = qtd_min;
		this.subcat = subcat;
		this.categ = categ;
		this.fornecedor = fornecedor;
	}

	/**
	 * Metodo: getCod
	 * 
	 * @return cod
	 */
	public int getCod() {
		return cod;
	}

	/**
	 * Metodo: setCod
	 * 
	 * @param cod
	 *            the cod to set
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}

	/**
	 * Metodo: getDescr
	 * 
	 * @return descr
	 */
	public String getDescr() {
		return descr;
	}

	/**
	 * Metodo: setDescr
	 * 
	 * @param descr
	 *            the descr to set
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}

	/**
	 * Metodo: getFreq_pedido
	 * 
	 * @return freq_pedido
	 */
	public int getFreq_pedido() {
		return freq_pedido;
	}

	/**
	 * Metodo: setFreq_pedido
	 * 
	 * @param freq_pedido
	 *            the freq_pedido to set
	 */
	public void setFreq_pedido(int freq_pedido) {
		this.freq_pedido = freq_pedido;
	}

	/**
	 * Metodo: getCod_barra
	 * 
	 * @return cod_barra
	 */
	public String getCod_barra() {
		return cod_barra;
	}

	/**
	 * Metodo: setCod_barra
	 * 
	 * @param cod_barra
	 *            the cod_barra to set
	 */
	public void setCod_barra(String cod_barra) {
		this.cod_barra = cod_barra;
	}

	/**
	 * Metodo: getPreco_ult_compra
	 * 
	 * @return preco_ult_compra
	 */
	public double getPreco_ult_compra() {
		return preco_ult_compra;
	}

	/**
	 * Metodo: setPreco_ult_compra
	 * 
	 * @param preco_ult_compra
	 *            the preco_ult_compra to set
	 */
	public void setPreco_ult_compra(double preco_ult_compra) {
		this.preco_ult_compra = preco_ult_compra;
	}

	/**
	 * Metodo: getQtd_total_estoque
	 * 
	 * @return qtd_total_estoque
	 */
	public int getQtd_total_estoque() {
		return qtd_total_estoque;
	}

	/**
	 * Metodo: setQtd_total_estoque
	 * 
	 * @param qtd_total_estoque
	 *            the qtd_total_estoque to set
	 */
	public void setQtd_total_estoque(int qtd_total_estoque) {
		this.qtd_total_estoque = qtd_total_estoque;
	}

	/**
	 * Metodo: getQtd_min
	 * 
	 * @return qtd_min
	 */
	public int getQtd_min() {
		return qtd_min;
	}

	/**
	 * Metodo: setQtd_min
	 * 
	 * @param qtd_min
	 *            the qtd_min to set
	 */
	public void setQtd_min(int qtd_min) {
		this.qtd_min = qtd_min;
	}

	/**
	 * Metodo: getSubcat
	 * 
	 * @return subcat
	 */
	public int getSubcat() {
		return subcat;
	}

	/**
	 * Metodo: setSubcat
	 * 
	 * @param subcat
	 *            the subcat to set
	 */
	public void setSubcat(int subcat) {
		this.subcat = subcat;
	}

	/**
	 * Metodo: getCateg
	 * 
	 * @return categ
	 */
	public int getCateg() {
		return categ;
	}

	/**
	 * Metodo: setCateg
	 * 
	 * @param categ
	 *            the categ to set
	 */
	public void setCateg(int categ) {
		this.categ = categ;
	}

	/**
	 * Metodo: getFornecedor
	 * 
	 * @return fornecedor
	 */
	public int getFornecedor() {
		return fornecedor;
	}

	/**
	 * Metodo: setFornecedor
	 * 
	 * @param fornecedor
	 *            the fornecedor to set
	 */
	public void setFornecedor(int fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categ;
		result = prime * result + cod;
		result = prime * result + ((cod_barra == null) ? 0 : cod_barra.hashCode());
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + fornecedor;
		result = prime * result + freq_pedido;
		long temp;
		temp = Double.doubleToLongBits(preco_ult_compra);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + qtd_min;
		result = prime * result + qtd_total_estoque;
		result = prime * result + subcat;
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
		ProdutoRef other = (ProdutoRef) obj;
		if (categ != other.categ)
			return false;
		if (cod != other.cod)
			return false;
		if (cod_barra == null) {
			if (other.cod_barra != null)
				return false;
		} else if (!cod_barra.equals(other.cod_barra))
			return false;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (fornecedor != other.fornecedor)
			return false;
		if (freq_pedido != other.freq_pedido)
			return false;
		if (Double.doubleToLongBits(preco_ult_compra) != Double.doubleToLongBits(other.preco_ult_compra))
			return false;
		if (qtd_min != other.qtd_min)
			return false;
		if (qtd_total_estoque != other.qtd_total_estoque)
			return false;
		if (subcat != other.subcat)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProdutoRef [cod=" + cod + ", descr=" + descr + ", freq_pedido=" + freq_pedido + ", cod_barra="
				+ cod_barra + ", preco_ult_compra=" + preco_ult_compra + ", qtd_total_estoque=" + qtd_total_estoque
				+ ", qtd_min=" + qtd_min + ", subcat=" + subcat + ", categ=" + categ + ", fornecedor=" + fornecedor
				+ "]";
	}
}
