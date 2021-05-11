package seleniumPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtils {

	public static String Testdatasheet = "D:\\Selenium\\New_Workspace\\SeleniumSessions\\AciesTrainingSessions\\Excel\\TestData.xlsx";
	public static File file = new File(Testdatasheet);

	HashMap<String, String> datas = new HashMap<String, String>();
	HashMap<String, String> locadatas = new HashMap<String, String>();
	public static Hashtable<String,String> table=null;

	public static Object[][] getTestData(String SheetName) throws IOException {

		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet(SheetName);
		XSSFRow row;
		Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; 
		System.out.println(sheet.getLastRowNum());
		for(int i=0;i<sheet.getLastRowNum();i++) {
			table=new Hashtable<String,String>();
			row=sheet.getRow(i);
			System.out.println(row.getCell(0).getStringCellValue());
		String key=row.getCell(0).getStringCellValue();
		int colNum= row.getLastCellNum();	
		for(int j=1;j<colNum;j++) {
			String value=row.getCell(j).getStringCellValue();
			table.put(key, value);
			data[0][0]=table;
			System.out.println("map"+table);	
		}
		}
		
	
		

		return data;

	}

	/*
	 * static Workbook book; static Sheet sheet;
	 * 
	 * public static String Testdatasheet =
	 * "D:\\Selenium\\New_Workspace\\SeleniumSessions\\AciesTrainingSessions\\Excel\\TestData.xlsx";
	 * 
	 * public static Object[][] getTestData(String SheetName) throws IOException {
	 * FileInputStream file = null; try { file = new FileInputStream(Testdatasheet);
	 * } catch (FileNotFoundException e) { e.printStackTrace(); } try { book =
	 * WorkbookFactory.create(file); } catch (EncryptedDocumentException e) {
	 * e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * sheet = book.getSheet(SheetName); HashMap<String, String> datas =
	 * hashtableObject(sheet);
	 * 
	 * Object[][] data = new
	 * Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; for (int i =
	 * 0; i < sheet.getLastRowNum(); i++) { for (int j = 0; j <
	 * sheet.getRow(0).getLastCellNum(); j++) { data[i][j] = sheet.getRow(i +
	 * 1).getCell(j).toString(); } }
	 * 
	 * return data;
	 * 
	 * }
	 */

	/*
	 * private static HashMap<String, String> hashtableObject(Sheet sheet) throws
	 * IOException {
	 * 
	 * Iterator<Row> itrow=sheet.rowIterator(); while(itrow.hasNext()) { Row
	 * ite=itrow.next(); Iterator<Cell> itcell=itrow.next().cellIterator();
	 * while(itcell.hasNext()) {
	 * //System.out.println(itcell.next().getStringCellValue());
	 * 
	 * String key=ite.getCell(0).toString(); String value=ite.getCell(1).toString();
	 * System.out.println("Key-->"+key); System.out.println("value-->"+value);
	 * datas.put(key,value);
	 * 
	 * System.out.println(datas); } return datas;
	 * 
	 * }
	 */
	}
