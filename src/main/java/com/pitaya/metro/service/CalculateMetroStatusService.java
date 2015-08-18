package com.pitaya.metro.service;

import com.pitaya.metor.domains.MetroCurrentStatusDomain;
import com.pitaya.metor.enums.SZMetrosEnum;

public interface CalculateMetroStatusService {

	MetroCurrentStatusDomain getMetroCurrentStatus(SZMetrosEnum szMetrosEnum);
}
