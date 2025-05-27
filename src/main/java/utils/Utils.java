package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	PrintStream logs;
	static FileInputStream fis;
	static RequestSpecification reqSpec;

	public RequestSpecification requestSpecification() {
		try {
			if (reqSpec == null) {
				logs = new PrintStream(new FileOutputStream("logs.txt"));
				reqSpec = new RequestSpecBuilder().setBaseUri(fetchGlobalProperty("baseUrl"))
						.addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(logs))
						.addFilter(ResponseLoggingFilter.logResponseTo(logs)).setContentType(ContentType.JSON).build();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return reqSpec;
	}

	public static String fetchGlobalProperty(String key) {
		Properties property = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return property.getProperty(key);
	}
	
	public String getJsonPath(Response response, String key) {
		String res = response.asString();
		JsonPath jp = new JsonPath(res);
		return jp.get(key).toString();
	}

}
