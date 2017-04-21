/*
 * Abstract Base Class and Derived Classes
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */

package Time;


public class MilTime extends Time{
    
    protected int milHours;
    
    public MilTime(){
        super();
        milHours = 0;
    }
    
    public MilTime(int milHours, int seconds){
        
        if(milHours >= 0 && milHours <= 1159){
            super.setHour(milHours/100);
            super.setMinutes(milHours % 100);
            AMorPM = 0;
        }
        else if(milHours >= 1200 && milHours <= 2359){
            super.setHour((milHours - 1200)/100);
            super.setMinutes((milHours-1200) % 100);
            AMorPM = 1;
        }
        else if(milHours < 0){
            super.setHour(0);
            super.setMinutes(0);
            AMorPM = 0;
        }
        else
            super.setHour(11);
            super.setMinutes(59);
            AMorPM = 1;
        
        this.milHours = milHours;
        this.seconds = seconds;
            
    }
    
    @Override
    public int getHour(){                   //Overridden accessor for MilHour
        return milHours;
    }
    
    @Override
    public void setHour(int milHours){      //Overrriden mutator for MilHour 
        if(milHours >= 0 && milHours <= 1159){
            super.setHour(milHours/100);
            super.setMinutes(milHours % 100);
            AMorPM = 0;
            this.milHours = milHours;
        }
        else if(milHours >= 1200 && milHours <= 2359){
            super.setHour((milHours-1200)/100);
            super.setMinutes((milHours-1200) % 100);
            AMorPM = 1;
                    this.milHours = milHours;
        }
        else if(milHours < 0){
            super.setHour(0);
            super.setMinutes(0);
            AMorPM = 0;
            this.milHours = 0;
        }
        else{
            super.setHour(11);
            super.setMinutes(59);
            AMorPM = 0;
            this.milHours = 1159;
        }
    }
    
    public void setTime(int milHours, int seconds){
        if(milHours >= 0 && milHours <= 1159){
            super.setHour(milHours/100);
            super.setMinutes(milHours % 100);
            AMorPM = 0;
            this.milHours = milHours;
        }
        else if(milHours >= 1200 && milHours <= 2359){
            super.setHour((milHours-1200)/100);
            super.setMinutes((milHours-1200) % 100);
            AMorPM = 1;
                    this.milHours = milHours;
        }
        else if(milHours < 0){
            super.setHour(0);
            super.setMinutes(0);
            AMorPM = 0;
            this.milHours = 0;
        }
        else{
            super.setHour(11);
            super.setMinutes(59);
            AMorPM = 0;
            this.milHours = 1159;
        }
        
        super.setSeconds(seconds);
        
    }
    
    public String getStandHr(){
        
        StringBuilder sb = new StringBuilder();

        sb.append(Integer.toString(super.getHour()));
        sb.append(":");
        
        if(super.getMinutes() < 10)
            sb.append("0");
        
        sb.append(Integer.toString(super.getMinutes()));
        
        if (AMorPM == 0)
            sb.append("AM");
        else 
            sb.append("PM");
        
        String standardTime = sb.toString();
        
        return standardTime;
    }
    
}
