package sim;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import lombok.Getter;
import sim.Constants.SimulationMode;
import sim.Constants.TrafficLightColor;

@Getter
public class Model {
	private Car carOne;
	private Car carTwo;
	private Car carThree;
	private ArrayList<Car> cars = new ArrayList<>();
	
	private TrafficLight lightOne;
	private TrafficLight lightTwo;
	private TrafficLight lightThree;
	private ArrayList<TrafficLight> lights = new ArrayList<>();

	private Time clock;
	private SimulationMode mode;
	
	public Model() {
		initLights();
		initCars();
		clock = new Time();
		mode = SimulationMode.INIT;
	}

	public TrafficLight newLight() {
		if (lights.size() == 0) {
			return new TrafficLight(new Point2D.Double(Constants.THOUSAND_METERS_IN_FEET, 0));
		}
		else {
			Double position = (lights.size() + 1) * Constants.THOUSAND_METERS_IN_FEET;
			return new TrafficLight(new Point2D.Double(position, 0));
		}		
	}
	
	private void initLights() {
		this.lightOne = newLight();
		addLight(lightOne);
		this.lightTwo = newLight();
		addLight(lightTwo);
		this.lightThree = newLight();
		addLight(lightThree);
	}
	
	private void initCars() {
		carOne = new Car(new Point2D.Double(0.0, 0.0), Constants.STOP_SPEED, lights);
		addCar(carOne);
		carTwo = new Car(new Point2D.Double(0.0, 0.0), Constants.STOP_SPEED, lights);
		addCar(carTwo);
		carThree = new Car(new Point2D.Double(0.0, 0.0), Constants.STOP_SPEED, lights);
		addCar(carThree);
	}
	
	public Car newCar() {
		return new Car(new Point2D.Double(0.0, 0.0), Constants.STOP_SPEED, lights);
	}
	
	public void addCar(Car c) {
		cars.add(c);
	}
	
	public void addLight(TrafficLight l) {
		lights.add(l);
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
		return tlc.toString();
	}
	
	public String getTrafficLightTwoStatus() {
		TrafficLightColor tlc = lightTwo.getColor();
		return tlc.toString();
	}
	
	public String getTrafficLightThreeStatus() {
		TrafficLightColor tlc = lightThree.getColor();
		return tlc.toString();
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
	
	public String getTimestamp() {
		return clock.getTime();
	}
	
}
