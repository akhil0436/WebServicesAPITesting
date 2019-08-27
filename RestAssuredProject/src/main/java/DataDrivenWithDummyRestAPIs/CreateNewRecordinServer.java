package DataDrivenWithDummyRestAPIs;


import java.io.IOException;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CreateNewRecordinServer {
	
	
	@Test(dataProvider = "EmpData")
	public void CreateNewRecord(String ename, String esal, String eage)
	{
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpreqquest=RestAssured.given();
		
		JSONObject objparams=new JSONObject();
		
		objparams.put("name",ename);
		objparams.put("salary",esal);
		objparams.put("age",eage);
		
		httpreqquest.header("Content-Type", "application/json");
		
		httpreqquest.body(objparams.toJSONString());
		
		Response response=httpreqquest.request(Method.POST,"/create");
		
		
		//capture response body to perform validations 
		
		
		String responsebody=response.getBody().asString();
		
		Assert.assertEquals(responsebody.contains(ename), true);
		Assert.assertEquals(responsebody.contains(esal), true);
		Assert.assertEquals(responsebody.contains(eage), true);
		
		
		int GetstatusCode=response.getStatusCode();
		System.out.println("The response Status Code is -- "+GetstatusCode);

		
		
	}

	
	@DataProvider(name="EmpData")
	String[][] GetEmpData() throws IOException 
	{
		
		String path="C:\\Users\\Welcome\\Desktop\\API &Web Services\\API Test Cases.xlsx";
		
		int rowcount=XLUtils.getRowCount(path, "RestAssuredData");
		int colcount=XLUtils.getCelCount(path, "RestAssuredData", 1);
		
		String empdata[][]=new String[rowcount][colcount];
		
		for(int i=1; i<=rowcount; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				
				empdata[i-1][j]=XLUtils.GetCelData(path, "RestAssuredData", i, j);	
				
			}
			
			
		}
		
		return(empdata);
		
	}

}
