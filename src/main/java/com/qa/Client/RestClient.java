package com.qa.Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.json.JSONException;



public class RestClient {
	
	//1. GET Method without Headers
	
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException, JSONException {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url); //httpget request
		CloseableHttpResponse httpRespone = httpClient.execute(httpGet);  //hit the API
		return httpRespone;
		
	}
	
	
	
	// Automate the API GET method with HEADERS
	
	public CloseableHttpResponse get(String url, HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url); //httpGet Request
		// we have to add this before execute the URL its like userame and Passwrod
		// and here "content-type" is Key and "Apllication/json" is the value
		for(Map.Entry<String, String> entry : headerMap.entrySet()) {
			//if we want to fetch the 2-3 headers
			// then MAP has to be used, entry will be part of the headerMap
			httpGet.addHeader(entry.getKey(), entry.getValue());
		}
		
		CloseableHttpResponse httpResponse = httpclient.execute(httpGet);
		httpGet.releaseConnection();
		System.out.println("DOne connection release result" +httpGet );
		return httpResponse;
		
		
	}

	//2. POST
	// I want to create the user as Morphin and JOb is leader
	public CloseableHttpResponse post(String url,String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url); //hit the URL
		httpPost.setEntity(new StringEntity(entityString)); // for to add payload	or create this payload
		
		// for Headers
		for(Map.Entry<String, String> entry : headerMap.entrySet()) {  
			httpPost.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse httpResponse = httpclient.execute(httpPost); // for execute the request
		httpPost.releaseConnection();
		return httpResponse;
	}
	
}
