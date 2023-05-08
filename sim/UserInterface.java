package sim;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UserInterface extends TimerTask implements ActionListener, ChangeListener {	
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
	
	public UserInterface() {	
		//Instantiate Sliders
		carsSlider = new JSlider(1, 5, 3);
		car1SpeedSlider = new JSlider(0, 120, 55);
		car2SpeedSlider = new JSlider(0, 120, 55);
		car3SpeedSlider = new JSlider(0, 120, 55);
		lightsSlider = new JSlider(1, 5, 3);
		carsSlider.setMajorTickSpacing(1);
		carsSlider.setPaintTicks(true);
		carsSlider.addChangeListener(this);
		car1SpeedSlider.setMajorTickSpacing(5);
		car1SpeedSlider.setPaintTicks(true);
		car1SpeedSlider.addChangeListener(this);
		car2SpeedSlider.setMajorTickSpacing(5);
		car2SpeedSlider.setPaintTicks(true);
		car2SpeedSlider.addChangeListener(this);
		car3SpeedSlider.setMajorTickSpacing(5);
		car3SpeedSlider.setPaintTicks(true);
		car3SpeedSlider.addChangeListener(this);
		lightsSlider.setMajorTickSpacing(1);
		lightsSlider.setPaintTicks(true);
		lightsSlider.addChangeListener(this);
		//Integer value = (Integer) carsSlider.getValue();
		//field1.setText(value.toString());
		
		//Instantiate TextFields
		field1 = new JTextField();
		field2 = new JTextField();
		field3 = new JTextField();
		field4 = new JTextField();
		field5 = new JTextField();
		field6 = new JTextField();
		field7 = new JTextField();
		field8 = new JTextField();
		field9 = new JTextField();
		field10 = new JTextField();
		
		//Instantiate Labels
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
		
		//Instantiate Buttons
		start = new JButton("START");
		stop = new JButton("STOP");
		pause = new JButton("PAUSE");
		continueButton = new JButton("CONTINUE");
		
		//Instantiate Panels
		containerPanel = new JPanel();
		sliderPanel = new JPanel();
		car1Panel = new JPanel();
		car2Panel = new JPanel();
		car3Panel = new JPanel();
		buttonPanel = new JPanel();
		sliderLabelPanel = new JPanel();
		timePanel = new JPanel();
		
		//Add Components to Panels
		sliderLabelPanel.add(noCars);
		sliderLabelPanel.add(car1Speed);
		sliderLabelPanel.add(car2Speed);
		sliderLabelPanel.add(car3Speed);
		sliderLabelPanel.add(noLights);
		sliderLabelPanel.setLayout(new GridLayout(0,5));
		sliderPanel.add(carsSlider);
		sliderPanel.add(car1SpeedSlider);
		sliderPanel.add(car2SpeedSlider);
		sliderPanel.add(car3SpeedSlider);
		sliderPanel.add(lightsSlider);
		sliderPanel.setLayout(new GridLayout(0,5));
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
		containerPanel.setLayout(new GridLayout(7,0));
		
		//Instantiate Frame
		frame = new JFrame("Traffic Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(500, 475);
		frame.setVisible(true);
		frame.add(containerPanel);
		frame.setLayout(new GridLayout(2,0));
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * UIManager.put("swing.boldMetal", Boolean.FALSE);
	 * 
	 * javax.swing.SwingUtilities.invokeLater(new Runnable() { public void run() {
	 * createAndShowGUI();
	 * 
	 * } }); }
	 */

	@Override
	public void stateChanged(ChangeEvent e) {
		/** Listen to the slider. */
		JSlider source = (JSlider) e.getSource();
		// if (!source.getValueIsAdjusting()) {
		System.out.println(source.getValue());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("moved");
	}

	public static void createAndShowGUI() {
		UserInterface ui = new UserInterface();
		System.out.println("UI Created: " + ui.toString());
	}
	
	public void run() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			}
		});
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setContainerPanel(JPanel containerPanel) {
		this.containerPanel = containerPanel;
	}

	public void setCar1Panel(JPanel car1Panel) {
		this.car1Panel = car1Panel;
	}

	public void setCar2Panel(JPanel car2Panel) {
		this.car2Panel = car2Panel;
	}

	public void setCar3Panel(JPanel car3Panel) {
		this.car3Panel = car3Panel;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public void setSliderPanel(JPanel sliderPanel) {
		this.sliderPanel = sliderPanel;
	}

	public void setSliderLabelPanel(JPanel sliderLabelPanel) {
		this.sliderLabelPanel = sliderLabelPanel;
	}

	public void setTimePanel(JPanel timePanel) {
		this.timePanel = timePanel;
	}

	public void setCarsSlider(JSlider carsSlider) {
		this.carsSlider = carsSlider;
	}

	public void setCar1SpeedSlider(JSlider car1SpeedSlider) {
		this.car1SpeedSlider = car1SpeedSlider;
	}

	public void setCar2SpeedSlider(JSlider car2SpeedSlider) {
		this.car2SpeedSlider = car2SpeedSlider;
	}

	public void setCar3SpeedSlider(JSlider car3SpeedSlider) {
		this.car3SpeedSlider = car3SpeedSlider;
	}

	public void setLightsSlider(JSlider lightsSlider) {
		this.lightsSlider = lightsSlider;
	}

	public void setField1(JTextField field1) {
		this.field1 = field1;
	}

	public void setField2(JTextField field2) {
		this.field2 = field2;
	}

	public void setField3(JTextField field3) {
		this.field3 = field3;
	}

	public void setField4(JTextField field4) {
		this.field4 = field4;
	}

	public void setField5(JTextField field5) {
		this.field5 = field5;
	}

	public void setField6(JTextField field6) {
		this.field6 = field6;
	}

	public void setField7(JTextField field7) {
		this.field7 = field7;
	}

	public void setField8(JTextField field8) {
		this.field8 = field8;
	}

	public void setField9(JTextField field9) {
		this.field9 = field9;
	}

	public void setField10(JTextField field10) {
		this.field10 = field10;
	}

	public void setCar1(JLabel car1) {
		this.car1 = car1;
	}

	public void setCar2(JLabel car2) {
		this.car2 = car2;
	}

	public void setCar3(JLabel car3) {
		this.car3 = car3;
	}

	public void setLight1(JLabel light1) {
		this.light1 = light1;
	}

	public void setLight2(JLabel light2) {
		this.light2 = light2;
	}

	public void setLight3(JLabel light3) {
		this.light3 = light3;
	}

	public void setSpeed(JLabel speed) {
		this.speed = speed;
	}

	public void setSpeed2(JLabel speed2) {
		this.speed2 = speed2;
	}

	public void setSpeed3(JLabel speed3) {
		this.speed3 = speed3;
	}

	public void setStatus(JLabel status) {
		this.status = status;
	}

	public void setStatus2(JLabel status2) {
		this.status2 = status2;
	}

	public void setStatus3(JLabel status3) {
		this.status3 = status3;
	}

	public void setNoCars(JLabel noCars) {
		this.noCars = noCars;
	}

	public void setNoLights(JLabel noLights) {
		this.noLights = noLights;
	}

	public void setCar1Speed(JLabel car1Speed) {
		this.car1Speed = car1Speed;
	}

	public void setCar2Speed(JLabel car2Speed) {
		this.car2Speed = car2Speed;
	}

	public void setCar3Speed(JLabel car3Speed) {
		this.car3Speed = car3Speed;
	}

	public void setCar1Location(JLabel car1Location) {
		this.car1Location = car1Location;
	}

	public void setCar2Location(JLabel car2Location) {
		this.car2Location = car2Location;
	}

	public void setCar3Location(JLabel car3Location) {
		this.car3Location = car3Location;
	}

	public void setStart(JButton start) {
		this.start = start;
	}

	public void setStop(JButton stop) {
		this.stop = stop;
	}

	public void setPause(JButton pause) {
		this.pause = pause;
	}

	public void setContinueButton(JButton continueButton) {
		this.continueButton = continueButton;
	}
	
}
