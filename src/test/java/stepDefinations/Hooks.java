package stepDefinations;

import io.cucumber.java.Before;

public class Hooks {
	AddPlaceStepDefinations addPlaceStepDefinations;

	@Before("@DeletePlace")
	public void beforeScenario() {
		addPlaceStepDefinations = new AddPlaceStepDefinations();
		if (AddPlaceStepDefinations.placeId == null) {
			addPlaceStepDefinations.add_place_api_payload_with("The Cottage", "Dublin Road", "Marathi");
			addPlaceStepDefinations.user_hits_http_request_call_to_add_place("addPlaceAPI", "POST");
			addPlaceStepDefinations.verify_place_id_created_maps_to_using("The Cottage", "getPlaceAPI");
		}

	}

}
