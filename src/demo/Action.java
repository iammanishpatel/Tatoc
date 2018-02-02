package demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

class MyAction extends DriverFactory {
	DriverFactory objParent = new DriverFactory();
	
	void courseSelection(){
		String courseXpath=".//a[@href='/tatoc/basic']";
		clickByXpath(courseXpath); 
		System.out.println("Basic course is selected");
	}
	
	void greenGridSelection(){
		String greenGrid="//div[@class='greenbox']";
		clickByXpath(greenGrid);
		System.out.println("Clicked on green grid");
	}
	
	void iframeSizeCalculation(){
		int size = iframeSize();
		System.out.println("size of iframe is: "+size);
	}
	
	void boxProceed() throws InterruptedException{
		String frameId,proceed,repaint,box1,box2,box_1_color,box_2_color;
		frameId="main";
		proceed="//a[@onclick='gonext();']";
		repaint="//a[@onclick='reloadChildFrame();']";
		box1="//div[contains(text(),'Box 1')]";
		box2="//div[contains(text(),'Box 2')]";
		
		switchToFrameByName(frameId);
		box_1_color = getCssValue(box1,"background-color");
		
		frameId="child";
		switchToFrameByName(frameId);
		box_2_color = getCssValue(box2,"background-color");
		switchToDefaultFrame();
		
		while(true){		
			if(box_1_color.equals(box_2_color)){
				clickByXpath(proceed);
				System.out.println("Clicked on Proceed");
				break;
			}
			else{
				clickByXpath(repaint);
				Thread.sleep(600);
				frameId="child";
				switchToFrameByName(frameId);
				box_2_color = getCssValue(box2,"background-color");
				switchToDefaultFrame();
			}
		}
	}
	
	void dragAnDropValidation() throws InterruptedException{
		String sourcePath,destinationPath,proceed;
		WebElement drop,drag;
		sourcePath="//div[@id='dragbox']";
		destinationPath="//div[@id='dropbox']";
		proceed="//a[@onclick='gonext();']";
		drag = elementByXpath(sourcePath);
		drop = elementByXpath(destinationPath);
		dragAndDrop(drag,drop);
		System.out.println("Drag and drop performed");
		Thread.sleep(1000);
		clickByXpath(proceed);
		System.out.println("Proceeded from drag and drop");
	}
	
	void popUpWindow() throws InterruptedException{
		String popUp, name, submit,proceed;
		popUp = "//*[contains(text(),'Launch Popup Window')]";
		name="//input[@id='name' and @type='text']";
		submit="//input[@id='submit']";
		proceed="//a[@onclick='gonext();']";
		clickByXpath(popUp);
		System.out.println("Launch Popup Window ");
		Thread.sleep(500);
		
		switchToWindow();
		System.out.println("Switched to child window");
		sendByXpath(name,"Manish");
		System.out.println("Name is entered");
		Thread.sleep(1000);
		clickByXpath(submit);
		System.out.println("Clicked on Submit");
		Thread.sleep(500);
		switchToWindow();
		System.out.println("Switched back to parent window");
		clickByXpath(proceed);
		System.out.println("Proceeded from Popup Window");
		}
	
	void cookieHandling(){
		String tokenButton, proceed,token,finalTokenValue,key;
		tokenButton="//*[contains(text(),'Generate Token')]";
		proceed="//a[@onclick='gonext();']";
		token="//span[@id='token']";
		key = "Token";
		clickByXpath(tokenButton);
		System.out.println("Clicked on Generate Token");
		System.out.println("Copying token value...");
		String tokenValue = getTextByXpath(token);
		System.out.println("Initially the token value is: "+tokenValue);
		finalTokenValue=tokenValue.substring(7,tokenValue.length());
		System.out.println("Token for cookie: "+finalTokenValue);
		cookie(key, finalTokenValue);
		System.out.println("Cookie is set as:"+key+" : "+finalTokenValue);
		clickByXpath(proceed);
		System.out.println("Proceeded after handling Cookie");
	}
	
}

