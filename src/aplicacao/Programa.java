package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		Pessoa p1 = new Pessoa(null, "José Carlos", "jose.carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Maria Rita", "mariarita@gmail.com");
		Pessoa p3 = new Pessoa(null, "Carlos Santana", "carlossantana@gmail.com");
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		Pessoa p = em.find(Pessoa.class, 2);
		
		System.out.println(p);
		
		em.remove(p);
		
		em.getTransaction().commit();
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

}
