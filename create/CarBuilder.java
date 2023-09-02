package create;

import java.time.Instant;
import sim.Car;
import sim.Constants;
import sim.Model;

public class CarBuilder implements CarBuilderInterface {
	private Car car;
	
	public void build() {
		car = getNewCar();
	}
	
	/*Builds movement related components*/
	@Override
	public void buildA() {
		car.setCurrentSpeed(Constants.STOP_SPEED);
		car.setPosition(Constants.START_POSITION);
		car.setIsMoving(false);
		car.setLastStop(Instant.now());
	}

	/*Builds light related components*/
	@Override
	public void buildB() {
		TrafficLightManager manager = Model.getLights();
		car.setLights(manager.getLights());
		car.setClosest(car.getClosestLight(car.getPositionAsDouble()));
	}

	@Override
	public Car getResult() {
		return car;
	}

	private Car getNewCar() {
		return new Car();
	}
	
	public static void main(String [] args) {
		Integer i = 5;
		Integer j = 7;
		int s = 7;
		Integer k = j;
		j = j +7;
		System.out.println("done");
	}
	
}
