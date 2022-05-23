package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import foundation.PageObjectBase;

public class RegistrationPage extends PageObjectBase {
	
	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public RegistrationPage enterFirstName(String firstName) {
		WebElement firstNameInput = this.driver.findElement(By.id("customer_firstname"));
		firstNameInput.sendKeys(firstName);
		return this;
	}
	
	public RegistrationPage enterLastName(String lastName) {
		WebElement lastNameInput = this.driver.findElement(By.id("customer_lastname"));
		lastNameInput.sendKeys(lastName);
		return this;
	}
	
	public RegistrationPage enterPassword(String password) {
		WebElement passwordInput = this.driver.findElement(By.id("passwd"));
		passwordInput.sendKeys(password);
		return this;
	}
	
	public RegistrationPage enterDateOfBirth(String day, String month, String year) {
		Select selectDay = new Select(this.driver.findElement(By.id("days")));
		selectDay.selectByValue(day);
		Select selectMonth = new Select(this.driver.findElement(By.id("months")));
		selectMonth.selectByValue(month);
		Select selectYear = new Select(this.driver.findElement(By.id("years")));
		selectYear.selectByValue(year);
		return this;
	}
	
	public AccountPage clickRegister() {
		WebElement registerButton = this.driver.findElement(By.id("submitAccount"));
		registerButton.click();
		return new AccountPage(this.driver);
	}
	

}
