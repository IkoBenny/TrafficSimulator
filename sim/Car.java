package sim;

import java.awt.geom.Point2D;
import java.time.Instant;

public class Car extends Thread {
	private double currentSpeed;
	private Point2D position;
	private Instant lastStop;
	private boolean isMoving;
//	private volatile boolean wait;
	
	public Car(Point2D.Double start, double speed) {
		currentSpeed = speed;
		position = start;
		isMoving = false;
		lastStop = Instant.now();
//		wait = true;
	}

	public synchronized void calculatePosition() {
		double now = Instant.now().toEpochMilli() / 1000.0; // milliseconds to seconds
		double start = lastStop.toEpochMilli() / 1000.0; // milliseconds to seconds
		double difference = now - start;
		double distance = difference * getCurrentSpeed();
		position.setLocation(distance, 0);
		//System.out.println(toString() + " moving for: " + difference + " seconds..");
	}
	
	/*
	 * public synchronized void carLock() throws InterruptedException { while(wait)
	 * { wait(); } }
	 */
	
	public double getCurrentSpeed() {
		return currentSpeed;
	}
	
	public synchronized String getPositionAsString() {
		double x = position.getX();
	    double y = position.getY();
	    return "(" + x + "," + y + ")";
	}
	
	public void go() {
		if (isMoving)
			return;

		if (isMoving == false) {
			isMoving = true;
			lastStop = Instant.now();
			currentSpeed = Constants.START_SPEED;
			for (int i = 0; i < 100000; i++) {
				try {
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
		go();
	}
	
	public synchronized void setCurrentSpeed(double currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public synchronized void stopCar() {
		currentSpeed = Constants.STOP_SPEED;
	}
	 
}
