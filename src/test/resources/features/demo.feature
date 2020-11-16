Feature: Sign In

  @debug
  Scenario: Connect toothbrush failed
    Given I accepted the privacy agreement
    When click the start button
    And start connect to toothbrush
    Then should get failed page

  Scenario: Check Terms & Conditions
    Given cancel the privacy agreement
    When click the terms and condition link
    Then should open browser

  Scenario: Check Privacy Policy
    Given cancel the privacy agreement
    When click the privacy policy link
    Then should open browser
