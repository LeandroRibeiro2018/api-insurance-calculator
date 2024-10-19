package com.desafio.api_insurance_calculator.domain.adapter.service;

import com.desafio.api_insurance_calculator.domain.port.repository.CustomerRepositoryPort;
import com.desafio.api_insurance_calculator.domain.Customer;
import com.desafio.api_insurance_calculator.domain.port.interfaces.CustomerServicePort;
import com.desafio.api_insurance_calculator.infrastructure.entity.CustomerEntity;
import com.desafio.api_insurance_calculator.infrastructure.strategy.CalculationStrategyFactory;

import java.util.List;

public class CustomerServiceImpl implements CustomerServicePort {

    private final CalculationStrategyFactory strategyFactory;


    private final CustomerRepositoryPort customerRepositoryPort;


    public CustomerServiceImpl(CalculationStrategyFactory strategyFactory, CustomerRepositoryPort customerRepositoryPort) {
        this.strategyFactory = strategyFactory;
        this.customerRepositoryPort = customerRepositoryPort;
    }


    @Override
    public Customer calculateInsurance(Customer customer) {
      double insuranceValue = strategyFactory.getStrategy(customer).calculate(customer);
        customer.setInsuranceValue(insuranceValue);
        return customer;
    }

    @Override
    public Customer saveCustomer(Customer customerRequest) {
        final Customer customer = new Customer(
                customerRequest.getName(),
                customerRequest.getDocument(),
                customerRequest.getBirthday(),
                customerRequest.getLocation(),
                customerRequest.getVehicleValue(),
                customerRequest.getInsuranceValue());
        this.customerRepositoryPort.save(customer);

        return customerRequest;
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return this.customerRepositoryPort.getAllCustomers();
    }


}
