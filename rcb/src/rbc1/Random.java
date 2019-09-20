package rbc1;

import java.util.Scanner;

public class Random {
 public static void main(String[] args) { 
	 String[] myArray= new String[5];
	 for(int i=0 ; i<5 ; i++)
		{
			 Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter data " + i);

		    String data = myObj.nextLine();  // Read user input
		    System.out.println("data " + i + " is: " + data);  // Output user input 
		   
			myArray[i] = data;
		    System.out.println(myArray[i]);
		    
		
		
		}
}
}
