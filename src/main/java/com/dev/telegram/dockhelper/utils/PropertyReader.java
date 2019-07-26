package com.dev.telegram.dockhelper.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class PropertyReader.
 * 
 * @author devender
 */
public class PropertyReader {

	private PropertyReader() {
	}

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyReader.class);
	
	/** The properties. */
	private static Properties properties = new Properties();

	static {
		try (final InputStream stream = PropertyReader.class.getResourceAsStream(Constants.BOT_PROPERTIES_FILE)) {
			properties.load(stream);
		} catch (IOException e) {
			LOGGER.error("Not able to access " + Constants.BOT_PROPERTIES_FILE + " file.", e);
		}
	}

	/**
	 * Gets the property.
	 *
	 * @param key the key
	 * @return the property
	 */
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
