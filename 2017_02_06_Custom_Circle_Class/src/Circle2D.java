/*
 * Custom Circle Class with Unique Methods
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */

public class Circle2D {
    
    double x, y, radius;
    
    
    public Circle2D(){
        x = 0;
        y = 0;
        radius = 1;
    }
    
    public Circle2D(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double getRadius(){
        return radius;
    }
    
    public double getArea(){
        return Math.PI*radius*radius;
    }
    
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }
    
    public boolean contains(double x, double y){
        boolean check = false;
        
        
        double distance = Math.sqrt(Math.abs((this.x-x)*(this.x-x)-(this.y-y)*(this.y-y)));
        if(distance > radius)
            check = false;
        else
            check = true;
        
        return check;
    }
    
    public boolean contains(Circle2D r){
        boolean check = false;

        double distance = Math.sqrt(Math.abs((this.x-r.x)*(this.x-r.x)-(this.y-r.y)*(this.y-r.y)));
        if(distance + r.radius <= radius)
            check = true;
        
        return check;
    }
    
    public boolean overlaps(Circle2D r){
        boolean check = false;

        double distance = Math.sqrt(Math.abs((x-r.x)*(x-r.x)-(y-r.y)*(y-r.y)));
        if(distance < radius + r.radius)
            check = true;
        
        return check;
    }
    
    
    
}
