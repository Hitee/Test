package rbc1;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class createworkbook {

	public static void main(String args[]) throws IOException

	{

		//To create a new WorkBook with xls extension

		Workbook wb = new HSSFWorkbook();

		FileOutputStream fileOut = new FileOutputStream("C:/Users/hisachde/Desktop/MavenTest.xls");

		wb.write(fileOut);

		fileOut.close();

		//To create a new WorkBook with xlsx extension

		Workbook wb1 = new XSSFWorkbook();

		FileOutputStream fileOut1 = new FileOutputStream("C:/Users/hisachde/Desktop/Test1.xlsx");

		wb.write(fileOut1);

		fileOut1.close();

	}

}