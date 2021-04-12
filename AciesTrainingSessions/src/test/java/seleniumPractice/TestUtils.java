package seleniumPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtils {
	static Workbook book;
	static Sheet sheet;
	
	public static String Testdatasheet = "D:\\Selenium\\Workspace\\AciesTrainingSessions\\Excel\\TestData.xlsx";
	
	public static Object[][] getTestData(String SheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(Testdatasheet);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		sheet = book.getSheet(SheetName);
		hashtableObject(sheet);
		Object [][]data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
		
	}

	private static void hashtableObject(Sheet sheet) {
	
		Iterator<Row> itrow=sheet.rowIterator();
		while(itrow.hasNext())
		{
			if(itrow.next().getRowNum()>0) {
		Iterator<Cell> itcell=itrow.next().cellIterator();
		System.out.println(itcell.next());
		
		
		}}
	}

}
