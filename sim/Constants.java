package sim;

import java.awt.geom.Point2D;

public class Constants {
	public static final double STOP_SPEED = 0.0;
	public static final double FEET_IN_A_MILE = 5280.0;
	public static final double AVERAGE_SPEED_IN_MILES = 55.0;
	public static final double MINUTES_IN_HOUR = 60.0;
	public static final double SECONDS_IN_MINUTE = 60.0;
	public static final double START_SPEED = (FEET_IN_A_MILE * AVERAGE_SPEED_IN_MILES) / (MINUTES_IN_HOUR * SECONDS_IN_MINUTE) ; // 55 miles per hour = 290400 feet per hour = 4840 feet per minute = ~80 feet per second
	public static final double THOUSAND_METERS_IN_FEET = 3280.84; // Distance between lights
	public static final String RED = "RED";
	public static final String YELLOW = "YELLOW";
	public static final String GREEN = "GREEN";
	public static final String START = "START";
	public static final String PAUSE = "PAUSE";
	public static final String STOP = "STOP";
	public static final String INIT = "INIT";
	public static final String CONTINUE = "CONTINUE";
	public static final String CARS = "CARS";
	public static final String LIGHTS = "LIGHTS";
	public static final Point2D START_POSITION = new Point2D.Double(0.0, 0.0);

	public enum TrafficLightColor {
		RED, YELLOW, GREEN;	
	}
	
	public enum SimulationMode {
		PAUSE, START, STOP, INIT, CONTINUE;		
	}
}
