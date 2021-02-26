package com.financegraph.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.financegraph.application.constants.NodeType;
import com.financegraph.application.entity.Edge;
import com.financegraph.application.entity.Node;
import com.financegraph.application.repository.NodeRepository;
import com.financegraph.application.request.GetMarketValueRequest;
import com.financegraph.application.service.impl.NodeQueryServiceImpl;

@SpringBootTest
class FinanceGraphSearchApplicationTests {

	@Mock
	private NodeRepository nodeRepo;
	
	@InjectMocks
	private NodeQueryServiceImpl queryService;
	
	@Test
	public void testMarketValueOfAFund() {
		Node fund = createTestFund("1234");
		
		GetMarketValueRequest request = new GetMarketValueRequest();
		
		request.setNodeId("1234");
		when(nodeRepo.findByNodeId("1234")).thenReturn(Optional.of(fund));	
		
		assertEquals(600, queryService.getMarketValue(request).getMarketValue());
	}
	
	@Test
	public void testMarketValueOfAFundWithExclusionList() {
		Node fund = createTestFund("1234");
		
		GetMarketValueRequest request = new GetMarketValueRequest();
		
		request.setNodeId("1234");
		request.setExclusionList(Collections.singletonList("1abc"));
		when(nodeRepo.findByNodeId("1234")).thenReturn(Optional.of(fund));	
		
		assertEquals(500, queryService.getMarketValue(request).getMarketValue());
	}

	
	@Test
	public void testMarketValueOfAnInvestor() {
		Node investor = createTestInvestor("5678");
		
		GetMarketValueRequest request = new GetMarketValueRequest();
		
		request.setNodeId("5678");
		when(nodeRepo.findByNodeId("5678")).thenReturn(Optional.of(investor));	
		
		assertEquals(1200, queryService.getMarketValue(request).getMarketValue());
	}
	
	
	@Test
	public void testMarketValueOfAnInvestorWithExclusionList() {
		Node investor = createTestInvestor("5678");
		
		GetMarketValueRequest request = new GetMarketValueRequest();
		
		request.setNodeId("5678");
		request.setExclusionList(Collections.singletonList("1abc"));
		when(nodeRepo.findByNodeId("5678")).thenReturn(Optional.of(investor));	
		assertEquals(1000, queryService.getMarketValue(request).getMarketValue());
	}

	private Node createTestInvestor(String investorId) {
		
		Node investor = new Node(investorId, "Inv1", null, NodeType.INVESTOR, 1);
		
		Set<Edge>edges = new HashSet<>();
		
		for(int i =0; i<2;i++) {
			Node fund = createTestFund(i+"abc");
			
			Edge edge = new Edge();
			
			edge.setChildNode(fund);
			
			edge.setParentNode(investor);
			
			edge.setWeightage(1d);
			
			edges.add(edge);
		}
		
		investor.setEdges(edges);
			
		return investor;
	}

	private Node createTestFund(String fundId) {
		Node fund = new Node(fundId, "F1", null, NodeType.FUND, 2);

		Set<Edge> edges = new HashSet<>();

		for (int i = 1; i < 4; i++) {

			Node holding = new Node(i+"abc", "H" + i, 10d, NodeType.HOLDING, 3);

			Edge edge = new Edge();

			edge.setParentNode(fund);

			edge.setChildNode(holding);

			edge.setWeightage(i * 10d);

			edges.add(edge);
		}

		fund.setEdges(edges);

		return fund;
	}
	
	
}
