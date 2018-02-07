package zebraFrame.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertiesUtil {
	
	String read(String x) throws IOException {
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\M1042993\\programsjava\\selenium\\new workspace\\FerrariF1Nov\\ferrari.properties"));
		Properties p=new Properties();
		p.load(fis);
		fis.close();
		return (p.getProperty(x));
	}
	
public static void main(String args[]) throws IOException
	{
		PropertiesUtil pu=new PropertiesUtil();
		String y=pu.read("mid");
		System.out.println(y);
	}
}
