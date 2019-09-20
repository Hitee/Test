package rbc1;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONExample5
{
	static Workbook wb = new HSSFWorkbook();
	
	static CreationHelper createHelper = wb.getCreationHelper();
	static org.apache.poi.ss.usermodel.Sheet sheet = wb.createSheet("Sheet1");
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException
	{
		
		//JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("pattern3.json"))
		{
			//Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray employeeList = (JSONArray) obj;
			System.out.println(employeeList);
			System.out.println(employeeList.size() + " this is the size");
			for (int i = 0 ; i<employeeList.size() ; i++)
			{
				Row row1 = sheet.createRow((short) i);
				//Row row[i] = sheet.createRow((short) i);
			}
			//for ( int  i = 0 ; i<employeeList.size() ; i++)
			//Iterate over employee array
			
			
			employeeList.forEach( emp -> {
				try {
					parseEmployeeObject( (JSONObject) emp );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} );
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void parseEmployeeObject(JSONObject employee) throws IOException
	{

		FileOutputStream fileOut = new FileOutputStream("C:/Users/hisachde/Desktop/Test.xls");

		
		//Get employee object within list
		JSONObject employeeObject = (JSONObject) employee.get("cars");
		System.out.println("size" + employeeObject.size());

		//Row row1 = sheet.createRow((short) 0);
		System.out.println("employee" + employee);
		
		
		for (int i = 0 ; i < employeeObject.size() -1; i++)
		{
			 Row row1 = sheet.createRow((short) i);
		
		
		
		//Get employee first name
		
		
		String firstName = (String) employeeObject.get("name");   
		System.out.println("name");
		row1.createCell(0).setCellValue(
				  
				  createHelper.createRichTextString("name"));
		 

		//Get employee last name
		String city = (String) employeeObject.get("city"); 
		System.out.println(city);
		row1.createCell(1).setCellValue(
				  
				  createHelper.createRichTextString(city));

		//Get employee website name
		String job = (String) employeeObject.get("job");   
		System.out.println(job);
		row1.createCell(2).setCellValue(
				  
				  createHelper.createRichTextString(job));
		wb.write(fileOut);  
		}
	}
}