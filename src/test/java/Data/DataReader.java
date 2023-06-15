package Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//this is utility class
public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//Data//LoginCredentials.json"), StandardCharsets.UTF_8);
		
		//convert string to hashmap
		//for thos we need add one dependency in pom.xml "jackson Databind" this is the dependency which convert
		//json string to hashmap
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		
		return data;
		
	}
}

/*How to provide data in jason
 Ans: First you need to create on data package and .json file in the package
      write the email id password combinations in json file
      create one utility class which convert the jason file to hashmap.
      for this we need to write some methods and add dependencies "jackson Databind" which convert the jason file to string and from string to hashmap.
      and then after call the method of utility class in our actual test within dataprovider annotation and return the object
      then after in test case pass the dataprovider in argument with method name and pass the HashMap<String, String> in method argument
      */

/*Create one package in src/test with name Datareader
create one file in this package -> logincreds.json
enter email and passord in this file

now need to create one utility which scan the jason and create hashmap out of it
previously we created hashmap manually, but with the help of that utility automatically hashmap created with json file
for this we need to write some methods which scans the json and create hashmap from this

in same data package create one class DataReader */
