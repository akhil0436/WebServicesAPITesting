package WebservicesTestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC7_GET_BasicAuthentication {
	
	
	@Test
	public void EnterBasicAuthentication()
	{
		
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		
		//we have to use PreemptiveBasicAuthScheme class from restassured
		PreemptiveBasicAuthScheme basicauth=new PreemptiveBasicAuthScheme();
		basicauth.setUserName("ToolsQA");
		basicauth.setPassword("TestPassword");
		
		RestAssured.authentication=basicauth;
		
		RequestSpecification httprequest=RestAssured.given();
		
		Response response=httprequest.request(Method.GET, "/");
		
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
