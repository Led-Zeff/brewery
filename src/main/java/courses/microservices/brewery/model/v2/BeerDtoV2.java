package courses.microservices.brewery.model.v2;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class BeerDtoV2 {
  private UUID id;
  private String name;
  private BeerStyle style;
  private Long upc;
}