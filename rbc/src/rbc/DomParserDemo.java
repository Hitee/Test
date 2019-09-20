/*https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
 */

package rbc;


import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParserDemo {
	/*static Workbook wb = new HSSFWorkbook();

	static CreationHelper createHelper = wb.getCreationHelper();
	static org.apache.poi.ss.usermodel.Sheet sheet = wb.createSheet("Sheet2");*/

	public static void main(String[] args) throws FileNotFoundException {
		//FileOutputStream fileOut = new FileOutputStream("C:/Users/hisachde/Desktop/Test.xls");
		try {
			File inputFile = new File("input.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("student");
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				//Row row1 = sheet.createRow((short) temp + 1);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("Student roll no : " 
							+ eElement.getAttribute("rollno"));
					//String ele = eElement.toString();
					System.out.println("this is temp " + temp);
					//row1.createCell(0).setCellValue(createHelper.createRichTextString(eElement.getAttribute("rollno")));
					//   wb.write(fileOut);  
					
					System.out.println("First Name : " 
							+ eElement
							.getElementsByTagName("firstname")
							.item(0)
							.getTextContent());
				/*	row1.createCell(1).setCellValue(createHelper.createRichTextString(eElement
							.getElementsByTagName("firstname")
							.item(0)
							.getTextContent()));*/
					
					System.out.println("Last Name : " 
							+ eElement
							.getElementsByTagName("lastname")
							.item(0)
							.getTextContent());
					/*row1.createCell(2).setCellValue(createHelper.createRichTextString(eElement
							.getElementsByTagName("lastname")
							.item(0)
							.getTextContent()));
					*/
					System.out.println("Nick Name : " 
							+ eElement
							.getElementsByTagName("nickname")
							.item(0)
							.getTextContent());
					/*row1.createCell(3).setCellValue(createHelper.createRichTextString(eElement
							.getElementsByTagName("nickname")
							.item(0)
							.getTextContent()));
					*/
					System.out.println("Marks : " 
							+ eElement
							.getElementsByTagName("marks")
							.item(0)
							.getTextContent());
					/*row1.createCell(4).setCellValue(createHelper.createRichTextString(eElement
							.getElementsByTagName("marks")
							.item(0)
							.getTextContent()));
					*/
				}
			}//wb.write(fileOut);  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}