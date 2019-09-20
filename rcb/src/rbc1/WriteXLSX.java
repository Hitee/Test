package rbc1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
public class WriteXLSX {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(new File("C:/Users/hisachde/Desktop/hi.xlsx"));
		Workbook workbook = new HSSFWorkbook (fis);
		Sheet sheet = workbook.getSheetAt(0);
		//Create First Row
		Row row1 = sheet.createRow(0);
		Cell r1c1 = row1.createCell(0);
		r1c1.setCellValue("Emd Id");
		Cell r1c2 = row1.createCell(1);
		r1c2.setCellValue("NAME");
		Cell r1c3 = row1.createCell(2);
		r1c3.setCellValue("AGE");
		//Create Second Row
		Row row2 = sheet.createRow(1);
		Cell r2c1 = row2.createCell(0);
		r2c1.setCellValue("1");
		Cell r2c2 = row2.createCell(1);
		r2c2.setCellValue("Ram");
		Cell r2c3 = row2.createCell(2);
		r2c3.setCellValue("20");		
		//Create Third Row
		Row row3 = sheet.createRow(2);
		Cell r3c1 = row3.createCell(0);
		r3c1.setCellValue("2");
		Cell r3c2 = row3.createCell(1);
		r3c2.setCellValue("Shyam");
		Cell r3c3 = row3.createCell(2);
		r3c3.setCellValue("25");
		fis.close();
		FileOutputStream fos =new FileOutputStream(new File("D:\\xlsx\\test.xlsx"));
	        workbook.write(fos);
	        fos.close();
		System.out.println("Done");
	}
} 
