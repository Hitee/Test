import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import EmpoyeeBean.EmployeePageBean;
//import EmpoyeeBean.EmployeePageBean;
//import EmpoyeeBean.EmployeePageBean;
public class webDriver {
	/*
	WebDriver driver = new ChromeDriver();
	//driver = new ChromeDriver();
	 public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		 driver.get("http://google.com");
		 //String textbox = "//*[@id="tsf"]/div[2]/div[1]/div[1]/div/div[2]/input";

		WebElement flag = driver.findElement(By.className("a4bIc"));
System.out.println(flag.toString());
flag.sendKeys("gvuftfv");
		Actions actions = new Actions(driver);
		///..WebElement elementLocator = driver.findElement(By.id("ID"));
		//actions.doubleClick().perform();
		actions.contextClick(flag).perform();
		//flag.sendKeys(arg0);
		//driver.wait(3000);
		driver.close();


	 */		
	//}
	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();					
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");					
		Actions actions = new Actions(driver);
		String baseUrl = "http://demo.guru99.com/test/login.html";					
		driver.get(baseUrl);					

		// Get the WebElement corresponding to the Email Address(TextField)		
		WebElement email = driver.findElement(By.id("email"));							

		// Get the WebElement corresponding to the Password Field		
		WebElement password = driver.findElement(By.name("passwd"));							

		email.sendKeys("abcd@gmail.com");
		actions.contextClick(email).perform();
		password.sendKeys("abcdefghlkjl");					
		System.out.println("Text Field Set");					

		// Deleting values in the text box		
		email.clear();			
		password.clear();			
		System.out.println("Text Field Cleared");					

		// Find the submit button		
		WebElement login = driver.findElement(By.id("SubmitLogin"));							

		// Using click method to submit form		
		email.sendKeys("abcd@gmail.com");					
		password.sendKeys("abcdefghlkjl");					
		login.click();			
		System.out.println("Login Done with Click");					

		//using submit method to submit the form. Submit used on password field		
		driver.get(baseUrl);					
		driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");							
		driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");							
		driver.findElement(By.id("SubmitLogin")).submit();					
		System.out.println("Login Done with Submit");					

		//driver.close();		

	}}
