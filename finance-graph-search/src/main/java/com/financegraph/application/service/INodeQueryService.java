package com.financegraph.application.service;

import com.financegraph.application.request.GetMarketValueRequest;
import com.financegraph.application.response.MarketValueResponse;

public interface INodeQueryService {
	public MarketValueResponse getMarketValue(GetMarketValueRequest request);
}
