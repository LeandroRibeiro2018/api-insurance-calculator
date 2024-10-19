package com.desafio.api_insurance_calculator.infrastructure.config;

import com.desafio.api_insurance_calculator.domain.port.interfaces.CustomerServicePort;
import com.desafio.api_insurance_calculator.domain.adapter.service.CustomerServiceImpl;
import com.desafio.api_insurance_calculator.domain.port.repository.CustomerRepositoryPort;
import com.desafio.api_insurance_calculator.infrastructure.strategy.CalculationStrategyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public CustomerServicePort customerService(CalculationStrategyFactory strategyFactory, CustomerRepositoryPort customerRepositoryPort) {
        return new CustomerServiceImpl(strategyFactory, customerRepositoryPort);
    }

}
