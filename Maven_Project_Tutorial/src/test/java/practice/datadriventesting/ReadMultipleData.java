package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleData {
	 public static void main(String[] args) throws Exception, IOException {
		    
		 FileInputStream fis=new FileInputStream("D:\\Selenium\\Maven_Project_Tutorial\\TestData\\TestScriptData.xlsx");
		 Workbook wb=WorkbookFactory.create(fis);
		 Sheet sh =wb.getSheet("Sheet1");
		 int rc=sh.getLastRowNum();
		 for(int i=1;i<=rc;i++)
		 {
			Row row=sh.getRow(i);
			String columndata1=row.getCell(0).toString();
			String columndata2=row.getCell(1).toString();
			System.out.println(columndata1 +"  "+columndata2);
		 }
		 wb.close();
  }
}
