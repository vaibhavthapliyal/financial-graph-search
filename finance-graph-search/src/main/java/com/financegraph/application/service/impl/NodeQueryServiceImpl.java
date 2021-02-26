package com.financegraph.application.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.financegraph.application.constants.NodeType;
import com.financegraph.application.entity.Node;
import com.financegraph.application.repository.NodeRepository;
import com.financegraph.application.request.GetMarketValueRequest;
import com.financegraph.application.response.MarketValueResponse;
import com.financegraph.application.service.INodeQueryService;

@Service("nodeQueryService")
public class NodeQueryServiceImpl implements INodeQueryService {
	
	@Autowired
	private NodeRepository nodeRepo;
	
	@Override
	public MarketValueResponse getMarketValue(GetMarketValueRequest request) {
		
		MarketValueResponse response = new MarketValueResponse("Value Calculated Successfully", HttpStatus.OK.value());
		Optional<Node> node = nodeRepo.findByNodeId(request.getNodeId());
		
		if(node.isPresent()) {
			Double marketValue = 0.0d;
			Node nodeVal= node.get();
			if(nodeVal.getNodeType().equals(NodeType.INVESTOR)) {
				marketValue = nodeVal.getEdges().stream().flatMap(e -> e.getChildNode().getEdges().stream())
						.filter(f -> !request.getExclusionList().contains(f.getChildNode().getNodeId()))
						.mapToDouble(e -> e.getChildNode().getValue() * e.getWeightage()).sum();
				
				response.setMarketValue(marketValue);
			}else if(nodeVal.getNodeType().equals(NodeType.FUND)) {
				marketValue = nodeVal.getEdges().stream()
						.filter(e -> !request.getExclusionList().contains(e.getChildNode().getNodeId()))
						.mapToDouble(e -> e.getChildNode().getValue() * e.getWeightage()).sum();
				response.setMarketValue(marketValue);
			}else {
				return new MarketValueResponse("Node of the type HOLDING not allowed", HttpStatus.BAD_REQUEST.value());
			}
		}else {
			return new MarketValueResponse("Node Not Found", HttpStatus.NOT_FOUND.value());
		}
		return response;
	}

}
