package excelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	private XSSFWorkbook wb1;
	private XSSFSheet sheet1;
	
	public ExcelRead(String path,int sheet_no) {
	File src = new File(path);
	try {
		FileInputStream fis = new FileInputStream(src);
		wb1 = new XSSFWorkbook(fis);
	} catch (IOException e) {
		e.printStackTrace();
	}
	sheet1 = wb1.getSheetAt(sheet_no);
	
	}
	public String getData(int row,int col) {
		String user_name =sheet1.getRow(row).getCell(col).getStringCellValue(); 
		return user_name;
	}

}
