Feature: QA Store My Account login
  Verify that user is able to log in to My Account

  Scenario Outline: Log in using valid credentials
    Given User has navigated to <url> with message <loginMessage>
    When User enters <username> and <password>
    And User clicks login button
    Then My Account page is displayed

    Examples:
    | url | username  | password  | loginMessage |
    | http://store.demoqa.com/products-page/your-account/ | cuctest | Test123 | You must be logged in to use this page. |
    | http://store.demoqa.com/products-page/your-account/ | cuctest2 | Test@12345 | You must be logged in to use this page. |