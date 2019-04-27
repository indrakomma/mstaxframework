package practicetestng;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import excelutilities.BaseSetup;

public class TC001 {

	HashMap<String, String> classTestdata = new HashMap<String, String>();

	@BeforeMethod
	public void satrtUp(){
		
		classTestdata = BaseSetup.datasheet_data.get("TC001");

		String browser = classTestdata.get("Browser");
		String url = classTestdata.get("URL");

		System.out.println(browser + " <===> " + url);
		if (browser.equalsIgnoreCase("Chrome")) {
			System.out.println("Chrome to be launch");
		}
		
	}
	
	
	@Test
	public void myFirstTest() {
		
		classTestdata = BaseSetup.datasheet_data.get("TC001");

		String browser = classTestdata.get("Browser");
		String url = classTestdata.get("URL");

		System.out.println(browser + " <===> " + url);
		if (browser.equalsIgnoreCase("Chrome")) {
			System.out.println("Chrome to be launch");
		}

		System.out.println("====================> myFirstTest TC001");
	}
}
