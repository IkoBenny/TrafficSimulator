import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GUI extends JFrame
{   
    //default instance variables
    private static int carsToCreate = 3;
    private static int lightsToCreate = 3;
    private static int defaultGapBetweenCars = 3;
    private ControlPanel cp = new ControlPanel();
    
   //Default constructor for GUI
    public GUI(){
        //set title
        super("Project 3");  
    }
  
    //Buttons for program control
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
            
            //when start button is pressed
            start.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               //prepare GUI for new look
               //add car info
               setLayout(new GridLayout(4 + getcarsToCreate() + getlightsToCreate(),0));
                begin();
                pack();
            }});
            
             stop.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               System.exit(0);

            }});
    }
}
    //when start is pressed
    public void begin(){
             for(int i =0; i < getcarsToCreate(); i++){
                    CarPanel c = new CarPanel();
                    add(c);
                    Thread t = new Thread(c);
                    t.start();
                }
                //add light info
                 for(int i =0; i < getlightsToCreate(); i++){
                    LightPanel l = new LightPanel();
                    add(l);                  
                }
        
    }


        
    //displays GUI at start
    public void display(){       
        setVisible(true);
        setSize(500,100);
        pack();
    }
    //add control panel to GUI
    public void displayControlPanel(){ 
        add(cp);
    }
    //gets number of cars to create
    public static int getcarsToCreate(){
        return carsToCreate;
    }
    //gets gap
    public static int getdefaultGapBetweenCars(){
        return defaultGapBetweenCars;
    }
    //gets number of lights
    public static int getlightsToCreate(){
        return lightsToCreate;
    }   
    //sets program parameters for lights, cars,gap
    public void getProgramConstraints(int ctc,int ltc,int dgbc){
                carsToCreate = ctc;
                lightsToCreate = ltc;
                defaultGapBetweenCars = dgbc;
    }
    //main method
    public static void main(String [] args){
        //to get car,light, gap information for start
                GUI g = new GUI();
                g.display();
                ObjectInfo o = new ObjectInfo();
                g.add(o);
                g.pack();    
                try{
                //wait for user input, then update variables
                Thread.sleep(20000);
                g.getProgramConstraints(o.getCarsQuantity(),o.getLightsQuantity(),o.getCarsDelay());  
                g.setVisible(false);
            }catch(InterruptedException ie){}                
        
            SwingUtilities.invokeLater(new Runnable(){
            public void run (){
                try{
                //wait for user input then display appropiate amount of panels
                Thread.sleep(20000);
                GUI h = new GUI();
                h.display();
                //create new Time object to display a running clock
                Time clock = new Time(70);
                Thread t = new Thread(clock);
                t.start();
                h.add(clock);
                h.displayControlPanel();
                h.pack();
                /*//add car info
                for(int i =0; i < getcarsToCreate(); i++){
                    CarPanel c = new CarPanel();
                    h.add(c);
                }
                //add light info
                 for(int i =0; i < getlightsToCreate(); i++){
                    LightPanel l = new LightPanel();
                    h.add(l);                  
                }
                h.pack();*/
                h.add(o);
                h.pack();
                h.setLayout(new GridLayout(4,0));
            }catch(InterruptedException ie){}                     
                
        }});}}
            
        

