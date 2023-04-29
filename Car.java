import java.awt.Point;
import java.util.*;

public class Car implements Runnable {
	private static final int START_SPEED = 55;
	private static final int STOP_SPEED = 0;
	private int currentSpeed;
	private Point position; // x,y position

	public Car(int speed, Point position) {
		this.position = position;
		currentSpeed = START_SPEED;
	}

	public synchronized void go() {
		currentSpeed = START_SPEED;
	}
	
	public synchronized void stop() {
		currentSpeed = STOP_SPEED;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	@Override
	public void run() {
		go();
	}

}
