package sim;

import javax.swing.SwingUtilities;

import builder.CarBuilder;
import builder.CarBuilderDirector;

public class Setup implements Command {
	private Mediator mvc;
	
	Setup(Mediator mvc) {
		this.mvc = mvc;
	}
	
	@Override
	public void execute() {
		setup();
	}

	private void setup() {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					mvc.getV().createAndShowGUI();
					mvc.getV().addActionListeners(mvc.getC());
					mvc.getV().addChangeListeners(mvc.getC());
					mvc.getC().setViewAndModel(mvc.getM(), mvc.getV());
				}
			});
	}
}
