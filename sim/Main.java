package sim;

import java.awt.geom.Point2D;
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
		LightManager lights = new LightManager();
		CarManager cars = new CarManager();
		lights.initLights();
		cars.setLights(lights.getLights());
		cars.initCars();
		
		TimeWrapper time = new TimeWrapper(new Time(), SimulationMode.INIT, v, m);
		CarWrapper carWrapper1 = new CarWrapper(cars.getCar(0), SimulationMode.INIT, v, m);
	
		for (;;) {
			Thread.sleep(1000);
			System.out.println("MAIN - Done Sleeping");
			switch (m.getMode()) {
			case START:
				System.out.println("START");
				while (m.getMode() == SimulationMode.START) {
					v.getContinueButton().setEnabled(true);
					v.getPause().setEnabled(true);
					v.getStop().setEnabled(true);			
					time.start();
					carWrapper1.start();
					carWrapper1.startCar();
		
					m.started();
				}	
				break;
			case INIT:
				System.out.println("INIT");
				while (m.getMode() == SimulationMode.INIT) {			
					m.init();
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
