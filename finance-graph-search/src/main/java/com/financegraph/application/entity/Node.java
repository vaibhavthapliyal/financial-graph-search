package com.financegraph.application.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.financegraph.application.constants.NodeType;

@Entity
@Table(name = "Node")
public class Node {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "node_id", unique = true)
	private String nodeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "value")
	private Double value;
	
	@Column(name = "node_type")
	private NodeType nodeType;
	
	@Column(name = "node_level")
	private Integer nodeLevel;
	
	public Node() {

	}
	
	public Node(String nodeId, String name, Double value, NodeType type, Integer nodeLevel){
		this.nodeId = nodeId;
		this.name = name;
		this.value = value;
		this.nodeType = type;
		this.nodeLevel = nodeLevel;
	}
	
	@JsonManagedReference
	@OneToMany(mappedBy = "parentNode", fetch = FetchType.LAZY)
	private Set<Edge> edges;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Set<Edge> getEdges() {
		return edges;
	}

	public void setEdges(Set<Edge> edges) {
		this.edges = edges;
	}

	public NodeType getNodeType() {
		return nodeType;
	}

	public void setNodeType(NodeType nodeType) {
		this.nodeType = nodeType;
	}

	public Integer getNodeLevel() {
		return nodeLevel;
	}

	public void setNodeLevel(Integer nodeLevel) {
		this.nodeLevel = nodeLevel;
	}
}
