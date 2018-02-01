package demo;

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
}

