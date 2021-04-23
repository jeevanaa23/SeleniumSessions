package amazonTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class dataRetrieveUtils extends AddAddress {

	
	public dataRetrieveUtils(WebDriver driver, Properties prop) {
		super(driver, prop);
		AddAddress.driver = driver;
		AddAddress.prop = prop;
	}

	public Object[][] dataret() throws IOException{
		
		String Testdatasheet = prop.getProperty("excelPath");
		Hashtable<Object, Object> datas = null;
		File file = new File(Testdatasheet);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		String key;
		Object val = null;
		Object[][] data = new Object[sheet.getLastRowNum()][1];
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		//Iterator<RowIterator> row=sheet.rowIterator();
		for (int i = 0; i < rowCount; i++) {
			datas=new Hashtable<Object,Object>();
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
			}
			data[i][0] = datas;

		}
		return data;
		
	}
	
	
}
