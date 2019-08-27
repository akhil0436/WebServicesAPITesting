package WebservicesTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC4_GET_Request_ValidateParticularHeader {
	
	
	@Test
	public void PrintAllHeaders()
	{
	
	//specify the base URI
	RestAssured.baseURI="https://maps.googleapis.com";
	 
	
	//Request object
    RequestSpecification httprequest=RestAssured.given();
    
    //Response object
    Response responseobj=httprequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AlzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELbJy1s");
    
    
	//Print response in console screen
    String responsebody=responseobj.getBody().asString();
    System.out.println("Response body is--"+responsebody);
    
    
    //to capture status code
    int Getstatuscode=responseobj.getStatusCode();
    System.out.println("The status code is --"+Getstatuscode);
    
    
    //print and validate particular header 
    String ContentType=responseobj.header("Content-Type");
    System.out.println("The Content-Type is --"+"  "+ContentType);
    Assert.assertEquals(ContentType, "application/xml; charset=UTF-8");
    
    
    //String Date=responseobj.header("Date");
    //System.out.println("The Date is --"+"  "+Date);
    //Assert.assertEquals(Date, "Sat, 17 Aug 2019 13:15:45 GMT");
    
    
    String Pragma=responseobj.header("Pragma");
    System.out.println("The Pragma is --"+"  "+Pragma);
    Assert.assertEquals(Pragma, "no-cache");
    
    
    
    String Expires=responseobj.header("Expires");
    System.out.println("The Expires is --"+"  "+Expires);
    Assert.assertEquals(Expires, "Fri, 01 Jan 1990 00:00:00 GMT");
    
    
    String CacheControl=responseobj.header("Cache-Control");
    System.out.println("The CacheControl is --"+"  "+CacheControl);
    Assert.assertEquals(CacheControl, "no-cache, must-revalidate");
    
    
    String Vary=responseobj.header("Vary");
    System.out.println("The Vary is --"+"  "+Vary);
    Assert.assertEquals(Vary, "Accept-Language");
    
    
    String TransferEncoding=responseobj.header("Transfer-Encoding");
    System.out.println("The TransferEncoding is --"+"  "+TransferEncoding);
    Assert.assertEquals(TransferEncoding, "chunked");
    
    
  
 
	
	}


}
