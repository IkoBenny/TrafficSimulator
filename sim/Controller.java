package sim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
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
			System.out.println("A start button was pressed...");	
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
		// TODO Auto-generated method stub

	}

	/*
	 * // turn this scoreboard on/off public void togglePower() {
	 * System.out.println("hitting power button..."); m.togglePower(); }
	 */
	
	public void setViewAndModel(Model m, View v) {
		model = m;
		view = v;
	}

	public void update() {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				/*
				 * gui.getHomeName().setText(m.getHomeName());
				 * gui.getAwayName().setText(m.getAwayName());
				 * gui.getQuarter().setText(m.getQuarter());
				 * gui.getArrow().setText(m.getPossessionArrow());
				 * gui.getHomeBonus().setSelected(m.getHomeBonus());
				 * gui.getAwayBonus().setSelected(m.getAwayBonus());
				 * gui.getHomeScore().setText(m.getHomeScore());
				 * gui.getAwayScore().setText(m.getAwayScore());
				 */
				view.getfield1().setText("car1speed");
				view.getfield2.setText("car2speed");
				view.getfield3.setText("car3speed");
				view.getfield4.setText("light1status");
				view.getfield5.setText("light2status");
				view.getfield6.setText("light3status");
				view.getfield7.setText("car1location");
				view.getfield8.setText("car1location");
				view.getfield9.setText("car3location");
				view.getfield10.setText("time");
			}
		});
	}

}
