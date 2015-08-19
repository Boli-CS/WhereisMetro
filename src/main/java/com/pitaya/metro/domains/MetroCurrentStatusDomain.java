package com.pitaya.metro.domains;

import java.util.Date;

import com.pitaya.metro.enums.MetroStationsEnum;
import com.pitaya.metro.enums.SZMetrosEnum;

/**
 * 地铁当前状态
 * @author boli
 *
 */
public class MetroCurrentStatusDomain {
	
	/**
	 * 记录的地铁线路
	 */
	SZMetrosEnum szMetrosEnum;
	
	/**
	 * 出发时间
	 */
	Date departTime;

	/**
	 * 到达时间
	 */
	Date arriveTime;
	
	/**
	 * 前一站
	 */
	MetroStationsEnum prevStation;
	
	/**
	 * 后一站
	 */
	MetroStationsEnum nextStation;
	
	/**
	 * 距离下一站的时间(s)
	 */
	long seconds;

	public SZMetrosEnum getSzMetrosEnum() {
		return szMetrosEnum;
	}

	public void setSzMetrosEnum(SZMetrosEnum szMetrosEnum) {
		this.szMetrosEnum = szMetrosEnum;
	}

	public Date getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Date departTime) {
		this.departTime = departTime;
	}

	public Date getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}

	public MetroStationsEnum getPrevStation() {
		return prevStation;
	}

	public void setPrevStation(MetroStationsEnum prevStation) {
		this.prevStation = prevStation;
	}

	public MetroStationsEnum getNextStation() {
		return nextStation;
	}

	public void setNextStation(MetroStationsEnum nextStation) {
		this.nextStation = nextStation;
	}

	public long getSeconds() {
		return seconds;
	}

	public void setSeconds(long seconds) {
		this.seconds = seconds;
	}
	
}
