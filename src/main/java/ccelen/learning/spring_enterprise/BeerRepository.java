package ccelen.learning.spring_enterprise;

import java.util.List;

import ccelen.learning.spring_enterprise.beers.domain.Beer;

public interface BeerRepository {
	public Beer getBeerById(int id);
	public List<Beer> getBeerByAlcohol(float alchohol);
	public void updateBeer(Beer b);
}
