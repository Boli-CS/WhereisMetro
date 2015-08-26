package com.pitaya.metro.domains;

import java.util.Date;

import com.pitaya.metro.enums.MetroStationsEnum;
import com.pitaya.metro.enums.MetroLineEnum;

/**
 * 地铁当前状态
 * @author boli
 *
 */
public class MetroCurrentStatusDomain {
	
	/**
	 * 记录的地铁线路
	 */
	MetroLineEnum metroLineEnum;
	
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
	Long seconds;

	public MetroLineEnum getMetroLineEnum() {
		return metroLineEnum;
	}

	public void setMetroLineEnum(MetroLineEnum metroLineEnum) {
		this.metroLineEnum = metroLineEnum;
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

	public Long getSeconds() {
		return seconds;
	}

	public void setSeconds(Long seconds) {
		this.seconds = seconds;
	}
	
}
