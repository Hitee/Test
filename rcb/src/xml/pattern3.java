package xml;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import javax.print.DocFlavor.STRING;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class pattern3 {

	static Workbook wb = new HSSFWorkbook();

	static CreationHelper createHelper = wb.getCreationHelper();
	static org.apache.poi.ss.usermodel.Sheet sheet = wb.createSheet("Sheet1");

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		////READING CELLS FROM EXCEL SHEET
		 String[] S = new String[4];
		 String excelFilePath = "C:/Users/hisachde/Desktop/Test.xls";
	        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	         
	        Workbook workbook = new HSSFWorkbook(inputStream);
	        Sheet firstSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = firstSheet.iterator();
	         
	        while (iterator.hasNext()) {
	            Row nextRow = iterator.next();
	            Iterator<Cell> cellIterator = nextRow.cellIterator();
	             int i = 0;
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	               // String[] S = new String[4];
	                switch (cell.getCellType()) {
	                    case Cell.CELL_TYPE_STRING:
	                        System.out.print(cell.getStringCellValue());
	                        S[i] = cell.getStringCellValue();
	                        System.out.println("this is i " + i);
	                         i++;
	                        //System.out.println("this is c " + c);
	                        break;
	                    case Cell.CELL_TYPE_BOOLEAN:
	                        System.out.print(cell.getBooleanCellValue());
	                        break;
	                    case Cell.CELL_TYPE_NUMERIC:
	                        System.out.print(cell.getNumericCellValue());
	                        break;
	                }
	                System.out.print(" - ");
	            }
	            System.out.println();
	        }
	         
	        //((FileInputStream) workbook).close();
	        inputStream.close();
		
		
		
		/////////////////////////////////////////////////////
		FileOutputStream fileOut = new FileOutputStream("C:/Users/hisachde/Desktop/Test.xls");
		
		
		JSONParser parser = new JSONParser();
		JSONArray a = (JSONArray) parser.parse(new FileReader("pattern6.json"));
		String toWrite = " ";
		//int i = 0 ;
		Row row = sheet.createRow((short) 0);
		System.out.println("cell 0 is " + row.getCell(0));
		for (Object o : a)
		{


			// for name
			//System.out.println("type name");
			//BufferedReader reader =  
	         //          new BufferedReader(new InputStreamReader(System.in)); 
	         
	        // Reading data using readLine 
	       // String name2 = reader.readLine(); 
	  
			//Row row1 = sheet.createRow((short) 0);

			JSONObject person = (JSONObject) o;
			System.out.println("person size " + person.size());
			//S                                                                       tring name = (String) person.get(name2);
			//System.out.println("name " + name);
			//	i++;
			//System.out.println("value of i " + i);
			Row row1 = sheet.createRow((short) 1);
			
			
	        // Printing the read line 
	       /// System.out.println("name2 " + name2);    
			String name = (String) person.get("name");
			System.out.println(name);
			row1.createCell(0).setCellValue(createHelper.createRichTextString(S[0]));
			//System.out.println("cell 0 is " + row1.getCell(0));
			//wb.write(fileOut);  
			/*
			 * row1.createCell(0).setCellValue(createHelper.createRichTextString(name));
			 * wb.write(fileOut);
			 */


			String city = (String) person.get("city");
			System.out.println(city);
			//i++;
			//System.out.println("value of i " + i);
			//row1 = sheet.createRow((short) i);
			row1.createCell(1).setCellValue(createHelper.createRichTextString(S[1]));
			
			//System.out.println("row1 " + row1);



			String job = (String) person.get("job");
			System.out.println(job);
			//i++;
			//System.out.println("value of i " + i);
			//row1 = sheet.createRow((short) i);
			//System.out.println("row1 " + row1);
			row1.createCell(2).setCellValue(createHelper.createRichTextString(S[2]));
			//wb.write(fileOut);  

			JSONArray cars = (JSONArray) person.get("cars");

			for (Object c : cars)
			{

				//Row row = sheet.createRow((short) i);

				JSONObject person2 = (JSONObject) c;
				String id = (String) person2.get("id");
				System.out.println(id);

				String email = (String) person2.get("email");
				System.out.println(email);

				
				toWrite = toWrite.concat("id : ").concat(id).concat(" , ").concat("email : ").concat(" ").concat(email).concat(" ; ");
				row1.createCell(3).setCellValue(createHelper.createRichTextString(S[3]));
				//System.out.println(row1.toString());


				//i++;
				//System.out.println("value of i " + i);

				//}

			}wb.write(fileOut);  
			//}

		}
	}
}