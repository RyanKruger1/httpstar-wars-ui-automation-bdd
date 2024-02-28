Feature: Start Wars - UI test cases

  Scenario: Validate sorting functionality of UI
    Given I navigate to website: "http://localhost:3000/" using browser: "chrome"
    When I sort movie table by "Title"
    Then I validate the last movie is "The Phantom Menace"

  Scenario Outline: Validate that item is contained in Species List
    Given I navigate to website: "http://localhost:3000/" using browser: "chrome"
    When I inspect movie 'The Empire Strikes Back'
    Then I validate 'Species' contain '<species>'
    Examples:
      | species |
      | Wookie  |
      | Human  |


  Scenario: Validate that item is not contained in planets list
    Given I navigate to website: "http://localhost:3000/" using browser: "chrome"
    When I inspect movie 'The Phantom Menace'
    Then I validate 'Planets' does not contain 'Camino'