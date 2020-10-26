package courses.microservices.brewery.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BeerDto {
  @Null
  private UUID id;
  @NotBlank
  private String name;
  @NotBlank
  private String style;
  @Positive
  private Long upc;

  private OffsetDateTime createdDate;
  private OffsetDateTime lastUpdatedDate;
}