package sim;

import builder.CarBuilder;
import builder.CarBuilderDirector;

public class BuildCars implements Command {
	private Mediator mvc;
	private CarBuilder builder = new CarBuilder();
	private CarBuilderDirector director = new CarBuilderDirector(builder);

	public BuildCars(Mediator mvc) {
		this.mvc = mvc;
	}

	@Override
	public void execute() {
		buildCars();
	}

	private void buildCars() {
		for (int i = 0; i < mvc.getView().carsSlider.getValue(); i++) {
			director.construct();
			Car car = builder.getResult();
			mvc.getModel().addCar(car);
		}

		for (int i = 0; i < mvc.getView().carsSlider.getValue(); i++) {
			mvc.getModel().startCar(i);
		}
	}
}
