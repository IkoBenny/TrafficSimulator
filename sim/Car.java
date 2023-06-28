package sim;

import java.awt.geom.Point2D;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Car extends Thread {
	private double currentSpeed;
	private Point2D position;
	private Instant lastStop;
	private boolean isMoving;
//	private volatile boolean wait;
	
	private static Logger log = LoggerFactory.getLogger(Car.class);
	
	public Car(Point2D.Double start, double speed) {
		log.debug("Inside Car(start, speed)...");
		currentSpeed = speed;
		position = start;
		isMoving = false;
		lastStop = Instant.now();
		log.debug("Leaving Car(start, speed)...");
//		wait = true;
	}

	public synchronized void calculatePosition() {
		log.debug("Inside calculatePosition()...");
		double now = Instant.now().toEpochMilli() / 1000.0; // milliseconds to seconds
		double start = lastStop.toEpochMilli() / 1000.0; // milliseconds to seconds
		double difference = now - start;
		double distance = difference * getCurrentSpeed();
		position.setLocation(distance, 0);
		log.debug("leaving calculatePosition()...");
		//System.out.println(toString() + " moving for: " + difference + " seconds..");
	}
	
	/*
	 * public synchronized void carLock() throws InterruptedException { while(wait)
	 * { wait(); } }
	 */
	
	public double getCurrentSpeed() {
		log.debug("Inside getCurrentSpeed()...");
		//log.info("Car distance: " + distance);
		log.debug("Leaving getCurrentSpeed()...");
		return currentSpeed;
	}
	
	public synchronized String getPositionAsString() {
		log.debug("Inside getPositionAsString()...");
		double x = position.getX();
	    double y = position.getY();
	    log.debug("Leaving getPositionAsString()...");
	    return "(" + x + "," + y + ")";
	}
	
	public void go() {
		log.debug("Inside go()...");
		if (isMoving) {
			log.debug("Leaving go()...");
			return;
		}
			
		if (isMoving == false) {
			isMoving = true;
			lastStop = Instant.now();
			currentSpeed = Constants.START_SPEED;
			for (int i = 0; i < 100000; i++) {
				try {
					log.debug("Inside go() loop...");
					calculatePosition();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//System.out.println("currentPosition: " + position);
			}
		}
	}
	
	@Override
	public void run() {
		log.debug("Inside run()...");
		go();
	}
	
	public synchronized void setCurrentSpeed(double currentSpeed) {
		log.debug("Inside setCurrentSpeed()...");
		this.currentSpeed = currentSpeed;
		log.debug("Leaving setCurrentSpeed()...");
	}

	public synchronized void stopCar() {
		log.debug("Inside stopCar()...");
		currentSpeed = Constants.STOP_SPEED;
		log.debug("Leaving stopCar()...");
	}
	 
}
