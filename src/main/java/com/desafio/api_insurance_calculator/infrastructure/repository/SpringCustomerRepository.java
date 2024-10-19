package com.desafio.api_insurance_calculator.infrastructure.repository;

import com.desafio.api_insurance_calculator.domain.Customer;
import com.desafio.api_insurance_calculator.infrastructure.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringCustomerRepository extends JpaRepository<CustomerEntity, Long>{

}
