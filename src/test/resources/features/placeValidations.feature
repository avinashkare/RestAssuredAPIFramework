Feature: Validating place API

@AddPlace @Regression
Scenario Outline: Check if place is being added by AddPlaceAPI
  Given AddPlaceAPI payload with "<name>" "<address>" "<language>"
  When User hits "addPlaceAPI" "post" HTTP request call
  Then API call should be successful with status code 200
  And Response body should contain "status" "OK"
  And Response body should contain "scope" "APP"
  And Verify place_id created maps to "<name>" using "getPlaceAPI"

Examples:
  | name         | address         | language |
  | Tree house    | Willow Park     | German   |
#  | The Cottage  | Dublin Road     | Hindi    |
#  | Magic house  | Cypress Garden  | English  |


@DeletePlace @Regression
Scenario:
	Given DeletePlace payload
	When User hits "deletePlaceAPI" "post" HTTP request call
	Then API call should be successful with status code 200
	And Response body should contain "status" "OK"
