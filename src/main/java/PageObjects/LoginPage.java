package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(xpath="//div[text()='*Email is required']")
	WebElement emailError;
	
	@FindBy(xpath="//div[text()='*Password is required']")
	WebElement passwordError;
	
	@FindBy(xpath="//div[text()='*Enter Valid Email']")
	WebElement invalidEmailError;
	
	@FindBy(xpath="//div[contains(@class,'toast-title')]")
	WebElement loginSuccess;
	
	@FindBy(xpath="//div[contains(@class,'toast-message')]")
	WebElement invalidEmailorPass;
	
	public void login(String Email, String Password)
	{
		email.sendKeys(Email);
		password.sendKeys(Password);
		login.click();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String loginSuccessMessage()
	{
		System.out.println(loginSuccess.getText());
		return loginSuccess.getText();
	}
	
	public String invalidEmailorpassMessage()
	{
		System.out.println(invalidEmailorPass.getText());
		return invalidEmailorPass.getText();
	}
	
	public String emailerrorMessage()
	{
		return emailError.getText();
	}
	
	public String passworderrorMessage()
	{
		return passwordError.getText();
	}
	
	public String inavldEmailErrMessage()
	{
		return invalidEmailError.getText();
	}

}
