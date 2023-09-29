package com.practice.tcsCodevita;

import java.io.File;  
import java.io.FileInputStream;  
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;   

public class ExcelSheetReading {
	public static void main(String[] args)   
	{  
		try  
		{  
			File file = new File("C:\\Users\\iashi\\OneDrive\\Desktop\\employee.xlsx");     
			FileInputStream fis = new FileInputStream(file);     
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);       
			Iterator<Row> itr = sheet.iterator();     
			while (itr.hasNext())                 
			{  
				Row row = itr.next();  
				Iterator<Cell> cellIterator = row.cellIterator();    
				while (cellIterator.hasNext())   
				{  
					Cell cell = cellIterator.next();  
					switch (cell.getCellType())               
					{  
						case Cell.CELL_TYPE_STRING:      
							System.out.print(cell.getStringCellValue() + "\t");  
							break;  
						case Cell.CELL_TYPE_NUMERIC:      
							System.out.print(cell.getNumericCellValue() + "\t");  
							break;  
						default:  
					}  
				}  
				System.out.println("");  
			}  
		}  
		catch(Exception e)  
		{  
			e.printStackTrace();  
		}  
	}  
}
