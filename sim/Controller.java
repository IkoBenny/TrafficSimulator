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
		// TODO Auto-generated method stub
		/*
		 * System.out.println("A button press is being responded to...");
		 * if(e.getSource() == gui.getButton("incrementButtonHome"))
		 * incrementHomeScore(); else if(e.getSource() == gui.getButton("stopButton"))
		 * stopTime(); else if(e.getSource() == gui.getButton("possessionButton"))
		 * togglePossessionArrow(); else if(e.getSource() ==
		 * gui.getButton("startButton")) startTime(); else if(e.getSource() ==
		 * gui.getButton("menuButton")) menu(); else if(e.getSource()==
		 * gui.getButton("zeroButton")) ; else if(e.getSource()==
		 * gui.getButton("oneButton")) ; else if(e.getSource()==
		 * gui.getButton("twoButton")) ; else if(e.getSource()==
		 * gui.getButton("threeButton")) ; else if(e.getSource()==
		 * gui.getButton("fourButton")) ; else if(e.getSource()==
		 * gui.getButton("fiveButton")) ; else if(e.getSource()==
		 * gui.getButton("sixButton")) ; else if(e.getSource()==
		 * gui.getButton("sevenButton")) ; else if(e.getSource()==
		 * gui.getButton("eightButton")) ; else if(e.getSource()==
		 * gui.getButton("nineButton")) ; else if(e.getSource()==
		 * gui.getButton("powerButton")) togglePower(); else if(e.getSource()==
		 * gui.getButton("incrementButtonAway")) incrementAwayScore(); else
		 * if(e.getSource()== gui.getButton("decrementButtonHome"))
		 * decrementHomeScore(); else if(e.getSource()==
		 * gui.getButton("decrementButtonAway")) decrementAwayScore();
		 */		
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
			}
		});
	}

}
