Feature: Sign In

  Scenario: Connect toothbrush failed
    Given I accepted the privacy agreement
    When click the start button
    And start connect to toothbrush
    Then should get failed page

  @debug
  Scenario: Check Terms & Conditions
    Given cancel the privacy agreement
    When click the terms and condition link
    Then should open the terms page
