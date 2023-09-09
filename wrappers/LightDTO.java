package wrappers;

import javax.swing.SwingUtilities;

import interfaces.ThreadWrapperInterface;
import sim.Constants;
import sim.Mediator;

public class LightDTO extends Thread implements ThreadWrapperInterface {
	Mediator mvc;
	String status;
	String position;
	int id;
	
	public LightDTO(Mediator mvc, String status, String position, int id) {
		this.mvc = mvc;
		this.status = status;
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
							mvc.getV().getLightViews().get(id).getStatus().setText(status);
							mvc.getV().getLightViews().get(id).getPosition().setText(position);
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
		position = mvc.getM().getLight(id).getPositionAsString();
		status = mvc.getM().getLight(id).getTlc().toString();
	}
}
