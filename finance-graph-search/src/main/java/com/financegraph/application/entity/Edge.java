package com.financegraph.application.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "edge")
public class Edge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Double weightage = 1.0d;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_node_id")
	private Node parentNode;
	
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "child_node_id")
	private Node childNode;


	public Double getWeightage() {
		return weightage;
	}


	public void setWeightage(Double weightage) {
		this.weightage = weightage;
	}


	public Node getParentNode() {
		return parentNode;
	}


	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}


	public Node getChildNode() {
		return childNode;
	}


	public void setChildNode(Node childNode) {
		this.childNode = childNode;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
}
