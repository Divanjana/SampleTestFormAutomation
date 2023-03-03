package com.packt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ProgressBar {
	
	@Test
	public void progressbar() {
		System.getProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/progress-bar");

		for(int i=0; i<3; i++) {
			WebElement start = driver.findElement(By.xpath("//button[@id='startStopButton']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", start);
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='resetButton']")));
			WebElement reset = driver.findElement((By.xpath("//button[@id='resetButton']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", reset);
		}
	}

}
