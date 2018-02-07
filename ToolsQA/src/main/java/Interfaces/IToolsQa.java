package Interfaces;

import java.io.IOException;

public interface IToolsQa {

	void fillPersonalInfo(String firstName, String lastName, String sex, String yoExp, String date, String profession,
			String photo, String tools, String continent, String seleniumCommands) throws IOException;

	void downLoadFile() throws InterruptedException;

	void clickOnLink();

	void clickOnPartialLink();
}
