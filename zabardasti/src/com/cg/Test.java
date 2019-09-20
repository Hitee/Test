package com.cg;
import com.mercury.qualitycenter.otaclient.ClassFactory;
import com.mercury.qualitycenter.otaclient.ITDConnection;

 

public class Test {  

public static void main(String[] args) {

//QC url

String url = "http://your alm server/qcbin";

//username for login

String username = "username";

//password for login

String password = "password";

//domain

String domain = "domian name";

//project

String project = "project name";

ITDConnection itdc = ClassFactory.createTDConnection();

itdc.initConnectionEx(url);

itdc.connectProjectEx(domain, project, username, password);

}

}

 
