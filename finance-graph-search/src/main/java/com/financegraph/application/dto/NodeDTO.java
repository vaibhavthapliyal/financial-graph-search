package com.financegraph.application.dto;

import java.io.Serializable;

import com.financegraph.application.constants.NodeType;

public class NodeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1998551452488648133L;

	private String nodeId;
	private String name;
	private Double value;
	private NodeType type; 
	private Integer nodeLevel;
	
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public NodeType getType() {
		return type;
	}
	public void setType(NodeType type) {
		this.type = type;
	}
	public Integer getNodeLevel() {
		return nodeLevel;
	}
	public void setNodeLevel(Integer nodeLevel) {
		this.nodeLevel = nodeLevel;
	}
}
