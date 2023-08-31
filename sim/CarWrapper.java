package sim;

import javax.swing.SwingUtilities;

public class CarWrapper extends Thread {
	Constants.SimulationMode mode;
	Car carObj;
	View view;
	Model model;
	
	public CarWrapper(Car carObj,Constants.SimulationMode mode, View view, Model model) {
		this.carObj = carObj;
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
				setMode(model.getMode());
				if (mode.equals(Constants.SimulationMode.STOP) == false
						&& mode.equals(Constants.SimulationMode.PAUSE) == false) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							view.getField1().setText(Double.toString(carObj.getCurrentSpeed()));
							view.getField7().setText(carObj.getPositionAsString());
							view.frame.repaint();
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
	
	public void pause() {
		if (mode.equals(Constants.SimulationMode.PAUSE)) {
			view.getField1().setText(carObj.getPositionAsString());
			view.getField7().setText(Double.toString(carObj.getCurrentSpeed()));
			view.frame.repaint();
		}
	}
	
	public void startCar () {
		carObj.go();
	}
}
