
Feature: App2 User management using feign client and rest template

  Scenario: Get user using Feign Client
    Given App1 is running
    When I call GET endpoint "/app2/api/user/feign/1"
    Then the response status should be 200
    And the response body should contain the user details
  Scenario: Get user using RestTemplate
    Given App1 is running
    When I call GET endpoint "/app2/api/user/rest/1"
    Then the response status should be 200
    And the response body should contain the user details
    
