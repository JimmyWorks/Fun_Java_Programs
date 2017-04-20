/*
 * Driver File to Test Functionality of Custom Rectangle Class
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */



public class Driver {


    public static void main(String[] args) {
        MyRectangle2D rectA = new MyRectangle2D(2, 2, 5.5, 4.9);
        System.out.printf("Created a rectangle, A, with center of (%.1f, %.1f) and "
                + "width of %.1f and height of %.1f\n\n", rectA.getX(), rectA.getY(), rectA.getWidth(), rectA.getHeight());
        System.out.printf("Rectangle, A, has an area of %.1f and a perimeter of %.1f \n\n", rectA.getArea(), rectA.getPerimeter());
        
        int x = 3, y = 3;
        
        //RECTANGLE A
        System.out.printf("Checking if point (%d, %d) is contained in rectangle, A...\n\n", x, y);
        System.out.printf("The result is ");
        if(rectA.contains(x, y))
            System.out.printf("true.\n\n");
        else
            System.out.printf("false.\n\n");
        
        //RECTANGLE B
        MyRectangle2D rectB = new MyRectangle2D(4, 5, 10.5, 3.2);
        System.out.printf("Created a rectangle, B, with center of (%.1f, %.1f) and "
                + "width of %.1f and height of %.1f\n\n", rectB.getX(), rectB.getY(), rectB.getWidth(), rectB.getHeight());
        
        System.out.printf("Checking if rectangle, B, is contained in rectangle, A...\n\n");
        System.out.printf("The result is ");
        if(rectA.contains(rectB))
            System.out.printf("true.\n\n");
        else
            System.out.printf("false.\n\n");
        
        //RECTANGLE C
        MyRectangle2D rectC = new MyRectangle2D(3, 5, 2.3, 5.4);
        System.out.printf("Created a rectangle, C, with center of (%.1f, %.1f) and "
                + "width of %.1f and height of %.1f\n\n", rectC.getX(), rectC.getY(), rectC.getWidth(), rectC.getHeight());
        
        System.out.printf("Checking if rectangle, C, overlaps rectangle, A...\n\n");
        System.out.printf("The result is ");
        if(rectA.overlaps(rectC))
            System.out.printf("true.\n\n");
        else
            System.out.printf("false.\n\n");
        
        
    }
    
}
