package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponent.BaseTest;

public class Login extends BaseTest {

	@Test(enabled = false)

	public void loginWithValidCred() throws IOException {
		loginpage.login("anshika@gmail.com", "Iamking@000");
		Assert.assertEquals(loginpage.loginSuccessMessage(), "Login Successfully");

	}

	@Test(enabled = false)

	public void loginWithoutCred() throws IOException {
		loginpage.login("", "");
		Assert.assertEquals(loginpage.emailerrorMessage(), "*Email is required");
		Assert.assertEquals(loginpage.passworderrorMessage(), "*Password is required");
	}

	@Test(enabled = false)

	public void loginWithInvalidCred() throws IOException {
		loginpage.login("knsdkj", "anskjan");
		Assert.assertEquals(loginpage.inavldEmailErrMessage(), "*Enter Valid Email");
	}

	@Test(enabled = false)

	public void loginWithWrongPass() throws IOException {
		loginpage.login("anshika@gmail.com", "anskjan");
		Assert.assertEquals(loginpage.invalidEmailorpassMessage(), "Incorrect email or password.");
	}
	
	/*	@Test(dataProvider = "getData")

	public void login(String email, String pass) {
		loginpage.login(email,pass);
		
		//Quest: How we use asset in this? to check whether test case is failed or pass?
//		Assert.assertEquals(loginpage.loginSuccessMessage(), "Login Successfully");
//		Assert.assertEquals(loginpage.emailerrorMessage(), "*Email is required");
//		Assert.assertEquals(loginpage.passworderrorMessage(), "*Password is required");
//		Assert.assertEquals(loginpage.inavldEmailErrMessage(), "*Enter Valid Email");
//		Assert.assertEquals(loginpage.invalidEmailorpassMessage(), "Incorrect email or password.");

	}
	
	@DataProvider()
	public Object[][] getData()
	{
		//1. Valid credentials
		//2. Invalid credential
		//3. Blank credential
		//4. Wrong password
		//We need to create one Object class array
		Object data[][] = new Object[4][2];
		//1st data set
		data[0][0]="anshika@gmail.com";
		data[0][1]="Iamking@000";
		//2nd data set
		data[1][0]="anshika@gmail.com";
		data[1][1]="anskjan";
		//3rd data set
		data[2][0]="knsdkj";
		data[2][1]="anskjan";
		//4th data set
		data[3][0]="";
		data[3][1]="";
		return data;
*/	
	
/*	@DataProvider()
	public Object[][] getData()
	{
		return new Object[][] {{"anshika@gmail.com","Iamking@000"},{"anshika@gmail.com","anskjan"},{"knsdkj","anskjan"},{"",""}};
		//return data;
	}  */

	
	
/*	@Test(dataProvider = "getData")

	public void login(HashMap<String, String> hm) 
	{
		loginpage.login(hm.get("email"), hm.get("password"));
	}
	
	//you can provide the data in array and in hashmap
	@DataProvider()
	public Object[][] getData()    //we are using hashmap because it's difficult to pass many arguments in our test above
	{
		HashMap<String, String> hm = new HashMap<>();  //<Object,Object> means key value pair is in any data type
		hm.put("email", "anshika@gmail.com");
		hm.put("password", "Iamking@000");
		
		HashMap<String, String> hm1 = new HashMap<>();
		hm1.put("email", "anshika@gmail.com");
		hm1.put("password", "hwduyd");
		
		HashMap<String, String> hm2 = new HashMap<>();
		hm2.put("email", "hiueqhfiuq");
		hm2.put("password", "jksdj");
		
		HashMap<String, String> hm3 = new HashMap<>();
		hm3.put("email", "");
		hm3.put("password", "");
		
		return new Object[][] {{hm},{hm1},{hm2},{hm3}};
	} */
	
	
	@Test(dataProvider = "getData")

	public void login(HashMap<String, String> hm) 
	{
		loginpage.login(hm.get("email"), hm.get("password"));
	}
	
	@DataProvider()
	public Object[][] getData() throws IOException    //we are providing this data from json file
	{
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//Data//LoginCredentials.json");
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)}};
	}
	
}
