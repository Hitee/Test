package maven.excel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//import org.apache.poi.hssf.model.Workbook;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excel {

	public static void main(String args[]) throws IOException

	{

		//To create a new WorkBook with xls extension

		HSSFWorkbook wb = new HSSFWorkbook();

		FileOutputStream fileOut = new FileOutputStream("C:/Users/hisachde/Desktop/Test.xls");

		wb.write(fileOut);

		fileOut.close();

		//To create a new WorkBook with xlsx extension

		//Workbook wb1 = new XSSFWorkbook();

		FileOutputStream fileOut1 = new FileOutputStream("C:/Users/hisachde/Desktop/Test1.xlsx");

		wb.write(fileOut1);

		fileOut1.close();

	}

}
