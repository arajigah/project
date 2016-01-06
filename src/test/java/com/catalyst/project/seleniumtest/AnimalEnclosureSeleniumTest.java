package com.catalyst.project.seleniumtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnimalEnclosureSeleniumTest {

	private WebDriver driver;
	
	
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080");
	}

	@Test
	public void testAddEnclosureWithValidEnclosure(){
		boolean result = false;
		createValidEnclosure();
		if(new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.className("toast-success"))).isDisplayed()){
			result = true;
		}
		assertTrue(result);
	}
	
	@Test
	public void testViewEnclosureAfterItHasBeenCreated(){
		createValidEnclosure();
		viewAnEnclosure();
		boolean result = driver.findElement(By.id("enclosure_name")).getText().equals("Enclosure Name: An Enclosure");
		
		assertTrue(result);
	}
	
	@Test
	public void testUpdateAnEnclosureAfterItIsCreated(){
		boolean result = false;
		createValidEnclosure();
		viewAnEnclosure();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("edit_enclosure_button"))).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("edit_enclosure_name_input"))).sendKeys("EditedEnclosure");
		driver.findElement(By.id("edit_button")).click();
		if(new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.className("toast-success"))).isDisplayed()){
			result = true;
		}
		
		assertTrue(result);
	}
	
	@Test
	public void testDeleteEnclosureAfterItIsCreatedAndViewed(){
		createValidEnclosure();
		viewAnEnclosure();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("delete_enclosure_button"))).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("welcome_message"))).click();
		
		String expectedUrl = "http://localhost:8080/#/";
		String actualUrl = driver.getCurrentUrl();
		
		assertEquals(expectedUrl, actualUrl);
	}
	
	@After
	public void quitDriver()throws Exception{
		driver.quit();
	}
	
	private void viewAnEnclosure(){
		driver.get("http://localhost:8080");
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("view_nav_collapse"))).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("view_enclosure"))).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("enclosure_0")));
		
		Collection<WebElement> enclosures = driver.findElements(By.className("enclosures"));
		driver.findElement(By.id("enclosure_" + (enclosures.size()-1))).click();

		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("enclosure_name")));
	}
	
	private void createValidEnclosure(){
		driver.findElement(By.id("add_nav_collapse")).click();
		driver.findElement(By.id("add_enclosure")).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("add_enclosure_name_input"))).sendKeys("An Enclosure");
		driver.findElement(By.xpath("//*[@id='add_enclosure_anaml_dropdown']/div/button")).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='add_enclosure_anaml_dropdown']/div/ul/li[6]/a"))).click();
		driver.findElement(By.xpath("//*[@id='add_enclosure_anaml_dropdown']/div/button")).click();
		driver.findElement(By.id("add_enclosure_number_of_animals_input")).sendKeys("156");
		driver.findElement(By.xpath("//*[@id='add_enclosure_feeding_time']/tbody/tr[1]/td[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='add_enclosure_feeding_time']/tbody/tr[1]/td[3]/a")).click();
		driver.findElement(By.xpath("//*[@id='add_enclosure_feeding_time']/tbody/tr[2]/td[4]/button")).click();
		try{
			driver.findElement(By.id("add_enclosure_new_condition")).click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("add_enclosure_condition_input"))).sendKeys("Condition");
		}catch(Exception e){
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("add_enclosure_condition_input"))).sendKeys("Condition");
		}
		driver.findElement(By.id("add_enclosure_add_button")).click();
	}
}
