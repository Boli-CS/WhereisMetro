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
	
	@Override
	public MetroCurrentStatusDomain getMetroCurrentStatus(MetroLineEnum metroLineEnum, MetroStationsEnum metroStationsEnum) {
		MetroCurrentStatusDomain metroCurrentStatusDomain = new MetroCurrentStatusDomain();
		
		Time currentTime = new Time(System.currentTimeMillis());
		//当前站到始发站的时间
		Integer goThroughTime = IMetroStationDao.getGoThroughTime(
				metroLineEnum.getCode(),metroStationsEnum.getCode(), currentStation.getCode());
		//下一班到达的车为departLineTime之前出发的第一班车
		Time departLineTime = new Time(currentTime.getTime() - goThroughTime * 1000);
		MetroLine metroLine = IMetroLineDao.getMetroLine(metroLineEnum.getCode(), MetroStationsEnum.luohu.getCode());
		Time actualDepartTime = metroLine.getFirstTime();
		while (actualDepartTime.before(departLineTime)) {
			actualDepartTime.setTime(actualDepartTime.getTime() + metroLine.getFastigiumInterval() * 60 * 1000);
		}
		
		System.out.println("下一班车的发车时间为：" + actualDepartTime);
		Integer residueTime = ((int)(actualDepartTime.getTime() - departLineTime.getTime())) / 1000;
		metroCurrentStatusDomain.setMetroLineEnum(metroLineEnum);
		metroCurrentStatusDomain.setSeconds(residueTime);
		metroCurrentStatusDomain.setPrevStation(MetroStationsEnum.luohu);
		metroCurrentStatusDomain.setNextStation(currentStation);
		
		
		return metroCurrentStatusDomain;
	}

	
}
