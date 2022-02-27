/*Benny Iko
 * 5/3/2020
 * Object Oriented Programming Languages
 * CMSC 335 7981
 * RunField.Java
 * This class extends JTextField and will update to show Car/Light information 
 */

import javax.swing.text.JTextComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RunField extends JTextField implements Runnable
{
    String toPrint ="";
    //default constructor
    public RunField(int n){
        //call to JTextField Constructor
        super(n);       
    }
    //when thread is called print this repeatedly
    public String printRun(String s){
        String temp = "";
        temp =s;
        return temp;      
    }
    //sets output to be displayed in textfield
    public synchronized void settoPrint(String s){
        toPrint = s;
    }
    
    public void settoPrint(double s){
        String temp = String.valueOf(s);
        toPrint = temp;
    }
    //when thread is called print this repeatedly
    public void run(){      
        try {          
            for(int i =0; i < 6000; i++){                 
            setText(toPrint);
            Thread.sleep(1000);
        }
        }      
        catch(InterruptedException e){
        System.out.printf("");
      }}
      
      /*public static void main(){
          RunField t = new RunField(10);
          t.settoPrint(1);
          t.setEditable(false);
          GUI j = new GUI();
          Thread th = new Thread(t);
          th.start();
          j.add(t);
          j.display();
          
        }*/
}
