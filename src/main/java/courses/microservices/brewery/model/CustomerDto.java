package courses.microservices.brewery.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class CustomerDto {
  private UUID id;
  private String name;
}