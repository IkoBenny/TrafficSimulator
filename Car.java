/*Benny Iko
 * 5/3/2020
 * Object Oriented Programming Languages
 * CMSC 335 7981
 * LightPanel.Java
 * This class has information regarding a car
 */
import java.util.*;

public class Car implements Runnable
{
    //instance variables for distance,speed,position...
    //...time,movement, and closest light respectively
    private double odometer;
    private double speedometer; // speed in MPH
    private double positionGPS;
    private static int totalCars; //keep running count of all lights in simulation
    private int VIN; //this Car's ID #
    private Date modelYear;
    private Date lastTimeCarWasIdle;
    private Date lastTimeCarChangedSpeed;
    private TrafficLight nextLight;
    private boolean moving;
    private ArrayList <TrafficLight> lightsOnThisRoad; 
    
    enum gears{PARK,DRIVE,NEUTRAL,REVERSE};
    
    public Car(){
        ++totalCars;
        VIN = totalCars;
        speedometer = 0;
        odometer = 0;
        lightsOnThisRoad = new ArrayList();
        //modelYear is time of creation
        modelYear = new Date();
        lastTimeCarWasIdle = modelYear;
        moving = false;
    }
    
    //record time to calculate distance...
    //distance will be added to odometer after stoppage or change of pace...
    public synchronized void accelerate(){
        if(speedometer == 0){
            moving = true;
            Date now = new Date();
            lastTimeCarWasIdle = now;
            lastTimeCarChangedSpeed = lastTimeCarWasIdle;
            speedometer += 5;        
        }      
        else{
        Date now = new Date();
        Date justBeforePuttingFootOnTheGas = lastTimeCarChangedSpeed; 
        lastTimeCarChangedSpeed = now;
        calculateDistance(justBeforePuttingFootOnTheGas, lastTimeCarChangedSpeed);
        speedometer += 5;
    }
    }
    //construct a new Light on this road
    public void addLightToList(TrafficLight t){
        lightsOnThisRoad.add(t);
    }   
    
    //approximates total distance traveled by Car in Miles
    public synchronized void calculateDistance(Date start, Date end) {
        int timeElapsed;
        int hour1 = start.getHours();
        int hour2 = end.getHours();
        //if hour has not turned...
        //...compute distance
        if(hour1 == hour2){
            int minutes1 = start.getMinutes();
            int minutes2 = end.getMinutes();
            timeElapsed = minutes2 - minutes1;
            odometer += timeElapsed * (speedometer/60); //MPM
            int seconds1 = start.getSeconds();
            int seconds2 = end.getSeconds();
            timeElapsed = seconds2 - seconds1;
            odometer += timeElapsed * (speedometer/3600); //MPS
        }
        //if the hour has turned...
        //...compute distance       
        else{
            int minutes1 = start.getMinutes();
            int minutes2 = end.getMinutes();
                //if hour has changed but an hour has not passed...
                if(minutes2 < minutes1){               
                    timeElapsed = (hour2 - hour1) * 60 - (minutes1 - minutes2);
                    odometer = timeElapsed * speedometer;
                }            
                else{               
                    timeElapsed = (hour2 - hour1) * 60 + (minutes2 - minutes1);
                    odometer = timeElapsed * speedometer;
                }
    }}   
    // Stop the traffic light. 
    public synchronized void cancel() { 
        moving = false;
        speedometer = 0; 
    }
    
    public synchronized void checkForRed(){
    if(nextLight.getColor().toString().equals("RED")){
        cancel();
        nextLight.waitForChange();
        moving = true;  
    }}
    
    //prints mileage of current Car
    public void displayMileage(){
        System.out.println(odometer);
    }
    
    
    //prints speed of current Car
    public void displaySpeed(){
        System.out.println(speedometer);
    }
    //assign the closest light object to this Car, if it has not been passed yet
    public synchronized void findClosestLight(){
        double distance;
        ArrayList <Double> currentDistanceFromAllLights = new ArrayList();
        
        for(int i =0; i < lightsOnThisRoad.size(); i++){
            //find distance between this Car and all lights
            double loc = lightsOnThisRoad.get(i).getLocation();
            distance = loc - odometer;
            currentDistanceFromAllLights.add(distance);
        }
        
        if(nextLight ==null)
            nextLight = lightsOnThisRoad.get(0);
        
        //if the distance between this Car is less than...
        //...the distance between Lights, this is the closest Light
        for(int i=0; i < currentDistanceFromAllLights.size(); i++){
            if(currentDistanceFromAllLights.get(i) < TrafficLight.getDistanceBetweenLights())
                nextLight = lightsOnThisRoad.get(i);
            }
        //if we are within 528 feet stop at the red 
        System.out.println("Light #: " + nextLight.getLightNo() + "Loc: " + nextLight.getLocation());
        if((nextLight.getLocation() - odometer) < .1)
        checkForRed();      
        }    
    //returns this Car No.   
    public int getVIN(){
        return VIN;
    }    
    
    public synchronized double getMileage(){
        return odometer;
    }
    
    public synchronized double getSpeed(){
        return speedometer;
    }
    //wait 3 seconds, then pull off
    public void run(){
        
        try{  
                accelerate();
                displaySpeed();
                displayMileage();
            while(moving){ 
                Thread.sleep(3000);
                accelerate();
                displaySpeed();
                displayMileage();
                findClosestLight();
            }
            
    }
    
    catch (InterruptedException ie){System.out.println("Oops!");}} 
  
    public void printMileage(){
        System.out.println("Current Mileage: " + odometer);
    }
    
    public void printModelYear(){
        System.out.println("Model Year: " + modelYear);
    }
    
    public void printSpeed(){
        System.out.println("Current Speed: " + speedometer);
    }

}
