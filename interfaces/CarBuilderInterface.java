package interfaces;

import sim.Car;

public interface CarBuilder {
	public abstract void build();
	public abstract void buildA();
	public abstract void buildB();
	public abstract Car getResult();
}
