package com.dev.telegram.dockhelper.proposals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The Class DockProposal.
 * 
 * @author devender
 */
public class DockProposal {
	
	/** The total dock staked. */
	private int totalDockStaked;
	
	/** The dock staked. */
	List<String> dockStaked = new ArrayList<>(2);
	
	/** The is closed. */
	private boolean isClosed;
	
	/** The highest stake index. */
	private byte highestStakeIndex;
	
	/** The options. */
	List<String> options = new ArrayList<>(2);
	
	/** The ipfs hash. */
	private String ipfsHash;
	
	/** The description. */
	private String description;
	
	/** The tx id. */
	private String txId;
	
	/** The start time. */
	private Date startTime;
	
	/** The end time. */
	private Date endTime;
	
	/** The passed. */
	private boolean passed;
	
	/** The title. */
	private String title;

	/**
	 * Gets the total dock staked.
	 *
	 * @return the total dock staked
	 */
	public int getTotalDockStaked() {
		return totalDockStaked;
	}

	/**
	 * Sets the total dock staked.
	 *
	 * @param totalDockStaked the new total dock staked
	 */
	public void setTotalDockStaked(int totalDockStaked) {
		this.totalDockStaked = totalDockStaked;
	}

	/**
	 * Gets the dock staked.
	 *
	 * @return the dock staked
	 */
	public List<String> getDockStaked() {
		return dockStaked;
	}

	/**
	 * Sets the dockStaked
	 *
	 * @param dockStaked
	 */
	public void setDockStaked(List<String> dockStaked) {
		this.dockStaked = dockStaked;
	}

	/**
	 * Gets the isClosed
	 *
	 * @return isClosed
	 */
	public boolean getIsClosed() {
		return isClosed;
	}

	/**
	 * Sets the isClosed.
	 *
	 * @param isClosed
	 */
	public void setIsClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	/**
	 * Gets highestStakeIndex
	 *
	 * @return the highestStakeIndex
	 */
	public byte getHighestStakeIndex() {
		return highestStakeIndex;
	}

	/**
	 * Sets the highestStakeIndex.
	 *
	 * @param highestStakeIndex
	 */
	public void setHighestStakeIndex(byte highestStakeIndex) {
		this.highestStakeIndex = highestStakeIndex;
	}

	/**
	 * Gets the options.
	 *
	 * @return the options
	 */
	public List<String> getOptions() {
		return options;
	}

	/**
	 * Sets the options.
	 *
	 * @param options
	 */
	public void setOptions(List<String> options) {
		this.options = options;
	}

	/**
	 * Gets the ipfsHash.
	 *
	 * @return the ipfsHash
	 */
	public String getIpfsHash() {
		return ipfsHash;
	}

	/**
	 * Sets the ipfsHash.
	 *
	 * @param ipfsHash
	 */
	public void setIpfsHash(String ipfsHash) {
		this.ipfsHash = ipfsHash;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the blockchain txId.
	 *
	 * @return the txId
	 */
	public String getTxId() {
		return txId;
	}

	/**
	 * Sets the txId.
	 *
	 * @param txId the blockchain txId
	 */
	public void setTxId(String txId) {
		this.txId = txId;
	}

	/**
	 * Gets the proposal startTime.
	 *
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * Sets the proposal startTime.
	 *
	 * @param startTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the proposal endTime.
	 *
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * Sets the proposal endTime.
	 *
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * Checks if passed.
	 *
	 * @return true, if is passed
	 */
	public boolean isPassed() {
		return passed;
	}

	/**
	 * Sets the passed.
	 *
	 * @param passed
	 */
	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	/**
	 * Gets the proposal title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the proposal title.
	 *
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "DockProposals [totalDockStaked=" + totalDockStaked + ", dockStaked=" + dockStaked + ", isClosed="
				+ isClosed + ", highestStakeIndex=" + highestStakeIndex + ", options=" + options + ", ipfsHash="
				+ ipfsHash + ", description=" + description + ", txId=" + txId + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", passed=" + passed + ", title=" + title + "]";
	}

}
