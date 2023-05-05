import java.awt.BorderLayout;
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
	JSlider slider;
	JTextField field1;
	JTextField field2;
	JTextField field3;
	JTextField field4;
	JTextField field5;
	JTextField field6;
	

	public UserInterface() {		
		slider = new JSlider(1, 3, 1);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.addChangeListener(this);
		Integer value = (Integer) slider.getValue();
		
		field1 = new JTextField();
		field2 = new JTextField();
		field3 = new JTextField();
		field4 = new JTextField();
		field5 = new JTextField();
		field6 = new JTextField();
		
		JLabel car1 = new JLabel("Car #1:	 ");
		JLabel car2 = new JLabel("Car #2:	");
		JLabel car3 = new JLabel("Car #3:	");
		JLabel light1 = new JLabel("Light #1:	 ");
		JLabel light2 = new JLabel("Light #2:	");
		JLabel light3 = new JLabel("Light #3:	");
		JLabel speed = new JLabel("Speed: ");
		JLabel speed2 = new JLabel("Speed: ");
		JLabel speed3 = new JLabel("Speed: ");
		
		
		
		JButton start = new JButton("START");
		JButton stop = new JButton("STOP");
		JButton pause = new JButton("PAUSE");
		JButton continueButton = new JButton("CONTINUE");
		
		
		field1.setText(value.toString());
		
		panel = new JPanel();
		panel = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel.add(slider);
		

		//panel2.setLayout(new GridLayout(3,2));
		panel2.add(car1);
	
		panel3.add(car2);
	
		panel4.add(car3);
		panel2.add(speed);
		panel2.add(field1);
		panel2.add(light1);
		panel2.add(field4);
		panel2.add(start);
		panel3.add(speed2);
		panel3.add(field2);
		panel3.add(light2);
		panel3.add(field5);
		panel3.add(stop);
		panel4.add(speed3);
		panel4.add(field3);
		panel4.add(light3);
		panel4.add(field6);
		panel4.add(continueButton);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel4);
		panel.add(panel5);
		panel5.add(pause);
		panel.setLayout(new GridLayout(5,0));
		

		
		frame = new JFrame("Slider");
			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.add(new G());
		frame.add(panel, BorderLayout.CENTER);
		frame.setLayout(new GridLayout(2, 0));
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
