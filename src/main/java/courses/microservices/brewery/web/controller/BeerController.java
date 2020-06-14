package courses.microservices.brewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import courses.microservices.brewery.model.BeerDto;
import courses.microservices.brewery.services.BeerService;

@RestController
@RequestMapping("api/v1/beer")
public class BeerController {
  private final BeerService beerService;

  public BeerController(BeerService beerService) {
    this.beerService = beerService;
  }
  
  @GetMapping("/{id}")
  public BeerDto getBeer(@PathVariable UUID id) {
    return beerService.findById(id);
  }

  @GetMapping
  public BeerDto getBeer() {
    return beerService.findById(null);
  }

  @PostMapping
  public ResponseEntity<Void> createBeeer(@RequestBody BeerDto beer) {
    var saved = beerService.save(beer);

    var headers = new HttpHeaders();
    headers.add("Location", "http://localhost:8080/api/v1/beer/" + saved.getId().toString());

    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }
  
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateBeer(@RequestBody BeerDto beer, @PathVariable UUID id) {
    beerService.save(beer);
  }

  @DeleteMapping("/{id}")
  public void deleteBeer(@PathVariable UUID id) {
    beerService.delete(id);
  }
}