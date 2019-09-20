package com.cg;

import com.mercury.qualitycenter.otaclient.ClassFactory;
import com.mercury.qualitycenter.otaclient.ITDConnection;
//import com4j.Com4jObject;
public class alm {
public static void main(String[] args) {
	System.out.println("jijj");
	String url="http://XXXX/qcbin/";
    String domain="ACTIVE";
    String project="QC_2013_Projects";
    String username="XXXX";
    String password="XXXXX";
    try{
        ITDConnection itd=ClassFactory.createTDConnection();
        itd.initConnectionEx(url);
        System.out.println("Test1:"+ itd.connected());

        itd.connectProjectEx(domain,project,username,password);

        //System.out.println(itd.connected());
    }catch(Exception e){

        e.printStackTrace();
    }
}
}
