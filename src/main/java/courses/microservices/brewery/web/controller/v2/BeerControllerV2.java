package courses.microservices.brewery.web.controller.v2;

import java.util.UUID;

import javax.validation.Valid;

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

import courses.microservices.brewery.model.v2.BeerDtoV2;
import courses.microservices.brewery.services.v2.BeerServiceV2;

@RestController
@RequestMapping("api/v2/beer")
public class BeerControllerV2 {
  private final BeerServiceV2 beerServiceV2;

  public BeerControllerV2(BeerServiceV2 beerService) {
    this.beerServiceV2 = beerService;
  }
  
  @GetMapping("/{id}")
  public BeerDtoV2 getBeer(@PathVariable UUID id) {
    return beerServiceV2.findById(id);
  }

  @GetMapping
  public BeerDtoV2 getBeer() {
    return beerServiceV2.findById(null);
  }

  @PostMapping
  public ResponseEntity<Void> createBeeer(@Valid @RequestBody BeerDtoV2 beer) {
    var saved = beerServiceV2.save(beer);

    var headers = new HttpHeaders();
    headers.add("Location", "http://localhost:8080/api/v2/beer/" + saved.getId().toString());

    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }
  
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateBeer(@Valid @RequestBody BeerDtoV2 beer, @PathVariable UUID id) {
    beerServiceV2.save(beer);
  }

  @DeleteMapping("/{id}")
  public void deleteBeer(@PathVariable UUID id) {
    beerServiceV2.delete(id);
  }
}