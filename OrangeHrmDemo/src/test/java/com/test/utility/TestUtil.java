package com.test.utility;

import java.util.ArrayList;

import XLS_reader.Xls_Reader;

public class TestUtil {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		ArrayList<Object[]> mydata  = new ArrayList<Object[]>();
		reader = new Xls_Reader("C:\\Users\\abc\\Desktop\\CAPGEMINI TRAINING\\M4 Training Material\\Cases.xlsx");
		
		for(int rowNum = 2; rowNum <= reader.getRowCount("testCases"); rowNum++) {
			String ename = reader.getCellData("testCases", "ename", rowNum);
			System.out.println(ename);
			String eID = reader.getCellData("testCases", "eID", rowNum);
			String sname = reader.getCellData("testCases", "supname", rowNum);
			
			Object ob[] = {ename, eID, sname};
			mydata.add(ob);
		}
		
		return mydata;
	}

}
