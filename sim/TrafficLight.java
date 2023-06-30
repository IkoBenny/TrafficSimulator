package sim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrafficLight extends Thread {
	Constants.TrafficLightColor tlc;
	boolean on;
	
	private static Logger log = LoggerFactory.getLogger(TrafficLight.class);

	public TrafficLight() {
		log.trace("Inside TrafficLight()...");
		tlc = Constants.TrafficLightColor.RED;
		log.trace("Leaving TrafficLight()...");
	}

	@Override
	public void run() {
		log.trace("Inside TrafficLight.run()...");
		on = true;
		while (on) {
			try {
				log.trace("Inside TrafficLight.run() while loop...");
				switch (tlc) {
				case GREEN:
					System.out.println("GREEN");
					Thread.sleep(10000); // green for 10 seconds
					break;
				case YELLOW:
					System.out.println("YELLOW");
					Thread.sleep(2000); // yellow for 2 seconds
					break;
				case RED:
					System.out.println("RED");
					Thread.sleep(12000); // red for 12 seconds
					break;
				}
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			changeColor();
			log.trace("Leaving TrafficLight.run() while loop...");
		}
	}

	synchronized void changeColor() {
		log.trace("Inside TrafficLight.changeColor()...");
		switch (tlc) {
		case RED:
			tlc = Constants.TrafficLightColor.GREEN;
			break;
		case YELLOW:
			tlc = Constants.TrafficLightColor.RED;
			break;
		case GREEN:
			tlc = Constants.TrafficLightColor.YELLOW;
		}
		log.trace("Leaving TrafficLight.changeColor()...");
	}

	synchronized Constants.TrafficLightColor getColor() {
		log.trace("Inside TrafficLight.getColor()...");
		log.trace("Leaving TrafficLight.getColor()...");
		return tlc;
	}

	synchronized void lightswitch() {
		log.trace("Inside TrafficLight.lightswitch()...");
		log.trace("Leaving TrafficLight.lightswitch()...");
		on = !on;
	}

	/*
	 * public static void main(String[] args) { TrafficLight tl = new
	 * TrafficLight(); tl.run(); }
	 */

}
  


