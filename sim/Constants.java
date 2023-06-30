package sim;
public class Constants {
	public static final double STOP_SPEED = 0.0;
	public static final double FEET_IN_A_MILE = 5280.0;
	public static final double AVERAGE_SPEED_IN_MILES = 55.0;
	public static final double MINUTES_IN_HOUR = 60.0;
	public static final double SECONDS_IN_MINUTE = 60.0;
	public static final double START_SPEED = (FEET_IN_A_MILE * AVERAGE_SPEED_IN_MILES) / (MINUTES_IN_HOUR * SECONDS_IN_MINUTE) ; // 55 miles per hour = 290400 feet per hour = 4840 feet per minute = ~80 feet per second
	public static final double THOUSAND_METERS_IN_FEET = 3280.84; // Distance between lights
	public static final String RED = "Red";
	public static final String YELLOW = "Yellow";
	public static final String GREEN = "Green";

	public enum TrafficLightColor {
		RED, YELLOW, GREEN;
		
		public static String toString(TrafficLightColor tlc) {
			switch (tlc) {
			case RED:
				return "Red";
			case YELLOW:
				return "Yellow";
			case GREEN:
				return "Green";
			}
			return null;
		}
	
	}
	
	public enum SimulationMode {
		PAUSE("pause"), START("start"), STOP("stop"), CONTINUE("continue");
		
		private String value;
		
		private SimulationMode(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
		
	}

}
