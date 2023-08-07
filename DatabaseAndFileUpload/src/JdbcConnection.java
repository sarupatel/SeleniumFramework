import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException, InterruptedException {
		
		//"jdbc:mysql://"+host+":"+port+"/database";
		//jdbc:mysql://localhost:3306/demo;
		String host="localhost";
		String port="3306";
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/demo", "root", "Admin$11");
		Statement s = connect.createStatement();
		ResultSet results = s.executeQuery("select * from credentials where scenario='outstbalancecard'");
		results.next();
		String username = results.getString("username");
		String password = results.getString("password");
		
		System.out.println("Username: "+username+" & Password: "+password+" for outstbalancecard scenario");

		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("Login")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("div#error")).getText());
		driver.close();
	}

}
