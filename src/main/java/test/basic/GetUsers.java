package test.basic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.basic.User;

public class GetUsers {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();

//		String jpql = "Select u from User u";
//		TypedQuery<User> query = em.createQuery(jpql, User.class);
//		query.setMaxResults(3);

		List<User> queryList = em
				.createQuery("Select u from User u", User.class)
				.setMaxResults(5) // QTD MAX FOR RESULT
				.getResultList();
		for (User userList : queryList) {
			System.out.println("Id: " + userList.getId());
			System.out.println("Name: " + userList.getNome());
			System.out.println("E-mail: " + userList.getEmail());
		}

		em.close();
		emf.close();
	}

}
