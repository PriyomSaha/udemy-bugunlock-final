package resources;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


//	THIS CLASS IS USED TO WRITE THE DATA INTO THE EXCEL SHEET

public class CreatingWorkbook {
	public static WebDriver driver;
	
	public CreatingWorkbook(WebDriver driver) {
		this.driver = driver;
	}
	
	public void creation() throws IOException {
		
	 XSSFWorkbook workbook = new XSSFWorkbook();
   	 XSSFSheet sheet = workbook.createSheet("Sheet 1");
   	 
   	 String[] columnHeadings= {"NAME","RATING", "DURATION"};
   	 
   	 Row headerRow = sheet.createRow(0);
   	 for(int i=0;i<columnHeadings.length;i++) {
   		 Cell cell = headerRow.createCell(i);
   		 cell.setCellValue(columnHeadings[i]);
   	 }
   	 
   	 ArrayList<ForValues> a= createData();
   	 int rownum=1;
   	 
   	 for(ForValues i:a) {
   		int cellnum=0;
   		 Row row = sheet.createRow(rownum++);
   		 row.createCell(cellnum++).setCellValue(i.getName());
   		 row.createCell(cellnum++).setCellValue(i.getRating());
   		 row.createCell(cellnum++).setCellValue(i.getDuration());
   	 }
   	 
//   	 FOR AUTOSIZING COLUMNS AS PER THE VALUE IN THE CELL
   	 for(int i=0;i<columnHeadings.length;i++) {
   		 sheet.autoSizeColumn(i);
   	 }
   	 
       FileOutputStream out = new FileOutputStream(new File("Output\\Final Output.xlsx"));
       workbook.write(out); 
       out.close(); 
       
       System.out.println("Successful."); 
   } 
	public static ArrayList<ForValues> createData() {
		
		ArrayList<ForValues> a  =new  ArrayList<>();
		
		String first1=driver.findElement(By.xpath("//div[@class='course-list--container--3zXPS']/div[1]/a/div[2]/div[1]")).getText();
		String first2=driver.findElement(By.xpath("//div[@class='course-list--container--3zXPS']/div[1]/a/div[2]/div[3]/span/span[2]")).getText();
		String first3=driver.findElement(By.xpath("//div[@class='course-list--container--3zXPS']/div[1]/a/div[2]/div[4]/span[1]")).getText();
		String second1=driver.findElement(By.xpath("//div[@class='course-list--container--3zXPS']/div[2]/a/div[2]/div[1]")).getText();
		String second2=driver.findElement(By.xpath("//div[@class='course-list--container--3zXPS']/div[2]/a/div[2]/div[3]/span/span[2]")).getText();
		String second3=driver.findElement(By.xpath("//div[@class='course-list--container--3zXPS']/div[2]/a/div[2]/div[4]/span[1]")).getText();

		a.add(new ForValues(first1,first2,first3));
		a.add(new ForValues(second1,second2,second3));
		
		return a;
	}
}