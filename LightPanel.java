///*Benny Iko
// * 5/3/2020
// * Object Oriented Programming Languages
// * CMSC 335 7981
// * LightPanel.Java
// * This class has GUI information regarding a light  
// */
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
//
//public class LightPanel extends JPanel implements Runnable {
//	// instance variables to display information about a Light
//	private JLabel lightID;
//	public RunField objectCount;
//	private JLabel lightPosition;
//	public RunField lightLocation;
//	private JLabel lightStatus;
//	public RunField color;
//	TrafficLight t = new TrafficLight();
//
//	public LightPanel() {
//		// add fields to Panel and make unchangeable
//		JLabel lightID = new JLabel("Light ID: ");
//		RunField objectCount = new RunField(2);
//		JLabel lightPosition = new JLabel("Light Position: ");
//		RunField lightLocation = new RunField(12);
//		JLabel lightStatus = new JLabel("STATUS: ");
//		RunField color = new RunField(8);
//		objectCount.setEditable(false);
//		lightLocation.setEditable(false);
//		color.setEditable(false);
//		setLayout(new GridLayout(0, 6));
//		add(lightID);
//		add(objectCount);
//		add(lightPosition);
//		add(lightLocation);
//		add(lightStatus);
//		add(color);
//		setVisible(true);
//	}
//
//	public void run() {
//
//	}
//}