package rbc1;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;



//import org.apache.poi.hslf.model.Sheet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.util.WorkbookUtil;



public class createnewsheet {

	public static void main(String args[]) throws IOException

	{



		//create a new workbook

		Workbook wb = new HSSFWorkbook();

		FileOutputStream fileOut = new FileOutputStream("C:/Users/hisachde/Desktop/Test.xls");



		//create a new sheet with sheet name Vineet1

		org.apache.poi.ss.usermodel.Sheet sheet1 = wb.createSheet("Sheet1");



		//create a new sheet with sheet name Vineet2



		org.apache.poi.ss.usermodel.Sheet sheet2 = wb.createSheet("Sheet2");



		//create a new sheet with sheet name Expense Details

		String safeName = WorkbookUtil.createSafeSheetName("[Test Details*?]");

		org.apache.poi.ss.usermodel.Sheet sheet3 = wb.createSheet(safeName);



		wb.write(fileOut);

		fileOut.close();

	}



}