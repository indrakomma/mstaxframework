package excelutilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class BaseSetup {

	public static LinkedHashMap<String, HashMap<String, String>> datasheet_data = 
			new LinkedHashMap<String, HashMap<String, String>>();
	static HashMap<String, String> data = new HashMap<String, String>();
	static ArrayList<String> classname = new ArrayList<String>();
	static int rownum = 0;

	
	public static void testDataLoad() {
		try {
			FileInputStream fis = new FileInputStream(
					"C:/Users/indraa36/Desktop/myframework/myfinalproject/data.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet2 = wb.getSheetAt(0);
			int totalrow = sheet2.getLastRowNum();
			System.out.println("total row is" + totalrow);
			String className = "";
			for (int i = 0; i < totalrow; i++) {
				int lastcolvalue = sheet2.getRow(i).getLastCellNum();
				System.out.println("in" + i + " row last col value is"
						+ lastcolvalue);
				data = new HashMap<String, String>();
				className = "";
				for (int j = 0; j < lastcolvalue; j++) {
					String header = sheet2.getRow(0).getCell(j)
							.getStringCellValue();
					String value = sheet2.getRow(i).getCell(j).toString();
					data.put(header, value);
					
					if(header.equalsIgnoreCase("ClassName"))
						className = value;
					if(header.equalsIgnoreCase("run") && value.equalsIgnoreCase("Y"))
						classname.add(className);
				}
				datasheet_data.put(className, data);
				rownum += 1;
			}
			System.out.println(datasheet_data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void createtestNGXMLFile() {
		String line1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		String line2 = "<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\">";
		String line3 = "<suite name=\"Default suite\">";
		String line4 = " <test name=\"Default test\">";
		String line5 = "<classes>";

		String line8 = "";
		String line9 = "</classes>";
		String line10 = "</test> <!-- Test -->";
		String line11 = "</suite> <!-- listners -->";

		String classNamesFinalString = "";
		for (int i = 0; i < classname.size(); i++) {
			classNamesFinalString = classNamesFinalString
					+ "<class name=\"practicetestng." + classname.get(i)
					+ "\"/>" + "\n";
		}

		line8 = classNamesFinalString;

		String finalTextNGXMLString = line1 + "\n" + line2 + "\n" + line3
				+ "\n" + line4 + "\n" + line5 + "\n" + line8 + "\n" + line9
				+ "\n" + line10 + "\n" + line11;
		System.out.println(finalTextNGXMLString);
		// till here u create ur own xml
		// below writing xml

		File file = null;
		FileWriter fileWriter = null;
		BufferedWriter writer = null;

		try {
			file = new File("testng_exe.xml");
			fileWriter = new FileWriter(file);
			file.createNewFile();
			writer = new BufferedWriter(fileWriter);
			writer.write(finalTextNGXMLString);
			System.out.println("File written successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}
	
	public static void executeTests(){
		TestNG obj = new TestNG();

		List<String> suites = new ArrayList<String>();
		suites.add("testng_exe.xml");// it will take only list

		obj.setTestSuites(suites);
		obj.run();
		
		System.out.println("Executed..........");
	}
	
	
	@Test
	public static void BaseSetup(){
		
		testDataLoad();
		
		createtestNGXMLFile();
		
		executeTests();
	}
	

}
