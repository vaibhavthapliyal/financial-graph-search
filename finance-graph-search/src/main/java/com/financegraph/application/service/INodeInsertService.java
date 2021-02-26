package com.financegraph.application.service;

import com.financegraph.application.request.InsertNodeRequest;
import com.financegraph.application.response.InsertNodeResponse;

public interface INodeInsertService {
	public InsertNodeResponse insertNode(InsertNodeRequest request);
}
