package sim;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;

import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;

import lombok.Getter;

@Getter
public class Controller implements ActionListener, ChangeListener {
	View view;
	private Model model;
	
	Thread startThread = new Thread(new Runnable() {
		@Override
		public void run() {
			System.out.println("Inside Thread...");
			for (;;) {
				try {
					Thread.sleep(1000);
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							if (model.getMode().equals(Constants.SimulationMode.STOP) == false && 
									model.getMode().equals(Constants.SimulationMode.PAUSE) == false	) {
								view.getField10().setText(model.getTimestamp());		 
								view.frame.repaint();
							}
							System.out.println("Text run1 displayed...");
						}
					});
					
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {	
							  view.getField4().setText(model.getTrafficLightOneStatus());
							  view.getField5().setText(model.getTrafficLightTwoStatus());
							  view.getField6().setText(model.getTrafficLightThreeStatus()); 
							  view.frame.repaint(); 
							  System.out.println("Text run2 displayed...");
						}
					});
					
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {	
							  view.getField1().setText(model.getCarOneSpeed());
							  view.getField2().setText(model.getCarTwoSpeed());
							  view.getField3().setText(model.getCarTwoSpeed()); 
							  view.frame.repaint(); 
							  System.out.println("Text run3 displayed..."); 
						}
					});
					
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							  view.getField7().setText(model.getCarOnePosition());
							  view.getField8().setText(model.getCarTwoPosition());
							  view.getField9().setText(model.getCarThreePosition()); 
							  view.frame.repaint(); 
							  System.out.println("Text run4 displayed...");	 
						}
					});

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});	 

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.getButton(Constants.SimulationMode.START.toString())) {
			System.out.println("A button press is being responded to...");
			model.startMode();
		}

		else if (e.getSource() == view.getButton(Constants.SimulationMode.STOP.toString())) {
			System.out.println("A stop button was pressed...");
			model.stopMode();
		}

		else if (e.getSource() == view.getButton(Constants.SimulationMode.CONTINUE.toString())) {
			System.out.println("A continue button was pressed...");
			model.continueMode();
		}

		else if (e.getSource() == view.getButton(Constants.SimulationMode.PAUSE.toString())) {
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
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// JSlider source = (JSlider) e.getSource();
	}
	
	public void stopSimulation() {
	}
}
