package DataDrivenframework.ExcelDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven {


	public ArrayList<String> getData(String testcaseName) throws IOException {
		FileInputStream fis = new FileInputStream("C:/Selenium/data/demoData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		ArrayList<String> arr = new ArrayList<>();
		
		int sheets = workbook.getNumberOfSheets();
		for(int i=0;i<sheets; i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet sheet = workbook.getSheetAt(i); 
				//Get access to rows
				Iterator<Row> rows = sheet.rowIterator(); //collection of rows
				Row row = rows.next();
				Iterator<Cell> cells = row.cellIterator(); //collection of cells
				int columnIndex=0;
				while(cells.hasNext()) {
					Cell firstCell = cells.next();	
						if(firstCell.getStringCellValue().equalsIgnoreCase("TestCases")) {
							columnIndex = firstCell.getColumnIndex();
							System.out.println(columnIndex);
							break;
						}
				}
				//int rowIndex=0;
				while(rows.hasNext()) {
					row = rows.next();
					if(row.getCell(columnIndex).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						//rowIndex=row.getRowNum();
						//System.out.println(rowIndex);
						Iterator<Cell> cd = row.cellIterator();
						Cell cellValue;
						while(cd.hasNext()) {
							cellValue = cd.next();
							if(cellValue.getCellType()==CellType.STRING) {
							arr.add(cellValue.getStringCellValue());
							} else {
								arr.add(NumberToTextConverter.toText(cellValue.getNumericCellValue()));
							}
						}
						break;
					}
				}
			}
		}
		workbook.close();
		fis.close();
		return arr;
	}

}
