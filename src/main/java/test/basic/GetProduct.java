package test.basic;

import java.util.List;

import infra.ProductDAO;
import model.basic.Produto;

public class GetProduct {

	public static void main(String[] args) {
		
		
		ProductDAO dao = new ProductDAO();
		List<Produto> products = dao.getAll();
		
		for (Produto product : products) {
			System.out.println(product);
		}
		System.out.println();
		products.stream().forEach(System.out::println);
		
		System.out.println();
		double amount = products
				.stream()
				.map(p -> p.getPreco())
				.reduce(0.0, (t, p) -> t + p).doubleValue();
		System.out.println("Amount: " + amount);
		
		dao.closeDAO();
		
	}

}
