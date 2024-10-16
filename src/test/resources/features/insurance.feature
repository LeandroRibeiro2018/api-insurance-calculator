Feature: Insurance Calculation


  Scenario: Calculate insurance for a vehicle with value <= 70000 in SP
    Given a customer with name "Maria", location "SP", and vehicle value 70000
    When the insurance is calculated
    Then the insurance insuranceValue should be 3500.0

  Scenario: Calculate insurance for a vehicle with value > 70000 and < 100000
    Given a customer with name "Carlos", location "RJ", and vehicle value 90000
    When the insurance is calculated
    Then the insurance insuranceValue should be 4950.0

  Scenario: Calculate insurance for a vehicle with value >= 100000
    Given a customer with name "Ana", location "RJ", and vehicle value 100000
    When the insurance is calculated
    Then the insurance insuranceValue should be 6000.0