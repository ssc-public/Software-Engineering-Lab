package com.unittest.codecoverage.services;

import com.unittest.codecoverage.models.Footpassenger;
import com.unittest.codecoverage.models.Traffic;

public interface TrafficBehaviorService {
	
	public void footpassengerCrossTheStreet(Traffic currentTrafic, Footpassenger currentFootpassengerBehavior);
	
}
