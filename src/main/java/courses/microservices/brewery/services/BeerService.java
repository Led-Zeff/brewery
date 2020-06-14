package courses.microservices.brewery.services;

import java.util.UUID;

import courses.microservices.brewery.model.BeerDto;

public interface BeerService {
	BeerDto findById(UUID id);

	BeerDto save(BeerDto beer);

	void delete(UUID id);
}