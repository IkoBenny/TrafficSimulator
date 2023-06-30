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
	private TrafficLight closest;
//	private volatile boolean wait;
	private static Logger log = LoggerFactory.getLogger(Car.class);
	
	public Car(Point2D.Double start, double speed) {
		log.info("Inside Car(start, speed)...");
		currentSpeed = speed;
		position = start;
		isMoving = false;
		lastStop = Instant.now();
		log.info("Leaving Car(start, speed)...");
//		wait = true;
	}

	public synchronized void calculatePosition() {
		log.info("Inside calculatePosition() {}...", position);
		double now = Instant.now().toEpochMilli() / 1000.0; // milliseconds to seconds
		double start = lastStop.toEpochMilli() / 1000.0; // milliseconds to seconds
		double difference = now - start;
		double distance = difference * getCurrentSpeed();
		position.setLocation(distance, 0);
		log.info("leaving calculatePosition()...");
		//System.out.println(toString() + " moving for: " + difference + " seconds..");
	}
	
	/*
	 * public synchronized void carLock() throws InterruptedException { while(wait)
	 * { wait(); } }
	 */
	
	public synchronized double getCurrentSpeed() {
		log.info("Inside getCurrentSpeed()...");
		//log.info("Car distance: " + distance);
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
	
	public void go() {
		log.info("Inside go()...");
		if (isMoving) {
			log.info("Leaving go()...");
			return;
		}
			
		if (isMoving == false) {
			isMoving = true;
			lastStop = Instant.now();
			currentSpeed = Constants.START_SPEED;
			for (int i = 0; i < 100000; i++) {
				try {
					log.info("Inside go() loop...");
					calculatePosition();
					//findNearestLight(getPositionAsDouble());
					//stopIfRed();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//System.out.println("currentPosition: " + position);
			}
		}
	}
	
	/*
	 * private void stopIfRed() { // TODO Auto-generated method stub if(
	 * closest.getColor().toString().equals(Constants.RED)) { stopCar(); } }
	 */

	/*
	 * private void findNearestLight(double position) { closest = }
	 */
	
	@Override
	public void run() {
		log.info("Inside run()...");
		go();
	}
	
	public synchronized void setCurrentSpeed(double currentSpeed) {
		log.info("Inside setCurrentSpeed()...");
		this.currentSpeed = currentSpeed;
		log.info("Leaving setCurrentSpeed()...");
	}

	public synchronized void stopCar() {
		log.info("Inside stopCar()...");
		currentSpeed = Constants.STOP_SPEED;
		log.info("Leaving stopCar()...");
	}
	 
}
