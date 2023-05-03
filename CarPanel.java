///*Benny Iko
// * 5/3/2020
// * Object Oriented Programming Languages
// * CMSC 335 7981
// * CarPanel.Java
// * This class has GUI information regarding a car 
// */
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
//
//public class CarPanel extends JPanel implements Runnable{
//        //instance variables to display information about a Car
//        public RunField threadStatus;
//        private JLabel carID;
//        public RunField objectCount;
//        private JLabel carPosition;
//        public RunField carDistance;
//        private JLabel carSpeed;    
//        public RunField carSpeedMPH;
//         
//        public CarPanel(){
//           //add fields to Panel and make unchangeable
//           RunField threadStatus = new RunField(2);
//           JLabel carID = new JLabel("Car ID: ");
//           RunField objectCount = new RunField(2);
//           JLabel carPosition = new JLabel("Car Position: ");
//           RunField carDistance = new RunField(12);
//           JLabel carSpeed = new JLabel("Speed (MPH) : " );    
//           RunField carSpeedMPH = new RunField(8);
//           threadStatus.setEditable(false);
//           objectCount.setEditable(false);
//           carDistance.setEditable(false);
//           carSpeedMPH.setEditable(false);
//           add(threadStatus);
//           add(carID);
//           add(objectCount);
//           add(carPosition);
//           add(carDistance);
//           add(carSpeed);
//           add(carSpeedMPH);
//           setLayout(new GridLayout(0,7));
//           setVisible(true);
//        }
//        
//         public void run(){
//             try{
//             Car c = new Car(); 
//             //create default lights
//             TrafficLight tl = new TrafficLight();
//             TrafficLight tl2 = new TrafficLight();
//             TrafficLight tl3 = new TrafficLight();
//             //threads for lights
//             Thread t4 = new Thread(tl);
//             Thread t5 = new Thread(tl2);
//             Thread t6 = new Thread(tl3);
//             t4.start();
//             t5.start();
//             t6.start();
//             //make lights visible to cars
//             c.addLightToList(tl);
//             c.addLightToList(tl2);
//             c.addLightToList(tl3);
//             Thread t = new Thread(c);
//             t.start();
//             //Thread t2 = new Thread(objectCount);
//             //t2.start();
//             Car c2 = new Car(); 
//             Thread t2 = new Thread(c2);
//             Thread.sleep(5000);
//             t2.start();
//             
//             //make lights visible to cars
//             c2.addLightToList(tl);
//             c2.addLightToList(tl2);
//             c2.addLightToList(tl3);
//             Car c3 = new Car(); 
//             //make lights visible to cars
//             c3.addLightToList(tl);
//             c3.addLightToList(tl2);
//             c3.addLightToList(tl3);
//             Thread t3 = new Thread(c3);
//             Thread.sleep(3000);
//             t3.start();
//             
//             for(int i = 0; i < 100; i ++){
//             Thread.sleep(1000);
//             objectCount.settoPrint(c.getSpeed());}}
//             catch(InterruptedException ie){}
//        }
//        
//
//    }