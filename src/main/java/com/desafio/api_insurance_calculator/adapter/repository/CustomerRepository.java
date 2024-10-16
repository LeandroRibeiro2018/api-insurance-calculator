package com.desafio.api_insurance_calculator.adapter.repository;

import com.desafio.api_insurance_calculator.core.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
