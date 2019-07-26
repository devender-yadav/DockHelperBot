package com.dev.telegram.dockhelper.copy;

import static com.dev.telegram.dockhelper.utils.Constants.NEW_LINE;

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
			builder.append("🗒️ " + proposal.getTitle());
			builder.append(NEW_LINE);
			builder.append(CommonUtil.removeNewLine(proposal.getDescription()));
			builder.append(NEW_LINE);
			builder.append(NEW_LINE);
			builder.append("💰 Total Docks Staked - " + proposal.getTotalDockStaked());
			builder.append(NEW_LINE);
			builder.append(NEW_LINE);
			builder.append("📅 Start Date - " + CommonUtil.convertDateToUTC(proposal.getStartTime()));
			builder.append(NEW_LINE);
			builder.append("📆 End Date - " + CommonUtil.convertDateToUTC(proposal.getEndTime()));
			builder.append(NEW_LINE);
			builder.append(NEW_LINE);

			if (proposal.getIsClosed()) {
				builder.append("Proposal is closed 📕");
				builder.append(NEW_LINE);
				if (proposal.isPassed()) {
					builder.append("Proposal is passed 🤗");
				}
			} else {
				builder.append("Proposal is active.Do Vote!");
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