import java.awt.geom.Point2D;
import java.time.Instant;
import java.util.TimerTask;

/*
 * A Car has a position [X,Y] and a current speed. 
 * A Car has two default settings speeds. When a car is created, its speed is 0 or it is stopped. 
 * A Car also moves or goes at 55 miles per hour/290400 feet per hour, and can stop or go. 
 * 
 * */

public class Car extends TimerTask {
	private static final double START_SPEED = 290400 / 120; // 55 miles per hour/290400 feet per hour
	private static final double STOP_SPEED = 0.0;
	private double currentSpeed;
	private Point2D position; // x,y position
	private Instant lastStop;
	private boolean isMoving;

	/*
	 * A Car is given a start position [X,Y] to be placed on the graph. 
	 * When a car is created, its speed is 0 or it is stopped. 
	 * lastStop is used for calculating distance.
	 * */
	
	public Car(Point2D.Double start) {
		currentSpeed = STOP_SPEED;
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
			currentSpeed = START_SPEED;
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
			double now = Instant.now().toEpochMilli() / 1000L; // milliseconds to seconds
			double start = lastStop.toEpochMilli() / 1000L; // milliseconds to seconds
			double difference = now - start;
			System.out.println(toString() + " moving for: " + difference + " seconds..");
			double distance = difference * currentSpeed;
			double currentDistanceTraveled = position.getX();
			double newDistance = (long) (currentDistanceTraveled + distance);
			position.setLocation(newDistance / 60, 0);
		}
	}

	public synchronized void stop() {
		currentSpeed = STOP_SPEED;
	}

	public synchronized double getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(double currentSpeed) {
		if (currentSpeed >= 0 && currentSpeed <= 120)
			this.currentSpeed = currentSpeed;
		else
			this.currentSpeed = 55;
	}

	@Override
	public void run() {
		go();
	}

}
