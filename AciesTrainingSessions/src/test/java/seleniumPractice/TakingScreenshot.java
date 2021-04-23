package seleniumPractice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TakingScreenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");

		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		/*
		 * WebElement we=driver.findElement(By.id("droppable")); File srcFile =
		 * ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * //FileUtils.copyFile(srcFile, new File(".\\Screeshots\\Screenshot"
		 * +System.currentTimeMillis()+ ".jpeg")); BufferedImage
		 * img=ImageIO.read(srcFile);
		 * 
		 * System.out.println("width"+we.getSize().getWidth());
		 * System.out.println("Height"+we.getSize().getHeight()); Point point
		 * =we.getLocation(); BufferedImage subimg=img.getSubimage(point.x, point.y,
		 * we.getSize().getWidth(), we.getSize().getHeight()); ImageIO.write(subimg,
		 * ".jpg", srcFile); File screenshotLoc=new File(".\\Screeshots\\webelement"
		 * +System.currentTimeMillis()+ ".jpeg"); FileUtils.copyFile(srcFile,
		 * screenshotLoc);
		 */
		Screenshot scrn = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(scrn.getImage(), "jpeg", new File(".\\Screeshots\\Asot" + System.currentTimeMillis() + ".jpeg"));
	}

}
