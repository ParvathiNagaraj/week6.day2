package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {

	@Test
	public void readData() throws IOException {

		// Open the Excel sheet
		XSSFWorkbook book = new XSSFWorkbook("./TestDatas/tc001.xlsx");

		// get to sheet where data is available

		XSSFSheet sheet = book.getSheetAt(0);

		// get row count
		int rowCount = sheet.getLastRowNum();
		System.out.println("The Row Count is " + rowCount);

		// get column count
		XSSFRow headerRow = sheet.getRow(0);
		short colCount = headerRow.getLastCellNum();
		System.out.println("The Column count is " + colCount);

		// getting datas from each cell

		for (int i = 1; i <= rowCount; i++) {

			XSSFRow eachRow = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {

				XSSFCell eachCol = eachRow.getCell(j);
				String data = eachCol.getStringCellValue();
				System.out.print(data+"\t");
			}
			
			System.out.println();
		}

	}

}
