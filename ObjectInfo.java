/*Benny Iko
 * 5/3/2020
 * Object Oriented Programming Languages
 * CMSC 335 7981
 * ObjectInfoPanel.Java
 * This class has GUI information regarding object quanitities 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ObjectInfo extends JPanel{
        //instance variables to display information about a Light
        private JLabel numOfLights;
        private JTextField lightsQuantity;
        private JLabel numOfCars;
        private JTextField carsQuantity;
        private JLabel carDelay;    
        private JTextField delayInSecs;
        int lightsQty;
        int carsQty;
        int delayS;
                      
        public ObjectInfo(){
           //add fields to Panel and make unchangeable
           JLabel numOfLights = new JLabel("(Default - 3) Lights Qty: ");
           RunField lightsQuantity = new RunField(2);
           JLabel numOfCars = new JLabel("(Default - 3) Cars Qty: ");
           RunField carsQuantity = new RunField(2);
           JLabel carDelay = new JLabel("(Default - 3 secs)Car Delay: ");    
           RunField delayInSecs = new  RunField(2);        
           lightsQuantity.setEditable(true);
           add(numOfLights);
           add(lightsQuantity);
           add(numOfCars);
           carsQuantity.setEditable(true);
           add(carsQuantity);
           add(carDelay);
           delayInSecs.setEditable(true);
           add(delayInSecs);
           setLayout(new GridLayout(0,6));
           setVisible(true);
           //save number of lights
           lightsQuantity.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               lightsQty= Integer.parseInt(lightsQuantity.getText());             
            }
        });
            //save number of cars
        carsQuantity.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               carsQty= Integer.parseInt(carsQuantity.getText());  
            }
        });
            //save number to delay between car creations
        delayInSecs.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               delayS= Integer.parseInt(delayInSecs.getText());  
            }
        });
           
        }
        //returns number of cars to create
        public int getCarsQuantity(){
            return carsQty;
        }
        //returns delay in secs to create
        public int getCarsDelay(){
            return delayS;
        }
        //returns number of lights to create
        public int getLightsQuantity(){
            return lightsQty;
        }
    }