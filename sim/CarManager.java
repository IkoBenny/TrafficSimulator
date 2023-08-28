package sim;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class CarManager {
	private Car carOne;
	private Car carTwo;
	private Car carThree;
	private ArrayList<Car> cars = new ArrayList<>();
	private ArrayList<TrafficLight> lights = new ArrayList<>();
	
	public void initCars() {
		carOne = new Car(new Point2D.Double(0.0, 0.0), Constants.STOP_SPEED, lights);
		addCar(carOne);
		carTwo = new Car(new Point2D.Double(0.0, 0.0), Constants.STOP_SPEED, lights);
		addCar(carTwo);
		carThree = new Car(new Point2D.Double(0.0, 0.0), Constants.STOP_SPEED, lights);
		addCar(carThree);
	}

	public void startCar(int car) {
		cars.get(car).go();
	}
	
	public void setCarSpeed(int car, double speed) {
		cars.get(car).setCurrentSpeed(speed);
	}
	
	public double getCarSpeed(int car) {
		return cars.get(car).getCurrentSpeed();
	}
	
	public String getCarPosition(int car) {
		return cars.get(car).getPositionAsString();
	}
	
	public Car newCar() {
		return new Car(new Point2D.Double(0.0, 0.0), Constants.STOP_SPEED, lights);
	}
	
	public void addCar(Car c) {
		cars.add(c);
	}
}
