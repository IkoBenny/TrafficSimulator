package sim;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class LightManager {
	private TrafficLight lightOne;
	private TrafficLight lightTwo;
	private TrafficLight lightThree;
	private ArrayList<TrafficLight> lights = new ArrayList<>();
	
	public TrafficLight newLight() {
		if (lights.size() == 0) {
			return new TrafficLight(new Point2D.Double(Constants.THOUSAND_METERS_IN_FEET, 0));
		}
		else {
			Double position = (lights.size() + 1) * Constants.THOUSAND_METERS_IN_FEET;
			return new TrafficLight(new Point2D.Double(position, 0));
		}		
	}
	
	public void initLights() {
		this.lightOne = newLight();
		addLight(lightOne);
		this.lightTwo = newLight();
		addLight(lightTwo);
		this.lightThree = newLight();
		addLight(lightThree);
	}
	
	public void addLight(TrafficLight l) {
		lights.add(l);
	}
	
	public String getTrafficLightStatus(int light) {
		return lights.get(light).getColor().toString();
	}

}
