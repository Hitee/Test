/*https://chillyfacts.com/java-send-url-http-request-read-xml-response/
*/
package xml;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
public class Test_HTTP_XML {
	public static void main(String[] args) {
		Test_HTTP_XML oobj_Test_HTTP_XML=new Test_HTTP_XML();
		oobj_Test_HTTP_XML.get_response();
	}
	public void get_response(){
		try {
			String api_key="AIzaSyBWouAFmXPVE7sKpmq-xxPLgxmNb-q5THe";
			String cordinates="23.023047,81.073447";
			String format="xml";
			String url = "https://maps.googleapis.com/maps/api/timezone/"+format+"?location="+cordinates+"&timestamp=1458000000&key="+api_key;
			System.out.println(url);
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			int responseCode = con.getResponseCode();
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			//print in String
			// System.out.println(response.toString());
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new InputSource(new StringReader(response.toString())));
			NodeList errNodes = doc.getElementsByTagName("TimeZoneResponse");
			if (errNodes.getLength() > 0) {
				Element err = (Element)errNodes.item(0);
				System.out.println("raw_offset -"+err.getElementsByTagName("raw_offset").item(0).getTextContent());
				System.out.println("dst_offset -"+err.getElementsByTagName("dst_offset").item(0).getTextContent());
				System.out.println("time_zone_id -"+err.getElementsByTagName("time_zone_id").item(0).getTextContent());
				System.out.println("time_zone_name -"+err.getElementsByTagName("time_zone_name").item(0).getTextContent());
			} else { 
				// success
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}