package driversetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.util.RLEDecompressingInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import excelutilities.BaseSetup;

public class driversetup {

	ArrayList<String> urlbrowser = new ArrayList<String>();
	List<String> urls=new ArrayList<String>();
	List<String> browsers=new ArrayList<String>();
	int totalcasesforrun=0;
	public String browsersetup="";
	public String urlsetup="";
	@Test
	public void fetchurlbrowser() throws IOException
	{
		
		
		FileInputStream fis=new FileInputStream("C:/Users/indraa36/Desktop/myframework/myfinalproject/data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet2=wb.getSheetAt(0);
		int totalrow=sheet2.getLastRowNum();
		int lastcol=sheet2.getRow(0).getLastCellNum();
		System.out.println("total row is"+totalrow);
		for (int i = 0; i<=lastcol ; i++) {
			
			if(sheet2.getRow(0).getCell(i).getStringCellValue().trim().equals("run"))
			{
				
				for (int j = 0; j <totalrow ; j++) {
					if(sheet2.getRow(j).getCell(i).getStringCellValue().trim().equals("Y"))
					{
						String tcname=sheet2.getRow(j).getCell(i-1).getStringCellValue();
						String url=sheet2.getRow(j).getCell(i+1).getStringCellValue();
						String browser=sheet2.getRow(j).getCell(i+2).getStringCellValue();
						urls.add(url);
						browsers.add(browser);
						
						urlbrowser.add(tcname);
						
					}
					
				}
			    totalcasesforrun=urlbrowser.size();
				
				
				System.out.println(totalcasesforrun);
				for (int z = 0; z < totalcasesforrun; z++) {
					
					browsersetup=browsers.get(z);
					urlsetup=urls.get(z);
					System.out.println( browsersetup  + urlsetup);
					
				}
	
				break;
			}
		
		}
	
	}
	
	
	public void driversetup(String lauchbrowse, String launchurl)
	{
		BaseSetup
		lauchbrowse=browsersetup;
		launchurl=urlsetup;
		if(lauchbrowse.equals("chrome"))
		{
			System.out.println("launching chrome");
		}else if (lauchbrowse.equals("firefox"))
		{
			System.out.println("firefox");
		}else if (lauchbrowse.equals("ie")) {
			System.out.println("ie");
		}else {
			System.out.println("launching edge");
		}
		
	}
	
	
}
