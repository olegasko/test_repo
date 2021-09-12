@tmsLink=EQFX-POC-01
Feature: Change And Check Locations feature

  Scenario Outline: Check List Of Locations

    Given user is on the EPAM main page
    When user clicks on menu button
    Then menu is open
    And activate Location "<region>" & "<lang>"
    And Location is "<region> (<lang>)"

    Examples:
      | №  | region          | lang |
      | 1  | Global          | EN   |
      | 2  | Hungary         | EN   |
      | 3  | Беларусь        | РУ   |
      | 4  | Czech Republic  | EN   |
      | 5  | India           | EN   |
      | 6  | Россия          | РУ   |
      | 7  | Česká Republika | CS   |
      | 8  | Polska          | PL   |
      | 9  | Україна         | UA   |
      | 10 | DACH            | DE   |
      | 11 | 中国              | 中文   |

