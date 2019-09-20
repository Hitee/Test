package employeeValidation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import EmpoyeeBean.EmployeePageBean;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefEmployeeValidation {
	private WebDriver driver;
	private EmployeePageBean obj;

	@Before
	public void beforeConfirm() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Given("^User is on 'hotelBooking' Page$")
	public void user_is_on_hotelBooking_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		obj = new EmployeePageBean(driver);
		driver.get("file:///C:/Users/admin/Desktop/pages/employee.html");

	}

	@When("^user enters invalid FirstName$")
	public void user_enters_invalid_FirstName() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		obj.setFirstName("nik");
		obj.setButton();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

	}

	@Then("^display 'Please fill the FirstName'$")
	public void display_Please_fill_the_FirstName() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(driver.switchTo().alert().getText(), "Please enter valid First Name");
	}

	@When("^user enters invalid LastName$")
	public void user_enters_invalid_LastName() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		obj.setFirstName("Azazel");
		obj.setLastName("cooper");
		obj.setButton();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

	}

	@Then("^display 'Please fill the LastName'$")
	public void display_Please_fill_the_LastName() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(driver.switchTo().alert().getText(), "Please enter valid Last Name");
	}

	@When("^user enters invalid Email$")
	public void user_enters_invalid_Email() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		obj.setFirstName("Azazel");
		obj.setLastName("Cooper");
		obj.setEmail("asq@qwr");
		obj.setButton();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

	}

	@Then("^display 'Please fill the Email'$")
	public void display_Please_fill_the_Email() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(driver.switchTo().alert().getText(), "Please enter valid Email Id.");
	}

	@When("^user enters invalid MobileNo$")
	public void user_enters_invalid_MobileNo() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		obj.setFirstName("Azazel");
		obj.setLastName("Cooper");
		obj.setEmail("dutta.nikkon@gmail.com");
		obj.setMobileNumber("45678");
		obj.setButton();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

	}

	@Then("^display 'Please fill the MobileNo'$")
	public void display_Please_fill_the_MobileNo() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(driver.switchTo().alert().getText(), "Please enter valid Mobile no.");
	}

	@When("^user enters invalid Salary$")
	public void user_enters_invalid_Salary() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		obj.setFirstName("Azazel");
		obj.setLastName("Cooper");
		obj.setEmail("dutta.nikkon@gmail.com");
		obj.setMobileNumber("9898878776");
		obj.setSalary("11");
		obj.setButton();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

	}

	@Then("^display 'Please fill the Salary'$")
	public void display_Please_fill_the_Salary() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(driver.switchTo().alert().getText(), "Please enter valid Salary");
	}

	@When("^user enters Salary in wrong format$")
	public void user_enters_Salary_in_wrong_format() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		obj.setFirstName("Azazel");
		obj.setLastName("Cooper");
		obj.setEmail("dutta.nikkon@gmail.com");
		obj.setMobileNumber("9898878776");
		obj.setSalary("2123");
		obj.setButton();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

	}

	@Then("^display 'Please provide salary in correct format'$")
	public void display_Please_provide_salary_in_correct_format() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//assertEquals(true, Pattern.matches("[0-9]{4}", obj.getSalary()+""));
		assertTrue(Pattern.matches("[0-9]{4}",""+obj.getSalary()));
	}
	
	@After
	public void closeDriver() {
		driver.close();
	}
}
