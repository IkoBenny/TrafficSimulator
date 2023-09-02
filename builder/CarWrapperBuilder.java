package builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import interfaces.ThreadWrapperInterface;
import interfaces.WrapperBuilderInterface;
import sim.Car;

public class CarWrapperBuilder implements WrapperBuilderInterface {
	private ThreadWrapperInterface car;
	private static Logger log = LoggerFactory.getLogger(CarBuilder.class);
	
	@Override
	public void build() {
		// TODO Auto-generated method stub

	}

	@Override
	public void buildA() {
		// TODO Auto-generated method stub

	}

	@Override
	public void buildB() {
		// TODO Auto-generated method stub

	}

	@Override
	public ThreadWrapperInterface getResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
