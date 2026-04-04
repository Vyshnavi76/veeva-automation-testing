package day19ddt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writingdatadynamicallyexcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\example2.xlsx");
		XSSFWorkbook w=new XSSFWorkbook();
		XSSFSheet sh=w.createSheet("Dynamic Data");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter rows and columns");
		int r=sc.nextInt();
		int c=sc.nextInt();
		for(int i=0;i<r;i++)
		{
			XSSFRow row=sh.createRow(i);
			for(int j=0;j<c;j++)
			{
				XSSFCell cell=row.createCell(j);
				cell.setCellValue(sc.next());
			}
		}
		w.write(fo);
		w.close();
		fo.close();
		System.out.println("File is created..........");
		
		

	}

}
