package sim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.TimerTask;

import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller extends TimerTask implements ActionListener, ChangeListener {
	View view;
	Model model;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.getButton("start")) {
			System.out.println("A button press is being responded to...");
			model.startMode();
		}
						
		else if (e.getSource() == view.getButton("stop")) {
			System.out.println("A stop button was pressed...");
			model.stopMode();	
		}
			
		else if (e.getSource() == view.getButton("continueButton")) {
			System.out.println("A continue button was pressed...");
			model.continueMode();
		}
			
		else if (e.getSource() == view.getButton("pause")) {
			System.out.println("A pause button was pressed...");
			model.pauseMode();
		}
			
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		/** Listen to the slider. */
		JSlider source = (JSlider) e.getSource();
		// if (!source.getValueIsAdjusting()) {
		System.out.println(source.getValue());
	}
	
	public static void main(String[] args) {

	}
	
	public void setViewAndModel(Model m, View v) {
		model = m;
		view = v;
	}

	public void startClock() {
		SwingUtilities.invokeLater(new Runnable() {
			Time t = new Time();
			public void run() {
				t.timestamp();
			}
			});
	
		
	
		
		/*
		 * Thread thread = new Thread(new Runnable() {
		 * 
		 * @Override public void run() { // TODO Auto-generated method stub
		 * System.out.println("Inside Thread..."); s.schedule(t, 1000L, 1000L);
		 * 
		 * for (;;) { try { Thread.sleep(1000);
		 * System.out.println("Before t.clockLock();..."); t.clockLock();
		 * System.out.println("After t.clockLock();..."); } catch (InterruptedException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * System.out.println("After model.getTimestamp()..."); }
		 * 
		 * }
		 * 
		 * } );
		 * 
		 * thread.start();
		 */
		
			SwingUtilities.invokeLater(new Runnable() {
			public void run() {
					/*
					 * view.getField1().setText(model.getCarOneSpeed());
					 * view.getField2().setText(model.getCarTwoSpeed());
					 * view.getField3().setText(model.getCarThreeSpeed());
					 * view.getField4().setText(model.getTrafficLightOneStatus());
					 * view.getField5().setText(model.getTrafficLightTwoStatus());
					 * view.getField6().setText(model.getTrafficLightThreeStatus());
					 * view.getField7().setText(model.getCarOnePosition());
					 * view.getField8().setText(model.getCarTwoPosition());
					 * view.getField9().setText(model.getCarThreePosition());
					 */
			}
		});
			
			/*
			 * try { SwingUtilities.invokeAndWait(thread); } catch
			 * (InvocationTargetException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
	}
	
	public void startSimulation() throws InterruptedException, InvocationTargetException {

		model.init();
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (;;) {
					try {
						Thread.sleep(1000);
						/*
						 * view.getField1().setText(model.getCarOneSpeed());
						 * view.getField2().setText(model.getCarTwoSpeed());
						 * view.getField3().setText(model.getCarThreeSpeed());
						 * view.getField4().setText(model.getTrafficLightOneStatus());
						 * view.getField5().setText(model.getTrafficLightTwoStatus());
						 * view.getField6().setText(model.getTrafficLightThreeStatus());
						 * view.getField7().setText(model.getCarOnePosition());
						 * view.getField8().setText(model.getCarTwoPosition());
						 * view.getField9().setText(model.getCarThreePosition());
						 */
						view.getField10().setText(model.getTimestamp());
						System.out.println("Inside Thread..." + model.getTimestamp());
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		
		}
		);
		
		thread.run();
		
	}

	@Override
	public void run() {
		System.out.println("Before - SwingUtil in run()...");
		
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
					/*
					 * view.getField1().setText(model.getCarOneSpeed());
					 * view.getField2().setText(model.getCarTwoSpeed());
					 * view.getField3().setText(model.getCarThreeSpeed());
					 * view.getField4().setText(model.getTrafficLightOneStatus());
					 * view.getField5().setText(model.getTrafficLightTwoStatus());
					 * view.getField6().setText(model.getTrafficLightThreeStatus());
					 * view.getField7().setText(model.getCarOnePosition());
					 * view.getField8().setText(model.getCarTwoPosition());
					 * view.getField9().setText(model.getCarThreePosition());
					 */
				view.getField10().setText("yo");
				view.getField10().repaint();
				System.out.println("In run()...");
			}
		});
		System.out.println("After - SwingUtil in run()...");

	}

}
