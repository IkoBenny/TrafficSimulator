package sim;

import java.awt.event.ActionEvent;

import javax.swing.event.ChangeEvent;

import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;

import lombok.Getter;

@Getter
public class Controller implements ActionListener, ChangeListener {
	private Mediator mvc;
	
	public Controller(Mediator mvc) {
		this.mvc = mvc;
	}
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mvc.getV().fetchButton(Constants.SimulationMode.START.toString())) {
			System.out.println("A button press is being responded to...");
			mvc.getM().startMode();
		}

		else if (e.getSource() == mvc.getV().fetchButton(Constants.SimulationMode.STOP.toString())) {
			System.out.println("A stop button was pressed...");
			mvc.getM().stopMode();
		}

		else if (e.getSource() == mvc.getV().fetchButton(Constants.SimulationMode.CONTINUE.toString())) {
			System.out.println("A continue button was pressed...");
			mvc.getM().continueMode();
		}

		else if (e.getSource() == mvc.getV().fetchButton(Constants.SimulationMode.PAUSE.toString())) {
			System.out.println("A pause button was pressed...");
			mvc.getM().pauseMode();
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		/*
		 * int cars = mvc.getV().getCarsSlider().getValue(); int lights =
		 * mvc.getV().getLightsSlider().getValue();
		 * 
		 * String carsText = Integer.toString(cars); String lightsText =
		 * Integer.toString(lights);
		 */
		
		//this.speed.setText(speedText);
		//this.position.setText(positionText);
	}
	
	
	public void startPressed() {
		mvc.getV().getStart().setEnabled(false);
		mvc.getV().getContinueButton().setEnabled(true);
		mvc.getV().getPause().setEnabled(true);
		mvc.getV().getStop().setEnabled(true);
	}

}
