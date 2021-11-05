Feature: Check_Why_EPAM_Blocks_order_and_Open_Pages_With_Examples

Scenario Outline: Open and check page
  Given user is on the EPAM main page
  When user click on link '<Page>' in header
  Then user on the page '<Header>'
  Examples:
  | Page            | Header          |
  | Services        | Services        |
  | How We Do It    | How We Do It    |
  | Our Work        | Our Work        |
  | Insights        | Insights        |
  | About           | About           |
  | Careers         | Work with Us    |

Scenario: Check Why EPAM blocks order on How We Do It page
  Given user is on the EPAM main page
  When user click on link 'How We Do It' in header
  Then user on the page 'How We Do It'
  And user can see blocks 'WHY EPAM?'
  And blocks has correct order
   | Growth | Global | Developers’ Developers | Solutions Not Just Services |