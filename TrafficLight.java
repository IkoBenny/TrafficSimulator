import java.util.TimerTask;

public class TrafficLight extends TimerTask {
	TrafficLightColor tlc;
	boolean on;

	public TrafficLight() {
		tlc = TrafficLightColor.RED;
	}
	
	public void run() {
		on = true;
		while (on) {
			try {
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
		}
	}

	synchronized void changeColor() {
		switch (tlc) {
		case RED:
			tlc = TrafficLightColor.GREEN;
			notifyAll();
			break;
		case YELLOW:
			tlc = TrafficLightColor.RED;
			break;
		case GREEN:
			tlc = TrafficLightColor.YELLOW;
		}
		notify();
	}

	synchronized TrafficLightColor getColor() {
		return tlc;
	}

	synchronized void lightswitch() {
		on = !on;
	}

}
  


