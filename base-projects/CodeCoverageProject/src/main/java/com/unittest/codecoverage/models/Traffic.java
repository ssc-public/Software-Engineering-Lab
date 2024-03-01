package com.unittest.codecoverage.models;

public class Traffic {
	
	private TrafficLigth currentTrafficLight;
	private boolean intenseCarTraffic;
	private short maxSpeedAllowed;
	private short minSpeedAllowed;
	private StreetDirectionFlow streetDirectionFlow;
	
	public TrafficLigth getCurrentTrafficLight() {
		return currentTrafficLight;
	}
	public void setCurrentTrafficLight(TrafficLigth currentSignaling) {
		this.currentTrafficLight = currentSignaling;
	}
	public boolean intenseCarTraffic() {
		return intenseCarTraffic;
	}
	public void setIntenseCarTraffic(boolean intenseCarTraffic) {
		this.intenseCarTraffic = intenseCarTraffic;
	}
	public short getMaxSpeedAllowed() {
		return maxSpeedAllowed;
	}
	public void setMaxSpeedAllowed(short maxSpeedAllowed) {
		this.maxSpeedAllowed = maxSpeedAllowed;
	}
	public short getMinSpeedAllowed() {
		return minSpeedAllowed;
	}
	public void setMinSpeedAllowed(short minSpeedAllowed) {
		this.minSpeedAllowed = minSpeedAllowed;
	}
	public StreetDirectionFlow getStreetDirectionFlow() {
		return streetDirectionFlow;
	}
	public void setStreetDirectionFlow(StreetDirectionFlow streetDirectionFlow) {
		this.streetDirectionFlow = streetDirectionFlow;
	}

}
