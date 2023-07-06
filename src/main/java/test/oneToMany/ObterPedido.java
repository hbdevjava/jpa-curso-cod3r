package test.oneToMany;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import infra.DAO;
import model.basic.Produto;
import model.oneToMany.ItemPedido;
import model.oneToMany.Pedido;

public class ObterPedido {

	public static void main(String[] args) {
		DAO<Pedido> dao = new DAO<>(Pedido.class);

		Pedido pedido = dao.getbyId(7L);

		for (ItemPedido item : pedido.getItens()) {
			System.out.println(item.getQtd());
			System.out.println(item.getProduct().getName());
		}

		dao.closeDAO();
	}

}
/**
 * failed to lazily initialize a collection of role: (EXCEPTION COMO QUANDO SE
 * TRABALHA COM OBJ GERENCIADOS)
 * 
 * @OneToMany(fetch = FetchType.EAGER, mappedBy = "pedido") //-> PEDIDO PARA MUITOS ITENS DE PEDIDO LADO BIDIRECIONAL (LADO ONE)
 * private  List<ItemPedido> itens;//-> RELAÇAO BIDIRECIONAL ONETOMANY
 *                                 //-> DEFAULT: FETCH DA RELAÇAO TOMANY É LAZY; (FORMA LENTA)
 *                 
 * 
 * @ManyToOne(fetch = FetchType.EAGER)//-> MUITOS ITEM DE PADIDO PARA UM PRODUTO (LADO MANY) 
 * private Produto product; //-> DEFAULT: FETCH DA  RELAÇAO TOONE É EAGER; (FORMA APRESSADA)
 *                  
 * 
 *@ManyToOne// MUITOS ITENS DE PEDIDO PARA UM PEDIDO (LADO MANY) 
 *private Pedido pedido;//-> ESSE ATRIBUTE ESTA SENDO MAPEADO NA CLASSE PEDIDO;
 *                  
 * 
 * 
 * 
 */