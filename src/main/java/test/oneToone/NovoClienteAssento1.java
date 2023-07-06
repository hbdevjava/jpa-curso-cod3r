package test.oneToone;

import infra.DAO;
import model.oneToone.Assento;
import model.oneToone.Cliente;


public class NovoClienteAssento1 {

	public static void main(String[] args) {
		
		Assento assento = new Assento("30H");
		Cliente cliente = new Cliente("Joao", assento);
		
		DAO<Object> dao = new DAO<>();
		
		dao.openTransaction()
		.include(assento)
		.include(cliente)
		.closeTransaction()
		.closeDAO();
	}

}
