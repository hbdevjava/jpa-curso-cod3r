package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class GetUser {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		User otherUser = em.find(User.class, 2l);
		System.out.println("Id: " + otherUser.getId());
		System.out.println("Name: " + otherUser.getNome());
		System.out.println("E-mail: " + otherUser.getEmail());
		
		
		 
		em.close();
		emf.close();
	
		
		
		
		
		
		
		

	}

}
