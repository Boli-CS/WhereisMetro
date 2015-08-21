package com.pitaya.metro.daos;

import org.apache.ibatis.annotations.Param;

import com.pitaya.metro.models.MetroLine;

public interface IMetroLineDao {

	/**
	 * 根据线路编号获取线路信息
	 * @param lineNum			地铁线路编号
	 * @param departStationNum	出发站台
	 * @return
	 */
	MetroLine getMetroLine(
			@Param(value="lineNum")Integer lineNum,
			@Param(value="departStationNum")Integer departStationNum);

}
