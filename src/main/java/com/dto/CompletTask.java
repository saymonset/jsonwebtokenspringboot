package com.dto;

import java.io.Serializable;

public class CompletTask implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String assignee;

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
}
