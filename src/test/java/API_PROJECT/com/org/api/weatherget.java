package API_PROJECT.com.org.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.restassured.response.Response;

@Epic("Regression test class")
public class weatherget {

	@Test
	@Description("Test Description test with corect/incorrect status code")
	public void Test001() {
		String str="https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02";
		Response resp=	get(str);
		int code = resp.getStatusCode();
		System.out.println("Status code " +code);
		try {
			Assert.assertEquals(code, 200);	
			System.out.println("correct code " +code);
			
		} catch (Throwable t) {
			System.out.println("Incorrect code" +t);
		}
		
	}
	
	@Test 
	@Description("Test Description test with Response data, code and response time")
	
	public void Test002() {
		String str="https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02";
		int code = get(str).statusCode();
		String data = get(str).asString();
		long time = get(str).getTime();
		System.out.println("Data is " +data);	
		System.out.println("Code "+code);
		System.out.println("Response time " +time);
	}	
	
}
