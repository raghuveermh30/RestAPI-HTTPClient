package com.qa.testng;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import org.json.JSONException;
import org.json.JSONObject;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Client.RestClient;

import util.TestUtil;


public class GetApITest extends RestClient{
	
	String url;
	String serviceUrl;
	String URI;
	public  int RESPONSE_STATUS_CODE = 200;
	@Test(priority = 2)
	public void getApiWithoutHeader() throws ClientProtocolException, IOException, JSONException  {
		//TestBase testBase = new TestBase();
	/*	HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");*/
		
		//for Reference
		//headerMap.put("username", "test");
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(".//src//main//java//com//qa//config//config.properties");
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	
		String url = prop.getProperty("URL");
		String serviceUrl = prop.getProperty("ServiceURL");
		
		String URI = url + serviceUrl;
		
		System.out.println(" URL is " +URI);
		 
		
		RestClient restClient = new RestClient();
		CloseableHttpResponse httpRespone= restClient.get(URI);
		System.out.println( "response is:" +httpRespone);
		
		//a. Status Code
		int statusCode = httpRespone.getStatusLine().getStatusCode();
		System.out.println(" Status code " +statusCode);
		
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE, "Status code is not 200");
		
		//b. JSON Response
		String responseString = EntityUtils.toString(httpRespone.getEntity(), "UTF-8");	
		JSONObject responseJson = new JSONObject(responseString);
			System.out.println("Response JSON from API " +responseJson);
		
		//validate the JSON Response --> Single value for assertion
		String per_page = TestUtil.getValueByJpath(responseJson, "/per_page");
		System.out.println("value of Per Page " +per_page);
		String actualvalue = "3";		
		Assert.assertEquals(actualvalue, per_page, "Test case is faild");
		
		//Get the value from JSON array.
		
		//String lastName = TestUtil.getValueByJpath(responseJson, "/data[0]/last_name");
		//System.out.println(lastName);
		
		//To validate the Headers
		Header[] headerArray = httpRespone.getAllHeaders();	
		HashMap<String, String> allHeaders = new HashMap<String, String>();		
		for(Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());
			
		}
		
		System.out.println("All headers " +allHeaders);
		
		
	
}
	@Test(priority = 1)
	public void getApiWithHeader() throws ClientProtocolException, IOException, JSONException  {
		//TestBase testBase = new TestBase();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemF0aW9uIjp7ImpvYlJvbGVzIjpbeyJjb2RlIjoiSU5UU1JWQyIsInNvdSI6IkhRIiwibm9kZU9ubHkiOmZhbHNlfV0sInZlcnNpb24iOiJWXzEifSwiZXhwIjoxNTIxMTI1NjYxMCwidXNlcl9uYW1lIjoiR0RTRVJWIiwianRpIjoiZmQ5OTQwMjQtMzNmMi00NjNjLWJjM2YtYjBkNGExZmExYmY0IiwiY2xpZW50X2lkIjoiZ2xvYmUiLCJzY29wZSI6WyJnbG9iZSJdfQ.Aw0ZeNxravwmaUOt7lP_CX5lohMkQclbmMpYBjmzOWwPztnnyRfivC4PYhlkOsuOIPcfWJ8B5pua4NM-SytMzMA3rliX474cUuKDl-NCeFSN_jmtww7WX4boMZSJKe_Q7lNM4yPhGOREUh3WXm2ZN8sTifY55HYwj4EHK5M862w3lnDO9OVTmgKbuE_ikgaZZZrVk39zsF0EzzM45wQfRdguSI5WU3wTiF5EnNpmw1s1A5wV237IpTdLqY_UllpEOv_0M06-nGaehHAn8ciRxyHE7SKyB4jlX_gctNm5Y50wbwpB0B1YFD-e7L2sbzceUOf2HnabyjAAhK96bNaaxQ");
		
		// for reference purpose, we may have more number of headers in globe
		//headerMap.put("username", "test");
		//headerMap.put("passwrd", "test01");
		//headerMap.put("authentication", "12333");
		// devlop
		
		//for Reference
		//headerMap.put("username", "test");
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(".//src//main//java//com//qa//config//config.properties");
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	
		String url = prop.getProperty("URL");
		String serviceUrl = prop.getProperty("ServiceURL");
		
		String URI = url + serviceUrl;
		
		System.out.println(" URL is " +URI);
		
		
		RestClient restClient = new RestClient();
		CloseableHttpResponse httpRespone= restClient.get(URI, headerMap);
		System.out.println( "response is:" +httpRespone);
		
		//a. Status Code
		int statusCode = httpRespone.getStatusLine().getStatusCode();
		System.out.println(" Status code " +statusCode);
		
		//Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE, "Status code is not 200");
		
		//b. JSON Response
		String responseString = EntityUtils.toString(httpRespone.getEntity(), "UTF-8");	
		JSONObject responseJson = new JSONObject(responseString);
			System.out.println("Response JSON from API " +responseJson);
		
		//validate the JSON Response --> Single value for assertion
		String per_page = TestUtil.getValueByJpath(responseJson, "/per_page");
		System.out.println("value of Per Page " +per_page);
		String actualvalue = "3";		
		Assert.assertEquals(actualvalue, per_page, "Test case is faild");
		
		//Get the value from JSON array.
		
		String lastName = TestUtil.getValueByJpath(responseJson, "/data[0]/last_name");
		System.out.println(lastName);
		
		//To validate the Headers
		Header[] headerArray = httpRespone.getAllHeaders();	
		HashMap<String, String> allHeaders = new HashMap<String, String>();		
		for(Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());
			
		}
		
		System.out.println("All headers " +allHeaders);
		
		
	
}
	
	
	
}
	

