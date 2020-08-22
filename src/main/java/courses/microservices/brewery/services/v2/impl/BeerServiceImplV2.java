package courses.microservices.brewery.services.v2.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import courses.microservices.brewery.model.v2.BeerDtoV2;
import courses.microservices.brewery.model.v2.BeerStyle;
import courses.microservices.brewery.services.v2.BeerServiceV2;

@Service
public class BeerServiceImplV2 implements BeerServiceV2 {

  @Override
  public BeerDtoV2 findById(UUID id) {
    return BeerDtoV2.builder()
      .id(UUID.randomUUID())
      .name("Lucifer")
      .style(BeerStyle.GOSE)
      .build();
  }

  @Override
  public BeerDtoV2 save(BeerDtoV2 beer) {
    return BeerDtoV2.builder()
      .id(UUID.randomUUID())
      .name(beer.getName())
      .style(beer.getStyle())
      .build();
  }

  @Override
  public void delete(UUID id) {
    
  }
  
}