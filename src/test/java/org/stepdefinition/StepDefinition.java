package org.stepdefinition;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	static WebDriver driver;
	@Given("User has to be in Adactin login page")
	public void user_has_to_be_in_Adactin_login_page() {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.get("https://adactinhotelapp.com/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}

	@When("User has to enter the invalid Username and password")
	public void user_has_to_enter_the_invalid_Username_and_password(io.cucumber.datatable.DataTable data) {
	   Map<String, String>mp = data.asMap(String.class,String.class);
	   String user = mp.get("Username");
	   System.out.println(user);
	   String pass = mp.get("password");
	   System.out.println(pass);
	   WebElement username = driver.findElement(By.id("username"));
	   username.sendKeys(user);
		  WebElement Password = driver.findElement(By.id("password"));
		  Password.sendKeys(pass);
	}

	@When("User has to click the login button")
	public void user_has_to_click_the_login_button() {
		driver.findElement(By.id("login")).click();
	}

	@Then("Error message will be displayed")
	public void error_message_will_be_displayed() {
		String text = driver.findElement(By.xpath("//div[@class='auth_error']")).getText();
		  System.out.println("Error Message : "+text);
		  driver.quit();
	}



}
