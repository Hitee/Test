package rbc1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.sun.faces.util.Json;
/*
import javax.json.Json;
import javax.json.JsonObject;*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class ReadJsonExample {
 
    public static void main(String a[]){
         
        File jsonInputFile = new File("/Users/java2novice/jsonInput.txt");
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Create JsonReader from Json.
            JsonReader reader = Json.createReader(is);
            // Get the JsonObject structure from JsonReader.
            JsonObject empObj = reader.readObject();
            reader.close();
            // read string data
            System.out.println("Emp Name: " + empObj.getString("emp_name"));
            // read integer data
            System.out.println("Emp Id: " + empObj.getInt("emp_id"));
            // read inner json element
            JsonObject addrObj = empObj.getJsonObject("address");
            System.out.println("City: " + addrObj.getString("city"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}