package rbc1;

import java.net.URL;

public class Test {
	
	
	public static void main(String[] args) {
	     try {
	         Send_HTTP_Request2.call_me();
	        } catch (Exception e) {
	         e.printStackTrace();
	       }
	     }
	
	public static void call_me() throws Exception {
	     String url = "http://api.ipinfodb.com/v3/ip-city/?key=d64fcfdfacc213c7ddf4ef911dfe97b55e4696be3532bf8302876c09ebd06b&ip=74.125.45.100&format=json";
	     URL obj = new URL(url);
	}
	
}
