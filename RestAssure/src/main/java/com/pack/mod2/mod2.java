package com.pack.mod2;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pack.helper.UIHelper;
import com.pack.main.AutoMain;
import com.pojo.JSON1;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

//public class RestAssuredTestResponse { @Test public void GetBookDetails() {
public class mod2 {
	
	@Test (
			priority=1,
			enabled=false,
			description="TC001"
			)
	public void getBookDetails() {
////////////////////////////////////////////////////////////////////////
AutoMain.extentTest = AutoMain.extentReports.createTest("TC002_getBookDetails");
////////////////////////////////////////////////////////////////////////
		RequestSpecification httpRequest = UIHelper.httpRequest_given("https://demoqa.com/BookStore/v1/Books");
/////////////////////////////////////////////////////////////////////
		Response response = UIHelper.httpRequest_get(httpRequest);
///////////////////////////////////////////////////////////////////
//		// Get the status code of the request.
//		// If request is successful, status code will be 200
		int statusCode = UIHelper.getResponseCode(response);
///////////////////////////////////////////////////////////////////
		// Assert that correct status code is returned.
		System.out.println("Actual StatusCode = "+statusCode);
		System.out.println("Expected StatusCode = 200");
		AutoMain.extentTest.info("Actual StatusCode = "+statusCode);
		AutoMain.extentTest.info("Expected StatusCode = 200");
		
		Assert.assertEquals(statusCode /* actual value */, 200 /* expected value */, "Correct status code returned");
///////////////////////////////////////////////////////////////////
	}
	
	@Test (
			priority=2,
			enabled=false,
			description="TC002"
			)
	public void getPetDetails() {
////////////////////////////////////////////////////////////////////////
AutoMain.extentTest = AutoMain.extentReports.createTest("TC003_getPetDetails_Invalid");
////////////////////////////////////////////////////////////////////////
		RequestSpecification httpRequest = UIHelper.httpRequest_given("https://demoqa.com/Account/v1/User/");
/////////////////////////////////////////////////////////////////////
		Response response = UIHelper.httpRequest_get(httpRequest, "test");
///////////////////////////////////////////////////////////////////
//		// Get the status code of the request.
//		// If request is successful, status code will be 200
		int statusCode = UIHelper.getResponseCode(response);
///////////////////////////////////////////////////////////////////
		// Assert that correct status code is returned.
		System.out.println("Actual StatusCode = "+statusCode);
		System.out.println("Expected StatusCode = 401");
		AutoMain.extentTest.info("Actual StatusCode = "+statusCode);
		AutoMain.extentTest.info("Expected StatusCode = 401");
		
		Assert.assertEquals(statusCode /* actual value */, 401 /* expected value */, "Correct status code returned");
///////////////////////////////////////////////////////////////////
	}
	
	@Test (
			priority=3,
			enabled=false,
			description="TC003"
			)
	
	public void getBookDetails_statusLine() {
////////////////////////////////////////////////////////////////////////
AutoMain.extentTest = AutoMain.extentReports.createTest("TC004_getBookDetails_statusLine");
////////////////////////////////////////////////////////////////////////
		RequestSpecification httpRequest = UIHelper.httpRequest_given("https://demoqa.com/BookStore/v1/Books");
/////////////////////////////////////////////////////////////////////
		Response response = UIHelper.httpRequest_get(httpRequest);
///////////////////////////////////////////////////////////////////
//		// Get the status code of the request.
//		// If request is successful, status code will be 200
		String statusLine = UIHelper.getStatusLine(response);
///////////////////////////////////////////////////////////////////
		// Assert that correct status code is returned.
		System.out.println("Actual StatusCode = "+statusLine);
		System.out.println("Expected StatusCode = HTTP/1.1 200 OK");
		AutoMain.extentTest.info("Actual StatusCode = "+statusLine);
		AutoMain.extentTest.info("Expected StatusCode = HTTP/1.1 200 OK");
		
		Assert.assertEquals(statusLine /* actual value */, "HTTP/1.1 200 OK" /* expected value */, "Correct status line returned");
///////////////////////////////////////////////////////////////////
	}

	@Test (
			priority=4,
			enabled=false,
			description="TC004"
			)
	public void getBookDetails_responseHeaders() {
////////////////////////////////////////////////////////////////////////
AutoMain.extentTest = AutoMain.extentReports.createTest("TC005_getBookDetails_responseHeaders");
////////////////////////////////////////////////////////////////////////
		RequestSpecification httpRequest = UIHelper.httpRequest_given("https://demoqa.com/BookStore/v1/Books");
/////////////////////////////////////////////////////////////////////
		Response response = UIHelper.httpRequest_get(httpRequest);
///////////////////////////////////////////////////////////////////
//		// Get the status code of the request.
//		// If request is successful, status code will be 200
		Headers headers = UIHelper.getResponseHeaders(response);
///////////////////////////////////////////////////////////////////
		// Assert that correct status code is returned.
		System.out.println("Actual headers = "+headers);
//		System.out.println("Expected StatusCode = HTTP/1.1 200 OK");
		AutoMain.extentTest.info("Actual headers = "+headers);
//		AutoMain.extentTest.info("Expected StatusCode = HTTP/1.1 200 OK");
		
//		Assert.assertEquals(headers /* actual value */, "HTTP/1.1 200 OK" /* expected value */, "Correct status line returned");
///////////////////////////////////////////////////////////////////
	}

	@Test (
			priority=5,
			enabled=false,
			description="TC005"
			)
	public void getBookDetails_responseHeader_ContentType() {
		////////////////////////////////////////////////////////////////////////
		AutoMain.extentTest = AutoMain.extentReports.createTest("TC006_getBookDetails_responseHeader_ContentType");
		////////////////////////////////////////////////////////////////////////
		RequestSpecification httpRequest = UIHelper.httpRequest_given("https://demoqa.com/BookStore/v1/Books");
		/////////////////////////////////////////////////////////////////////
		Response response = UIHelper.httpRequest_get(httpRequest);
		///////////////////////////////////////////////////////////////////
		String header = UIHelper.getResponseHeader(response,"Content-Type");
		///////////////////////////////////////////////////////////////////
		System.out.println("Actual header = "+header);
		System.out.println("Expected header = application/json");
		AutoMain.extentTest.info("Actual header = "+header);
		AutoMain.extentTest.info("Expected header = application/json");
		
		Assert.assertEquals(header /* actual value */, "application/json; charset=utf-8" /* expected value */, "Correct Content-Type returned");
		///////////////////////////////////////////////////////////////////
}

	@Test (
			priority=6,
			enabled=false,
			description="TC006"
			
			)
	public void getWeatherDetails_body() {
		////////////////////////////////////////////////////////////////////////
		AutoMain.extentTest = AutoMain.extentReports.createTest("TC007_getWeatherDetails_body");
		////////////////////////////////////////////////////////////////////////
//		RequestSpecification httpRequest = UIHelper.httpRequest_given("https://restapi.demoqa.com/utilities/weather/city");
		RequestSpecification httpRequest = UIHelper.httpRequest_given("https://api.coindesk.com/v1/bpi/currentprice.json");
		/////////////////////////////////////////////////////////////////////
//		Response response = UIHelper.httpRequest_get(httpRequest,"/Hyderabad");
		Response response = UIHelper.httpRequest_get(httpRequest);
		///////////////////////////////////////////////////////////////////
		JsonPath js = UIHelper.getJsonPath(response);
		///////////////////////////////////////////////////////////////////
		String allNodes=UIHelper.getJsonPath_allNodes(js);
		System.out.println("Actual All Nodes2 = "+allNodes);
		///////////////////////////////////////////////////////////////////
		String resDis = UIHelper.getJsonPath_key(response,"disclaimer");
		System.out.println("Actual resAge = "+resDis);
		///////////////////////////////////////////////////////////////////
//		System.out.println("Actual resAge = "+resDis);
//		System.out.println("Expected header = application/json");

		
//		AutoMain.extentTest.info("Actual body = "+resBody);
//		AutoMain.extentTest.info("Expected header = application/json");
		
//		Assert.assertEquals(header /* actual value */, "application/json" /* expected value */, "Correct Content-Type returned");
		///////////////////////////////////////////////////////////////////
}

	@Test (
			priority=7,
//			enabled=false,
			description="TC007"
			)
	public void createBookDetails_httpPost() {
		////////////////////////////////////////////////////////////////////////
		AutoMain.extentTest = AutoMain.extentReports.createTest("TC007_createBookDetails_httpPost");
		////////////////////////////////////////////////////////////////////////
		//https://dummy.restapiexample.com/api/v1/update/21
//		RequestSpecification httpRequest = UIHelper.httpRequest_given("https://demoqa.com/BookStore/v1/Books");
		RequestSpecification httpRequest = UIHelper.httpRequest_given("https://dummy.restapiexample.com/api/v1");
		/////////////////////////////////////////////////////////////////////
		// JSONObject is a class that represents a Simple JSON. 
		// We can add Key - Value pairs using the put method 
		JSONObject requestParams = new JSONObject(); 
//		UIHelper.updateJsonObject(requestParams, "userId", "TQ123");
//		UIHelper.updateJsonObject(requestParams, "isbn", "9781449325862");
		
		UIHelper.updateJsonObject(requestParams, "name", "test");
		UIHelper.updateJsonObject(requestParams, "salary", "12345");
		UIHelper.updateJsonObject(requestParams, "age", "50");
		///////////////////////////////////////////////////////////////////
		// Add a header stating the Request body is a JSON 
		UIHelper.httpRequest_addHeader(httpRequest, "Content-Type", "application/json");
		UIHelper.httpRequest_addBody(httpRequest, requestParams);
		
		String putApi="/update/21";
		String postApi="/create";
		Response response = UIHelper.httpRequest_post(httpRequest, postApi);
		
		String statusLine=UIHelper.getStatusLine(response);
		
//		String allNodesdata = UIHelper.getJsonPath_allNodes(response);
//		System.out.println("Actual allNodesdata = "+allNodesdata);
		///////////////////////////////////////////////////////////////////
//		System.out.println("Actual header = "+header);
//		System.out.println("Expected header = application/json");
//		AutoMain.extentTest.info("Actual header = "+header);
//		AutoMain.extentTest.info("Expected header = application/json");
		
//		Assert.assertEquals(header /* actual value */, "application/json; charset=utf-8" /* expected value */, "Correct Content-Type returned");
		///////////////////////////////////////////////////////////////////
}
	
	@Test (
			priority=8,
			enabled=false,
			description="TC008"
			)
	public void deserializeJson_sand2() throws InterruptedException {
		////////////////////////////////////////////////////////////////////////
		AutoMain.extentTest = AutoMain.extentReports.createTest("TC008_deserializeJson");
		////////////////////////////////////////////////////////////////////////
		
		RequestSpecification httpRequest = UIHelper.httpRequest_given("https://jsonplaceholder.typicode.com/posts");
		
		/////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////
		UIHelper.httpRequest_addHeader(httpRequest, "Content-Type", "application/json");
//		UIHelper.httpRequest_addBody(httpRequest);
//		httpRequest.body("");
		
		String postApi="";
		Response response = UIHelper.httpRequest_post(httpRequest, postApi);
		
		ResponseBody bodyAsResBody = UIHelper.getResponseBody_asResponseBody(response);
		String bodyAsString = UIHelper.getResponseBody_asString(response);
		
		Thread.sleep(1000);
//		System.out.println("Status = "+UIHelper.getJsonPath_key(response,"status"));
//		System.out.println("Data = "+UIHelper.getJsonPath_key(response,"data"));
//		System.out.println("Message = "+UIHelper.getJsonPath_key(response,"message"));
		
		System.out.println("All Nodes = "+UIHelper.getJsonPath_allNodes(response));
		////////////////////////////////////
//		  Gson gson = new Gson();
//	
//		  JSONSuccessResponse bodyAsGson = gson.fromJson(bodyAsString, JSONSuccessResponse.class);
//		  
//			System.out.println("bodyAsGson status = "+bodyAsGson.status);
//			System.out.println("bodyAsGson data = "+bodyAsGson.data);
//			System.out.println("bodyAsGson message = "+bodyAsGson.message);
		//////////////////////////////////////
		
		
		JSON1 bodyJs = bodyAsResBody.as(JSON1.class);
	
		
		System.out.println("JS id = "+bodyJs.id);
//		////////////////////////////////////
//		Data bodyJs = bodyAsResBody.as(Data.class);
//		
//		System.out.println("JS name = "+bodyJs.name);
//		System.out.println("JS salary = "+bodyJs.salary);
//		System.out.println("JS age = "+bodyJs.age);
//		System.out.println("JS id = "+bodyJs.id);
		
		//////////////////////////////////////
		
//		JsonElement je = new JsonParser().parse(bodyAsString);
//		
//		System.out.println("JE = "+je.getAsJsonObject().getAsString());
//		;
//		
		
		
		String statusLine=UIHelper.getStatusLine(response);
		System.out.println("Response Status Line = "+statusLine);
//		getResponseBody_asString
		System.out.println("Response Body as String = "+UIHelper.getResponseBody_asString(response));
		
		
		///////////////////////////////////////////////////////////////////
}

	
	@Test (
			priority=9,
			enabled=false,
			description="TC007"
			)
	public void updateBook_put() {
		
		String userId= "toolsqa_test"; 
		String baseUrl="https://dummy.restapiexample.com/api/v1"; 
//		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3RpbmcxMjMiLCJwYXNzd29yZCI6IlBhc3N3b3JkQDEiLCJpYXQiOjE2Mjg1NjQyMjF9.lW8JJvJF7jKebbqPiHOBGtCAus8D9Nv1BK6IoIIMJQ4"; 
		String isbn ="9781449325865";
		
		RequestSpecification httpRequest = UIHelper.httpRequest_given(baseUrl);
		
//		UIHelper.httpRequest_addHeader(httpRequest, "Authorization", "Bearer " + token);
		UIHelper.httpRequest_addHeader(httpRequest, "Content-Type", "application/json");
		
		
		JSONObject requestParams = new JSONObject(); 
//		UIHelper.updateJsonObject(requestParams, "userId", "TQ123");
//		UIHelper.updateJsonObject(requestParams, "isbn", "9781449325862");
		
		UIHelper.updateJsonObject(requestParams, "name", "nameput");
		UIHelper.updateJsonObject(requestParams, "salary", "1222");
		UIHelper.updateJsonObject(requestParams, "age", "10");
		
		UIHelper.httpRequest_addBody(httpRequest, requestParams);
		
		String putApi="/update/21";
//		Response response = httpRequest.put("/update/21");
		Response response = UIHelper.httpRequest_put(httpRequest, putApi);
		
	    System.out.println("The response code = " +response.getStatusCode());
	    Assert.assertEquals(response.getStatusCode(),200);
		
		
		
//	    RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
//	            .header("Content-Type", "application/json");
//
//	    //Calling the Delete API with request body
//	    Response res = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").put("/BookStore/v1/Book/9781449325862");
//
//	    //Fetching the response code from the request and validating the same
//	    System.out.println("The response code - " +res.getStatusCode());
//	    Assert.assertEquals(res.getStatusCode(),200);

	}
	
	@Test (
			priority=10,
			enabled=false,
			description="TC0010"
			)
	public void deleteBook_delete() {
		
		
//		String userId= "de5d75d1-59b4-487e-b632-f18bc0665c0d";
//		String baseUrl="https://demoqa.com/swagger/";
//		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3RpbmcxMjMiLCJwYXNzd29yZCI6IlBhc3N3b3JkQDEiLCJpYXQiOjE2Mjg1NjQyMjF9.lW8JJvJF7jKebbqPiHOBGtCAus8D9Nv1BK6IoIIMJQ4";
//		String isbn ="9781449337711";
//		
//		
//		RestAssured.baseURI = baseUrl;
//		  RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
//			         .header("Content-Type", "application/json");
//		 
//		  //Calling the Delete API with request body
//		  Response res = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").delete("/BookStore/v1/Book");
//	 
//		  //Fetching the response code from the request and validating the same
//		  System.out.println("The response code is - " +res.getStatusCode());
//	      Assert.assertEquals(res.getStatusCode(),204);
		
		
		
		
		String baseUrl="https://dummy.restapiexample.com/api/v1"; 
		
		RequestSpecification httpRequest = UIHelper.httpRequest_given(baseUrl);
		
		UIHelper.httpRequest_addHeader(httpRequest, "Content-Type", "application/json");
		
		
		JSONObject requestParams = new JSONObject(); 
		
		UIHelper.httpRequest_addBody(httpRequest, requestParams);
		
		String delApi="/delete/719";
		Response response = UIHelper.httpRequest_delete(httpRequest, delApi);
		
	    System.out.println("The response code = " +response.getStatusCode());
	    Assert.assertEquals(response.getStatusCode(),200);
		
		System.out.println("");
		
//	    RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
//	            .header("Content-Type", "application/json");
//
//	    //Calling the Delete API with request body
//	    Response res = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").put("/BookStore/v1/Book/9781449325862");
//
//	    //Fetching the response code from the request and validating the same
//	    System.out.println("The response code - " +res.getStatusCode());
//	    Assert.assertEquals(res.getStatusCode(),200);

	}
	


}