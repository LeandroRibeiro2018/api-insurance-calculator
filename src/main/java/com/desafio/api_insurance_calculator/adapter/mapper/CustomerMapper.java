package com.desafio.api_insurance_calculator.adapter.mapper;

import com.desafio.api_insurance_calculator.adapter.dto.CustomerRequest;
import com.desafio.api_insurance_calculator.adapter.dto.CustomerResponse;
import com.desafio.api_insurance_calculator.core.domain.Customer;


//@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerRequest dto);

    CustomerResponse toCustomerResponse(Customer entity);

    CustomerRequest toCustomerRequest(Customer entity);


}
