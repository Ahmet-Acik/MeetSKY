@MTSK-413
Feature: Log out functionality
  As a user, I should be able to log out.


  @MTSK-411
  Scenario: User can log out and land in login page
    Given User logs in with valid credentials
    Given User clicks to Expandable content button on top-right corner
    When User Clicks Log out button
    Then User should be logged out successfully and can see the login page

  @MTSK-412
  Scenario: User can not go to home page again by clicking step back button after successfully logged out.
    Given User logs in with valid credentials
    Given User clicks to Expandable content button on top-right corner
    When User Clicks Log out button
    Then User should be logged out successfully and can see the login page
    And User should not be able to go to home page again by clicking step back button