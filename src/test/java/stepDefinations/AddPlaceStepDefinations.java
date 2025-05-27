package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testDataBuilder.PayloadBuilder;
import testResources.APIResources;
import utils.Utils;

public class AddPlaceStepDefinations extends Utils {
	RequestSpecification reqSpec;
	Response response;
	PayloadBuilder addPlacePayload = new PayloadBuilder();
	APIResources apiResources;
	//when new scenario starts non static variable will be set to null hence declaring it as static
	static String placeId;

	@Given("AddPlaceAPI payload with {string} {string} {string}")
	public void add_place_api_payload_with(String name, String address, String language) {
		reqSpec = given().spec(requestSpecification())
				.body(addPlacePayload.buildAddPlacePayload(name, address, language));

	}

	@When("User hits {string} {string} HTTP request call")
	public Response user_hits_http_request_call_to_add_place(String resource, String httpMethod) {
		apiResources = APIResources.valueOf(resource);

		switch (httpMethod.toUpperCase()) {
		case "GET":
			response = reqSpec.when().get(apiResources.getResource());
			break;
		case "POST":
			response = reqSpec.when().post(apiResources.getResource());
			break;
		case "PUT":
			response = reqSpec.when().put(apiResources.getResource());
			break;
		case "DELETE":
			response = reqSpec.when().delete(apiResources.getResource());
			break;
		default:
			throw new IllegalArgumentException("Unsupported HTTP method: " + httpMethod);
		}
		
		return response;
	}

	@Then("API call should be successful with status code {int}")
	public void api_call_should_be_successful_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("Response body should contain {string} {string}")
	public void response_body_should_contain(String key, String expectedValue) {
		assertEquals(getJsonPath(response, key), expectedValue);
	}
	
	@Then("Verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expected, String resource) {
		placeId = getJsonPath(response, "place_id");
		reqSpec = given().spec(requestSpecification()).queryParam("place_id", placeId);
		user_hits_http_request_call_to_add_place(resource, "GET");
		assertEquals(getJsonPath(response, "name"), expected);
	}
	
	@Given("DeletePlace payload")
	public void delete_place_payload() {
		reqSpec = given().spec(requestSpecification()).body(addPlacePayload.buildDeletePlacePayload(placeId));
	}


}
