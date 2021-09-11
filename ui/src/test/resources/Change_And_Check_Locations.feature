@tmsLink=EQFX-POC-02
Feature: Change And Check Locations feature

  Scenario Outline: Check List Of Locations

    Given user is on the EPAM main page
    When user clicks on menu button
    Then menu is open
    And activate Location "<region>" & "<lang>"
    And Location is "<region> (<lang>)"

    Examples:
      | region          | lang |
      | Global          | EN   |
      | Hungary         | EN   |
      | Беларусь        | РУ   |
      | Czech Republic  | EN   |
      | India           | EN   |
      | Россия          | РУ   |
      | Česká Republika | CS   |
      | Polska          | PL   |
      | Україна         | UA   |
      | DACH            | DE   |
      | 中国              | 中文   |

