package com.jetblue.checkIn.constants;

import java.io.File;

public class FilePathConstants {
	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;

	public final static String RESOURCES_HOME = USER_HOME + "src" + File.separator + "main" + File.separator
			+ "resources" + File.separator;

	public final static String LOCATOR_HOME = RESOURCES_HOME + "locators" + File.separator;
	
	public final static String CHECKIN_LOCATOR_FILEPATH = LOCATOR_HOME + "checkIn_locators.properties";
}
