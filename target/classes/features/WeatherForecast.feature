
Feature: Weather forecast

  Scenario: Get current weather forecast.
    Given I have city name "Mumbai"
    When  I do call to weather forecast api for current weather
    Then  I receive current weather forecast for "Mumbai"