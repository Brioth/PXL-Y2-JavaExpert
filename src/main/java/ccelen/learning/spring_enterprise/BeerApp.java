package ccelen.learning.spring_enterprise;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ccelen.learning.spring_enterprise.beers.domain.Beer;

public class BeerApp 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext ctx = SpringApplication.run(BeerAppConfig.class, args);
        BeerRepository repo = ctx.getBean("beerRepository", BeerRepository.class);
        Beer beer = repo.getBeerById(1);

        System.out.println("beer by id: " + beer);
        
        List<Beer> beers = repo.getBeerByAlcohol(2.75f);
        System.out.println("beer by alc: ");
        for (Beer beerAlc : beers) {
			System.out.println(beerAlc);
		}
        
        System.out.println("update beer: ");
        System.out.println(beer.getStock());
        beer.setStock(200);
        System.out.println(beer.getStock());
    }
}
