package day19ddt;

import java.io.*;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writingdataintoexcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");
		XSSFWorkbook w=new XSSFWorkbook();
		XSSFSheet sh=w.createSheet("Data");
		XSSFRow r1=sh.createRow(0);
		r1.createCell(0).setCellValue("Vyshnavi");
		r1.createCell(1).setCellValue(1234);
		r1.createCell(2).setCellValue(2500);
		
		XSSFRow r2=sh.createRow(1);
		r2.createCell(0).setCellValue("Ramu");
		r2.createCell(1).setCellValue(123774);
		r2.createCell(2).setCellValue(256800);
		
		XSSFRow r3=sh.createRow(2);
		r3.createCell(0).setCellValue("shiv");
		r3.createCell(1).setCellValue(123094);
		r3.createCell(2).setCellValue(250890);
		
		w.write(fo);
		w.close();
		fo.close();
		System.out.println("File is created");
	}

}
