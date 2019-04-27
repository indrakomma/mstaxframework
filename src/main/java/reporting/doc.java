package reporting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;

import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.testng.annotations.Test;

public class doc {
	
	@Test
	public void doc() throws IOException
	{
		FileOutputStream outt=new FileOutputStream("C:/Users/indraa36/Desktop/myframework/sample.doc");
		XWPFDocument doc=new XWPFDocument();
		XWPFParagraph para=doc.createParagraph();
		XWPFRun run=para.createRun();
		run.setText("passed");
		
		doc.write(outt);
		doc.close();
		System.out.println("writed");
	}
	
	public void pdf() throws IOException
	{
		FileOutputStream outt=new FileOutputStream("C:/Users/indraa36/Desktop/myframework/sample.pdf");
		Document doc=new Document() {
		
		
		};
		
		
		System.out.println("writed");
	}

}
