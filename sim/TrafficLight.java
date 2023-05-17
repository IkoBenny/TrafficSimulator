package sim;


public class TrafficLight extends Thread {
	Constants.TrafficLightColor tlc;
	boolean on;

	public TrafficLight() {
		tlc = Constants.TrafficLightColor.RED;
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
			tlc = Constants.TrafficLightColor.GREEN;
			break;
		case YELLOW:
			tlc = Constants.TrafficLightColor.RED;
			break;
		case GREEN:
			tlc = Constants.TrafficLightColor.YELLOW;
		}
	}

	synchronized Constants.TrafficLightColor getColor() {
		return tlc;
	}

	synchronized void lightswitch() {
		on = !on;
	}

	public static void main(String[] args) {
		TrafficLight tl = new TrafficLight();
		tl.run();
	}

}
  


