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
		log.trace("Inside Car(start, speed)...");
		currentSpeed = speed;
		position = start;
		isMoving = false;
		lastStop = Instant.now();
		log.trace("Leaving Car(start, speed)...");
//		wait = true;
	}

	public synchronized void calculatePosition() {
		log.trace("Inside calculatePosition()...");
		double now = Instant.now().toEpochMilli() / 1000.0; // milliseconds to seconds
		double start = lastStop.toEpochMilli() / 1000.0; // milliseconds to seconds
		double difference = now - start;
		double distance = difference * getCurrentSpeed();
		position.setLocation(distance, 0);
		log.trace("leaving calculatePosition()...");
		//System.out.println(toString() + " moving for: " + difference + " seconds..");
	}
	
	/*
	 * public synchronized void carLock() throws InterruptedException { while(wait)
	 * { wait(); } }
	 */
	
	public double getCurrentSpeed() {
		log.trace("Inside getCurrentSpeed()...");
		//log.info("Car distance: " + distance);
		log.trace("Leaving getCurrentSpeed()...");
		return currentSpeed;
	}
	
	public synchronized String getPositionAsString() {
		log.trace("Inside getPositionAsString()...");
		double x = position.getX();
	    double y = position.getY();
	    log.trace("Leaving getPositionAsString()...");
	    return "(" + x + "," + y + ")";
	}
	
	public void go() {
		log.trace("Inside go()...");
		if (isMoving) {
			log.trace("Leaving go()...");
			return;
		}
			
		if (isMoving == false) {
			isMoving = true;
			lastStop = Instant.now();
			currentSpeed = Constants.START_SPEED;
			for (int i = 0; i < 100000; i++) {
				try {
					log.trace("Inside go() loop...");
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
		log.trace("Inside run()...");
		go();
	}
	
	public synchronized void setCurrentSpeed(double currentSpeed) {
		log.trace("Inside setCurrentSpeed()...");
		this.currentSpeed = currentSpeed;
		log.trace("Leaving setCurrentSpeed()...");
	}

	public synchronized void stopCar() {
		log.trace("Inside stopCar()...");
		currentSpeed = Constants.STOP_SPEED;
		log.trace("Leaving stopCar()...");
	}
	 
}
