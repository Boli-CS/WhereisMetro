package com.pitaya.metro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitaya.metro.daos.IMetroStationDao;
import com.pitaya.metro.domains.MetroCurrentStatusDomain;
import com.pitaya.metro.enums.SZMetrosEnum;
import com.pitaya.metro.models.MetroStation;
import com.pitaya.metro.service.CalculateMetroStatusService;

@Service("calculateMetroStatusService")
public class CalculateMetroStatusServiceImpl implements CalculateMetroStatusService {

	@Autowired
	IMetroStationDao IMetroStationDao;
	
	@Override
	public MetroCurrentStatusDomain getMetroCurrentStatus(SZMetrosEnum szMetrosEnum) {
		List<MetroStation> metroStations = IMetroStationDao.findAll();
		for (MetroStation metroStation : metroStations) {
			
		}
		return null;
	}

	
}
