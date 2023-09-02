package builder;

import interfaces.CarBuilderInterface;
import interfaces.DirectorInterface;

public class CarBuilderDirector implements DirectorInterface {
	CarBuilderInterface builder;
	
	public CarBuilderDirector(CarBuilderInterface builder) {
		this.builder = builder;
	}
	
	@Override
	public void construct() {
		builder.build();
		builder.buildA();
		builder.buildB();
	}

}
