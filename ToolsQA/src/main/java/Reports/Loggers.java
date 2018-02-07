package Reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Loggers {

	private static final Logger Log = Logger.getLogger(Loggers.class.getName());

	public static void read()
	{

		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\Resources\\com\\Ferrari_F1_Club\\Properties\\log4j.properties");
			
	
	}
}
