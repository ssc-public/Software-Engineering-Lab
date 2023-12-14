package com.unittest.codecoverage.models;

public class Footpassenger {
	
	private boolean crossedTheCrosswalk;
	private TrafficLigth crossedTrafficLigth;
	private boolean lookedToTheRight;
	private boolean lookedToTheLeft;
	private boolean crossedTheRoad;
	
	public boolean crossedTheCrosswalk() {
		return crossedTheCrosswalk;
	}
	public void setCrossedTheCrosswalk(boolean crossedTheCrosswalk) {
		this.crossedTheCrosswalk = crossedTheCrosswalk;
	}
	public TrafficLigth getCrossedTrafficLigth() {
		return crossedTrafficLigth;
	}
	public void setCrossedTrafficLigth(TrafficLigth crossedSignaling) {
		this.crossedTrafficLigth = crossedSignaling;
	}
	public boolean lookedToTheRight() {
		return lookedToTheRight;
	}
	public void setLookedToTheRight(boolean lookedToTheRight) {
		this.lookedToTheRight = lookedToTheRight;
	}
	public boolean lookedToTheLeft() {
		return lookedToTheLeft;
	}
	public void setLookedToTheLeft(boolean lookedToTheLeft) {
		this.lookedToTheLeft = lookedToTheLeft;
	}
	public boolean crossedTheRoad() {
		return crossedTheRoad;
	}
	public void setCrossedTheRoad(boolean crossedTheStreet) {
		this.crossedTheRoad = crossedTheStreet;
	}
	
	
}
