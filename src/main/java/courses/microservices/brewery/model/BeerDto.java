package courses.microservices.brewery.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BeerDto {
  private UUID id;
  private String name;
  private String style;
  private Long upc;
}