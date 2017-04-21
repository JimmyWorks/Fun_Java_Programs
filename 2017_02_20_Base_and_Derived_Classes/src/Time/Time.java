/*
 * Abstract Base Class and Derived Classes
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */

package Time;


public abstract class Time {
    
    protected int hour;
    protected int minutes;
    protected int seconds;
    protected int AMorPM; // 0 for day, 1 for night
    
    
    public Time(){
        hour = 0;
        minutes = 0;
        seconds = 0;
        AMorPM = 0;
    }
    
    public Time(int hour, int minutes, int seconds, int AMorPM){
        setHour(hour);
        setMinutes(minutes);
        setSeconds(seconds);
        this.AMorPM = AMorPM;
    }
    
    public void setHour(int hour){
        if(hour <= 0)
            this.hour = 12;
        else if(hour > 11)
            this.hour = 11;

    }
    
    public int getHour(){
        return hour;
    }
    
    public void setMinutes(int minutes){
        
        if(minutes < 0)
            this.minutes = 0;
        else if(minutes > 59)
            this.minutes = 59;
        else        
            this.minutes = minutes;
    }
    
    public int getMinutes(){
        return minutes;
    }
    
    public void setSeconds(int seconds){
        if(seconds < 0)
            this.seconds = 0;
        else if(seconds > 59)
            this.seconds = 59;
        else        
            this.seconds = seconds;
    }
    
    public int getSeconds(){
    return seconds;
    }
    
    
    
}
