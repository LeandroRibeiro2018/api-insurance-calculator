package com.desafio.api_insurance_calculator.domain.mapper;

import com.desafio.api_insurance_calculator.domain.dto.CustomerRequest;
import com.desafio.api_insurance_calculator.domain.dto.CustomerResponse;
import com.desafio.api_insurance_calculator.domain.Customer;


//@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerRequest dto);

    CustomerResponse toCustomerResponse(Customer entity);

    CustomerRequest toCustomerRequest(Customer entity);


}
