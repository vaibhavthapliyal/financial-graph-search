package com.financegraph.application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financegraph.application.request.GetMarketValueRequest;
import com.financegraph.application.request.InsertNodeRequest;
import com.financegraph.application.response.InsertNodeResponse;
import com.financegraph.application.response.MarketValueResponse;
import com.financegraph.application.service.INodeInsertService;
import com.financegraph.application.service.INodeQueryService;

@RestController
@RequestMapping("/api/graph")
public class GraphController {

	@Autowired
	@Qualifier("insertNodeDefault")
	private INodeInsertService insertService;
	
	@Autowired
	@Qualifier("nodeQueryService")
	private INodeQueryService queryService;
	
	@PostMapping("/")
	public InsertNodeResponse addNodeAndEdge(@RequestBody InsertNodeRequest request) {
		return insertService.insertNode(request);
	}
	
	@PostMapping("/marketValue")
	public MarketValueResponse getMarketValue(@RequestBody GetMarketValueRequest request) {
		return queryService.getMarketValue(request);
	}
	
	
	
}
