package demo;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
	
	String getTextByXpath(String getTextByXpath){
		return elementByXpath(getTextByXpath).getText();
	}
	
	String getTextByCssSelector(String getTextByCssSelector){
		return elementByCssSelector(getTextByCssSelector).getText();
	}
	
	String getTextByTagName(String getTextByTagName){
		return elementByTagName(getTextByTagName).getText();
	}
	
	void sendByXpath(String sendByXpath,String content){
		elementByXpath(sendByXpath).sendKeys(content);;
	}
	
	void sendByCssSelector(String sendByCssSelector,String content){
		elementByCssSelector(sendByCssSelector).sendKeys(content);;
	}
	
	void sendByTagName(String sendByTagName,String content){
		elementByTagName(sendByTagName).sendKeys(content);;
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
	
	void dragAndDrop(WebElement dg,WebElement dp) throws InterruptedException{
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.dragAndDrop(dg, dp).perform();
		
	}
	
	void switchToWindow(){
		//String parentWindow=driver.getWindowHandle();
		String childWindow="";
		Set<String> subWindow=driver.getWindowHandles();
		Iterator<String> itr = subWindow.iterator();
		while (itr.hasNext()){
			childWindow = itr.next();
        }
		driver.switchTo().window(childWindow);
		//driver.switchTo().window(parentWindow);
	}
	
	void cookie(String key,String cookieValue){
		Cookie c = new Cookie(key, cookieValue);
		driver.manage().addCookie(c);
	}

}

