package infra;

import java.util.List;
import java.util.NoSuchElementException;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.basic.Produto;
import model.basic.User;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			// log
		}
	}

	public DAO() {
		this(null);
	}

	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();

	}

	public DAO<E> openTransaction() {
		em.getTransaction().begin();
		return this;
	}

	public DAO<E> closeTransaction() {
		em.getTransaction().commit();
		return this;
	}

	public DAO<E> include(E entity) {
		em.persist(entity);
		return this;
	}
	
	public E getbyId(Object id) {
		return em.find(classe, id);
	}

	public DAO<E> insertTAllTransaction(E entity) {
		openTransaction();
		em.persist(entity);
		closeTransaction();
		return this;
	}

	public List<E> getAll(int limit, int ofset) {
		if (classe == null) {
			throw new UnsupportedOperationException("Classe Nula");
		}
		String jpql = "Select e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(limit);
		query.setFirstResult(ofset);
		return query.getResultList();
	}

	public List<E> getAll() {
		return this.getAll(10, 0);
	}
	
//	public Long delete(long id) {
//		em.remove(id);
//		return id;
//	}
		

	public void closeDAO() {
		em.close();
	}
	
	public List<E> consultar(String nomeConsulta, Object...params ){//-> ...ARGUMENTOS VARIAVEIS DE OBJETOS (NO PYTHON **ARGS)
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		for (int i = 0; i < params.length; i+= 2) {
			query.setParameter(params[i].toString(), params[i + 1]);
		}
		return query.getResultList();
	}
		
		
	
	
	

}
