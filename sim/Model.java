package sim;

import lombok.Getter;
import sim.Constants.SimulationMode;

@Getter
public class Model {
	private CarManager cars = new CarManager();
	private LightManager lights = new LightManager();
	private Time clock;
	private SimulationMode mode;
	
	public Model() {
		clock = new Time();
		CarManager cars = new CarManager();
		LightManager lights = new LightManager();
		cars.initCars();
		lights.initLights();
		mode = SimulationMode.INIT;
	}
	
	public synchronized void startMode () {
		mode = SimulationMode.START;
		notify();
	}
	
	public synchronized void stopMode () {
		mode = SimulationMode.STOP;
		notify();
	}
	
	public synchronized void pauseMode () {
		mode = SimulationMode.PAUSE;
		notify();
	}
	
	public synchronized void continueMode () {
		mode = SimulationMode.CONTINUE;
		notify();
	}
	
	public synchronized void stopped() {
		System.out.println("Inside stopped()...");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Starting back up...");
	}
	
	public synchronized void started() {
		System.out.println("Inside started()...");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Starting back up...");
	}

	public synchronized void restarted() {
		System.out.println("Inside restarted()...");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Starting back up...");
	}
	
	public synchronized void paused() {
		System.out.println("Inside paused()...");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Starting back up...");
	}
	
	public String getTimestamp() {
		return clock.getTime();
	}

	public void setCarSpeed(int car, int speed) {
		cars.setCarSpeed(car, speed);
	}
}
