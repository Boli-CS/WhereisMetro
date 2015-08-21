package com.pitaya.metro.service.impl;

import java.sql.Time;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitaya.metro.daos.IMetroLineDao;
import com.pitaya.metro.daos.IMetroStationDao;
import com.pitaya.metro.domains.MetroCurrentStatusDomain;
import com.pitaya.metro.enums.MetroStationsEnum;
import com.pitaya.metro.enums.MetroLineEnum;
import com.pitaya.metro.models.MetroLine;
import com.pitaya.metro.service.CalculateMetroStatusService;

@Service("calculateMetroStatusService")
public class CalculateMetroStatusServiceImpl implements CalculateMetroStatusService {

	@Autowired
	IMetroStationDao IMetroStationDao;
	
	@Autowired
	IMetroLineDao IMetroLineDao;
	
	private final MetroStationsEnum currentStation = MetroStationsEnum.laojie;
	
	//早高峰和晚高峰起止时间
	private final Time morningFastigiumStartTime = new Time(7,30,00);
	private final Time morningFastigiumEndTime = new Time(9,00,00);
	private final Time eveningFastigiumStartTime = new Time(17,30,00);
	private final Time eveningFastigiumEndTime = new Time(19,30,00);
	
	
	@Override
	public MetroCurrentStatusDomain getMetroCurrentStatus(MetroLineEnum metroLineEnum, 
			MetroStationsEnum metroStationsEnum) {
		MetroCurrentStatusDomain metroCurrentStatusDomain = new MetroCurrentStatusDomain();
		
		Time currentTime = new Time(System.currentTimeMillis());
		//当前站到始发站的时间
		Integer goThroughTime = IMetroStationDao.getGoThroughTime(
				metroLineEnum.getCode(),metroStationsEnum.getCode(), currentStation.getCode());
		//下一班到达的车为departLineTime之前出发的第一班车
		Time departLineTime = new Time(currentTime.getTime() - goThroughTime * 1000);
		MetroLine metroLine = IMetroLineDao.getMetroLine(metroLineEnum.getCode(), metroStationsEnum.getCode());
		Time actualDepartTime = metroLine.getFirstTime();
		while (actualDepartTime.before(departLineTime)) {
			if( (actualDepartTime.after(morningFastigiumStartTime) && actualDepartTime.before(morningFastigiumEndTime)
			 || (actualDepartTime.after(eveningFastigiumStartTime) && actualDepartTime.before(eveningFastigiumEndTime)))){
				actualDepartTime.setTime(actualDepartTime.getTime() + metroLine.getFastigiumInterval() * 60 * 1000);
			}
			else {
				actualDepartTime.setTime(actualDepartTime.getTime() + metroLine.getUsualInterval() * 60 * 1000);
			}
		}
		
		Integer residueTime = ((int)(actualDepartTime.getTime() - departLineTime.getTime())) / 1000;
		metroCurrentStatusDomain.setMetroLineEnum(metroLineEnum);
		metroCurrentStatusDomain.setSeconds(residueTime);
		return metroCurrentStatusDomain;
	}

	
}
