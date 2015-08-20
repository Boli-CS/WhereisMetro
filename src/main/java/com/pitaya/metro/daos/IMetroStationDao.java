package com.pitaya.metro.daos;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pitaya.metro.models.MetroStation;

public interface IMetroStationDao {
	
	public List<MetroStation> findAll();

	/**
	 * 计算<code>lineNum</code>号线从到达<code>startStationNum</code>站至到达
	 * <code>currentStationNum</code>站的时间，以秒为单位
	 * @param lineNum
	 * @param departStationNum
	 * @param currentStationNum
	 * @return
	 */
	public Integer getGoThroughTime(
			@Param(value="lineNum")Integer lineNum, 
			@Param(value="startStationNum")Integer startStationNum,
			@Param(value="currentStationNum")Integer currentStationNum);

}
