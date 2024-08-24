Feature: As a user, I need to make a hotel reservation.

  @reservation
  Scenario Outline: Make a hotel reservation
    Given The user enters the hotel reservation page
    When Search for the hotel and specify the conditions
      | <location> | <checkin> | <checkout> | <rooms> | <adults> | <children> | <rate_min> | <rate_max> | <score> |
    Then look for the best option and make the reservation
      | <email> | <password> |
    And validates the successful reservation

    Examples:
      | location       | checkin     | checkout    | rooms | adults | children | rate_min | rate_max | score | email | password |
      | Las Vegas, USA | 23 Aug 2024 | 28 Aug 2024 | 2     | 3      | 2        | 200      | 500      | 3     |       |          |