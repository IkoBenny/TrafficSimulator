package sim;

import java.awt.geom.Point2D;
import java.time.Instant;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Car extends Thread implements Cloneable{
	private double currentSpeed;
	private Point2D position;
	private Instant lastStop;
	private boolean isMoving;
	private ArrayList<TrafficLight> lights;
	private TrafficLight closest;
	private static Logger log = LoggerFactory.getLogger(Car.class);

	public Car() {
		log.info("Inside Car() {}...", position);
		log.info("Inside Car() {}...", position);
	}

	public synchronized void calculatePosition() {
		log.info("Inside calculatePosition() {}...", position);
		double now = Instant.now().toEpochMilli() / 1000.0;
		double start = lastStop.toEpochMilli() / 1000.0;
		double difference = now - start;
		double distance = difference * getCurrentSpeed();
		position.setLocation(distance, 0);
		log.info("leaving calculatePosition()...");
	}

	public synchronized double getCurrentSpeed() {
		log.info("Inside getCurrentSpeed()...");
		log.info("Leaving getCurrentSpeed()...");
		return currentSpeed;
	}

	public synchronized Double getPositionAsDouble() {
		log.info("Inside getPositionAsDouble()...");
		double x = position.getX();
		log.info("Leaving getPositionAsString()...");
		return x;
	}

	public synchronized String getPositionAsString() {
		log.info("Inside getPositionAsString()...");
		double x = position.getX();
		double y = position.getY();
		log.info("Leaving getPositionAsString()...");
		return "(" + x + "," + y + ")";
	}
	
	public void setLights(ArrayList<TrafficLight> lights) {
		this.lights = lights;
	}

	public void go() {
		double gps;
		double intersection;
		log.info("Inside go()...");
		lastStop = Instant.now();
		currentSpeed = Constants.START_SPEED;
		isMoving = true;
		while (isMoving) {
			log.info("Inside go() loop...");
			calculatePosition();
			findNearestLight();
			intersection = closest.getPosition().getX();
			gps =  getPositionAsDouble();
			if (intersection - gps <= 500) {
				stopIfRed();
				while (closest.getColor().equals(Constants.TrafficLightColor.RED)) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			isMoving = true;
			currentSpeed = Constants.START_SPEED;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		log.info("Leaving go()...");
	}

	private synchronized void stopIfRed() {
		log.info("Inside stopIfRed()...");
		if (closest.getColor().equals(Constants.TrafficLightColor.RED)) {
			log.info("Inside stopIfRed() if...");
			stopCar();
		}
		log.info("Leaving stopIfRed()...");
	}

	private synchronized void findNearestLight() {
		log.info("Inside findNearestLight()...");
		double pos = getPositionAsDouble();
		closest = getClosestLight(pos);
		log.info("closest light: {}...", closest.getPosition());
		log.info("Leaving findNearestLight()...");
	}

	public TrafficLight getClosestLight(double position) {
		log.info("Inside getClosestLight()...");
		if (position < Constants.THOUSAND_METERS_IN_FEET) {
			log.info("Leaving getClosestLight()...{}", lights.get(0));
			return lights.get(0);
		} else {
			for (int i = 1; i < lights.size(); i++) {
				if (lights.get(i).getPosition().getX() > position) {
					log.info("Leaving getClosestLight()...{}", lights.get(i));
					return lights.get(i);
				}
			}
		}
		log.info("Leaving getClosestLight()...");
		return null;
	}

	public synchronized void setCurrentSpeed(double currentSpeed) {
		log.info("Inside setCurrentSpeed()...");
		this.currentSpeed = currentSpeed;
		log.info("Leaving setCurrentSpeed()...");
	}

	public synchronized void stopCar() {
		log.info("Inside stopCar()...");
		currentSpeed = Constants.STOP_SPEED;
		isMoving = false;
		log.info("Leaving stopCar()...");
	}
	
	public Object clone() throws CloneNotSupportedException {
		Car c = (Car)super.clone();
		c.position = new Point2D.Double();
		c.lastStop = this.lastStop;
		c.lights = new ArrayList<>();
		c.closest = new TrafficLight(closest.getPosition());
		return c; 
	}

	public void run() {
		go();
	}

	public String pause() {
		return null;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public void setIsMoving(boolean b) {
		isMoving = b;	
	}

	public void setLastStop(Instant now) {
		lastStop = now;		
	}

	public void setClosest(TrafficLight closestLight) {
		closest = closestLight;
	}
}
