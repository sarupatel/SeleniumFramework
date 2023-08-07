package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderMethod {

	@Test(dataProvider="testData")
	public void pintUserPass(String user, String pass) {
		System.out.println("Username: "+ user);
		System.out.println("Password: "+ pass);
	}
	
	@DataProvider
	public Object[][] testData() {
		//Object[][] data = new Object[3][2] - can be defined this way then data needs to be provided individually
		Object[][] data = {{"firstUser","firstPassword"},{"secondUser","secondPassword"},{"thirdUser", "thirdPassword"}};
		return data;	
	}
}
