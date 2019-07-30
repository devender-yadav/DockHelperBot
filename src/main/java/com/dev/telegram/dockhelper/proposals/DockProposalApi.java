package com.dev.telegram.dockhelper.proposals;

import static com.dev.telegram.dockhelper.utils.Constants.NEW_LINE;
import static com.dev.telegram.dockhelper.utils.Constants.STAR;
import static com.dev.telegram.dockhelper.utils.Constants.UNDERSCORE;
import static com.dev.telegram.dockhelper.utils.Constants.HYPHEN;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.telegram.dockhelper.utils.CommonUtil;
import com.dev.telegram.dockhelper.utils.RestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * The Class DockProposalApi to query dock json to fetch proposals
 * 
 * @author devender
 */
public class DockProposalApi {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(DockProposalApi.class);

	/** The Constant DOCK_PROPOSAL_URL. */
	public static final String DOCK_PROPOSAL_URL = "https://dock.io/proposals.json";

	private DockProposalApi() {
	}

	/**
	 * Generate telegram msg.
	 *
	 * @param proposals the proposals
	 * @return the string
	 */
	public static String generateTelegramMsg(List<DockProposal> proposals) {
		if (proposals.isEmpty()) {
			return "No Proposals at the moment!";
		}
		String msg = "";
		for (DockProposal proposal : proposals) {
			StringBuilder builder = new StringBuilder();
			builder.append("🗒️ " + STAR + proposal.getTitle() + STAR);
			builder.append(NEW_LINE);
			builder.append(UNDERSCORE + CommonUtil.removeNewLineChar(proposal.getDescription()) + UNDERSCORE);
			builder.append(NEW_LINE);
			builder.append(NEW_LINE);
			builder.append("💰 Total Docks Voted - " + CommonUtil.formatNumber(proposal.getTotalDockStaked()));
			builder.append(NEW_LINE);
			builder.append(NEW_LINE);
			builder.append("📅 " + CommonUtil.convertDateToUTC(proposal.getStartTime()));
			builder.append(HYPHEN);
			builder.append(CommonUtil.convertDateToUTC(proposal.getEndTime()));

			if (!proposal.getIsClosed()) {
				builder.append(NEW_LINE);
				builder.append(NEW_LINE);
				builder.append("Only ");
				builder.append(STAR + CommonUtil.betweenDates(proposal.getStartTime(), proposal.getEndTime()) + STAR);
				builder.append(" days left to vote!");
			}
			builder.append(NEW_LINE);
			builder.append(NEW_LINE);
			builder.append(NEW_LINE);
			msg = msg + builder.toString();
		}
		return msg.trim();
	}

	/**
	 * Gets the proposals.
	 *
	 * @return the proposals
	 */
	public static List<DockProposal> getProposals() {
		String resp = RestUtil.fetchData(DOCK_PROPOSAL_URL);
		JSONArray arr = new JSONArray(resp);
		List<DockProposal> proposals = new ArrayList<>();
		for (int i = 0; i < arr.length(); i++) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				DockProposal proposal = mapper.readValue(arr.get(i).toString(), DockProposal.class);
				proposals.add(proposal);
			} catch (JSONException | IOException e) {
				LOGGER.error("Error occured while processing JSON response.", e);
			}
		}
		return proposals;
	}

	/**
	 * Gets the active proposals.
	 *
	 * @return the active proposals
	 */
	public static List<DockProposal> getActiveProposals() {
		return getProposals().stream().filter(p -> !p.getIsClosed()).collect(Collectors.toList());
	}

	/**
	 * Gets the closed proposals.
	 *
	 * @return the closed proposals
	 */
	public static List<DockProposal> getClosedProposals() {
		return getProposals().stream().filter(p -> p.getIsClosed()).collect(Collectors.toList());
	}

	/**
	 * Gets the passed proposals.
	 *
	 * @return the passed proposals
	 */
	public static List<DockProposal> getPassedProposals() {
		return getProposals().stream().filter(p -> p.isPassed()).collect(Collectors.toList());
	}

}
