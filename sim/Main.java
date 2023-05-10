package sim;

import java.awt.geom.Point2D;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		TrafficLight lightOne = new TrafficLight();
		TrafficLight lightTwo = new TrafficLight();
		TrafficLight lightThree = new TrafficLight();
		Car carOne = new Car(new
				Point2D.Double(0.0, 0.0), Constants.START_SPEED);
		Car carTwo = new Car(new
				Point2D.Double(0.0, 0.0), Constants.START_SPEED);
		Car carThree = new Car(new
				Point2D.Double(0.0, 0.0), Constants.START_SPEED);
		Time clock = new Time();
		Scheduler scheduler = new Scheduler();

		// create the Model, View and Controller
		Model m = new Model(lightOne, lightTwo, lightThree, carOne, carTwo, carThree, clock, scheduler);
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

		// refreshes the GUI/View display every second
		while (true) {
			c.update();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
