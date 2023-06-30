package sim;


import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import sim.Constants.SimulationMode;

public class Main {

	public static void main(String[] args) throws InterruptedException, InvocationTargetException {
		// create the Model, View and Controller
		Model m = new Model();
		View v = new View();
		Controller c = new Controller();


		// Schedule the GUI to be created on the event thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// show GUI/View, then connect it and Model to Controller
				v.createAndShowGUI();
				v.addChangeListeners(c);
				v.addActionListeners(c);
				c.setViewAndModel(m, v);
			}
		});

		for (;;) {

			switch (m.getMode()) {
			case START:
				System.out.println("START");
				while (m.getMode() == SimulationMode.START) {
					c.getStartThread().start();
					c.getModel().getLightOne().start();
					c.getModel().getLightTwo().start();
					c.getModel().getLightThree().start();
					c.getModel().getCarOne().start();
					c.getModel().getCarTwo().start();
					c.getModel().getCarThree().start();
					m.started();
				}
				break;
			case PAUSE:
				System.out.println("PAUSE");
				while (m.getMode() == SimulationMode.PAUSE) {
					m.paused();
				}
				break;
			case CONTINUE:
				System.out.println("CONTINUE");
				while (m.getMode() == SimulationMode.CONTINUE) {
					m.restarted();
				}
				break;
			case STOP:
				System.out.println("STOP");
				while (m.getMode() == SimulationMode.STOP) {
					m.stopped();
				}
				break;
			}
		}
	}
		

		//Use Strategy pattern depending on button selected
		


}
