package sim;

import javax.swing.SwingUtilities;

import builder.CarBuilder;
import builder.CarBuilderDirector;

public class Setup implements Command {
	private Mediator mvc;
	private CarBuilder builder = new CarBuilder();
	private CarBuilderDirector director = new CarBuilderDirector(builder);
	
	Setup(Mediator mvc) {
		this.mvc = mvc;
	}
	
	@Override
	public void execute() {
		setup();
		buildLights();
		buildCars();
	}

	private void setup() {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					mvc.getV().createAndShowGUI();
					mvc.getV().addActionListeners(mvc.getC());
					mvc.getV().addChangeListeners(mvc.getC());
					mvc.getC().setViewAndModel(mvc.getM(), mvc.getV());
				}
			});
	}

	private void buildLights() {
		TrafficLight one;
		TrafficLight two;
		TrafficLight three;
		
		one = mvc.getM().newLight();
		mvc.getM().addLight(one);
		two = mvc.getM().newLight();
		mvc.getM().addLight(two);
		three = mvc.getM().newLight();	
		mvc.getM().addLight(three);
	}
	
	private void buildCars() {
		Car one;
		Car two;
		Car three;
		
		director.construct();
		one = builder.getResult();
		director.construct();
		two = builder.getResult();
		director.construct();
		three = builder.getResult();
		
		mvc.getM().addCar(one);
		mvc.getM().addCar(two);
		mvc.getM().addCar(three);
	}
}
