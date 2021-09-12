@tmsLink=EQFX-POC-03
Feature: Check List Of Links On Investors Page feature

  Scenario: Check List Of Links

    Given user is on the EPAM main page
    When user clicks on the link 'Investors' on footer
    Then user can see 'https://investors.epam.com/investors' page
    And user can see list of links on this page
    And list has correct order
      | Stock Price | Quarterly Earnings | SEC Filings | News | Events | Leadership & Governance | FAQ | Contact Investor Relations |