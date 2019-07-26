package com.dev.telegram.dockhelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * The Class DockHelperApp - main class to run the bot
 * 
 * @author devender
 */
public class DockHelperApp {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(DockHelperApp.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		ApiContextInitializer.init();

		TelegramBotsApi botsApi = new TelegramBotsApi();

		try {
			botsApi.registerBot(new DockHelperBot());
			LOGGER.info("DockHelperBot has started!");
		} catch (TelegramApiException e) {
			LOGGER.error("Not able to start DockHelperBot.", e);
		}
	}

}
