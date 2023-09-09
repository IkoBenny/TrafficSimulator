package wrappers;

import javax.swing.SwingUtilities;

import interfaces.ThreadWrapperInterface;
import sim.Car;
import sim.Constants;
import sim.Model;
import sim.View;
import sim.Constants.SimulationMode;
import sim.Mediator;

public class CarDTO extends Thread implements ThreadWrapperInterface {
	Mediator mvc;
	double speed;
	String position;
	int id;
	
	public CarDTO(Mediator mvc, double speed, String position, int id) {
		this.mvc = mvc;
		this.speed = speed;
		this.position = position;
		this.id = id;
	}
	
	public void run() {
		startThread();
	}
	
	@Override
	public void startThread() {
		for (;;) {
			try {
				Thread.sleep(1000);
				if (mvc.getM().getMode().equals(Constants.SimulationMode.STOP) == false
						&& mvc.getM().getMode().equals(Constants.SimulationMode.PAUSE) == false) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							update();
							mvc.getV().getCarViews().get(id).getSpeed().setText(Double.toString(speed));
							mvc.getV().getCarViews().get(id).getPosition().setText(position);
							mvc.getV().getFrame().repaint();
						}
					});

				} else if (mvc.getM().getMode().equals(Constants.SimulationMode.PAUSE)) {
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	public void update() {
		position = mvc.getM().getCar(id).getPositionAsString();
		speed = mvc.getM().getCar(id).getCurrentSpeed();
	}
}
