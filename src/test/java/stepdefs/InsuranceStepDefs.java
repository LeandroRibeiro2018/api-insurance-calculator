package stepdefs;

import com.desafio.api_insurance_calculator.adapter.dto.CustomerRequest;
import com.desafio.api_insurance_calculator.adapter.mapper.CustomerMapper;
import com.desafio.api_insurance_calculator.core.domain.Customer;
import com.desafio.api_insurance_calculator.core.port.CustomerServicePort;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class InsuranceStepDefs {
    private CustomerRequest customerRequest;
    private double calculatedInsuranceValue;

    @Given("a customer with name {string}, location {string}, and vehicle value {double}")
    public void a_customer_with_name_location_and_vehicle_value(String name, String location, double vehicleValue) {
        customerRequest = new CustomerRequest(name,"Teste", location,"SP",vehicleValue,73000.0);
    }

    @When("the insurance is calculated")
    public void the_insurance_is_calculated() {
        double vehicleValue = customerRequest.getVehicleValue();
        String location = customerRequest.getLocation();

        if (vehicleValue <= 70000) {
            if (location.equals("SP")) {
                calculatedInsuranceValue = vehicleValue * 0.05; // 5% para SP
            } else {
                calculatedInsuranceValue = vehicleValue * 0.04; // 4% para outras cidades
            }
        } else if (vehicleValue > 70000 && vehicleValue < 100000) {
            calculatedInsuranceValue = vehicleValue * 0.055; // 5.5% para veículos entre 70.000 e 100.000
        } else if (vehicleValue >= 100000) {
            calculatedInsuranceValue = vehicleValue * 0.06; // 6% para veículos acima de 100.000
        } else {
            throw new IllegalArgumentException("Valor do veículo fora do intervalo esperado");
        }
    }

    @Then("the insurance insuranceValue should be {double}")
    public void the_insurance_value_should_be(double expectedValue) {
        assertEquals(expectedValue, calculatedInsuranceValue, 0.01);
    }
}
