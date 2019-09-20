package rbc1;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;
import java.util.Scanner;
import org.json.JSONObject;
//import org.apache.poi.hslf.model.Sheet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.CreationHelper;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Workbook;



public class CreatingCell2 {


	public static void main(String args[]) throws IOException {
		String[] myArray= new String[5];
		
		
		Workbook wb = new HSSFWorkbook();

		FileOutputStream fileOut = new FileOutputStream("C:/Users/hisachde/Desktop/Test.xls");

		// Workbook wb = new XSSFWorkbook();



		CreationHelper createHelper = wb.getCreationHelper();

		org.apache.poi.ss.usermodel.Sheet sheet = wb

				.createSheet("Sheet1");



		// Create the first Row



		Row row1 = sheet.createRow((short) 0);

		for(int i=0 ; i<5 ; i++)
		{
			 Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter data " + i);

		    String data = myObj.nextLine();  // Read user input
		    System.out.println("data " + i + " is: " + data);  // Output user input 
		    myArray[i] = data;
		    System.out.println(myArray[i]);
		    
		
		
		//}
		

		// inserting first row cell value

		row1.createCell(0).setCellValue(

				createHelper.createRichTextString(myArray[0]));



		row1.createCell(1).setCellValue(

				createHelper.createRichTextString(myArray[1]));



		row1.createCell(2).setCellValue(

				createHelper.createRichTextString(myArray[2]));



		row1.createCell(3).setCellValue(

				createHelper.createRichTextString(myArray[3]));



		row1.createCell(4).setCellValue(

				createHelper.createRichTextString(myArray[4]));

		}

		// creating second row



		Row row2 = sheet.createRow((short) 1);


		// inserting first row cell value

		row2.createCell(0).setCellValue(001);

		row2.createCell(1).setCellValue(

				createHelper.createRichTextString("Tshirt"));

		row2.createCell(2).setCellValue(

				createHelper.createRichTextString("Tshirt-description"));



		row2.createCell(3).setCellValue(

				createHelper.createRichTextString("0087l"));

		row2.createCell(4).setCellValue(

				createHelper.createRichTextString("Tshirt-model"));



		// Write the output to a file



		wb.write(fileOut);

		fileOut.close();

	}



}