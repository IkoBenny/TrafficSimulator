package sim;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;

import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;

/*import javax.swing.JSlider;
import javax.swing.SwingUtilities;*/

public class Controller implements ActionListener, ChangeListener {
	View view;
	Model model;
	
	Thread startSimulationThread = new Thread(new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (;;) {
				try {
					Thread.sleep(1000);
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {	
							view.getField10().setText(model.getTimestamp());
							System.out.println("Inside Thread..." + model.getTimestamp());
						}
					});
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	});

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.getButton(Constants.SimulationMode.START.getValue())) {
			System.out.println("A button press is being responded to...");
			model.startMode();
		}

		else if (e.getSource() == view.getButton(Constants.SimulationMode.STOP.getValue())) {
			System.out.println("A stop button was pressed...");
			model.stopMode();
		}

		else if (e.getSource() == view.getButton(Constants.SimulationMode.CONTINUE.getValue())) {
			System.out.println("A continue button was pressed...");
			model.continueMode();
		}

		else if (e.getSource() == view.getButton(Constants.SimulationMode.PAUSE.getValue())) {
			System.out.println("A pause button was pressed...");
			model.pauseMode();
		}
	}

	public void continueSimulation() {
	}
	
	public void pauseSimulation() {
	}
	
	public void setViewAndModel(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void startSimulation() {
		model.init();
		startSimulationThread.run();
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// JSlider source = (JSlider) e.getSource();
	}
	
	public void stopSimulation() {
	}
}
