@BearerToken
Feature: Generate Bearer Token

  Scenario Outline: User should be able to generate Bearer Token Successfully
    Given User should have the Bearer Token base URL
    When User initiates post call by using endpoint along with query params Username,Pasword,ClientId,Client_Secret
    And User should get status code as "200" in response
    Then User verifies bearer token is generated and present in the response
