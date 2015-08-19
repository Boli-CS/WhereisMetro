package com.pitaya.metro.daos;

import java.util.List;

import com.pitaya.metro.models.MetroStation;

public interface IMetroStationDao {
	
	public List<MetroStation> findAll();

}
