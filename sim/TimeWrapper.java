package sim;

public class TimeWrapper extends Thread {
	Constants.SimulationMode mode;
	SimObject obj;
	View view;
	
	public TimeWrapper(SimObject obj,Constants.SimulationMode mode, View view) {
		this.obj = obj;
		this.mode = mode;
		this.view = view;
	}
	
	public void start() {
		for (;;) {
			try {
				Thread.sleep(1000);
				String s = obj.start();
				if (mode.equals(Constants.SimulationMode.STOP) == false
						&& mode.equals(Constants.SimulationMode.PAUSE) == false) {
					view.getField10().setText(s);
					view.frame.repaint();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

