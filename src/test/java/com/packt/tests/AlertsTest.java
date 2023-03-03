package com.packt.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest {
	
	@Test (priority = 1)
	public void alertstestbutton() {
		System.getProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		
		WebElement alertbutton = driver.findElement(By.xpath("//button[@id='alertButton']"));
		alertbutton.click();
		
		WebDriverWait fiveSecondsWait = new WebDriverWait(driver,5);
		fiveSecondsWait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert1 = driver.switchTo().alert();
		String alert1Text = alert1.getText();
		System.out.println(alert1Text);
		
		Assert.assertTrue(alert1Text.equals("You clicked a button"),"Alert text is not equal");
		sleep();
		
		alert1.accept();
		
		sleep();
		
		driver.quit();
		
	}
	
	@Test (priority = 2)
	public void alertconfirm() {
		System.getProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		
		WebElement alertbutton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		alertbutton.click();
		
		WebDriverWait fiveSecondsWait = new WebDriverWait(driver,5);
		fiveSecondsWait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert1 = driver.switchTo().alert();   
		alert1.accept();
		
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='confirmResult']")));
		
		WebElement confirmText = driver.findElement(By.xpath("//span[@id='confirmResult']"));
		String Textconfirm = confirmText.getText();
		Assert.assertTrue(Textconfirm.equals("You selected Ok"),"Text is not equal");
		
		sleep();
		
		driver.quit();
		
	}
	
	private void sleep() {
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
