package com.desafio.api_insurance_calculator.infrastructure.repository;

import com.desafio.api_insurance_calculator.domain.Customer;
import com.desafio.api_insurance_calculator.domain.dto.CustomerRequest;
import com.desafio.api_insurance_calculator.domain.port.repository.CustomerRepositoryPort;
import com.desafio.api_insurance_calculator.infrastructure.entity.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerRepository implements CustomerRepositoryPort {

    private final SpringCustomerRepository springCustomerRepository;

    public CustomerRepository(SpringCustomerRepository springCustomerRepository) {
        this.springCustomerRepository = springCustomerRepository;
    }


    @Override
    public CustomerEntity save(Customer customer) {
        final CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());
        customerEntity.setDocument(customer.getDocument());
        customerEntity.setBirthday(customer.getBirthday());
        customerEntity.setLocation(customer.getLocation());
        customerEntity.setVehicleValue(customer.getVehicleValue());
        customerEntity.setInsuranceValue(customer.getInsuranceValue());

        final CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setName(customer.getName());
        customerRequest.setDocument(customer.getDocument());
        customerRequest.setBirthday(customer.getBirthday());
        customerRequest.setLocation(customer.getLocation());
        customerRequest.setVehicleValue(customer.getVehicleValue());
        customerRequest.setInsuranceValue(customer.getInsuranceValue());
      try {
            return springCustomerRepository.save(customerEntity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar cliente", e);
        }

    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return springCustomerRepository.findAll();
    }

}
