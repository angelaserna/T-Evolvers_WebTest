Feature: As a user, I need to authenticate in the web application

  @failed
  Scenario Outline: Login in Demo DX Hotels
    Given The user enters the hotel reservation page
    When  I authenticate in Demo DX Hotels with <email> and <password>
    Then I verify the result obtained from the authentication

    Examples:
      | email         | password |
      | test@test.com | 123456   |