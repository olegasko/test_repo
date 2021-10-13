Feature: Test


Scenario: task 1
  Given user is on the EPAM main page
  When user click on link 'Link' in header
  Then user on the page 'Page'


Scenario: task 2
  Given user is on the EPAM main page
  When user click on link 'How we do it' on header
  Then user on page 'How we do it'
  And user can see blocks 'Why EPAM?'
  And blocks has correct order