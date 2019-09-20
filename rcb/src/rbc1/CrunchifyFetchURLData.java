package rbc1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class CrunchifyFetchURLData {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:/Users/hisachde/Desktop/hellooo.xls");
	//	File file = new File("C:/Users/hisachde/Desktop/hello.doc");
		//File file = new File("C:/Users/hisachde/Desktop/hello.txt");
        FileWriter fr = null;
        fr = new FileWriter(file);
		
		try {
			URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=chicago&sensor=false&#8221");
			//URL url = new URL("https://reqres.in/api/users");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String strTemp = "";
			while (null != (strTemp = br.readLine())) {
				 
				try
				{
				fr.write(strTemp);
				System.out.println(strTemp);
				
				}
				catch(IOException e)
				{
					System.out.println("ERRORRR" + e); 
				}
				
						
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			fr.close();
		}
	}
}