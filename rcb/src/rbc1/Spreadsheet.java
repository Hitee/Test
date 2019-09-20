package rbc1;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Spreadsheet {

	 public Spreadsheet() {
	        Workbook AccountInfo = new HSSFWorkbook();
	        Sheet Information = AccountInfo.createSheet();

	        Row titles = Information.createRow(0);

	        Cell username = titles.createCell(0);
	        username.setCellValue("Username");

	        Cell password = titles.createCell(1);
	        password.setCellValue("Password");

	        try {
	            FileOutputStream Accounts = new FileOutputStream("Account Information.xls");
	            AccountInfo.write(Accounts);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	
}
