package sim;

import sim.Constants.SimulationMode;
import sim.Constants.TrafficLightColor;

public class Model {
	TrafficLight lightOne;
	TrafficLight lightTwo;
	TrafficLight lightThree;
	Car carOne;
	Car carTwo;
	Car carThree;
	Time clock;
	public static SimulationMode mode;
	
	public Model(TrafficLight lightOne, TrafficLight lightTwo, TrafficLight lightThree, Car carOne, Car carTwo,
			Car carThree, Time clock) {
		this.lightOne = lightOne;
		this.lightTwo = lightTwo;
		this.lightThree = lightThree;
		this.carOne = carOne;
		this.carTwo = carTwo;
		this.carThree = carThree;
		this.clock = clock;
		mode = SimulationMode.STOP;
	}

	public synchronized void startMode () {
		mode = SimulationMode.START;
		notify();
	}
	
	public synchronized void stopMode () {
		mode = SimulationMode.STOP;
		notify();
	}
	
	public synchronized void pauseMode () {
		mode = SimulationMode.PAUSE;
		notify();
	}
	
	public synchronized void continueMode () {
		mode = SimulationMode.CONTINUE;
		notify();
	}
	
	public synchronized void stopped() {
		System.out.println("Inside stopped()...");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Starting back up...");
	}
	
	public synchronized void started() {
		System.out.println("Inside started()...");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Starting back up...");
	}

	public synchronized void restarted() {
		System.out.println("Inside restarted()...");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Starting back up...");
	}
	
	public synchronized void paused() {
		System.out.println("Inside paused()...");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Starting back up...");
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
	
	public void startCar(String carNo) {
		switch(carNo) {
		case "1":
			carOne.go();
		case "2":
			carTwo.go();
		case "3":
			carThree.go();	
		}
	}
	
	public void init() {
		lightOne.run();
		lightTwo.run();
		lightThree.run();
		clock.run();
	}

	public String getTimestamp() {
		return clock.getTime();
	}

}
