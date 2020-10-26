package courses.microservices.brewery.web.mappers;

import org.mapstruct.Mapper;

import courses.microservices.brewery.model.Customer;
import courses.microservices.brewery.model.CustomerDto;

@Mapper
public interface CustomerMapper {
  CustomerDto customerToDto(Customer customer);
  Customer dtoToCustomer(CustomerDto customerDto);
}
