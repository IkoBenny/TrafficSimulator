package interfaces;

import sim.Car;

public interface CarBuilderInterface {
	public abstract void build();
	public abstract void buildA();
	public abstract void buildB();
	public abstract Car getResult();
}
