package builder;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import interfaces.CarBuilderInterface;
import sim.Car;
import sim.Constants;
import sim.Model;

public class CarBuilder implements CarBuilderInterface {
	private Car car;
	private static Logger log = LoggerFactory.getLogger(CarBuilder.class);
	
	public CarBuilder() {
		log.info("Inside CarBuilder() {}...");
		log.info("Leaving CarBuilder() {}...");
	}
	
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
		car.setLights(Model.getLights());
		car.setClosest(car.getClosestLight(car.getPositionAsDouble()));
	}

	@Override
	public Car getResult() {
		return car;
	}

	private Car getNewCar() {
		return new Car();
	}
	
}
