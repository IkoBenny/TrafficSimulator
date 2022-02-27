
/*Benny Iko
 * 5/3/2020
 * Object Oriented Programming Languages
 * CMSC 335 7981
 * LightPanel.Java
 * This class has GUI information regarding time  
 */
import java.util.Date;
import javax.swing.text.JTextComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Time extends JTextField implements Runnable
{           
    public Time(int i){
        super(i);
    }
    //gets current time
    public Date getTime(){
        Date time = new Date();
        return time;
    }  
    //prints current time
    public void printTime(){
        Date time = new Date();
        System.out.println(time);}         
    //prints time for a 1hr 40 minutes: 
    public void run(){      
        try {          
            for(int i =0; i < 6000; i++){
            Thread.sleep(1000);
            Date time = new Date();
            setText(time.toString());
        }
        }      
        catch(InterruptedException e){
        System.out.printf("We are frozen in time");
      }}
    }

