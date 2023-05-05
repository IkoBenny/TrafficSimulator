import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends TimerTask implements ActionListener, ChangeListener {

	private static final long serialVersionUID = -3815559884838069448L;

	public Slider() {
		JFrame frame = new JFrame("Slider");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		JPanel panel = new JPanel();
		JSlider slider = new JSlider(1, 3, 1);
		panel.add(slider);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.addChangeListener(this);
		JTextField field = new JTextField();
		panel.add(field);
		Integer value = (Integer) slider.getValue();
		field.setText(value.toString());
		frame.add(panel, BorderLayout.CENTER);
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
		Slider slider = new Slider();
		slider.toString();
	}
	
	public void run() {
		
	}

}
