package examples;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.*;
import jxl.read.biff.BiffException;

public class ExcelHandle {
	public static void main(String[] args) throws BiffException, IOException {
	    Sheet sheet;
	    Workbook book;
	    List<Cell> cellList = null;
	    book= Workbook.getWorkbook(new File("C:\\WORK_201911\\choujiang\\name.xlsx")); 
	    sheet = book.getSheet(0); 
	    System.out.println(sheet);
	    book.close(); 
	}
}


