Feature: Test


Scenario: task 1
  Given user is on the EPAM main page
  When user click on link 'Services' in header
  Then user on the page 'Services'


Scenario: task 2
  Given user is on the EPAM main page
  When user click on link 'How We Do It' in header
  Then user on the page 'How We Do It'
  And user can see blocks 'Why EPAM?'
  And blocks has correct order
   | Growth | Global | Developers’ Developers | Solutions Not Just Services |