package sim;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import lombok.Getter;

@Getter
public class CarView {
	Mediator mvc;
	JPanel carPanel;
	JPanel carPanel2;
	JPanel carPanel3;
	JPanel carPanel4;
	JTextField speed;
	JTextField position;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JSlider carSpeedSlider;
	JSlider carPositionSlider;
	int id;
	
	public CarView(int id) {
		this.id = id;
		carPositionSlider = new JSlider(0, 20000, 0);
		carPositionSlider.setMajorTickSpacing(5000);
		carPositionSlider.setMinorTickSpacing(1000);
		carPositionSlider.setPaintTicks(true);
		carSpeedSlider = new JSlider(0, 120, 55);
		carSpeedSlider.setMajorTickSpacing(5);
		carSpeedSlider.setPaintTicks(true);
		carPanel = new JPanel();
		carPanel2 = new JPanel();
		carPanel3 = new JPanel();
		carPanel4 = new JPanel();
		speed = new JTextField(20);
		position = new JTextField(20);
		label1 = new JLabel("Car #" + id + ": ");
		label2 = new JLabel("Speed:	");
		label3 = new JLabel("Position: ");
		carPanel.add(carPanel2);
		carPanel2.add(label1);
		carPanel3.add(label2);
		carPanel3.add(carSpeedSlider);
		carPanel3.add(speed);	
		carPanel4.add(label3);
		carPanel4.add(carPositionSlider);
		carPanel4.add(position);
		
		
		//carPanel2.add(field3);
		//carPanel2.add(field4);
		carPanel.setLayout(new GridLayout(4,0));
		//carPanel.add(label1);
		carPanel.add(carPanel2);
		carPanel.add(carPanel3);
		carPanel.add(carPanel4);
		carPanel3.setLayout(new GridLayout(0,3));
		carPanel4.setLayout(new GridLayout(0,3));
	}
	
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		CarView view = new CarView(1);
		jf.add(view.getCarPanel());
	}
}
