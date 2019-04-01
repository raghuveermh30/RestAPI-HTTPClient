package com.qa.users;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.JSONException;
import org.json.JSONObject;




public class JsonSchema {

	public static void main(String[] args) throws FileNotFoundException, IOException, JSONException {
		
/*		//String file1 ="C:\\Users\\raghuveer.mh\\Desktop\\CompleteScema.json";
		
		File f = new File("C:\\Users\\raghuveer.mh\\Desktop\\CompleteScema.json");

				FileReader is = new FileReader(f);
				
			  JSONObject rawSchema = new JSONObject(is);
			  Schema schema = SchemaLoader.load(rawSchema);
			  
			  String jsonPAth = "C:\\Users\\raghuveer.mh\\Desktop\\Booking_Updte.json";
			 
			  System.out.println((int)jsonPAth.trim().charAt(0));
							
		  JSONObject allCDs =new JSONObject(jsonPAth);
		  schema.validate(new JSONObject(allCDs)); 
			  
			 
			  SchemaLoader loader = SchemaLoader.builder()
		                .schemaJson(rawSchema)
		                .draftV6Support() // or draftV7Support()
		                .build();
		schema = loader.load().build();*/
			
		System.out.println("hello");

	}

}
