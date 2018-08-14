Feature: QA Store demo website
  Example scenarios

  Scenario Outline: Log in using valid credentials
    Given User has navigated to <url> with message <loginMessage>
    When User enters <username> and <password>
    And User clicks login button
    Then My Account page is displayed

    Examples:
    | url | username  | password  | loginMessage |
    | http://store.demoqa.com/products-page/your-account/ | cuctest | Test123 | You must be logged in to use this page. |
    | http://store.demoqa.com/products-page/your-account/ | cuctest2 | Test@12345 | You must be logged in to use this page. |


  Scenario Outline:  Page title check - check, that selected page has appropriate page title
    Given User has navigated to <homepage> with page title <title>
    When User selects <entry> from header menu <menuCategoryXPath>
    Then Apropriate page with correct <pagetitle> is loaded

    Examples:
    | homepage | title | entry | menuCategoryXPath | pagetitle |
    | http://store.demoqa.com/ | ONLINE STORE \| Toolsqa Dummy Test site | menu-item-34 | //nav[@id='main-nav']//a[contains(text(),'Product Category')]/.. | Accessories \| ONLINE STORE |