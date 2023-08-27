package sim;

import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import sim.Constants.SimulationMode;

public class Main {
	Model m = new Model();
	View v = new View();
	Controller c = new Controller();
	
	public static void main(String[] args)  {
		Main mainObj = new Main();
		try {
			mainObj.init();
			mainObj.sim();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sim() throws InterruptedException, InvocationTargetException {
		for (;;) {
			Thread.sleep(1000);
			System.out.println("MAIN - Done Sleeping");
			switch (m.getMode()) {
			case START:
				System.out.println("START");
				while (m.getMode() == SimulationMode.START) {
					SimWrapper time = new SimWrapper(new Time(), SimulationMode.START, v);
					time.start();
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
			default:
				break;
			}
		}
	}

	public void init() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				v.createAndShowGUI();
				v.addChangeListeners(c);
				v.addActionListeners(c);
				c.setViewAndModel(m, v);
			}
		});
	}
}
