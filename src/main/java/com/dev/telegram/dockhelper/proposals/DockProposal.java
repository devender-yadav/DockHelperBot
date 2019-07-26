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
	 * Sets the dock staked.
	 *
	 * @param dockStaked the new dock staked
	 */
	public void setDockStaked(List<String> dockStaked) {
		this.dockStaked = dockStaked;
	}

	/**
	 * Gets the checks if is closed.
	 *
	 * @return the checks if is closed
	 */
	public boolean getIsClosed() {
		return isClosed;
	}

	/**
	 * Sets the closed.
	 *
	 * @param isClosed the new closed
	 */
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	/**
	 * Gets the highest stake index.
	 *
	 * @return the highest stake index
	 */
	public byte getHighestStakeIndex() {
		return highestStakeIndex;
	}

	/**
	 * Sets the highest stake index.
	 *
	 * @param highestStakeIndex the new highest stake index
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
	 * @param options the new options
	 */
	public void setOptions(List<String> options) {
		this.options = options;
	}

	/**
	 * Gets the ipfs hash.
	 *
	 * @return the ipfs hash
	 */
	public String getIpfsHash() {
		return ipfsHash;
	}

	/**
	 * Sets the ipfs hash.
	 *
	 * @param ipfsHash the new ipfs hash
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
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the tx id.
	 *
	 * @return the tx id
	 */
	public String getTxId() {
		return txId;
	}

	/**
	 * Sets the tx id.
	 *
	 * @param txId the new tx id
	 */
	public void setTxId(String txId) {
		this.txId = txId;
	}

	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * Sets the start time.
	 *
	 * @param startTime the new start time
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * Sets the end time.
	 *
	 * @param endTime the new end time
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * Checks if is passed.
	 *
	 * @return true, if is passed
	 */
	public boolean isPassed() {
		return passed;
	}

	/**
	 * Sets the passed.
	 *
	 * @param passed the new passed
	 */
	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
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
