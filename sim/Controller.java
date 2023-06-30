package sim;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;

import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;

import lombok.Getter;
import sim.Constants.TrafficLightColor;

/*import javax.swing.JSlider;
import javax.swing.SwingUtilities;*/

@Getter
public class Controller implements ActionListener, ChangeListener {
	private View view;
	private Model model;
	
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
	
	Thread startThread = new Thread(new Runnable() {
		@Override
		public void run() { // TODO Auto-generated method stub
			System.out.println("Inside Thread...");
			//mlightThree.lightswitch();
			 //m.carThree.go(); 
			for (;;) {
				try {
					Thread.sleep(1000);
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							String time = model.getTimestamp();
							view.getField10().setText(time);		 
							view.frame.repaint();
							System.out.println("Text run1 displayed...");
						}
					});
					
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {	
							  TrafficLightColor col = model.getLightOne().getColor(); 
							  TrafficLightColor col2 = model.getLightTwo().getColor();
							  TrafficLightColor col3 = model.getLightThree().getColor();
							  String status = TrafficLightColor.toString(col); 
							  String status2 = TrafficLightColor.toString(col2); 
							  String status3 = TrafficLightColor.toString(col3); 
							  view.getField4().setText(status);
							  view.getField5().setText(status2);
							  view.getField6().setText(status3); 
							  view.frame.repaint(); 
							  System.out.println("Text run2 displayed...");
							 
						}
					});
					
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {	
							  double pos = model.getCarOne().getCurrentSpeed();
							  double pos2 = model.getCarTwo().getCurrentSpeed();
							  double pos3 = model.getCarThree().getCurrentSpeed();
							  String status = Double.toString(pos);
							  String status2 = Double.toString(pos2);
							  String status3 = Double.toString(pos3);
							  view.getField1().setText(status);
							  view.getField2().setText(status2);
							  view.getField3().setText(status3); 
							  view.frame.repaint(); 
							  System.out.println("Text run3 displayed...");
							 
						}
					});
					
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {	
							  String pos = model.getCarOnePosition();
							  String pos2 = model.getCarTwoPosition();
							  String pos3 = model.getCarThreePosition();
							  view.getField7().setText(pos);
							  view.getField8().setText(pos2);
							  view.getField9().setText(pos3); 
							  view.frame.repaint(); 
							  System.out.println("Text run4 displayed...");	 
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
