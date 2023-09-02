package sim;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import builder.CarBuilder;
import builder.CarBuilderDirector;
import lombok.Getter;
import sim.Constants.SimulationMode;

@Getter
public class Model {
	private static ArrayList <TrafficLight> lights;
	private static ArrayList<Car> cars;
	private Time clock;
	private SimulationMode mode;
	private static Logger log = LoggerFactory.getLogger(Model.class);
	
	public Model() {
		log.info("Inside Model() {}...");	
		clock = new Time();
		mode = SimulationMode.INIT;
		lights = new ArrayList<>();
		cars = new ArrayList<>();
		log.info("Leaving Model() {}...");
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

	public synchronized void init() {
		System.out.println("Inside init()...");
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

	public void addLight(TrafficLight l) {
		log.info("Inside addLight(TrafficLight)...");
		lights.add(l);
		log.info("Leaving addLight(TrafficLight)...");
	}
	
	public TrafficLight newLight() {
		log.info("Inside newLight()...");
		if (lights.size() == 0) {
			log.info("Leaving newLight()...");
			return new TrafficLight(new Point2D.Double(Constants.THOUSAND_METERS_IN_FEET, 0));
		}
		else {
			Double position = (lights.size() + 1) * Constants.THOUSAND_METERS_IN_FEET;
			log.info("Leaving newLight()...");
			return new TrafficLight(new Point2D.Double(position, 0));
		}		
	}
	
	public void startLight(int light) {
		lights.get(light).lightswitch();
	}
	
	public static ArrayList<TrafficLight> getLights() {
		return lights;
	}

	public void startCar(int car) {
		cars.get(car).go();
	}
	
	public void setCarSpeed(int car, double speed) {
		cars.get(car).setCurrentSpeed(speed);
	}
	
	public double getCarSpeed(int car) {
		return cars.get(car).getCurrentSpeed();
	}
	
	public Car getCar(int car) {
		return cars.get(car);
	}
	
	public String getCarPosition(int car) {
		return cars.get(car).getPositionAsString();
	}
	
	public void addCar(Car c) {
		cars.add(c);
	}
	
	public static ArrayList<Car> getCars() {
		return cars;
	}
}
