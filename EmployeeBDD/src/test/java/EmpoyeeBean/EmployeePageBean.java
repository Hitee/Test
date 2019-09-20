package EmpoyeeBean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePageBean {
	
	WebDriver driver;
	// Elements
	@FindBy(id = "txtFirstName")
	@CacheLookup
	WebElement firstName;

	@FindBy(id = "txtLastName")
	@CacheLookup
	WebElement lastName;

	@FindBy(id = "txtEmail")
	@CacheLookup
	WebElement email;

	@FindBy(id = "txtPhone")
	@CacheLookup
	WebElement mobileNumber;

	@FindBy(id = "txtSalary")
	@CacheLookup
	WebElement salary;

	@FindBy(name = "payband")
	@CacheLookup
	WebElement payband;

	@FindBy(name = "city")
	@CacheLookup
	WebElement city;

	@FindBy(name = "state")
	@CacheLookup
	WebElement state;

	@FindBy(id = "btnPayment")
	@CacheLookup
	WebElement button;

	//Initiating driver
	public EmployeePageBean(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Setters
	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber.sendKeys(mobileNumber);
	}

	public void setSalary(String salary) {
		this.salary.sendKeys(salary);
	}

	public void setPayband(String payband) {
		this.payband.sendKeys(payband);
	}

	public void setCity(String city) {
		this.city.sendKeys(city);
	}

	public void setState(String state) {
		this.state.sendKeys(state);
	}

	public void setButton() {
		button.click();
	}

	// Getters

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public WebElement getSalary() {
		return salary;
	}

	public WebElement getPayband() {
		return payband;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getButton() {
		return button;
	}

}
