package DataDrivenframework.ExcelDriven;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidedSample {

	@Test(dataProvider="testData")
	public void testMethod(String greeting, String communication, String id) {
		System.out.println(greeting+" "+communication+" "+id);
	}
	
	@DataProvider(name="testData")
	public Object[][] getData() throws IOException {
		//Object[][] data = {{"hello", "text", "1"}, {"bye", "message", "123"}, {"solo", "call", "463"}};
		//return data;
		
		
		FileInputStream fis = new FileInputStream("C:/Selenium/data/testData.xlsx");
		XSSFWorkbook excel = new XSSFWorkbook(fis);
		XSSFSheet testSheet = excel.getSheet("Sheet1");
		int rowCount = testSheet.getPhysicalNumberOfRows();
		int firstRowNum = testSheet.getFirstRowNum();
		XSSFRow firstRow= testSheet.getRow(firstRowNum);
		int columnCount = firstRow.getPhysicalNumberOfCells();
		System.out.println(rowCount+ " " + columnCount);
		Object[][] data = new Object[rowCount][columnCount]; 
		
		Iterator<Row> rows = testSheet.rowIterator();
		
		Row row = null;
		int i =0;
		int j=0;
		while(rows.hasNext()) {
			row = rows.next();

			Iterator<Cell> cells = row.cellIterator();
			while(cells.hasNext()) {
				Cell cellData = cells.next();

				if(cellData.getCellType()!=CellType.BLANK) {
						if(cellData.getCellType()==CellType.NUMERIC) {
							System.out.println(NumberToTextConverter.toText(cellData.getNumericCellValue()));
							data[i][j]=NumberToTextConverter.toText(cellData.getNumericCellValue());
							j++;
							continue;
						}
						System.out.println(cellData.getStringCellValue());
						data[i][j]=cellData.getStringCellValue();
						j++;
				}
			}
			if(j>0) {
				i++;
				j=0;
			}
			
		}	
		excel.close();
		return data;
	}
	
	
	
}
