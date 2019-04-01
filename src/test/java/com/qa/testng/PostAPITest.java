/**
 * 
 */
package com.qa.testng;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.Client.RestClient;
import com.qa.users.UsersData;

/**
 * @author raghuveer.mh
 *
 */
public class PostAPITest extends RestClient{
	
	@Test
	public void postApiTest() throws ClientProtocolException, IOException, JSONException {
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(".//src//main//java//com//qa//config//config.properties");
		
		try {
			prop.load(ip);
		} catch (IOException e) {
		
		}	
		
	
		String url = prop.getProperty("URL");
		String serviceUrl = prop.getProperty("ServiceURL");
		
		String URI = url + serviceUrl;
		// complete end point URL
		System.out.println(" URL is " +URI);
		
		RestClient restClient = new RestClient();
		
		// Header
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		
	// for the payload create the JAVA class "USERDATA"	
		
		//(JACKSON API) the JAVA file is converting into the JSON file-- Marshling
		// Add dependency in POM.xml of JACKSON API
		ObjectMapper mapper = new ObjectMapper();
		UsersData users = new UsersData("morpheus" , "leader"); //expected USERS object
		
		
		
		// generats the JSON file
		mapper.writeValue(new File("C:\\Users\\raghuveer.mh\\Desktop\\JavaProjects\\RESTAPI\\src\\main\\java\\com\\qa\\base\\UsersBlank.json"), users);
		
		// converts the java file to JSON Particular string --Marshling
		// The value json stores in string value in order to print
		String usersJson =mapper.writeValueAsString(users);
		System.out.println("JSON " +usersJson);
		
		//String str = FileUtils.readFileToString("C:\\Users\\raghuveer.mh\\eclipse-workspace\\RESTAPI\\src\\main\\java\\com\\qa\\base\\UsersBlank.json", "UTF-8");
	
		// first call the API
		CloseableHttpResponse httpResponse = restClient.post(URI, usersJson, headerMap);
		
		// 1 stataus code
		int statusCode = httpResponse.getStatusLine().getStatusCode();	
		assertEquals(statusCode, 201);
		
		// 2 JSON String	
		String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");	
		//UTF-8 is the format in order to read the JSON Properly
		JSONObject responseJSON = new JSONObject(responseString);
		System.out.println("Respone from API " +responseJSON);
		
		//here we are doing JSON to JAVA  --unmarshling
		UsersData userObj = mapper.readValue(responseString, UsersData.class);
		System.out.println("User Job is " +userObj); // Actual USERS object
		
		Assert.assertTrue(users.getName().equals(userObj.getName()));
		Assert.assertTrue(users.getJob().equals(userObj.getJob()));
		
		System.out.println(userObj.getId());
		System.out.println(userObj.getCreatedAt());
	}

}
