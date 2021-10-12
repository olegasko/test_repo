@tmsLink=EQFX-POC-01
Feature: pet feature

  Scenario: create a pet
    Given pet 'Шарик' with photo Urls is created
      | https://google.com/search?q=%D0%A8%D0%B0%D1%80%D0%B8%D0%BA&tbm=isch |
    When I update the pet
      | https://www.google.com/search?q=%D0%9F%D1%91%D1%81%D0%B8%D0%BA&tbm=isch |
    Then I get updated pet
