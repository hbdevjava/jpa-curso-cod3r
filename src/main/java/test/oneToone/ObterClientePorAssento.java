package test.oneToone;

import infra.DAO;
import model.oneToone.Assento;
import model.oneToone.Cliente;

public class ObterClientePorAssento {

	public static void main(String[] args) {

		DAO<Cliente> daoCliente = new DAO<>(Cliente.class);
		Cliente cliente = daoCliente.getbyId(4L);
		System.out.println("Assento: " + cliente.getAssento().getName());
		daoCliente.closeDAO();
		//-> RELAÇAO BIDIRECIONAL: OBTER ASSENTO A PARTIR DE CLIENTE
		
		
		DAO<Assento> daoAssento = new DAO<>(Assento.class);
		Assento assento = daoAssento.getbyId(4L);
		System.out.println("Cliente: " + assento.getCliente().getName());
		daoAssento.closeDAO();
		//-> RELAÇAO BIDIRECIONAL: OBTER CLIENTE A PARTIR DE ASSENTO

	}

}
