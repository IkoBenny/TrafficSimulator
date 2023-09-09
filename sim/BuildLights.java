package sim;

public class BuildLights implements Command {
	private Mediator mvc;
	
	public BuildLights(Mediator mvc) {
		this.mvc = mvc;
	}
	
	@Override
	public void execute() {
		build();
	}

	public void build() {
		for(int i=0; i < mvc.getV().lightsSlider.getValue(); i++) {
			TrafficLight light = mvc.getM().newLight();
			mvc.getM().addLight(light);
		}
		
		for(int i=0; i < mvc.getV().lightsSlider.getValue(); i++) {
			mvc.getM().startLight(i);
		}
	}
	
}
