package com.financegraph.application.request;

import java.io.Serializable;

import com.financegraph.application.dto.NodeDTO;

public class InsertNodeRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1725878534210607894L;

	private NodeDTO parentNode;
	
	private NodeDTO childNode;
	
	public NodeDTO getParentNode() {
		return parentNode;
	}

	public void setParentNode(NodeDTO parentNode) {
		this.parentNode = parentNode;
	}

	public NodeDTO getChildNode() {
		return childNode;
	}

	public void setChildNode(NodeDTO childNode) {
		this.childNode = childNode;
	}

	private Double edgeWeight;


	public Double getEdgeWeight() {
		return edgeWeight;
	}

	public void setEdgeWeight(Double edgeWeight) {
		this.edgeWeight = edgeWeight;
	}
}
