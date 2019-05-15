package Performance.Performance;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class commonFunctions {
	double x;
	double y;
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
public static double getRandomIntegerBetweenRange(double min, double max){
    double x = (int)(Math.random()*((max-min)+1))+min;
    return x;
}

public void Upload_docs_WithoutWait(String sPath) throws InterruptedException
{
       try {
              StringSelection stringSelection = new StringSelection(sPath);
              
              Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
              clipboard.setContents(stringSelection, stringSelection);
              Thread.sleep(4000);;
              Robot robot = new Robot();
              robot.keyPress(KeyEvent.VK_CONTROL);
              robot.keyPress(KeyEvent.VK_V);
              robot.keyRelease(KeyEvent.VK_V);
              robot.keyRelease(KeyEvent.VK_CONTROL);
              robot.keyPress(KeyEvent.VK_ENTER);
              robot.keyRelease(KeyEvent.VK_ENTER);
       } catch (AWTException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
       }
       
}

	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
}


