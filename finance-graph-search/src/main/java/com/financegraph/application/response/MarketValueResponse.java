package com.financegraph.application.response;

import java.io.Serializable;

public class MarketValueResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1224067120200205040L;

	private String message;
	
	private int code;
	
	private Double marketValue;
	
	public MarketValueResponse() {
		
	}
	
	public MarketValueResponse(String message, int code){
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}
}
