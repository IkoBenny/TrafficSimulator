import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider implements ActionListener, ChangeListener {
	
	public static void main (String [] args) {
        JFrame frame = new JFrame("Slider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
		JSlider slider = new JSlider(1, 3, 1);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		frame.add(slider, BorderLayout.CENTER);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
	    /** Listen to the slider. */
		/*
		 * public void stateChanged(ChangeEvent e) { JSlider source =
		 * (JSlider)e.getSource(); if (!source.getValueIsAdjusting()) { int fps =
		 * (int)source.getValue(); if (fps == 0) { if (!frozen) stopAnimation(); } else
		 * { delay = 1000 / fps; timer.setDelay(delay); timer.setInitialDelay(delay *
		 * 10); if (frozen) startAnimation(); } } }
		 */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("moved");
	}

}
