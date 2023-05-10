package sim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements ActionListener, ChangeListener {
	View view;
	Model model;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("A button press is being responded to...");
		if (e.getSource() == view.getButton("start"))
			model.init();	
		else if (e.getSource() == view.getButton("stop"))
			System.out.println("A stop button was pressed...");
		else if (e.getSource() == view.getButton("continueButton"))
			System.out.println("A continue button was pressed...");
		else if (e.getSource() == view.getButton("pause"))
			System.out.println("A pause button was pressed...");
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

	public void update() {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				view.getField4().setText(model.getTrafficLightOneStatus());
				view.getField5().setText(model.getTrafficLightTwoStatus());
				view.getField6().setText(model.getTrafficLightThreeStatus());
			}
		});

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				view.getField1().setText(model.getCarOneSpeed());
				view.getField2().setText(model.getCarTwoSpeed());
				view.getField3().setText(model.getCarThreeSpeed());
			}
		});

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				view.getField7().setText(model.getCarOnePosition());
				view.getField8().setText(model.getCarTwoPosition());
				view.getField9().setText(model.getCarThreePosition());
				view.getField10().setText(model.getTimestamp());
			}
		});
	}
	

}
