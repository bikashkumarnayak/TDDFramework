package dataProvaider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FrameworkConfig.Config;

public class DataprovaiderTestData {
	@Test(dataProvider = "getDataWithTable")
	public void print(Map<String,String> map) {
		System.out.println(map.get("username"));
//		System.out.println(map.get("password"));
//		System.out.println(map.get("firstname"));
//		System.out.println(map.get("lastname"));
	}
	@DataProvider
	public Object[] getDataWithTable() throws IOException {
		File file=new File(Config.getExcel1()+"\\ExcelData\\ExcelData.xlsx");
		FileInputStream fs = new FileInputStream(file);
		Workbook wb =WorkbookFactory.create(fs);
		Sheet sheet = wb.getSheetAt(0);
		int lastrownum=sheet.getLastRowNum();
		int lastcellnum=sheet.getRow(0).getLastCellNum();
		
		Object[] data = new Object[sheet.getLastRowNum()];
		DataFormatter formatter = new DataFormatter();
		Map<String,String> table;
		
		for(int i=1; i<=lastrownum; i++) {
			table = new HashMap<>();
			for(int j=0; j<lastcellnum;j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
				table.put(key, value);
				data[i-1] = table;
			}
		}
		return data;
	}
	@SuppressWarnings("resource")
	@DataProvider
	public Object[][] getData() throws IOException {
		
		File file=new File(Config.getExcel());
		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=1; i<=sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++) {
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	@DataProvider(name="Tranzacklogin")
	public Object[][] getTranzacklogin(){
		Object[][] data=new Object[2][2];
		data[0][0]="monalisa.sahu@abstechno.in";
		data[0][1]="Abs@1234";
		return data;
		
	}
	@DataProvider(name="AirfaceData")
	public Object[][] getAirfacedata(){
		return new Object[][] {{"BIKASH","55"},{"sumeet.thakur@abstechno.in","11"}};
		
	}
	
}
