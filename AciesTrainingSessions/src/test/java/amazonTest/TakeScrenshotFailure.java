package amazonTest;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TakeScrenshotFailure extends SearchProduct {

	public static String filePath;
	public static void takeScreenshot() throws IOException {
		System.out.println("Entering Take Screenshot");
		/*
		 * File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * filePath=System.getProperty("user.dir")+
		 * "\\Screeshots\\Failurescreenshot\\Failed_"+System.currentTimeMillis()+
		 * ".jpeg"; System.out.println(filePath); FileUtils.copyFile(scrFile, new
		 * File(filePath));
		 */
		
		Screenshot scrn = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(scrn.getImage(), "jpeg", new File(".\\Screeshots\\Asot" + System.currentTimeMillis() + ".jpeg"));
		
		
	}

}
