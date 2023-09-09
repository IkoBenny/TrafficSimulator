package sim;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import lombok.Data;
import lombok.Getter;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class View implements Runnable, ChangeListener, EventListener {
	JFrame frame;
	JPanel containerPanel;
	ArrayList<CarView> carViews;
	JPanel buttonPanel;
	JSlider lightsSlider;
	JSlider carsSlider;
	
	JButton start;
	JButton stop;
	JButton pause;
	JButton continueButton;

	public View() {
		System.out.println("View created...");
	}
	
	public void addActionListeners(ActionListener listener) {	
		start.addActionListener(listener);
		stop.addActionListener(listener);
		pause.addActionListener(listener);
		continueButton.addActionListener(listener);
	  }

	public JButton fetchButton(String name) {
		switch(name) {
		case Constants.START:
			return start;
		case Constants.STOP:
			return stop;
		case Constants.PAUSE:
			return pause;
		case Constants.CONTINUE:
			return continueButton;
		}
		return null;
	}
		 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		View view = new View();
		Thread thread = new Thread(view);
		thread.start();;
	}

	public void createAndShowGUI() {
		// Instantiate Buttons
		start = new JButton("START");
		stop = new JButton("STOP");
		pause = new JButton("PAUSE");
		continueButton = new JButton("CONTINUE");
		continueButton.setEnabled(false);
		pause.setEnabled(false);
		stop.setEnabled(false);

		// Instantiate Panels
		containerPanel = new JPanel();
		buttonPanel = new JPanel();
		CarView cv = new CarView(0); 
		containerPanel.add(buttonPanel);
		
		//Instantiate Sliders	
		carsSlider = new JSlider(1, 5, 3);
		lightsSlider = new JSlider(1, 5, 3);		
		
		carsSlider.setMajorTickSpacing(1);
		lightsSlider.setMajorTickSpacing(1);
		
		carsSlider.setPaintTicks(true);			
		lightsSlider.setPaintTicks(true);
		
		buttonPanel.add(start);
		buttonPanel.add(pause);
		buttonPanel.add(continueButton);
		buttonPanel.add(stop);
		buttonPanel.add(carsSlider);
		buttonPanel.add(lightsSlider);
		buttonPanel.add(cv.getCarPanel());
		containerPanel.setLayout(new GridLayout());

		// Instantiate Frame
		frame = new JFrame("Traffic Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(1600, 475);
		frame.setVisible(true);
		frame.add(containerPanel);
		frame.setLayout(new GridLayout(2, 0));
	}

	@Override
	public void run() {
		SwingUtilities.invokeLater(()-> createAndShowGUI());	
	}

	@Override
	public void stateChanged(ChangeEvent e) {
	}

	public CarView getCv(int id) {
		CarView cv = carViews.get(id);
		return cv;
	}

}
