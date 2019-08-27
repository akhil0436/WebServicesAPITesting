package WebservicesTestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC5_GET_Request_ValidateAllHeaders {
	
	
	@Test
	public void ValidateAllHeaders()

	{
		//specify base URI
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//specify request
		RequestSpecification Httprequest=RestAssured.given();
		
		//specify response
		Response response=Httprequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AlzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELbJy1s");
		
		//Print body in console
	    String responseBody=response.getBody().asString();
	    System.out.println("Here the Response Body is --"+responseBody);
	    
	    //print status code
	    int responsecode=response.getStatusCode();
	    System.out.println("The response code is --"+"   "+responsecode);
	    
	    //print all headers
	    Headers GetAllHeaders=response.headers();
	    System.out.println("Here all the headers data or information below --"+" "+GetAllHeaders);
		
		for(Header advncdLoop:GetAllHeaders)
		{
			System.out.println(advncdLoop.getName()+"    "+advncdLoop.getValue());
		}
	}

}
