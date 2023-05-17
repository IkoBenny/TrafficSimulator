package sim;

import java.awt.geom.Point2D;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import sim.Constants.SimulationMode;
import sim.Constants.TrafficLightColor;

public class Main {

	public static void main(String[] args) throws InterruptedException, InvocationTargetException {
		TrafficLight lightOne = new TrafficLight();
		TrafficLight lightTwo = new TrafficLight();
		TrafficLight lightThree = new TrafficLight();
		Car carOne = new Car(new Point2D.Double(0.0, 0.0), Constants.STOP_SPEED);
		Car carTwo = new Car(new Point2D.Double(0.0, 0.0), Constants.STOP_SPEED);
		Car carThree = new Car(new Point2D.Double(0.0, 0.0), Constants.STOP_SPEED);
		Time clock = new Time();
		// create the Model, View and Controller
		Model m = new Model(lightOne, lightTwo, lightThree, carOne, carTwo, carThree, clock);
		View v = new View();
		Controller c = new Controller();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() { // TODO Auto-generated method stub
				System.out.println("Inside Thread...");
				m.lightThree.lightswitch();
				 //m.carThree.go(); 
				for (;;) {
					try {
						Thread.sleep(1000);
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								String time = m.getTimestamp();
								v.getField10().setText(time);		 
								v.frame.repaint();
								System.out.println("Text run1 displayed...");
							}
						});
						
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								
								  TrafficLightColor col = m.lightThree.getColor(); 
								  String status = TrafficLightColor.toString(col); 
								  v.getField5().setText(status);
								  v.frame.repaint(); 
								  System.out.println("Text run2 displayed...");
								 
							}
						});
						

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});	 

		// Schedule the GUI to be created on the event thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// show GUI/View, then connect it and Model to Controller
				v.createAndShowGUI();
				v.addChangeListeners(c);
				v.addActionListeners(c);
				c.setViewAndModel(m, v);
			}
		});

		for (;;) {

			switch (Model.mode) {
			case START:
				System.out.println("START");
				while (Model.mode == SimulationMode.START) {
					thread.start();
					lightThree.start();
					m.started();
				}
				break;
			case PAUSE:
				System.out.println("PAUSE");
				while (Model.mode == SimulationMode.PAUSE) {
					m.paused();
				}
				break;
			case CONTINUE:
				System.out.println("CONTINUE");
				while (Model.mode == SimulationMode.CONTINUE) {
					m.restarted();
				}
				break;
			case STOP:
				System.out.println("STOP");
				while (Model.mode == SimulationMode.STOP) {
					m.stopped();
				}
				break;
			}
		}
	}
		

		//Use Strategy pattern depending on button selected
		


}
