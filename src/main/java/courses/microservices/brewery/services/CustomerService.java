package courses.microservices.brewery.services;

import java.util.UUID;

import courses.microservices.brewery.model.CustomerDto;

public interface CustomerService {
  CustomerDto findById(UUID id);
  CustomerDto save(CustomerDto customer);
  void delete(UUID id);
}