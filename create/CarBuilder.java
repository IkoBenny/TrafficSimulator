package create;

import java.time.Instant;
import sim.Car;
import sim.Constants;
import sim.Mediator;
import sim.Model;

public class CarBuilder implements CarBuilderInterface {
	private Car car;
	private Mediator mvc;
	
	CarBuilder(Mediator mvc) {
		this.mvc = mvc;
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
