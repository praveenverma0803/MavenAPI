package API_PROJECT.com.org.api;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.restassured.response.Response;
@Epic("Smoke test class")
public class ApiParameter {

	String str="https://samples.openweathermap.org/data/2.5/weather";
	
	@Test
	@Description("Test Description test with Return code and API status")
	public void Test003() {
	
		Response resp= given().queryParam("q", "London") 	
                .queryParam("appid", "439d4b804bc8187953eb36d2a8c26a02") 
				.get(str);
		
		int code = resp.getStatusCode();

		if (code==200) {
			System.out.println("API working ");
			System.out.println("Status code " +code);
		} else {
			System.out.println("API not working");
		}
	}
		
	@Test 
	@Description("Test Description test with status code only")
	public void Test004() {

			given().
				queryParam("q", "London"). 	
                queryParam("appid", "439d4b804bc8187953eb36d2a8c26a02"). 
			get(str).
			then().
			assertThat().statusCode(201);
		}
}
