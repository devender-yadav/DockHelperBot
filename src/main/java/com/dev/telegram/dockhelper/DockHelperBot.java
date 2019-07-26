package com.dev.telegram.dockhelper;

import static com.dev.telegram.dockhelper.utils.Constants.NEW_LINE;
import static com.dev.telegram.dockhelper.utils.Constants.SLASH;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.dev.telegram.dockhelper.copy.DockProposalApi;
import com.dev.telegram.dockhelper.utils.PropertyReader;

/**
 * The Class DockHelperBot.
 * 
 * @author devender
 */
public class DockHelperBot extends TelegramLongPollingBot {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(DockHelperBot.class);

	public void onUpdateReceived(Update update) {

		if (update.hasMessage() && update.getMessage().hasText()) {
			String txt = update.getMessage().getText().toLowerCase();
			String msg = null;

			if (txt.startsWith(SLASH)) {
				msg = commandToMsg(txt);
			}

			if (msg != null) {
				LOGGER.info(msg);
				postMsg(update, msg);
			}
		}
	}

	/**
	 * Telegram bot command to message
	 *
	 * @param command the telegram bot command
	 * @return the msg
	 */
	private String commandToMsg(String command) {
		switch (command.split("@")[0]) {

		case "/start":
			return "Hi! I will help you in viewing Dock Proposals.\n\nClick /help to see commands!";
		case "/help":
			return buildHelpMsg();
		case "/proposals":
			return DockProposalApi.generateTelegramMsg(DockProposalApi.getProposals());
		case "/closed_proposals":
			return DockProposalApi.generateTelegramMsg(DockProposalApi.getClosedProposals());
		case "/active_proposals":
			return DockProposalApi.generateTelegramMsg(DockProposalApi.getActiveProposals());
		case "/passed_proposals":
			return DockProposalApi.generateTelegramMsg(DockProposalApi.getPassedProposals());
		default:
			return null;
		}
	}

	/**
	 * Builds the /help msg.
	 *
	 * @return the help msg
	 */
	private String buildHelpMsg() {

		StringBuilder builder = new StringBuilder();

		builder.append("/proposals - Dock proposals");
		builder.append(NEW_LINE);
		builder.append("/active_proposals - Dock active proposals");
		builder.append(NEW_LINE);
		builder.append("/passed_proposals - Dock passed proposals");
		builder.append(NEW_LINE);
		builder.append("/closed_proposals - Dock closed proposals");

		return builder.toString();

	}

	/**
	 * Post msg to users
	 *
	 * @param update the update
	 * @param reply the msg to be sent back to user
	 */
	private void postMsg(Update update, String reply) {
		SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText(reply);
		try {
			execute(message);
			LOGGER.info("sending msg!!!");
		} catch (TelegramApiException e) {
			LOGGER.error("Some error occured.", e);
		}
	}

	@Override
	public String getBotUsername() {
		return PropertyReader.getProperty("bot.username");
	}

	
	@Override
	public String getBotToken() {
		return PropertyReader.getProperty("bot.token");
	}

}