package rbc1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
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
		FileOutputStream fileOut = new FileOutputStream("C:/Users/hisachde/Desktop/Test.xls");
		JSONParser parser = new JSONParser();
		JSONArray a = (JSONArray) parser.parse(new FileReader("pattern3.json"));
		String toWrite = " ";
		//int i = 0 ;
		for (Object o : a)
		{


			//Row row1 = sheet.createRow((short) 0);

			JSONObject person = (JSONObject) o;
			System.out.println("person size " + person.size());
			String name = (String) person.get("name");
			System.out.println(name);
			//	i++;
			//System.out.println("value of i " + i);
			Row row1 = sheet.createRow((short) 0);
			row1.createCell(0).setCellValue(createHelper.createRichTextString(name));
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
			row1.createCell(1).setCellValue(createHelper.createRichTextString(city));
			//System.out.println("row1 " + row1);



			String job = (String) person.get("job");
			System.out.println(job);
			//i++;
			//System.out.println("value of i " + i);
			//row1 = sheet.createRow((short) i);
			//System.out.println("row1 " + row1);
			row1.createCell(2).setCellValue(createHelper.createRichTextString(job));
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

				
				toWrite = toWrite.concat("id : ").concat(id).concat(" , ").concat("email : ").concat(" ").concat(email).concat("  ");
				row1.createCell(3).setCellValue(createHelper.createRichTextString(toWrite));
				//System.out.println(row1.toString());


				//i++;
				//System.out.println("value of i " + i);

				//}

			}wb.write(fileOut);  
			//}

		}
	}
}