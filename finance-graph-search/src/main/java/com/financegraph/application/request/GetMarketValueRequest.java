package com.financegraph.application.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sun.istack.NotNull;

public class GetMarketValueRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -758882889493146277L;
	
	@NotNull
	private String nodeId;
	
	private List<String> exclusionList = new ArrayList<>();

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public List<String> getExclusionList() {
		return exclusionList;
	}

	public void setExclusionList(List<String> exclusionList) {
		this.exclusionList = exclusionList;
	}
}
