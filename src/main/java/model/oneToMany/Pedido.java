package model.oneToMany;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "pedido") //-> PEDIDO PARA MUITOS ITENS DE PEDIDO LADO BIDIRECIONAL (LADO ONE)
	private List<ItemPedido> itens;//-> RELAÇAO BIDIRECIONAL ONETOMANY
								   //-> DEFAULT: FETCH DA RELAÇAO TOMANY É LAZY; (FORMA LENTA)
	
	
	@Column(nullable = false)
	private Date data;
	
	public Pedido() {
		this(new Date());
	}

	public Pedido(Date data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	
	
	
}
