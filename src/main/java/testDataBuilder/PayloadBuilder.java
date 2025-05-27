package testDataBuilder;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;


public class PayloadBuilder {
	
	public AddPlace buildAddPlacePayload(String name, String address, String language) {
		List<String> types = new ArrayList<>();
		types.add("shoe park");
		types.add("shop");
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		AddPlace addPlace = new AddPlace();
		addPlace.setAccuracy(50);
		addPlace.setName(name);
		addPlace.setPhoneNumber("(+91) 983 893 3937");
		addPlace.setAddress(address);
		addPlace.setTypes(types);
		addPlace.setWebsite("http://google.com");
		addPlace.setLanguage(language);
		addPlace.setLocation(l);
		
		return addPlace;
	}
	
	public String buildDeletePlacePayload(String placeId) {
		return "{ \"place_id\": \""+placeId+"\" }";
	}

}
