package kdf;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Methods {
	
	static WebDriver driver;
	
	public static void openbrowser(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public static void navigateto(String baseurl){
		driver.get(baseurl);
	}
	public static void enterusername(String locator,String value,String param) {
		
		if(locator.equals("name")){
			driver.findElement(By.name(value)).sendKeys(param);
			}
		else if(locator.equals("id")){
		driver.findElement(By.id(value)).sendKeys(param);
		}
	}
	public static void enterpassword(String locator,String value,String param) {
	  if(locator.equals("name")){
			driver.findElement(By.name(value)).sendKeys(param);
		}
		else if(locator.equals("id")){
		    driver.findElement(By.id(value)).sendKeys(param);
		}
	}
	public static void Submit(String locator,String value) {
		if(locator.equals("name")){
			driver.findElement(By.name(value)).click();
		}
		else if (locator.equals("id")){
		    driver.findElement(By.id(value)).click();
		}
	}
	public static void verifyMessage(String value,String message){
		String expectedMessage = message;
		String actualMessage = driver.findElement(By.xpath(value)).getText();
		Assert.assertEquals(actualMessage,expectedMessage);
	}
	public static void getscreenshot() throws IOException {
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File("C:\\s37\\login"+(new Random().nextInt())+".jpg"));
   }
	public static void closeBrowser(){
		driver.close();
	}

}
