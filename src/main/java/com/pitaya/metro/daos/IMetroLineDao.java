package com.pitaya.metro.daos;

import org.apache.ibatis.annotations.Param;

import com.pitaya.metro.models.MetroLine;

public interface IMetroLineDao {

	/**
	 * 根据线路编号获取线路信息
	 * @param lineNum
	 * @return
	 */
	MetroLine getMetroLine(
			@Param(value="lineNum")Integer lineNum,
			@Param(value="departStationNum")Integer departStationNum);

}
