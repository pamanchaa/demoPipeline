package com.pack.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class UIHelper {

//////////////////////////////////////////////////////////////////////////////////////////////////////////
//REQUEST
	public static RequestSpecification httpRequest_given(String uri) {
///////////////////////////////////////////////////		
		System.out.println("URI = " + uri);
///////////////////////////////////////////////////
		//The base URI indicates the root address of the resource we are 
		//going to request from the server (hence the name base URI)
		
		//Internally io.restassured.RestAssured class uses an HTTP builder library, which 
		///is a Groovy language-based HTTP client.
		
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = uri;

///////////////////////////////////////////////////////////////////
		//This line gets the RequestSpecification of the request to be sent to the server. 
		//Rest Assured library provides an interface called RequestSpecification for this purpose. 
		//The variable httpRequest stores the request so that we can modify it if required like adding authentication details, adding headers, etc.
		//For this particular test, we are not modifying the variable.
		
		// Get the RequestSpecification of the request to be sent to the server
		RequestSpecification httpRequest = RestAssured.given();
///////////////////////////////////////////////////////////////////
		System.out.println("httpRequest = " + httpRequest);
///////////////////////////////////////////////////
///////////////////////////////////////////////////
		return httpRequest;
	}

	public static RequestSpecification httpRequest_addHeader(RequestSpecification httpRequest, String key, String value) {
		httpRequest.header(key, value); 
		return httpRequest;
	}
	
	public static RequestSpecification httpRequest_addBody(RequestSpecification httpRequest,JSONObject requestParams) {
		httpRequest.body(requestParams.toJSONString());
		return httpRequest;
	}
	
	public static Response httpRequest_get(RequestSpecification httpRequest) {
///////////////////////////////////////////////////		
		System.out.println("httpRequest = " + httpRequest);
///////////////////////////////////////////////////
		Response response = httpRequest.get("");
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
		System.out.println("response = " + response);
///////////////////////////////////////////////////
		return response;
	}
	
	public static Response httpRequest_get(RequestSpecification httpRequest, String param1) {
///////////////////////////////////////////////////		
System.out.println("httpRequest = " + httpRequest);
System.out.println("param1 = " + param1);
///////////////////////////////////////////////////
Response response = httpRequest.get(param1);
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
System.out.println("response = " + response);
///////////////////////////////////////////////////
return response;
}

	public static Response httpRequest_request(RequestSpecification httpRequest, String method) {
		///////////////////////////////////////////////////		
		System.out.println("httpRequest = " + httpRequest);
		System.out.println("Method = " + method);
		///////////////////////////////////////////////////
		Response response = null;
		//Response response = httpRequest.get("");
		method=method.toUpperCase();
		
			switch (method) {
			
			case ("GET"):
				//we call the server to get the resource using the RequestSpecification object. 
				//The below code line uses the request method to send the request for the resource to the server.
				
				//The request method takes two arguments, the first is the HTTP method and the second is a string. 
				//The string parameter is used to specify the parameters that are to be sent with the base URI
				//In this case, to get pet store details we do not send any parameters hence the blank string. 
				
				//The Response interface (io.restassured.response.Response) represents a response returned from a server. 
				//It contains all the data sent by the server
				response = httpRequest.request(Method.GET, "");
				break;
				
			}
		///////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////
			System.out.println("response = " + response);
		///////////////////////////////////////////////////
		return response;
}

	public static Response httpRequest_post(RequestSpecification httpRequest, String postApi) {
	///////////////////////////////////////////////////		
	System.out.println("httpRequest = " + httpRequest);
	System.out.println("postApi = " + postApi);
	///////////////////////////////////////////////////
	Response response = httpRequest.post(postApi);
	///////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////
	System.out.println("response = " + response);
	///////////////////////////////////////////////////
	return response;
	}
	
	public static Response httpRequest_put(RequestSpecification httpRequest, String putApi) {
		///////////////////////////////////////////////////		
		System.out.println("httpRequest = " + httpRequest);
		System.out.println("putApi = " + putApi);
		///////////////////////////////////////////////////
		Response response = httpRequest.put(putApi);
		///////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////
		System.out.println("response = " + response);
		///////////////////////////////////////////////////
		return response;
		}

	public static Response httpRequest_delete(RequestSpecification httpRequest, String putApi) {
		///////////////////////////////////////////////////		
		System.out.println("httpRequest = " + httpRequest);
		System.out.println("putApi = " + putApi);
		///////////////////////////////////////////////////
		Response response = httpRequest.delete(putApi);
		///////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////
		System.out.println("response = " + response);
		///////////////////////////////////////////////////
		return response;
		}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//RESPONSE
	
	//=============================================================================
	//1. Header
	
	public static String getResponseHeader(Response response, String header) {
		///////////////////////////////////////////////////		
		System.out.println("response = " + response);
		System.out.println("header = " + header);
		///////////////////////////////////////////////////
		// Response.asString method will directly return the content of the body as String.
		
		String responseHeader = response.getHeader(header);
		/////////////////////////////////////////////////////
		System.out.println("responseHeader = " + responseHeader);
		///////////////////////////////////////////////////
		///////////////////////////////////////////////////
		return responseHeader;
	}

	public static Headers getResponseHeaders(Response response) {
		///////////////////////////////////////////////////		
		System.out.println("response = " + response);
		///////////////////////////////////////////////////
		// Response.asString method will directly return the content of the body as String.
		Headers responseHeaders=null;
		responseHeaders = response.getHeaders();
		
		for ( Header header: responseHeaders) {
			System.out.println("Key = " + header.getName() + " Value = " + header.getValue()); 
		}
		/////////////////////////////////////////////////////
		///////////////////////////////////////////////////
		///////////////////////////////////////////////////
		return responseHeaders;
	}
	//=============================================================================
	
	//=============================================================================
	//2. Body

	public static String getResponseBody_asString(Response response) {
		///////////////////////////////////////////////////		
		System.out.println("response = " + response);
		///////////////////////////////////////////////////
		// Response.asString method will directly return the content of the body as String.
		
		String responseBody = response.toString();
		/////////////////////////////////////////////////////
		System.out.println("responseBody = " + responseBody);
		///////////////////////////////////////////////////
		///////////////////////////////////////////////////
		return responseBody;
	}
	
	public static ResponseBody  getResponseBody_asResponseBody(Response response) {
		///////////////////////////////////////////////////		
		System.out.println("response = " + response);
		///////////////////////////////////////////////////
		
//		String responseBody = response.toString();
		ResponseBody body= response.getBody();
		/////////////////////////////////////////////////////
		System.out.println("responseBody = " + body);
		///////////////////////////////////////////////////
		///////////////////////////////////////////////////
		return body;
	}
	//=============================================================================
	
	//=============================================================================
	//3. Status
	
	public static int getResponseCode(Response response) {
///////////////////////////////////////////////////		
		System.out.println("response = " + response);
///////////////////////////////////////////////////
// Get the status code of the request.
// If request is successful, status code will be 200
		int statusCode = response.getStatusCode();
/////////////////////////////////////////////////////
		System.out.println("statusCode = " + statusCode);
///////////////////////////////////////////////////
///////////////////////////////////////////////////
		return statusCode;
	}
	
	public static String getStatusLine(Response response) {
///////////////////////////////////////////////////		
		System.out.println("response = " + response);
///////////////////////////////////////////////////
//Get the status code of the request.
//If request is successful, status code will be 200
		String statusLine = response.getStatusLine();
/////////////////////////////////////////////////////
		System.out.println("statusLine = " + statusLine);
///////////////////////////////////////////////////
///////////////////////////////////////////////////
		return statusLine;
	}
	//=============================================================================
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//JSON
	
	
	public static String getJsonPath_key(Response response,String key) {
	    String complete = response.asString();
	    JsonPath js = new JsonPath(complete);
	   return js.get(key);
//	    return js.get(key).toString();
	}
	
	public static JsonPath getJsonPath(Response response) {
	    JsonPath js = response.jsonPath();
	   return js;
	}
	
	public static String getJsonPath_allNodes(JsonPath js) {
	    String allNodes = js.get().toString();
	   return allNodes;
	}
	
	public static String getJsonPath_allNodes(Response response) {
		 JsonPath js = response.jsonPath();
		String allNodes = js.get().toString();
	   return allNodes;
	}

	public static JSONObject updateJsonObject(JSONObject requestParams, String key, String value) {
		requestParams.put(key, value);
	   return requestParams;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
//SERIALIZE/DESERIALIZE
	public static void serializeToFile(Object classObject, String fileName)
	{
		try {

			// Step 1: Open a file output stream to create a file object on disk.
			// This file object will be used to write the serialized bytes of an object
			FileOutputStream fileStream = new FileOutputStream(fileName);

			// Step 2: Create a ObjectOutputStream, this class takes a files stream.
			// This class is responsible for converting the Object of any type into
			// a byte stream
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

			// Step 3: ObjectOutputStream.writeObject method takes an Object and 
			// converts it into a ByteStream. Then it writes the Byte stream into
			// the file using the File stream that we created in step 1.
			objectStream.writeObject(classObject);

			// Step 4: Gracefully close the streams
			objectStream.close();
			fileStream.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Object deSerializeFromFileToObject(String fileName)
	{
		try {

			// Step 1: Create a file input stream to read the serialized content
			// of rectangle class from the file
			FileInputStream fileStream = new FileInputStream(new File(fileName));

			// Step 2: Create an object stream from the file stream. So that the content
			// of the file is converted to the Rectangle Object instance
			ObjectInputStream objectStream = new ObjectInputStream(fileStream);

			// Step 3: Read the content of the stream and convert it into object
			Object deserializeObject = objectStream.readObject();

			// Step 4: Close all the resources
			objectStream.close();
			fileStream.close();

			// return the deserialized object
			return deserializeObject;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
//JSON	
//////////////////////////////////////////////////////////////////////////////////////////////////////////

	
//	/////////////////////////////////////////////////////////////////////////////////
//	//FOR PRACTICE:
//	
//	//REQ
//	RestAssured.baseURI = uri;
//	RequestSpecification httpRequest = RestAssured.given();
//	httpRequest.header(key, value); 
//	httpRequest.body(requestParams.toJSONString());
//	Response response = httpRequest.get("");
//	Response response = httpRequest.get(param1);
//	response = httpRequest.request(Method.GET, "");
//	Response response = httpRequest.post(postApi);
//	Response response = httpRequest.put(putApi);
//	Response response = httpRequest.delete(delApi);

//	//RES
//	String responseHeader = response.getHeader(header);
//	
//	responseHeaders = response.getHeaders();
//	for ( Header header: responseHeaders) {
//		System.out.println("Key = " + header.getName() + " Value = " + header.getValue()); 
//	}
//	
//	String responseBody = response.toString();
//	ResponseBody body= response.getBody();
//	int statusCode = response.getStatusCode();
//	String statusLine = response.getStatusLine();
	
//	//JSON
//    String complete = response.asString();
//    JsonPath js = new JsonPath(complete);
//   return js.get(key);
//  
//   JsonPath js = response.jsonPath();
//   String allNodes = js.get().toString();
//   
//   requestParams.put(key, value);
//   
//   //SER and DESER
//   FileOutputStream fileStream = new FileOutputStream(fileName);
//   ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
//   objectStream.writeObject(classObject);
//   
//   FileInputStream fileStream = new FileInputStream(new File(fileName));
//   ObjectInputStream objectStream = new ObjectInputStream(fileStream);
//   Object deserializeObject = objectStream.readObject();
//	/////////////////////////////////////////////////////////////////////////////////  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
