package courses.microservices.brewery.model.v2;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class BeerDtoV2 {
  @Null
  private UUID id;
  @NotBlank
  private String name;
  private BeerStyle style;
  @Positive
  private Long upc;
}