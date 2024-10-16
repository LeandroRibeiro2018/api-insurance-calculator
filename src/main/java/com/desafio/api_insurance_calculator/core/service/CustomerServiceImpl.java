package com.desafio.api_insurance_calculator.core.service;

import com.desafio.api_insurance_calculator.adapter.dto.CustomerResponse;
import com.desafio.api_insurance_calculator.adapter.repository.CustomerRepository;
import com.desafio.api_insurance_calculator.core.domain.Customer;
import com.desafio.api_insurance_calculator.core.port.CustomerServicePort;
import com.desafio.api_insurance_calculator.core.strategy.CalculationStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerServicePort {

    private final CalculationStrategyFactory strategyFactory;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CalculationStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }


    @Override
    public Customer calculateInsurance(Customer customer) {
      double insuranceValue = strategyFactory.getStrategy(customer).calculate(customer);
        customer.setInsuranceValue(insuranceValue);
        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
      customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}
