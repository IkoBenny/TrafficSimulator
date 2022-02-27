/*Benny Iko
 * 5/3/2020
 * Object Oriented Programming Languages
 * CMSC 335 7981
 * TrafficLight.Java
 * This class has information regarding a light  
 */
public class TrafficLight implements Runnable
{    
    private TrafficLightColor tlc; // holds the current traffic light color 
    private boolean stop = false; // set to true to stop the simulation 
    private boolean changed = false; // true when the light has changed
    private static final double distanceBetweenLights = .62137119; //distance between lights
    private static int totalLights; //keep running count of all lights in simulation
    private int lightNo; //each light has an ID #
    private double location; //psoition of this light
      
    enum TrafficLightColor{  
      RED,GREEN,YELLOW;
      
      public static String toString(TrafficLightColor tc){
        String colorRep ="";
          switch(tc){
              case RED:
              colorRep = "RED";
              case YELLOW:
              colorRep = "YELLOW";
              case GREEN:
              colorRep = "GREEN";             
        }
        return colorRep;
    }

}
    //create new light and start light on RED...
    //...assign light a #
    //increment total of lights...
    public TrafficLight(){
      ++totalLights;
      lightNo = totalLights;
      location = distanceBetweenLights * lightNo;
      tlc = TrafficLightColor.RED;
    }
    
    public static double getDistanceBetweenLights(){
        return distanceBetweenLights;
    }
    
    public int getLightNo(){
        return lightNo;
    }
    
    public double getLocation(){
        return location;
    }
    
    
    // Start up light. 
    public void run(){ 
        while(!stop) { 
            try { 
                switch(tlc) { 
                    case GREEN: 
                    System.out.println("GREEN");
                    Thread.sleep(10000); // green for 10 seconds 
                    break; 
                    case YELLOW: 
                    System.out.println("YELLOW");
                    Thread.sleep(2000);  // yellow for 2 seconds 
                    break; 
                    case RED: 
                    System.out.println("RED");
                    Thread.sleep(12000); // red for 12 seconds 
                    break;
                }
            }       
             catch(InterruptedException exc) { 
                System.out.println(exc);
            }      
      changeColor(); 
    }  
  } 
    //change color
    synchronized void changeColor(){ 
    switch(tlc) { 
      case RED: 
        tlc = TrafficLightColor.GREEN;
        notifyAll();
        break; 
      case YELLOW: 
        tlc = TrafficLightColor.RED; 
        break; 
      case GREEN: 
       tlc = TrafficLightColor.YELLOW; 
    }
    changed = true;
    notify(); // signal that the light has changed 
  } 
    //wait for light change
    synchronized void waitForChange() { 
    try { 
      while(!changed)
          wait(); // wait for light to change
           
      changed = false;
    } catch(InterruptedException exc) { 
      System.out.println(exc); 
    } 
  }
  // return light color
    synchronized TrafficLightColor getColor() { 
    return tlc; 
  }
  
  // Stop the traffic light. 
  synchronized void cancel() { 
    stop = true; 
  }
}
    
    
    
    
  


