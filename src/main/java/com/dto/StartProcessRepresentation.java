package com.dto;

public class StartProcessRepresentation {
	private String assignee;
	private String format;
	private double accurancy;
	

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public double getAccurancy() {
		return accurancy;
	}

	public void setAccurancy(double accurancy) {
		this.accurancy = accurancy;
	}
}
