package Performance.Performance;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public  class Test {

	double x;
	double y;

public double getRandomIntegerBetweenRange(double min, double max){
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

	
}
