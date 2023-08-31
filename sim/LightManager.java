package sim;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LightManager {
	private TrafficLight lightOne;
	private TrafficLight lightTwo;
	private TrafficLight lightThree;
	private ArrayList<TrafficLight> lights = new ArrayList<>();
	private static Logger log = LoggerFactory.getLogger(LightManager.class);
	
	public LightManager() {
		log.info("Inside LightManager()...");
		initLights();
		switchLights();
		log.info("Leaving LightManager()...");
	}
	
	public TrafficLight newLight() {
		log.info("Inside newLight()...");
		if (lights.size() == 0) {
			log.info("Leaving newLight()...");
			return new TrafficLight(new Point2D.Double(Constants.THOUSAND_METERS_IN_FEET, 0));
		}
		else {
			Double position = (lights.size() + 1) * Constants.THOUSAND_METERS_IN_FEET;
			log.info("Leaving newLight()...");
			return new TrafficLight(new Point2D.Double(position, 0));
		}		
	}
	
	public void initLights() {
		log.info("Inside initLights()...");
		this.lightOne = newLight();
		addLight(lightOne);
		this.lightTwo = newLight();
		addLight(lightTwo);
		this.lightThree = newLight();
		addLight(lightThree);
		log.info("Leaving initLights()...");
	}
	
	public void switchLights() {
		log.info("Inside switchLights()...");
		lightOne.lightswitch();
		lightTwo.lightswitch();
		lightThree.lightswitch();
		log.info("Leaving switchLights()...");
	}
	
	public void addLight(TrafficLight l) {
		log.info("Inside addLight(TrafficLight)...");
		lights.add(l);
		log.info("Leaving addLight(TrafficLight)...");
	}
	
	public String getTrafficLightStatus(int light) {
		log.info("Inside getTrafficLightStatus(int)...");
		log.info("Leaving getTrafficLightStatus(int)...");
		return lights.get(light).getColor().toString();
	}

	public ArrayList<TrafficLight> getLights() {
		log.info("Inside getLights()...");
		log.info("Leaving getLights()...");
		return lights;
	}

}
