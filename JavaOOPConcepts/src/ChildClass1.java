import org.testng.annotations.Test;

public class ChildClass1 extends ParentClass1{

	@Test
	public void runTest() {
		test();
		AnotherClass ac = new AnotherClass(3);
		System.out.println(ac.increment());
		System.out.println(ac.decrement());
	}
}
