package day19ddt;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

//excel--->workbook--->sheets--->rows---->cells
public class Readingdatafromexcel {

	public static void main(String[] args) throws IOException {
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
		
		XSSFWorkbook w=new XSSFWorkbook(fs);
		XSSFSheet sh=w.getSheet("Sheet1");
		int r=sh.getLastRowNum();
		int c=sh.getRow(1).getLastCellNum();
		System.out.println("Rows are: "+r+" Columns are :"+c);
		for(int i=0;i<r;i++)
		{
			XSSFRow cu=sh.getRow(i);
			for(int j=0;j<c;j++)
			{
				XSSFCell cell=cu.getCell(j);
				System.out.print(cell.toString()+"\t");
				
			}
			System.out.println();
		}
        w.close();
        fs.close();
	}

}
