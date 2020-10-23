package courses.microservices.brewery.web.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import lombok.extern.slf4j.Slf4j;

@Slf4j
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

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public List<String> validationErrorHandler(ConstraintViolationException e) {
    log.error(e.getMessage(), e);
    return e.getConstraintViolations().stream().map(cv -> cv.getPropertyPath() + " " + cv.getMessage()).collect(Collectors.toList());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public List<String> argumentNotValid(MethodArgumentNotValidException e) {
    log.error(e.getMessage(), e);
    return e.getBindingResult().getFieldErrors().stream().map(fe -> fe.getField() + " -> " + fe.getDefaultMessage()).collect(Collectors.toList());
    // return e.getBindingResult().getAllErrors().stream().map(error -> e.getParameter().getParameterName() + e.).collect(Collectors.toList());
  }
}