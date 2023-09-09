package sim;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import lombok.Getter;

@Getter
public class LightView implements ChangeListener {
	JPanel lightPanel;
	JPanel lightPanel2;
	JPanel lightPanel3;
	JPanel lightPanel4;
	JTextField status;
	JTextField position;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JSlider lightStatusSlider;
	JSlider lightPositionSlider;
	int id;
	Dictionary<Integer, JLabel> labels;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	
	public LightView(int id) {
		lightPanel = new JPanel();
		lightPanel2 = new JPanel();
		lightPanel3 = new JPanel();
		lightPanel4 = new JPanel();
		status = new JTextField(20);
		position = new JTextField(20);
		label1 = new JLabel("Light #" + id + ": ");
		label2 = new JLabel("Status:	");
		label3 = new JLabel("Position: ");
		label4 = new JLabel(Constants.GREEN);
		label5 = new JLabel(Constants.YELLOW);
		label6 = new JLabel(Constants.RED);
		labels = new Hashtable<Integer, JLabel>();
		labels.put(0, label4);
		labels.put(1, label5);
		labels.put(2, label6);
		lightStatusSlider = new JSlider(0,2,0);
		lightStatusSlider.setMajorTickSpacing(1);
		lightStatusSlider.setPaintTicks(true);
		lightStatusSlider.setPaintLabels(true);
		lightStatusSlider.setLabelTable(labels);
		lightPositionSlider = new JSlider(0, 20000, 0);
		lightPositionSlider.setPaintTicks(true);
		lightPositionSlider.setPaintLabels(true);
		lightPositionSlider.setMajorTickSpacing(5000);
		lightPositionSlider.setMinorTickSpacing(1000);
		this.id = id;
		lightPanel.add(lightPanel2);
		lightPanel2.add(label1);
		lightPanel3.add(label2);
		lightPanel3.add(lightStatusSlider);
		lightPanel3.add(status);
		lightPanel4.add(label3);
		lightPanel4.add(lightPositionSlider);
		lightPanel4.add(position);
		
		
		//lightPanel2.add(field3);
		//lightPanel2.add(field4);
		lightPanel.setLayout(new GridLayout(4,0));
		//lightPanel.add(label1);
		lightPanel.add(lightPanel2);
		lightPanel.add(lightPanel3);
		lightPanel.add(lightPanel4);
		lightPanel3.setLayout(new GridLayout(0,3));
		lightPanel4.setLayout(new GridLayout(0,3));
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		int speedInt = lightStatusSlider.getValue();
		int positionInt =  lightPositionSlider.getValue();
		
		String speedText = Integer.toString(speedInt);
		String positionText = Integer.toString(positionInt);
		
		status.setText(speedText);
		this.position.setText(positionText);
	}

	
}
