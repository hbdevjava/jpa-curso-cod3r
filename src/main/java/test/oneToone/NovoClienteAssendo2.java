package test.oneToone;

import infra.DAO;
import model.oneToone.Assento;
import model.oneToone.Cliente;

public class NovoClienteAssendo2 {

	public static void main(String[] args) {
		
		Assento assento = new Assento("02B");
		Cliente cliente = new Cliente("Janainna", assento);
		
		DAO<Object> dao = new DAO<>();
//		dao.insertTAllTransaction(cliente);// -> incluir atomico
		
		
		
		
		System.out.println(cliente.getAssento().getName());
		System.out.println(cliente.getAssento().getCliente().getName());
	}

}
