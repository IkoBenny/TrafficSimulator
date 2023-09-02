package sim;

import java.lang.reflect.InvocationTargetException;

import lombok.Getter;
import sim.Constants.SimulationMode;
import wrappers.CarDTO;

@Getter
public class SimulationAlgorithm implements Command {
	private Mediator mvc;
	
	SimulationAlgorithm(Mediator mvc) {
		this.mvc = mvc;
	}
	
	@Override
	public void execute() {
		try {
			sim();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void sim() throws InterruptedException, InvocationTargetException {
		
			switch (mvc.getM().getMode()) {
			case START:
				System.out.println("START");
				while (mvc.getM().getMode() == SimulationMode.START) {
					mvc.getV().getContinueButton().setEnabled(true);
					mvc.getV().getPause().setEnabled(true);
					mvc.getV().getStop().setEnabled(true);
					
					String s = mvc.getM().getCarPosition(0);
					double d = mvc.getM().getCarSpeed(0);
					CarDTO c = new CarDTO(mvc, d, s, 0);
					c.start();
					mvc.getM().startCar(0);
					mvc.getM().startLight(0);
					mvc.getM().started();
				}	
				break;
			case INIT:
				System.out.println("INIT");
				while (mvc.getM().getMode() == SimulationMode.INIT) {			
					mvc.getM().init();
				}
				break;
			default:
				break;
			}
		}
	}

