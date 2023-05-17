package sim;

import java.awt.geom.Point2D;
import java.time.Instant;
import java.util.TimerTask;

public class Car extends Thread {
	private double currentSpeed;
	private Point2D position;
	private Instant lastStop;
	private boolean isMoving;
	private volatile boolean wait;
	
	public Car(Point2D.Double start, double speed) {
		currentSpeed = speed;
		position = start;
		isMoving = false;
		lastStop = Instant.now();
		wait = true;
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("currentPosition: " + position);
			}
		}
	}
	
	public synchronized void calculatePosition() {
			double now = Instant.now().toEpochMilli() / 1000.0; // milliseconds to seconds
			double start = lastStop.toEpochMilli() / 1000.0; // milliseconds to seconds
			double difference = now - start;
			double distance = difference * getCurrentSpeed();
			position.setLocation(distance, 0);
			System.out.println(toString() + " moving for: " + difference + " seconds..");
	}
	
	public synchronized void stopCar() {
		currentSpeed = Constants.STOP_SPEED;
	}

	public double getCurrentSpeed() {
		return currentSpeed;
	}

	public synchronized void setCurrentSpeed(double currentSpeed) {
			this.currentSpeed = currentSpeed;
	}

	@Override
	public void run() {
		go();
	}

	public synchronized Point2D getPosition() {
		return position;
	}

	public synchronized String getPositionAsString() {
		return position.toString();
	}
	
	
	public synchronized void carLock() throws InterruptedException {
		while(wait) {
			wait();
		}
	}
	
	  public static void main (String [] args) { Car c = new Car(new
	  Point2D.Double(0.0, 0.0), Constants.START_SPEED); c.run(); }
	 
}
