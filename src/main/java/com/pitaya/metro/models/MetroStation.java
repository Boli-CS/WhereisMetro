package com.pitaya.metro.models;

public class MetroStation {
	
	/**
	 * 站台编号
	 */
	Integer stationNum;
	
	/**
	 * 所属线路
	 */
	Integer lineNum;
	
	/**
	 * 站台名字
	 */
	String stationName;
	
	/**
	 * 上一站到达间隔时间(秒)
	 */
	Integer intervalTime;

	public Integer getStationNum() {
		return stationNum;
	}

	public void setStationNum(Integer stationNum) {
		this.stationNum = stationNum;
	}

	public Integer getLineNum() {
		return lineNum;
	}

	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Integer getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(Integer intervalTime) {
		this.intervalTime = intervalTime;
	}
	
}
