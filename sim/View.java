package sim;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class View implements Runnable {
	JFrame frame;
	
	JPanel containerPanel;
	JPanel car1Panel;
	JPanel car2Panel;
	JPanel car3Panel;
	JPanel buttonPanel;
	JPanel sliderPanel;
	JPanel sliderLabelPanel;
	JPanel timePanel;
	
	JSlider carsSlider;
	JSlider car1SpeedSlider;
	JSlider car2SpeedSlider;
	JSlider car3SpeedSlider;
	JSlider lightsSlider;
	
	JTextField field1;
	JTextField field2;
	JTextField field3;
	JTextField field4;
	JTextField field5;
	JTextField field6;
	JTextField field7;
	JTextField field8;
	JTextField field9;
	JTextField field10;
	
	JLabel car1;
	JLabel car2;
	JLabel car3;
	JLabel light1;
	JLabel light2;
	JLabel light3;
	JLabel speed;
	JLabel speed2;
	JLabel speed3;
	JLabel status;
	JLabel status2;
	JLabel status3;
	JLabel noCars;
	JLabel noLights;
	JLabel car1Speed;
	JLabel car2Speed;
	JLabel car3Speed;
	JLabel car1Location;
	JLabel car2Location;
	JLabel car3Location;
	
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
	
	public void addChangeListeners(ChangeListener listener) {
		carsSlider.addChangeListener(listener);
		car1SpeedSlider.addChangeListener(listener);
		car2SpeedSlider.addChangeListener(listener);
		car3SpeedSlider.addChangeListener(listener);
		lightsSlider.addChangeListener(listener);;
	  }

	public JButton getButton(String name) {
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

	}

	public void createAndShowGUI() {
		// Instantiate Sliders
		carsSlider = new JSlider(1, 5, 3);
		car1SpeedSlider = new JSlider(0, 120, 55);
		car2SpeedSlider = new JSlider(0, 120, 55);
		car3SpeedSlider = new JSlider(0, 120, 55);
		lightsSlider = new JSlider(1, 5, 3);
		carsSlider.setMajorTickSpacing(1);
		carsSlider.setPaintTicks(true);
		car1SpeedSlider.setMajorTickSpacing(5);
		car1SpeedSlider.setPaintTicks(true);
		car2SpeedSlider.setMajorTickSpacing(5);
		car2SpeedSlider.setPaintTicks(true);
		car3SpeedSlider.setMajorTickSpacing(5);
		car3SpeedSlider.setPaintTicks(true);
		lightsSlider.setMajorTickSpacing(1);
		lightsSlider.setPaintTicks(true);
		// Integer value = (Integer) carsSlider.getValue();
		// field1.setText(value.toString());

		// Instantiate TextFields
		field1 = new JTextField(20);
		field2 = new JTextField(20);
		field3 = new JTextField(20);
		field4 = new JTextField(20);
		field5 = new JTextField(20);
		field6 = new JTextField(20);
		field7 = new JTextField(20);
		field8 = new JTextField(20);
		field9 = new JTextField(20);
		field10 = new JTextField(20);

		// Instantiate Labels
		car1 = new JLabel("Car #1:	 ");
		car2 = new JLabel("Car #2:	");
		car3 = new JLabel("Car #3:	");
		light1 = new JLabel("Light #1:	 ");
		light2 = new JLabel("Light #2:	");
		light3 = new JLabel("Light #3:	");
		speed = new JLabel("Speed: 	");
		speed2 = new JLabel("Speed: 	");
		speed3 = new JLabel("Speed: 	");
		status = new JLabel("Status: 	");
		status2 = new JLabel("Status: 	");
		status3 = new JLabel("Status: 	");
		noCars = new JLabel("No. of Cars: 	");
		noLights = new JLabel("No. of Lights: 	");
		car1Speed = new JLabel("Car #1 Speed: 	");
		car2Speed = new JLabel("Car #2 Speed: 	");
		car3Speed = new JLabel("Car #3 Speed: 	");
		car1Location = new JLabel("Location: 	");
		car2Location = new JLabel("Location: 	");
		car3Location = new JLabel("Location: 	");

		// Instantiate Buttons
		start = new JButton("START");
		stop = new JButton("STOP");
		pause = new JButton("PAUSE");
		continueButton = new JButton("CONTINUE");

		// Instantiate Panels
		containerPanel = new JPanel();
		sliderPanel = new JPanel();
		car1Panel = new JPanel();
		car2Panel = new JPanel();
		car3Panel = new JPanel();
		buttonPanel = new JPanel();
		sliderLabelPanel = new JPanel();
		timePanel = new JPanel();

		// Add Components to Panels
		sliderLabelPanel.add(noCars);
		sliderLabelPanel.add(car1Speed);
		sliderLabelPanel.add(car2Speed);
		sliderLabelPanel.add(car3Speed);
		sliderLabelPanel.add(noLights);
		sliderLabelPanel.setLayout(new GridLayout(0, 5));
		sliderPanel.add(carsSlider);
		sliderPanel.add(car1SpeedSlider);
		sliderPanel.add(car2SpeedSlider);
		sliderPanel.add(car3SpeedSlider);
		sliderPanel.add(lightsSlider);
		sliderPanel.setLayout(new GridLayout(0, 5));
		timePanel.add(field10);
		car1Panel.add(car1);
		car2Panel.add(car2);
		car3Panel.add(car3);
		car1Panel.add(speed);
		car1Panel.add(field1);
		car1Panel.add(car1Location);
		car1Panel.add(field7);
		car1Panel.add(light1);
		car1Panel.add(status);
		car1Panel.add(field4);
		car2Panel.add(speed2);
		car2Panel.add(field2);
		car2Panel.add(car2Location);
		car2Panel.add(field8);
		car2Panel.add(light2);
		car2Panel.add(status2);
		car2Panel.add(field5);
		car3Panel.add(speed3);
		car3Panel.add(field3);
		car3Panel.add(car3Location);
		car3Panel.add(field9);
		car3Panel.add(light3);
		car3Panel.add(status3);
		car3Panel.add(field6);
		containerPanel.add(sliderLabelPanel);
		containerPanel.add(sliderPanel);
		containerPanel.add(car1Panel);
		containerPanel.add(car2Panel);
		containerPanel.add(car3Panel);
		containerPanel.add(buttonPanel);
		containerPanel.add(timePanel);
		buttonPanel.add(start);
		buttonPanel.add(pause);
		buttonPanel.add(continueButton);
		buttonPanel.add(stop);
		containerPanel.setLayout(new GridLayout(7, 0));

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

}
