package courses.microservices.brewery.services.v2;

import java.util.UUID;

import courses.microservices.brewery.model.v2.BeerDtoV2;

public interface BeerServiceV2 {
  BeerDtoV2 findById(UUID id);

	BeerDtoV2 save(BeerDtoV2 beer);

	void delete(UUID id);
}