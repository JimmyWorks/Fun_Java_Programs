/*
 * Abstract Base Class and Derived Classes
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */


import Time.*;

public class Main {

    public static void main(String[] args) {
     
        //Create miltary time for 1200 hours, i.e. 12:00PM
        
        System.out.println("Entering 1200 hours for military time.");
        MilTime firstTime = new MilTime(1200, 0);
        
        System.out.printf("Verifying the set time in standard time: %s\n\n", firstTime.getStandHr());
        
        System.out.println("Now testing Time Clock function by entering the following:");
        System.out.println("Start Time: 1130 hours");
        System.out.println("End Time: 1355 hours\n\n");
        
        TimeClock intervalTest = new TimeClock(1130, 0, 1355, 0);
        
        System.out.printf("Verifying the start time: %d hours\n", intervalTest.getHour());
        System.out.printf("Verifying the end time: %d hours\n", intervalTest.getEndHour());
        System.out.printf("Verifying the elapsed time: %.2f hours\n", intervalTest.TimeDifference());
    }
    
}
