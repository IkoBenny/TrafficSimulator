package sim;

import java.awt.geom.Point2D;
import java.time.Instant;
import java.util.TimerTask;

public class Car extends TimerTask {
	private double currentSpeed;
	private Point2D position;
	private Instant lastStop;
	private boolean isMoving;
	
	public Car(Point2D.Double start, double speed) {
		currentSpeed = speed;
		position = start;
		isMoving = false;
		lastStop = Instant.now();
	}

	public synchronized void go() {
		if (isMoving)
			return;

		if (isMoving == false) {
			isMoving = true;
			lastStop = Instant.now();
			currentSpeed = Constants.START_SPEED;
			for (int i = 0; i < 100000; i++) {
				updatePosition();
				System.out.println("currentPosition: " + position);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private synchronized void updatePosition() {
		if (isMoving == false) {
			return;
		}

		if (isMoving) {
			double now = Instant.now().toEpochMilli() / 1000.0; // milliseconds to seconds
			double start = lastStop.toEpochMilli() / 1000.0; // milliseconds to seconds
			double difference = now - start;
			double distance = difference * currentSpeed;
			position.setLocation(distance, 0);
			System.out.println(toString() + " moving for: " + difference + " seconds..");
		}
	}

	public synchronized void stop() {
		currentSpeed = Constants.STOP_SPEED;
	}

	public synchronized double getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(double currentSpeed) {
			this.currentSpeed = currentSpeed;
	}

	@Override
	public void run() {
		go();
	}

	/*
	 * public static void main (String [] args) { Car c = new Car(new
	 * Point2D.Double(0.0, 0.0), Constants.START_SPEED); c.run(); }
	 */
}
