package com.desafio.api_insurance_calculator.adapter.controller;

import com.desafio.api_insurance_calculator.domain.dto.CustomerRequest;
import com.desafio.api_insurance_calculator.domain.dto.CustomerResponse;
import com.desafio.api_insurance_calculator.domain.mapper.CustomerMapper;
import com.desafio.api_insurance_calculator.domain.Customer;
import com.desafio.api_insurance_calculator.domain.port.interfaces.CustomerServicePort;
import com.desafio.api_insurance_calculator.adapter.exception.InsuranceCalculationException;
import com.desafio.api_insurance_calculator.infrastructure.entity.CustomerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    private static final Logger logger = LoggerFactory.getLogger(InsuranceController.class);

    private final CustomerServicePort customerService;
    private final CustomerMapper customerMapper;

    @Autowired
    public InsuranceController(CustomerServicePort customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }


    @PostMapping("/calculate")
    public ResponseEntity<CustomerResponse> calculateInsurance(@RequestBody CustomerRequest customerRequest) throws InsuranceCalculationException {
        logger.info("Recebida requisição para calcular seguro: {}", customerRequest);
        Customer customer = customerMapper.toCustomer(customerRequest);
        if (customer.getVehicleValue() == 0.0) {
            logger.error("Valor do veículo inválido: {}", customer.getVehicleValue());
            return ResponseEntity.badRequest().body(new CustomerResponse("Valor do veículo inválido"));
        }

        try {
            customer = customerService.calculateInsurance(customer);
            logger.info("Seguro calculado com sucesso: {}", customer);
            CustomerResponse customerResponse = customerMapper.toCustomerResponse(customer);
            customerService.saveCustomer(customer);
            logger.info("Seguro salvo no banco de dados: {}", customer);
            return ResponseEntity.ok(customerResponse);
        } catch (InsuranceCalculationException e) {
            logger.error("Erro específico ao calcular seguro: {}", e.getMessage(), e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomerResponse("Erro ao calcular seguro"));
        } catch (Exception e) {
            logger.error("Erro inesperado ao calcular seguro: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomerResponse("Erro inesperado"));
        }
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers() {

        logger.info("Recebida requisição para obter todos os clientes");

        List<CustomerEntity> customers = customerService.getAllCustomers();

        if (customerService.getAllCustomers().isEmpty()) {
            logger.warn("Nenhum cliente encontrado");
            Map<String, String> message = new HashMap<>();
            message.put("message", "Nenhum cliente encontrado");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(customers);
    }


}
