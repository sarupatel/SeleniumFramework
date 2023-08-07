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

public class ExtractDataFromExcel {

	public static void main(String[] args) throws IOException {
		
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

				//if(!cellData.getStringCellValue().isEmpty()) {
				if(cellData.getCellType()!=CellType.BLANK) {
						//if(cellData.getCellType()==CellType.STRING) {
							//System.out.println(cellData.getStringCellValue());
							//data[i][j]=cellData.getStringCellValue();
							//i++;
						//} else 
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

	}

}
