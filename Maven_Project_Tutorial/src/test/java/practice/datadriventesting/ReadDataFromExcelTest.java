package practice.datadriventesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {
  
	public static void main(String[] args) throws Exception {
		//step 1:get the excel path location & java object of the physical ExcelFile
		FileInputStream fis=new FileInputStream("D:\\Selenium\\Maven_Project_Tutorial\\TestData\\TestScriptData.xlsx");
		//step 2:open workbook in read mode
		Workbook workbook=WorkbookFactory.create(fis);
		//step 3:get the control of the sheet
		Sheet sheet=workbook.getSheet("org");
		//step 4:get the control of the row
		Row row=sheet.getRow(1);
		//step 5:get the control of the 2nd cell & read the string data
	//	Cell cell=row.getCell(2);
	//	String data=cell.getStringCellValue();
		double data=row.getCell(3).getNumericCellValue();
		
		
		System.out.println(data);
		//step 6:close the workbook
		workbook.close();
	}
}
