package demo;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		MyAction obj = new MyAction();
		
		obj.initDriver();  // Browser initiation...
		obj.courseSelection();  //Selection of Course
		obj.greenGridSelection(); //Clicking on grid gate color i.e, Green
		obj.iframeSizeCalculation(); // Getting size of iFrame
		obj.boxProceed(); // Clicked on proceed after matching box1 and box2
		obj.dragAnDropValidation(); // Drag and drop check
		obj.popUpWindow(); // PopUp Windows validation
		obj.cookieHandling(); // Handling cookie
	}
	
}
