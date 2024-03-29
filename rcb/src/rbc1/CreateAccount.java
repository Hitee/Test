package rbc1;

import java.awt.Event;
import java.io.InputStream;
import java.net.URL;

public class CreateAccount {
	URL url = new URL("https://graph.facebook.com/search?q=java&type=post");
	  try (InputStream is = url.openStream();
	       JsonParser parser = Json.createParser(is)) {
	      while (parser.hasNext()) {
	          Event e = parser.next();
	          if (e == Event.KEY_NAME) {
	              switch (parser.getString()) {
	                  case "name":
	                      parser.next();
	                    System.out.print(parser.getString());
	                    System.out.print(": ");
	                    break;
	                case "message":
	                    parser.next();
	                    System.out.println(parser.getString());
	                    System.out.println("---------");
	                    break;
	             }
	         }
	     }
	 }
}
