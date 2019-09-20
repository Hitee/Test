package employeeRegistration;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import EmpoyeeBean.EmployeePageBean;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefEmployeeDetails {
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
		obj.setFirstName("");
		obj.setButton();
	}

	@Then("^display 'Please fill the FirstName'$")
	public void display_Please_fill_the_FirstName() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(driver.switchTo().alert().getText(), "Please fill the First Name");
	}

	@When("^user enters invalid LastName$")
	public void user_enters_invalid_LastName() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		obj.setFirstName("Azazel");
		obj.setLastName("");
		obj.setButton();

	}

	@Then("^display 'Please fill the LastName'$")
	public void display_Please_fill_the_LastName() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(driver.switchTo().alert().getText(), "Please fill the Last Name");

	}

	@When("^user enters invalid Email$")
	public void user_enters_invalid_Email() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		obj.setFirstName("Azazel");
		obj.setLastName("Cooper");
		obj.setEmail("");
		obj.setButton();

	}

	@Then("^display 'Please fill the Email'$")
	public void display_Please_fill_the_Email() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(driver.switchTo().alert().getText(), "Please fill the Email");

	}

	@When("^user enters invalid MobileNo$")
	public void user_enters_invalid_MobileNo() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		obj.setFirstName("Azazel");
		obj.setLastName("Cooper");
		obj.setEmail("dutta.nikkon@gmail.com");
		obj.setMobileNumber("");
		obj.setButton();

	}

	@Then("^display 'Please fill the MobileNo'$")
	public void display_Please_fill_the_MobileNo() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(driver.switchTo().alert().getText(), "Please fill the Mobile No.");

	}

	@When("^user enters invalid Salary$")
	public void user_enters_invalid_Salary() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		obj.setFirstName("Azazel");
		obj.setLastName("Cooper");
		obj.setEmail("dutta.nikkon@gmail.com");
		obj.setMobileNumber("9898878776");
		obj.setSalary("");
		obj.setButton();

	}

	@Then("^display 'Please fill the Salary'$")
	public void display_Please_fill_the_Salary() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(driver.switchTo().alert().getText(), "Please fill the Salary");

	}

	@When("^user enters invalid PayBand$")
	public void user_enters_invalid_PayBand() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		obj.setFirstName("Azazel");
		obj.setLastName("Cooper");
		obj.setEmail("dutta.nikkon@gmail.com");
		obj.setMobileNumber("9898878776");
		obj.setSalary("2500");
		obj.setPayband("");
		obj.setButton();

	}

	@Then("^display 'Please fill the Payband'$")
	public void display_Please_fill_the_Payband() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(driver.switchTo().alert().getText(), "Please select Payband");

	}

	@When("^user enters invalid City$")
	public void user_enters_invalid_City() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		obj.setFirstName("Azazel");
		obj.setLastName("Cooper");
		obj.setEmail("dutta.nikkon@gmail.com");
		obj.setMobileNumber("9898878776");
		obj.setSalary("2500");
		obj.setPayband("A5");
		obj.setCity("");
		obj.setButton();

	}

	@Then("^display 'Please fill the City'$")
	public void display_Please_fill_the_City() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(driver.switchTo().alert().getText(), "Please select city");

	}

	@When("^user enters invalid State$")
	public void user_enters_invalid_State() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		obj.setFirstName("Azazel");
		obj.setLastName("Cooper");
		obj.setEmail("dutta.nikkon@gmail.com");
		obj.setMobileNumber("9898878776");
		obj.setSalary("2500");
		obj.setPayband("A5");
		obj.setCity("Chennai");
		obj.setState("");
		obj.setButton();
	}

	@Then("^display 'Please fill the State'$")
	public void display_Please_fill_the_State() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(driver.switchTo().alert().getText(), "Please select state");

	}
}
