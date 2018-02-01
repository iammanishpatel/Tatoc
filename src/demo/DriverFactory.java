package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	final String url = "http://10.0.1.86/tatoc";
	WebDriver driver;
	
	void initDriver(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\manishpatel\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	WebElement elementByXpath(String myXpath){
		return driver.findElement(By.xpath(myXpath));
	}
	
	WebElement elementByCssSelector(String cssSelector){
		return driver.findElement(By.cssSelector(cssSelector));
	}
	
	WebElement elementByTagName(String tagName){
		return driver.findElement(By.tagName(tagName));
	}
	
	void clickByXpath(String clickByXpath){
		elementByXpath(clickByXpath).click();
	}
	
	void clickByCssSelector(String clickByCssSelector){
		elementByCssSelector(clickByCssSelector).click();;
	}
	
	void clickByTagName(String clickByTagName){
		elementByTagName(clickByTagName).click();;
	}
	
	void sendByXpath(String sendByXpath){
		elementByXpath(sendByXpath).sendKeys();;
	}
	
	void sendByCssSelector(String sendByCssSelector){
		elementByCssSelector(sendByCssSelector).sendKeys();;
	}
	
	void sendByTagName(String sendByTagName){
		elementByTagName(sendByTagName).sendKeys();;
	}
	
	void switchToFrameByName(String frameName){
		driver.switchTo().frame(frameName);
	}
	
	String getCssValue(String element, String cssValue){
		return elementByXpath(element).getCssValue(cssValue);
	}
	
	int iframeSize(){
		return driver.findElements(By.tagName("iframe")).size();
	}
	void switchToDefaultFrame(){
		driver.switchTo().parentFrame();
	}
}

