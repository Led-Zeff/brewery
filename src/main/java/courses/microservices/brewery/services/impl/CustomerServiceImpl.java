package courses.microservices.brewery.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import courses.microservices.brewery.model.CustomerDto;
import courses.microservices.brewery.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
  @Override
  public CustomerDto findById(UUID id) {
    return CustomerDto.builder()
        .id(UUID.randomUUID())
        .name("John")
        .build();
  }

  @Override
  public CustomerDto save(CustomerDto customer) {
    if (customer.getId() == null) {
      customer.setId(UUID.randomUUID());
    }
    return customer;
  }

  @Override
  public void delete(UUID id) {
  }
}