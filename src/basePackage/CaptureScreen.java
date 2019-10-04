package basePackage;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreen{

	public File file,folder;
	public void captureScreen(String fileName, String moduleName,JFrame frame){
		String SCREENSHOT_DIR = "D:\\ScreenShots\\"+moduleName;
		
		   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		   Rectangle screenRectangle = new Rectangle(screenSize); 
		   try {
			   Robot robot = new Robot();
			   frame.setVisible(false);
			   BufferedImage image = robot.createScreenCapture(screenRectangle);
			   folder = new File(SCREENSHOT_DIR);
			   if(!folder.exists()) {
				   folder.mkdir();
			   }
			   file = new File(SCREENSHOT_DIR+"\\"+fileName+" "+getCurrentTimeStamp()+".png");
			   file.createNewFile();
			ImageIO.write(image, "png", file);
			frame.setVisible(true);
		} catch (IOException | AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String getCurrentTimeStamp() {
		return new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss").format(new Date());
	}
}
