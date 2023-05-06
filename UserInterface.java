import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import components.G;

public class UserInterface extends TimerTask implements ActionListener, ChangeListener {
	JFrame frame;
	JPanel panel;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JPanel panel6;
	JPanel panel7;
	JPanel panel8;
	JSlider slider;
	JSlider slider2;
	JSlider slider3;
	JSlider slider4;
	JSlider slider5;
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
	

	public UserInterface() {		
		slider = new JSlider(1, 5, 3);
		slider2 = new JSlider(0, 120, 55);
		slider3 = new JSlider(0, 120, 55);
		slider4 = new JSlider(0, 120, 15);
		slider5 = new JSlider(1, 5, 3);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.addChangeListener(this);
		slider2.setMajorTickSpacing(5);
		slider2.setPaintTicks(true);
		slider2.addChangeListener(this);
		slider3.setMajorTickSpacing(5);
		slider3.setPaintTicks(true);
		slider3.addChangeListener(this);
		slider4.setMajorTickSpacing(5);
		slider4.setPaintTicks(true);
		slider4.addChangeListener(this);
		slider5.setMajorTickSpacing(1);
		slider5.setPaintTicks(true);
		slider5.addChangeListener(this);
		Integer value = (Integer) slider.getValue();
		
		field1 = new JTextField();
		field2 = new JTextField();
		field3 = new JTextField();
		field4 = new JTextField();
		field5 = new JTextField();
		field6 = new JTextField();
		field7 = new JTextField();
		field8 = new JTextField();
		field9 = new JTextField();
		field10 = new JTextField("00:00:00");
		
		JLabel car1 = new JLabel("Car #1:	 ");
		JLabel car2 = new JLabel("Car #2:	");
		JLabel car3 = new JLabel("Car #3:	");
		JLabel light1 = new JLabel("Light #1:	 ");
		JLabel light2 = new JLabel("Light #2:	");
		JLabel light3 = new JLabel("Light #3:	");
		JLabel speed = new JLabel("Speed: 	");
		JLabel speed2 = new JLabel("Speed: 	");
		JLabel speed3 = new JLabel("Speed: 	");
		JLabel status = new JLabel("Status: 	");
		JLabel status2 = new JLabel("Status: 	");
		JLabel status3 = new JLabel("Status: 	");
		JLabel noCars = new JLabel("No. of Cars: 	");
		JLabel noLights = new JLabel("No. of Lights: 	");
		JLabel car1Speed = new JLabel("Car #1 Speed: 	");
		JLabel car2Speed = new JLabel("Car #2 Speed: 	");
		JLabel car3Speed = new JLabel("Car #3 Speed: 	");
		JLabel car1Location = new JLabel("Location: 	");
		JLabel car2Location = new JLabel("Location: 	");
		JLabel car3Location = new JLabel("Location: 	");
		
		
		
		JButton start = new JButton("START");
		JButton stop = new JButton("STOP");
		JButton pause = new JButton("PAUSE");
		JButton continueButton = new JButton("CONTINUE");
		
		
		field1.setText(value.toString());
		
		panel = new JPanel();
		panel6 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		panel7.add(noCars);
		panel7.add(car1Speed);
		panel7.add(car2Speed);
		panel7.add(car3Speed);
		panel7.add(noLights);
		panel7.setLayout(new GridLayout(0,5));
		panel6.add(slider);
		panel6.add(slider2);
		panel6.add(slider3);
		panel6.add(slider4);
		panel6.add(slider5);
		panel6.setLayout(new GridLayout(0,5));
		panel8.add(field10);
		

		//panel2.setLayout(new GridLayout(3,2));
		panel2.add(car1);
	
		panel3.add(car2);
	
		panel4.add(car3);
		panel2.add(speed);
		panel2.add(field1);
		panel2.add(car1Location);
		panel2.add(field7);
		panel2.add(light1);
		panel2.add(status);
		panel2.add(field4);
		
		panel3.add(speed2);
		panel3.add(field2);
		panel3.add(car2Location);
		panel3.add(field8);
		panel3.add(light2);
		panel3.add(status2);
		panel3.add(field5);
		
		panel4.add(speed3);
		panel4.add(field3);
		panel4.add(car3Location);
		panel4.add(field9);
		panel4.add(light3);
		panel4.add(status3);
		panel4.add(field6);
		
		panel.add(panel7);
		panel.add(panel6);	
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel8);
		panel5.add(start);
		panel5.add(pause);
		panel5.add(continueButton);
		panel5.add(stop);		
		panel.setLayout(new GridLayout(7,0));
		

		
		frame = new JFrame("Slider");
			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(800, 800);
		frame.setVisible(true);
		
		frame.add(new G());
		frame.add(panel);
		
		frame.setLayout(new GridLayout(2,0));
	}

	public static void main(String[] args) {

		UIManager.put("swing.boldMetal", Boolean.FALSE);

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
				
			}
		});
	}

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
		ui.toString();
	}
	
	public void run() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				for (int i =0; i < 10000; i++) {
					field1.setText(Integer.toString(i));
				}
			}
		});
	}

}
