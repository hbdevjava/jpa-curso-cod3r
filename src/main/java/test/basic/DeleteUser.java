package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class DeleteUser {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		User user = em.find(User.class, 9L);
		
		if(user != null) {
			em.remove(user);
		}
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();


	}

}
