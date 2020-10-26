package courses.microservices.brewery.web.mappers;

import org.mapstruct.Mapper;

import courses.microservices.brewery.model.Beer;
import courses.microservices.brewery.model.BeerDto;

@Mapper
public interface BeerMapper {
  
  BeerDto beerToBeerDto(Beer beer);

  Beer beerDtoToBeer(BeerDto beerDto);

}
