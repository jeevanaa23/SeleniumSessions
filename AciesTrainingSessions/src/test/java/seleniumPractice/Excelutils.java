package seleniumPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excelutils {
	WebDriver driver;

	public static String Testdatasheet = "D:\\Workspace\\SeleniumSessions\\AciesTrainingSessions\\Excel\\TestData.xlsx";
	public static File file = new File(Testdatasheet);

	/*
	 * @Test public void a_pageload() { WebDriverManager.chromedriver().setup();
	 * driver = new ChromeDriver(); driver.get("https://www.saucedemo.com/");
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); }
	 */

	@DataProvider
	public Object[][] getlogindata() throws IOException {
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row;
		String key;
		Object val;
	HashMap<Object,Object> datas=null;
		Object[][] data = new Object[sheet.getLastRowNum()][1];
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		//Iterator<RowIterator> row=sheet.rowIterator();
		for (int i = 0; i < rowCount; i++) {
			datas=new HashMap<Object,Object>();
			int cellcount = sheet.getRow(i).getLastCellNum();
		//	System.out.println("Row" + i + " data is :");
			for (int j = 0; j < cellcount; j++) {
				 key=sheet.getRow(0).getCell(j).getStringCellValue();
				if(sheet.getRow(i + 1).getCell(j).getCellType().equals(CellType.STRING)) {
					val=sheet.getRow(i + 1).getCell(j).getStringCellValue();
				}else if(sheet.getRow(i + 1).getCell(j).getCellType().equals(CellType.NUMERIC)) {
					 val=sheet.getRow(i + 1).getCell(j).getNumericCellValue();
				}
				else {
					val=sheet.getRow(i+1).getCell(j).getRichStringCellValue().toString();
				}
				datas.put(key, val);
			
				System.out.println("Key----"+key+"Value------"+val);
				data[i][0] = datas;
			}
			

		}
		return data;
	}

	@Test(dataProvider = "getlogindata")
	public void a_loginTest(HashMap<Object, Object> testData) {

		if (testData != null) {
			System.out.println("entering-->logintest");
			/*
			 * Set<Object> key=testData.keySet(); for(Object keys:key) {
			 * System.out.println("Key  "+keys+"  Value  "+testData.get(keys)); }
			 */
			System.out.println(testData.get("username"));
			System.out.println(testData.get("password"));
		}
		/*
		 * driver.findElement(By.id("user-name")).sendKeys(username);
		 * driver.findElement(By.id("password")).sendKeys(password);
		 * driver.findElement(By.id("login-button")).click();
		 */ }

}
