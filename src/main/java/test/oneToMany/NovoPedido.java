package test.oneToMany;



import infra.DAO;
import model.basic.Produto;
import model.oneToMany.ItemPedido;
import model.oneToMany.Pedido;

public class NovoPedido {

	public static void main(String[] args) {
		DAO<Object> dao = new DAO<Object>();
		
		
		
		
		Pedido pedido = new Pedido();
		Produto produto = new Produto("Relogio", 3458.33);
		ItemPedido item = new ItemPedido(pedido, produto, 10);
		
		
		dao.openTransaction()
		.include(pedido)
		.include(produto)
		.include(item)
		.closeTransaction()
		.closeDAO();

	}

}
