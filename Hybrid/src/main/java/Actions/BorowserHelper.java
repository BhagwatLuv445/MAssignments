package Actions;

import Base.TestBase;

public class BorowserHelper extends TestBase
{
	public static void goBack()
	{
		driver.navigate().back();
	}

	public static void goForward()
	{
		driver.navigate().forward();
	}

	public static void refresh()
	{
		driver.navigate().refresh();
	}

	public static void closeTab()
	{
		driver.close();
	}

	public static void closeBrowser()
	{
		driver.quit();
	}

	public static void navigateToUrl(String url)
	{
		driver.navigate().to(url);
	}
}
