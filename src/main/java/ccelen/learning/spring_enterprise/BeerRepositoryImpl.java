package ccelen.learning.spring_enterprise;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ccelen.learning.spring_enterprise.beers.domain.Beer;

@Repository("beerRepository")
public class BeerRepositoryImpl implements BeerRepository{
	private EntityManagerFactory emf;
	
	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public Beer getBeerById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Beer beer = em.find(Beer.class, id);
		tx.commit();
		em.close();
		return beer;
	}
	
	public List<Beer> getBeerByAlcohol(float alcohol){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Beer> query = em.createQuery("Select b from Beers as b where b.Alcohol=:alc", Beer.class);
		query.setParameter("alc", alcohol);
		List<Beer> beers = query.getResultList();
		tx.commit();
		em.close();
		return beers;	
	}
	
	public void updateBeer(Beer b) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Beer old = em.find(Beer.class, b.getId());
		em.merge(b);
		tx.commit();
		em.close();		
	}
}
