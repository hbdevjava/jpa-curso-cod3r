package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class AlterUser1 {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		User user = em.find(User.class, 1L);
		//System.out.println("E-mail: " + user.getEmail());
		user.setEmail("bia@outlook.com");
		em.merge(user); //-> Merge() � o metodo responsavel pela altera��o;
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
