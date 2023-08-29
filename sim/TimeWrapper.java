package sim;

public class TimeWrapper extends Thread {
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
		for (;;) {
			try {
				Thread.sleep(1000);
				String s = timeObj.start();
				setMode(model.getMode());
				if (mode.equals(Constants.SimulationMode.STOP) == false
						&& mode.equals(Constants.SimulationMode.PAUSE) == false) {
					view.getField10().setText(s);
					view.frame.repaint();
				}
				
				else if (mode.equals(Constants.SimulationMode.PAUSE)) {
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void pause() {
		String s = timeObj.start();
		if (mode.equals(Constants.SimulationMode.PAUSE)) {
			view.getField10().setText(s);
			view.frame.repaint();
		}
	}
}

