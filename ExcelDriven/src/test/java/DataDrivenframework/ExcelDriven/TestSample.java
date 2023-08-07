package DataDrivenframework.ExcelDriven;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws IOException {
		
		ExcelDataDriven exd = new ExcelDataDriven();
		ArrayList<String> data = exd.getData("Purchase");
		data.stream().forEach(s -> System.out.println(s));
	}

}
