package com.pitaya.metro.models;

public class MetroStation {
	
	/**
	 * 线路
	 */
	Integer lineNum;
	
	/**
	 * 站台名
	 */
	String station;

	public Integer getLineNum() {
		return lineNum;
	}

	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}
	
}
