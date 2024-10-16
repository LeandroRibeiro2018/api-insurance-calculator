package stepdefs;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class InsuranceRestAssuredTest {

    @Test
    public void testCalculateInsuranceForLowValueStrategy() {
        RestAssured.baseURI = "http://localhost:8080/insurance";

        String requestBody = """
            {
              "name": "João",
              "document": "123.456.789-10",
              "birthday": "1990-07-10",
              "location": "BH",
              "vehicleValue": 70000
            }
        """;

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/calculate");

        assertEquals(200, response.getStatusCode());

        if(response.jsonPath().get("insuranceValue") != null){
        assertEquals(2800.0, response.jsonPath().getDouble("insuranceValue"));
    }else {
            fail("A chave 'insuranceValue' não foi encontrada no corpo da resposta.");
        }
        }

    @Test
    public void testCalculateInsuranceForSP() {
        RestAssured.baseURI = "http://localhost:8080/insurance";

        String requestBody = """
            {
              "name": "Maria",
              "document": "987.654.321-00",
              "birthday": "1985-05-15",
              "location": "SP",
              "vehicleValue": 70000
            }
        """;

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/calculate");

        assertEquals(200, response.getStatusCode());
        if (response.jsonPath().get("insuranceValue") != null) {
            assertEquals(3500.0, response.jsonPath().getDouble("insuranceValue"));
        } else {
            fail("Campo 'value' não encontrado na resposta.");
        }
        assertEquals(3500.0, response.jsonPath().getDouble("insuranceValue"));
    }
}

