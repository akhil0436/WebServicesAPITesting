package WebservicesTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC6_GET_Response_JsonResoponseBody {

	
	@Test
	public void ValidateResponseJsonBody()

	{
		//specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//specify request
		RequestSpecification Httprequest=RestAssured.given();
		
		//specify response
		Response response=Httprequest.request(Method.GET, "/Delhi");
		
		//Print body in console
	    String responseBody=response.getBody().asString();
	    System.out.println("Here the Response Body is --"+responseBody);
	    
	    //print status code
	    int responsecode=response.getStatusCode();
	    System.out.println("The response code is --"+"   "+responsecode);
	    
	    Assert.assertEquals(responseBody.contains("Delhi"), true);   
	    
	}
	
	
}
