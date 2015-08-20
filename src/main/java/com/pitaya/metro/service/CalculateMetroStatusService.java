package com.pitaya.metro.service;

import com.pitaya.metro.domains.MetroCurrentStatusDomain;
import com.pitaya.metro.enums.MetroLineEnum;
import com.pitaya.metro.enums.MetroStationsEnum;

public interface CalculateMetroStatusService {

	/**
	 * 根据<code>metroLineEnum</code>号线和出发站：<code>metroStationsEnum</code>
	 * 计算获取相应的<code>MetroCurrentStatusDomain</code>
	 * @param metroLineEnum
	 * @param metroStationsEnum
	 * @return
	 */
	MetroCurrentStatusDomain getMetroCurrentStatus(
			MetroLineEnum metroLineEnum,
			MetroStationsEnum metroStationsEnum);
}
