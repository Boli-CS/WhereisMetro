package com.pitaya.metro.models;

import java.sql.Time;

/**
 * 地铁线路表格
 * @author boli
 *
 */
public class MetroLine {
	
	/**
	 * 地铁线路编号
	 */
	Integer lineNum;
	
	/**
	 * 地铁线路名称
	 */
	String lineName;
	
	/**
	 * 出发站台编号
	 */
	Integer departStationNum;
	
	/**
	 * 早班车时间
	 */
	Time firstTime;
	
	/**
	 * 末班车时间
	 */
	Time lastTime;
	
	/**
	 * 高峰时期时间间隔(分)
	 */
	Integer fastigiumInterval;
	
	/**
	 * 普通时期时间间隔(分)
	 */
	Integer usualInterval;

	public Integer getLineNum() {
		return lineNum;
	}

	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public Integer getDepartStationNum() {
		return departStationNum;
	}

	public void setDepartStationNum(Integer departStationNum) {
		this.departStationNum = departStationNum;
	}

	public Time getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(Time firstTime) {
		this.firstTime = firstTime;
	}

	public Time getLastTime() {
		return lastTime;
	}

	public void setLastTime(Time lastTime) {
		this.lastTime = lastTime;
	}

	public Integer getFastigiumInterval() {
		return fastigiumInterval;
	}

	public void setFastigiumInterval(Integer fastigiumInterval) {
		this.fastigiumInterval = fastigiumInterval;
	}

	public Integer getUsualInterval() {
		return usualInterval;
	}

	public void setUsualInterval(Integer usualInterval) {
		this.usualInterval = usualInterval;
	}
	
}
