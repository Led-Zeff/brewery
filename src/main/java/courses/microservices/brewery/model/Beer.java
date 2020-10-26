package courses.microservices.brewery.model;

import java.util.UUID;

import courses.microservices.brewery.model.v2.BeerStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Beer {
  private UUID id;
  private String name;
  private BeerStyle style;
  private Long upc;
}
