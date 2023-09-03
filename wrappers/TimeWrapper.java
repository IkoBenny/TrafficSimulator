package wrappers;

import javax.swing.SwingUtilities;

import interfaces.ThreadWrapperInterface;
import sim.Constants;
import sim.Model;
import sim.Time;
import sim.View;
import sim.Constants.SimulationMode;

public class TimeWrapper extends Thread implements ThreadWrapperInterface {
	Constants.SimulationMode mode;
	Time  timeObj;
	View view;
	Model model;
	
	public TimeWrapper(Time timeObj,Constants.SimulationMode mode, View view, Model model) {
		this.timeObj = timeObj;
		this.mode = mode;
		this.view = view;
		this.model = model;
	}
	
	public void setMode(Constants.SimulationMode mode) {
		this.mode = mode;
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
				setMode(model.getMode());
				if (mode.equals(Constants.SimulationMode.STOP) == false
						&& mode.equals(Constants.SimulationMode.PAUSE) == false) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							view.getField10().setText(s);
							//view.frame.repaint();
						}
					});
				}		
				else if (mode.equals(Constants.SimulationMode.PAUSE)) {
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	public void pauseThread() {
		String s = timeObj.start();
		if (mode.equals(Constants.SimulationMode.PAUSE)) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					view.getField10().setText(s);
					//view.frame.repaint();
				}
			});
		}	
	}

	
	public void stopThread() {
		String s = timeObj.start();
		if (mode.equals(Constants.SimulationMode.PAUSE)) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					view.getField10().setText(s);
					//view.frame.repaint();
				}
			});
		}
	}
}
