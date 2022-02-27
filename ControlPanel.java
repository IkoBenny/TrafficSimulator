/*Benny Iko
 * 5/3/2020
 * Object Oriented Programming Languages
 * CMSC 335 7981
 * ControlPanel.Java
 * This class has GUI information regarding program. Stop,play,etc...  
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ControlPanel extends JPanel{
        //instantiate buttons and add to controlPanel
        JButton start = new JButton("Start");
        JButton resume = new JButton("Resume");
        JButton pause = new JButton("Pause");
        JButton stop = new JButton("Stop");
        JLabel programStatus = new JLabel();
        JPanel controlPanel = new JPanel();       
        public ControlPanel(){
            add(start);
            add(stop);
            add(resume);
            add(pause);
            add(programStatus);
            setLayout(new GridLayout(0,5));
            //when start button is pressed
            start.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               

               
            }
        });
        
    }}