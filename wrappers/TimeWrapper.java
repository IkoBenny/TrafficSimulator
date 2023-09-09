package wrappers;

import javax.swing.SwingUtilities;

import interfaces.ThreadWrapperInterface;
import sim.Constants;
import sim.Model;
import sim.Time;
import sim.View;
import sim.Constants.SimulationMode;
import sim.Mediator;

public class TimeWrapper extends Thread implements ThreadWrapperInterface {
	Mediator mvc;
	Time  timeObj;

	
	public TimeWrapper(Mediator mvc) {
		this.mvc = mvc;
		timeObj = new Time();
	}
	
	public void run() {
		startThread();
	}
	
	@Override
	public void startThread() {
		for (;;) {
			try {
				Thread.sleep(1000);
				String s = timeObj.start();
				if (mvc.getM().getMode().equals(Constants.SimulationMode.STOP) == false
						&& mvc.getM().getMode().equals(Constants.SimulationMode.PAUSE) == false) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							mvc.getV().getTime().setText(s);
							mvc.getV().getFrame().repaint();
						}
					});
				}		
				else if (mvc.getM().getMode().equals(Constants.SimulationMode.PAUSE)) {
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

