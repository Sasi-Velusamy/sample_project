package com.jetblue.checkIn.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	public static Properties properties;

	/**
	 * 
	 * This method is used to get locator key value.
	 * 
	 * @param filePath
	 * @param KeyValue
	 * @return value
	 */
	public static String getValue(String filePath, String keyValue) {
		properties = new Properties();
		String value = null;

		try {
			properties.load(new FileInputStream(filePath));
			value = properties.getProperty(keyValue, "");

		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return value;
	}
}
