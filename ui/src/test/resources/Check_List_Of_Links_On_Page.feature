@tmsLink=EQFX-POC-03
Feature: Check List Of Links On Investors Page feature

  Scenario: Check List Of Links

    Given user is on the EPAM main page
    When user clicks on the link "Investors" on footer
    Then user can see "Investors" page
    And user can see the <List Of Links> on this page
    And the <List Of Links> has correct order