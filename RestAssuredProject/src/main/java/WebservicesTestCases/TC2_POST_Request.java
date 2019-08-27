package WebservicesTestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC2_POST_Request {

	
	
	@Test
	public void CreateEmpDetails()
	{
		
		
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//Specify request
		RequestSpecification httprequest=RestAssured.given();
		
		
		//specify request body or payload data
		JSONObject JsonParams=new JSONObject();
		JsonParams.put("FirstName","Akhgfil");
		JsonParams.put("LastName","Akhdgfdil");
		JsonParams.put("UserName","Agdfdbgfkhil");
		JsonParams.put("Password","Akhbgfbfbfil");
		JsonParams.put("Email","Akhilgfbfdbb@gmail.com");
		
		
		//to add the header params
		httprequest.header("Content-Type", "application/json");
		
		//add the json to body of request
		httprequest.body(JsonParams.toJSONString());
		
		//specify response
		Response response=httprequest.request(Method.POST, "/register");
		
		String responseToString=response.body().asString();
		
		System.out.println("The response is--"+responseToString);
		
		
		//validate and capture status code
		int statuscode=response.getStatusCode();
		System.out.println("The status code is --"+statuscode);
		Assert.assertEquals(statuscode, 201);
		
		//validate the reponse json body
		
		String SuccessCode=response.jsonPath().get("SuccessCode");
		Assert.assertEquals(SuccessCode, "OPERATION_SUCCESS");
		
		
		
	}
	
	
	
}
