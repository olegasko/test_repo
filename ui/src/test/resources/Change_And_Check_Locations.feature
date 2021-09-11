@tmsLink=EQFX-POC-02
Feature: Change And Check Locations feature

  Scenario: Change And Check Locations 'Україна (UA)' and 'Global (EN)'

    Given on the EPAM main page

    When click on Menu button
    Then menu is open
    And activate Location 'Україна (UA)'
    And Location is 'Україна (UA)'

    And click on Menu button
    And menu is open
    And activate Location 'Global (EN)'
    And Location is 'Global (EN)'