package courses.microservices.brewery.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import courses.microservices.brewery.model.BeerDto;
import courses.microservices.brewery.services.BeerService;

@Service
public class BeerServiceImpl implements BeerService {
  @Override
  public BeerDto findById(UUID id) {
    return BeerDto.builder()
      .id(UUID.randomUUID())
      .name("Lucifer")
      .style("Pale Ale")
      .build();
  }

  @Override
  public BeerDto save(BeerDto beer) {
    return BeerDto.builder()
      .id(UUID.randomUUID())
      .name(beer.getName())
      .style(beer.getStyle())
      .build();
  }

  @Override
  public void delete(UUID id) {
    
  }
}