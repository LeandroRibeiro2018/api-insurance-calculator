package com.desafio.api_insurance_calculator.domain.mapper;

import com.desafio.api_insurance_calculator.domain.dto.CustomerRequest;
import com.desafio.api_insurance_calculator.domain.dto.CustomerResponse;
import com.desafio.api_insurance_calculator.domain.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public Customer toCustomer(CustomerRequest dto) {
        if (dto == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setDocument(dto.getDocument());
        customer.setBirthday(dto.getBirthday());
        customer.setLocation(dto.getLocation());
        customer.setVehicleValue(dto.getVehicleValue());
        return customer;
    }

    @Override
    public CustomerResponse toCustomerResponse(Customer entity) {
       if (entity == null) {
            return null;
        }
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setName(entity.getName());
        customerResponse.setLocation(entity.getLocation());
        customerResponse.setInsuranceValue(entity.getInsuranceValue());
        return customerResponse;
    }

    @Override
    public CustomerRequest toCustomerRequest(Customer entity) {
        if (entity == null) {
            return null;
        }
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setName(entity.getName());
        customerRequest.setDocument(entity.getDocument());
        customerRequest.setBirthday(entity.getBirthday());
        customerRequest.setLocation(entity.getLocation());
        customerRequest.setVehicleValue(entity.getVehicleValue());
        return customerRequest;
    }
}
