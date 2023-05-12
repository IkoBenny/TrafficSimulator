package sim;

import java.awt.geom.Point2D;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import sim.Constants.SimulationMode;

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
					c.startClock();
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
