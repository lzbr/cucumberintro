Feature: QA Store My Account login
  Verify that user is able to log in to My Account

  Scenario: Log in using valid credentials
    Given User has navigated to <url>
    When User enters <username> and <password>
    And User clicks login button
    Then My Account page is displayed