package model.oneToMany;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import model.basic.Produto;

@Entity
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@ManyToOne(fetch = FetchType.EAGER)//-> MUITOS ITEM DE PADIDO PARA UM PRODUTO (LADO MANY)
	private Produto product;		   //-> DEFAULT: FETCH DA RELAÇAO TOONE É EAGER; (FORMA APRESSADA)
	
	@ManyToOne// MUITOS ITENS DE PEDIDO PARA UM PEDIDO (LADO MANY)
	private Pedido pedido;//-> ESSE ATRIBUTE ESTA SENDO MAPEADO NA CLASSE PEDIDO;
	
	@Column(nullable = false)
	private int qtd;
	
	@Column(nullable = false)
	private Double preco;

	

	public ItemPedido(Pedido pedido, Produto product, int qtd) {
		super();
		this.setPedido(pedido);
		this.setProduct(product);
		this.setQtd(qtd);
	}

	public ItemPedido() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduct() {
		return product;
	}

	public void setProduct(Produto produto) {
		if(produto != null && this.preco == null) {
			this.setPreco(produto.getPreco());	   										
		}
		this.product = produto;
		
		/**
		 * if(produto != null && this.preco == null) {
		 *	this.setPreco(produto.getPreco());	 
		 *
		 *  
		 *	-> SE O PRODUDO JA EXISTIR NA BASE E JA TIVER VALOR ATRIBUIDO ENTAO,									  
	     *	-> SET O NOVO PREÇO E MOSTRE ESSE NOVO VALOR;									   
	     * 	-> VALOR NULL NAO É APENAS "NULO" É UMA VALOR QUE DEPENDE MUITO DO 									   
		 * 	-> CONTEXTO QUE ELE TA SENDO EMPREGADO; 
		 *  -> NO CASO A CIMA ELE ENTRA COM UM SUPOSTO VALOR EXISTENTE NO BANCO DE DADOS.
		 * 
		 * 
		 */
		
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}


}
