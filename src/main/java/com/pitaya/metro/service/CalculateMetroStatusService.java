package com.pitaya.metro.service;

import com.pitaya.metro.domains.MetroCurrentStatusDomain;
import com.pitaya.metro.enums.SZMetrosEnum;

public interface CalculateMetroStatusService {

	MetroCurrentStatusDomain getMetroCurrentStatus(SZMetrosEnum szMetrosEnum);
}
