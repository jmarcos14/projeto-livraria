package br.com.caelum.livraria.dao;


import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil implements Serializable{

	private static final long serialVersionUID = -1713748812089859387L;
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("livraria");

	public JPAUtil() {
		
	}	
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close(EntityManager em) {
		em.close();
	}
}


