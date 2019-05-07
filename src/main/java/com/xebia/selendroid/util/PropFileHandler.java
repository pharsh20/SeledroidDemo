package com.xebia.selendroid.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropFileHandler {

	Properties properties = null;

	public PropFileHandler(Properties properties) {

		this.properties = properties;
	}

	/**
	 * Read from property file.
	 *
	 * @param fileName
	 * @param property
	 * @return
	 */
	public String readProperty(String fileName, String property) {
		try {
			String value = null;
			String file = "src/main/resource/" + fileName + ".properties";

			if (new File(file).exists()) {
				InputStream inPropFile = null;
				inPropFile = new FileInputStream(file);
				properties.load(inPropFile);

				value = properties.getProperty(property);
				inPropFile.close();
			} else {
				System.out.println("File '" + file + "' not found");
			}
			return value;
		} catch (Exception e) {
			return "";
		}
	}

}
