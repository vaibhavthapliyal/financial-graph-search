package com.financegraph.application.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.financegraph.application.entity.Edge;
import com.financegraph.application.entity.Node;
import com.financegraph.application.repository.EdgeRepository;
import com.financegraph.application.repository.NodeRepository;
import com.financegraph.application.request.InsertNodeRequest;
import com.financegraph.application.response.InsertNodeResponse;
import com.financegraph.application.service.INodeInsertService;

@Service("insertNodeDefault")
public class NodeInsertServiceImpl implements INodeInsertService {

	@Autowired
	private NodeRepository nodeRepo;
	
	@Autowired
	private EdgeRepository edgeRepo;
	
	@Override
	@Transactional
	public InsertNodeResponse insertNode(InsertNodeRequest request) {
		
		Node parentNode = nodeRepo.findByNodeId(request.getParentNode().getNodeId())
				.orElse(new Node(request.getParentNode().getNodeId(), request.getParentNode().getName(),
						request.getParentNode().getValue(), request.getParentNode().getType(),
						request.getParentNode().getNodeLevel()));
		
		
		Node childNode = nodeRepo.findByNodeId(request.getChildNode().getNodeId())
				.orElse(new Node(request.getChildNode().getNodeId(), request.getChildNode().getName(),
						request.getChildNode().getValue(), request.getChildNode().getType(),
						request.getChildNode().getNodeLevel()));
		
		
		Edge edge = new Edge();
		
		edge.setWeightage(request.getEdgeWeight());
		
		edge.setParentNode(parentNode);
		
		edge.setChildNode(childNode);
		
		if(CollectionUtils.isEmpty(parentNode.getEdges())) {
			Set<Edge> edges = new HashSet<>();
			edges.add(edge);
			parentNode.setEdges(edges);
		}else {
			parentNode.getEdges().add(edge);
		}
		
		nodeRepo.save(parentNode);
		
		nodeRepo.save(childNode);
		
		edgeRepo.save(edge);
		
		return new InsertNodeResponse("Relation Created Successfully", HttpStatus.CREATED.value());
	}

}
