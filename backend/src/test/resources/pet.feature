@tmsLink=EQFX-POC-01
Feature: pet feature

  Scenario: create a pet
    Given pet is created
    When I update a pet
    Then I get updated pet
