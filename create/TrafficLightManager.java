package create;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import sim.Constants;
import sim.TrafficLight;

public class TrafficLightManager {
	private ArrayList <TrafficLight> lights = new ArrayList<>();
	
	public void addLight(TrafficLight light) {
		lights.add(light);
	}
	
	public TrafficLight newLight() {
		if (lights.size() == 0) {
			return new TrafficLight(new Point2D.Double(Constants.THOUSAND_METERS_IN_FEET, 0));
		}
		else {
			Double position = lights.size() * Constants.THOUSAND_METERS_IN_FEET;
			return new TrafficLight(new Point2D.Double(position, 0));
		}		
	}

	public TrafficLight getClosestLight(double position) {
		if (position < Constants.THOUSAND_METERS_IN_FEET ) {
			return lights.get(0);
		}
		else {
			for (int i =1; i < lights.size(); i ++) {
				if(lights.get(i).getPosition().getX()< position) {
					return lights.get(i);
				}
			}		
		}
		return null;
	}

	public ArrayList<TrafficLight> getLights() {
		return lights;
	}

}
