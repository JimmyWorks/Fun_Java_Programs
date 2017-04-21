/*
 * Abstract Base Class and Derived Classes
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */

package Time;


public class TimeClock extends MilTime{
    
    protected int milHours;  //same name hides MilTime.milhours which is "start time"
    protected int seconds;   //same name hides MilTime.seconds which is "starting seconds"
    
    public TimeClock(){
        super();
        milHours = super.getHour();     //the default sets end time to start time
        seconds = super.getSeconds();   //the default sets end time to start time
    }
    
    public TimeClock(int milStart, int startSeconds, int milEnd, int endSeconds){
        super(milStart, startSeconds);
        setEndHours(milEnd);
        setEndSeconds(endSeconds);
    }
    
    public int getEndHour(){
        return milHours;
    }
    
    public int getEndSeconds(){
        return seconds;
    }
    
    public void setEndHours(int milHours){
        if(milHours >= 0 && milHours <= 2359){
            this.milHours = milHours;
        }
        else if(milHours < 0){
            this.milHours = 0;
        }
        else{
            this.milHours = 2359;
        }
    }
    
    public void setEndSeconds(int seconds){
        if(seconds < 0)
            this.seconds = 0;
        else if(seconds > 59)
            this.seconds = 59;
        else        
            this.seconds = seconds;
    }
    
    public double TimeDifference(){
        int difference;
        double totalHours;
        
        if(milHours >= super.getHour())
            difference = milHours - super.getHour();
        else
            difference = 2400 - super.getHour() + milHours;
        
        totalHours = difference/100 + (double)(difference%100)/60;
        
        return totalHours;
    }
    
}
