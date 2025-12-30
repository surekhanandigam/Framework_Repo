package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackToExcelTest {
   public static void main(String[] args)throws Throwable  {
	   FileInputStream fis=new FileInputStream("D:\\Selenium\\Maven_Project_Tutorial\\TestData\\TestScriptData.xlsx");
	   Workbook wb=WorkbookFactory.create(fis);
	   Sheet sh =wb.getSheet("org");
	   Row r=sh.getRow(1);
	   Cell c=r.createCell(4);	//it will delete the old data and create new data Or cell
	   c.setCellType(CellType.STRING);
	   c.setCellValue("Pass");
	   
	   FileOutputStream fos=new FileOutputStream("D:\\Selenium\\Maven_Project_Tutorial\\TestData\\TestScriptData.xlsx");
	   wb.write(fos);
	   wb.close();
	   System.out.println("======Executed========");
	   
  }
}
