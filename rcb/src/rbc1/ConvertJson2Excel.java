package rbc1;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJson2Excel {
	public static void main(String[] args) throws IOException {
		// Step 1: Read JSON File to List Objects
		List customers = readJsonFile2Objects("customers.json");
		
    	// Step 2: Convert Java List Objects to JSON File
    	writeObjects2ExcelFile(customers, "customers.xlsx");
	}
	
	/**
	 * 
	 * Convert JSON String to Java List Objects
	 * 
	 * @param pathFile
	 * @return
	 */
	private static List readJsonFile2Objects(String pathFile){
		InputStream inJson = Customer.class.getResourceAsStream(pathFile);
		List customers = null;
		
		try {
			customers = new ObjectMapper().readValue(inJson, new TypeReference>(){});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return customers;
	}
	
	/**
	 * 
	 * Write Java Object Lists to Excel File
	 * 
	 * @param customers
	 * @param filePath
	 * @throws IOException 
	 */
	private static void writeObjects2ExcelFile(List customers, String filePath) throws IOException {
		String[] COLUMNs = {"Id", "Name", "Address", "Age"};
		
		Workbook workbook = new XSSFWorkbook();
		 
		CreationHelper createHelper = workbook.getCreationHelper();
 
		Sheet sheet = workbook.createSheet("Customers");
 
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setColor(IndexedColors.BLUE.getIndex());
 
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
 
		// Row for Header
		Row headerRow = sheet.createRow(0);
 
		// Header
		for (int col = 0; col < COLUMNs.length; col++) {
			Cell cell = headerRow.createCell(col);
			cell.setCellValue(COLUMNs[col]);
			cell.setCellStyle(headerCellStyle);
		}
 
		// CellStyle for Age
		CellStyle ageCellStyle = workbook.createCellStyle();
		ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
 
		int rowIdx = 1;
		for (Customer customer : customers) {
			Row row = sheet.createRow(rowIdx++);
 
			row.createCell(0).setCellValue(customer.getId());
			row.createCell(1).setCellValue(customer.getName());
			row.createCell(2).setCellValue(customer.getAddress());
 
			Cell ageCell = row.createCell(3);
			ageCell.setCellValue(customer.getAge());
			ageCell.setCellStyle(ageCellStyle);
		}
 
		FileOutputStream fileOut = new FileOutputStream(filePath);
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
	}
}