package com.financegraph.application.response;

import java.io.Serializable;

public class InsertNodeResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4815690392336417248L;

	private String message;
	
	private int code;

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
	
	public InsertNodeResponse(String message, int code) {
		this.message = message;
		this.code = code;
	}
	
	public InsertNodeResponse() {
		
	}
}
