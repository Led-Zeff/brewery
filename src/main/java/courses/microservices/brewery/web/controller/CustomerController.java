package courses.microservices.brewery.web.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import courses.microservices.brewery.model.CustomerDto;
import courses.microservices.brewery.services.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
  private CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/{id}")
  public CustomerDto getCustomer(@PathVariable UUID id) {
    return customerService.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CustomerDto createCustomer(@Valid @RequestBody CustomerDto customer) {
    return customerService.save(customer);
  }

  @PutMapping("/{id}")
  public CustomerDto updateCustomer(@PathVariable UUID id, @RequestBody CustomerDto customer) {
    customer.setId(id);
    return customerService.save(customer);
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable UUID id) {
    customerService.delete(id);
  }
}