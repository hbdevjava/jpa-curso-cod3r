package test.basic;

import infra.DAO;
import model.basic.Produto;

public class NewProduct {

	public static void main(String[] args) {
		DAO<Produto> dao = new DAO<>();
		Produto prod = new Produto("Iphone 14Pro Max", 8524.22);
		Produto prod1 = new Produto("Airs Pods", 1500.21);
		Produto prod2 = new Produto("Mac Book Pro Max", 1524.22);
		Produto prod3 = new Produto("Airs Tag", 224.02);
		Produto prod4 = new Produto("Phone Pro", 124.22);
		
		
		
		dao.insertTAllTransaction(prod4).closeDAO();
		
		dao.openTransaction()
		.include(prod2)
		.closeTransaction()
		.closeDAO();
		
		
		
		

	}

}
