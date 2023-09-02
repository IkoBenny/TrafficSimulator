package sim;

import java.lang.reflect.InvocationTargetException;

import sim.Constants.SimulationMode;

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
		for (;;) {
			Thread.sleep(1000);
			System.out.println("MAIN - Done Sleeping");
			switch (mvc.getM().getMode()) {
			case START:
				System.out.println("START");
				while (mvc.getM().getMode() == SimulationMode.START) {
					mvc.getV().getContinueButton().setEnabled(true);
					mvc.getV().getPause().setEnabled(true);
					mvc.getV().getStop().setEnabled(true);			
					mvc.getC().startThreads();
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
}
