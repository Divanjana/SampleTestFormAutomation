package com.packt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration {
	
	@Test
	public void registration() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");    
		driver.manage().window().maximize();
//		WebElement dropDrown = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
//		Select color = new Select(dropDrown);
//		color.selectByIndex(3);
		
		WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
		WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
		WebElement gender1 = driver.findElement(By.xpath("//input[@value='Female']"));
		WebElement gender2 = driver.findElement(By.xpath("//input[@value='Male']"));
		WebElement subject = driver.findElement(By.xpath("//input[@id='userNumber']"));
		WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
		WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-2']"));
		WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
		WebElement textarea = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		WebElement date = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));

		
//		WebElement autoOptions = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
//		WebElement choseimage = driver.findElement(By.xpath("//input[@id='uploadPicture']"));

		
		firstname.sendKeys("Ishanka");
		lastname.sendKeys("Divanjana");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", gender1);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", gender2);
		email.sendKeys("ishanka.divanjana@gmail.com");
		subject.sendKeys("0777262300");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", date);
//		try {
//			Thread.sleep(1000);
//		} catch(InterruptedException e) {
//			e.printStackTrace();         //div[@class='react-datepicker__month-container']
//		}
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='react-datepicker__month-container']")));
		WebElement month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
//		date.sendKeys(Keys.CONTROL + "a");
//		try {
//			Thread.sleep(1000);
//		} catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		date.sendKeys("23Jan2022"); 
//		date.sendKeys(Keys.ENTER);
		
		Select mm = new Select(month);
		mm.selectByIndex(3);
		WebElement dd = driver.findElement(By.xpath("//div[@class='react-datepicker__month']//following-sibling::div[text()='13']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dd);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox1);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox2);
//		autoOptions.sendKeys("english");
//		WebElement autocompleteResult = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
//		autocompleteResult.click();
//		wait.until(ExpectedConditions.visibilityOf(autoOptions));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", choseimage);
		textarea.sendKeys("Hello world this is my description");
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
		
	    boolean t = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']")).isDisplayed();
	     if (t) {
	       System.out.println("Element is dispalyed");
	    }else{
	       System.out.println("Element is not dispalyed");
	    }
		
		
		WebElement ThankYouTitile = driver.findElement(By.xpath("//td[text()='Mobile']//following-sibling::td"));
		String ThankYouText = ThankYouTitile.getText();
		Assert.assertTrue(ThankYouText.contains("0777262300"), "phone number is not visible");
		
		driver.quit();
	}

}
