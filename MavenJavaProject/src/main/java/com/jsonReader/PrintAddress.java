package com.jsonReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

public class PrintAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrintAddress obj = new PrintAddress();
		obj.printAllAddresses();
	}

	public String prettyPrintAddress(Address address) {

		 return address.toString();
	}
	
	public String printAddressWithTypes(Address address){
		
		if(address.getType().getName().equals("Physical Address")) {
			return "This is the physical address - " + address.toString();
		}else if(address.getType().getName().equals("Postal Address")) {
			return "This is the postal address - " + address.toString();
		}else 
			return "This is the business address - " + address.toString();
	}
	
	
	public void printAllAddresses() {
		
		final ObjectMapper objectMapper = new ObjectMapper();
		List<Address> addressList;
	    JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

		try {
			
			File initialFile = new File("src/main/resources/schema.json");
		    InputStream is = new FileInputStream(initialFile);
		    
		    JsonSchema schema = factory.getSchema(is);
		    
		    JsonNode node = objectMapper.readTree(new File("src/main/resources/addresses.json"));
	        
	        Set<ValidationMessage> errors = schema.validate(node);
	        System.out.println("Errors in first json object: " + errors);
			
			addressList = objectMapper.readValue(
			        new File("src/main/resources/addresses.json"), 
			        new TypeReference<List<Address>>(){});
			
			addressList.forEach(x -> System.out.println(x.toString()));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
