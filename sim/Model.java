package sim;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

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
		this.lightOne = newLight();
		this.lightTwo = newLight();
		this.lightThree = newLight();
		carOne = new Car(new Point2D.Double(0.0, 0.0), Constants.STOP_SPEED);
		carTwo = new Car(new Point2D.Double(0.0, 0.0), Constants.STOP_SPEED);
		carThree = new Car(new Point2D.Double(0.0, 0.0), Constants.STOP_SPEED);
		clock = new Time();
		mode = SimulationMode.STOP;
	}

	public TrafficLight newLight() {
		if (lights.size() == 0) {
			return new TrafficLight(new Point2D.Double(Constants.THOUSAND_METERS_IN_FEET, 0));
		}
		else {
			Double position = lights.size() * Constants.THOUSAND_METERS_IN_FEET;
			return new TrafficLight(new Point2D.Double(position, 0));
		}		
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

	public TrafficLight getClosestLight(double position) {
		if (position < Constants.THOUSAND_METERS_IN_FEET ) {
			return lights.get(0);
		}
		else {
			for (int i =1; i < lights.size(); i ++) {
				if(lights.get(i).getPosition().getX()< position) {
					return lights.get(i);
				}
			}
			
		}
		return null;
	}
	
}
