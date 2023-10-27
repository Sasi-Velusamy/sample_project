package com.jetblue.checkIn.dataprovide;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jetblue.checkIn.pages.CheckIn;

public class ExcelUtils {
	String fileName = "CheckIn_Test_Data.xlsx";
	String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
			+ "resources" + File.separator + "testdata" + File.separator + fileName;
	XSSFWorkbook workbook;
	FileInputStream inputStream;
	FileOutputStream outputStream;
	String firstName, lastName, departureCity, pnr,checkInText;

	public void excelReader() {
		try {
			inputStream = new FileInputStream(new File(filePath));
			workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheet("checkInData");
			int rowCount = sheet.getPhysicalNumberOfRows() - 1;
			for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
				firstName = sheet.getRow(rowIndex).getCell(0).getStringCellValue();
				lastName = sheet.getRow(rowIndex).getCell(1).getStringCellValue();
				departureCity = sheet.getRow(rowIndex).getCell(2).getStringCellValue();
				pnr = sheet.getRow(rowIndex).getCell(3).getStringCellValue();
				if (firstName != null && lastName != null && departureCity != null && pnr != null) {
					String checkInStatus = CheckIn.pnrCheckIn(firstName, lastName, departureCity, pnr);
					if (checkInStatus == "Passed") {
						Row row = sheet.getRow(rowIndex);
						Cell cell = row.getCell(4);
						cell.setCellValue("CHECKIN");
						outputStream = new FileOutputStream(new File(filePath));
						workbook.write(outputStream);
					} else {
						Row row = sheet.getRow(rowIndex);
						Cell cell = row.getCell(4);
						cell.setCellValue("UNCHECKIN");
						outputStream = new FileOutputStream(new File(filePath));
						workbook.write(outputStream);
					}
				}
			}
			workbook.close();
			outputStream.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
