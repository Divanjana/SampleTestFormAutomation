package com.packt.tests;

import java.util.Set;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsAndFrame {
	
	@Test
	public void windows() {
		System.getProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows"); 
		WebElement newTabButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
		newTabButton.click();
		
		String firstWindow = driver.getWindowHandle();
		
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> windowsIterator = allWindows.iterator();
		
		while (windowsIterator.hasNext()) {
			String windowHandle = windowsIterator.next().toString();
			if (!windowHandle.equals(firstWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
	}
	
	@Test
	public void wysiwygEditorTest() {
		System.getProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Opening page
		driver.get("http://the-internet.herokuapp.com/iframe");
		System.out.println("Page opened!");

		// SLEEP FOR STUDENTS TO SEE THE SCREEN
		sleep();
		
		WebElement iFrame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iFrame);

		// Typing text
		WebElement textArea = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
		textArea.clear();
//		textArea.sendKeys("Hello, world!");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].innerHTML = 'Hello, world!'", textArea);

		// SLEEP FOR STUDENTS TO SEE THE SCREEN
		sleep();

		Assert.assertTrue(textArea.getText().equals("Hello, world!"),
				"Text in editor is not correct. Its " + textArea.getText());
	}
	
	private void sleep() {
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
