package WebservicesTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC3_GET_Request_UsersList {
	
	
	
	@Test
	public void GetUserList()
	{
	
	//specify the base URI
	RestAssured.baseURI="https://reqres.in";
	 
	
	//Request object
    RequestSpecification httprequest=RestAssured.given();
    
    //Response object
    Response responseobj=httprequest.request(Method.GET, "/api/users?page=2");
    
    
	//Print response in console screen
    String responsebody=responseobj.getBody().asString();
    
    System.out.println("Response body is--"+responsebody);
    
    
    //to capture status code
    int Getstatuscode=responseobj.getStatusCode();
    System.out.println("The status code is --"+Getstatuscode);
    

    //to capture status line
    String GetstatusLine=responseobj.getStatusLine();
    System.out.println("The status line is--"+GetstatusLine);
    
    
		System.out.println("Print the validation here");
		
		
		//Validation 
		Assert.assertEquals(String.valueOf(Getstatuscode), "200");
	
	}

}
