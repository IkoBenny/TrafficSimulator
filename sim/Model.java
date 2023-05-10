package sim;

import sim.Constants.TrafficLightColor;

public class Model {
	TrafficLight lightOne;
	TrafficLight lightTwo;
	TrafficLight lightThree;
	Car carOne;
	Car carTwo;
	Car carThree;
	Time clock;
	Scheduler scheduler;
	
	public Model(TrafficLight lightOne, TrafficLight lightTwo, TrafficLight lightThree, Car carOne, Car carTwo,
			Car carThree, Time clock, Scheduler scheduler) {
		this.lightOne = lightOne;
		this.lightTwo = lightTwo;
		this.lightThree = lightThree;
		this.carOne = carOne;
		this.carTwo = carTwo;
		this.carThree = carThree;
		this.scheduler = scheduler;
		this.clock = clock;
	}

	public String getCarOneSpeed() {
		return Double.toString(carOne.getCurrentSpeed());
	}
	
	public String getCarTwoSpeed() {
		return Double.toString(carTwo.getCurrentSpeed());
	}
	
	public String getCarThreeSpeed() {
		return Double.toString(carThree.getCurrentSpeed());
	}
	
	public String getTrafficLightOneStatus() {
		TrafficLightColor tlc = lightOne.getColor();
		return TrafficLightColor.toString(tlc);
	}
	
	public String getTrafficLightTwoStatus() {
		TrafficLightColor tlc = lightTwo.getColor();
		return TrafficLightColor.toString(tlc);
	}
	
	public String getTrafficLightThreeStatus() {
		TrafficLightColor tlc = lightThree.getColor();
		return TrafficLightColor.toString(tlc);
	}
	
	public String getCarOnePosition() {
		return carOne.getPositionAsString();
	}

	public String getCarTwoPosition() {
		return carTwo.getPositionAsString();
	}

	public String getCarThreePosition() {
		return carThree.getPositionAsString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public void init() {
		lightOne.run();
		lightTwo.run();
		lightThree.run();
		carOne.run();
		carTwo.run();
		carThree.run();
		clock.run();
	}

	public String getTimestamp() {
		return Long.toString(clock.timestamp());
	}

}
