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

public class pattern6 {
	public static void main(String[] args) throws Exception {  
	    JSONObject jsonObject = (JSONObject) readJsonSimpleDemo("example.json");
	    Person ben = new Person(
	                (String) jsonObject.get("name"),
	                Integer.valueOf(jsonObject.get("age").toString()),
	                (Boolean) jsonObject.get("isMarried"),
	                (List<String>) jsonObject.get("hobbies"),
	                (List<Person>) jsonObject.get("kids"));

	    System.out.println(ben);
	}
}
