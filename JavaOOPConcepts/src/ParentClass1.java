import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ParentClass1 {

	public void test() {
		System.out.println("I am cool");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("I am first");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("I am last");
	}
}
