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
		for(int i=0; i < mvc.getView().lightsSlider.getValue(); i++) {
			TrafficLight light = mvc.getModel().newLight();
			mvc.getModel().addLight(light);
		}
		
		for(int i=0; i < mvc.getView().lightsSlider.getValue(); i++) {
			mvc.getModel().startLight(i);
		}
	}
	
}
