/*
 * Custom Rectangle Class with Unique Methods
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */



public class MyRectangle2D {
    double x, y; // center of the rectangle (x, y)
    double width, height;
    
    public MyRectangle2D(){
        x = y = 0;
        width = height = 1.0;
    }
    
    public MyRectangle2D(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public void setCenter(double x, double y){
        this.x = x;
        this.y =y;
    }
    
    public double getHeight(){
        return height;
    }
    
    public double getWidth(){
        return width;
    }
    
    public void setHeight(double height){
        this.height = height;
    }
    
    public void setWidth(double width){
        this.width = width;
    }
    
    public double getArea(){
        return width*height;
    }
    
    public double getPerimeter(){
        return 2*(width+height);
    }
    
    public boolean contains(double x, double y){
        boolean check = false;
        
        if(x > this.x-(width/2) && x < this.x+(width/2)){
            if(y > this.y-(height/2) && y < this.y+(height/2))
                check = true;
        }
        else
            check = false;
        
        return check;
    }
    
    public boolean contains(MyRectangle2D r){
        boolean check = false;
        
        if(contains(r.getX(),r.getY())){
            if(r.getX()+r.getWidth()/2 < x+width/2 && r.getX()-r.getWidth()/2 > x-width/2){
                if(r.getY()+r.getHeight()/2 < y+height/2 && r.getY()-r.getHeight()/2 > y-height/2)
                    check = true;
            }
        }
        else
            check = false;
        
        return check;
    }
    
    public boolean overlaps(MyRectangle2D r){
        boolean check = false;
        
        //check overlap on x-axis
        if( r.getX()+r.getWidth()/2 > x+width/2 && r.getX()-r.getWidth()/2 < x+width/2 //overlaps top border
         || r.getX()+r.getWidth()/2 > x-width/2 && r.getX()-r.getWidth()/2 < x-width/2 //overlaps bottom border
         || r.getX()+r.getWidth()/2 < x+width/2 && r.getX()-r.getWidth()/2 > x-width/2 //contained within
         || r.getX()+r.getWidth()/2 > x+width/2 && r.getX()-r.getWidth()/2 < x-width/2){ //surrounds
            //check overlap in y-axis
            if( r.getY()+r.getHeight()/2 > y+height/2 && r.getY()-r.getHeight()/2 < y+height/2 //overlaps top border
             || r.getY()+r.getHeight()/2 > y-height/2 && r.getY()-r.getHeight()/2 < y-height/2 //overlaps bottom border
             || r.getY()+r.getHeight()/2 < y+height/2 && r.getY()-r.getHeight()/2 > y-height/2 //contained within
             || r.getY()+r.getHeight()/2 > y+height/2 && r.getY()-r.getHeight()/2 < y-height/2){
                check = true;
            }
        }
        else
            check = false;
        
        return check;
    }
    
    
}
